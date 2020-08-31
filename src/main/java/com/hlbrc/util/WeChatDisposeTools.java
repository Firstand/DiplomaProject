package com.hlbrc.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.json.JSONException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hlbrc.entity.Manager;
import com.hlbrc.entity.WeChatAppIdAppSecret;
import com.hlbrc.entity.WeChatToken;
import com.hlbrc.enums.IRole;
import com.hlbrc.enums.WeCharEnum;

import net.sf.json.JSONObject;

public class WeChatDisposeTools{
	String appid="";
	String appsecret="";
	public WeChatDisposeTools(){
		getAppIdAppSecret();
	}
	/**
	 * Gets interface access credentials ��ȡ�ӿڷ���ƾ֤,��д��xml�ļ���
	 * 
	 * @param appid     ƾ֤
	 * @param appsecret ��Կ
	 * @return
	 */
	public boolean setToken() {
		WeChatToken token = null;
		ChattingRecordsIO cro = new ChattingRecordsIO();
		net.sf.json.JSONArray jsonarray = cro.readFileWx("diploma_project_wechat");
		for(int i=0;i<jsonarray.size();i++) {
			JSONObject obj = jsonarray.getJSONObject(i);
			String requestUrl = WeCharEnum.ACCESS_TOKEN_URL.replace("APPID", obj.getString("appid")).replace("APPSECRET", obj.getString("appsecret"));
			// ����GET�����ȡƾ֤
			JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);
			if (null != jsonObject && obj.getString("appid")!=null && !"".equals(obj.getString("appid")) && !"none".equals(jsonObject.getString("access_token"))) {
				try {
					token = new WeChatToken();
					token.setAccessToken(jsonObject.getString("access_token"));
					token.setExpiresIn(jsonObject.getInt("expires_in"));
					cro.writeFileByBytesXml("token_"+obj.getString("appid"),token,WeChatToken.class);
					return true;
				} catch (JSONException | IOException e) {
					token = null;
					// ��ȡtokenʧ��
					System.err.println("��ȡtokenʧ�� errcode:{} errmsg:{}" + jsonObject.getInt("errcode")
							+ jsonObject.getString("errmsg"));
					return false;
				}
			}
		}
		return false;
	}
	/**
	 * ��xml�ļ��ж�ȡ΢��Token
	 * @return
	 */
	public WeChatToken getToken() {
		ChattingRecordsIO cro = new ChattingRecordsIO();
		WeChatToken wct = null;
		try {
			wct = (WeChatToken) cro.getContentXml("token_"+appid,WeChatToken.class);
			System.out.println(wct.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wct;
	}
	/**
	 * �����û���appid appsecret
	 * @param appid
	 * @param appsecret
	 */
	public void setAppIdAppSecret(String appid, String appsecret) {
		ChattingRecordsIO cro = new ChattingRecordsIO();
		WeChatAppIdAppSecret wcis = new WeChatAppIdAppSecret();
		boolean flag = true;
		try {
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			Manager manager = (Manager)request.getSession().getAttribute("manager");
			if(manager!=null) {
				wcis.setAppid(appid);
				wcis.setAppsecret(appsecret);
				cro.writeFileByBytesXml("appid_appsecret_"+manager.getManager_id(),wcis,WeChatAppIdAppSecret.class);
				net.sf.json.JSONArray jsonarray = cro.readFileWx("diploma_project_wechat");
				for(int i=0;i<jsonarray.size();i++) {
					JSONObject obj = jsonarray.getJSONObject(i);
					if(appid.equals(obj.getString("appid"))) {
						flag = false;
						break;
					}
				}
				if(flag) {
					jsonarray.add(wcis);
				}
				cro.writeFileByBytesWx("diploma_project_wechat", jsonarray.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
		}
	}
	/**
	 * �����û���appid appsecret
	 * @param appid
	 * @param appsecret
	 */
	public void getAppIdAppSecret() {
		ChattingRecordsIO cro = new ChattingRecordsIO();
		WeChatAppIdAppSecret wais;
		try {
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			Manager manager = (Manager)request.getSession().getAttribute("manager");
			if(manager!=null) {
				wais = (WeChatAppIdAppSecret) cro.getContentXml("appid_appsecret_"+manager.getManager_id(),WeChatAppIdAppSecret.class);
				if(wais!=null) {
					appid = wais.getAppid();
					appsecret = wais.getAppsecret();
					System.out.println(wais.toString());
				}
			}
		} catch (NullPointerException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Send an HTTPS request ����https����
	 * 
	 * @param requestUrl    �����ַ
	 * @param requestMethod ����ʽ��GET��POST��
	 * @param outputStr     �ύ������
	 * @return JSONObject(ͨ��JSONObject.get(key)�ķ�ʽ��ȡjson���������ֵ)
	 */
	public JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		try {
			// ����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// ������SSLContext�����еõ�SSLSocketFactory����
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// ��������ʽ��GET/POST��
			conn.setRequestMethod(requestMethod);

			// ��outputStr��Ϊnullʱ�������д����
			if (null != outputStr) {
				OutputStream outputStream = conn.getOutputStream();
				// ע������ʽ
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// ����������ȡ��������
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// �ͷ���Դ
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			System.err.println("���ӳ�ʱ��" + ce.getMessage());
		} catch (Exception e) {
			jsonObject.put("access_token", "none");
			jsonObject.put("expires_in", 0);
			System.err.println("https�����쳣��{}" + e.getMessage());
		}
		return jsonObject;
	}
	/**
	 * Upload the Logo of the card volume �ϴ������Logo
	 * @param appid
	 * @param appsecret
	 * @param filePath
	 * @return
	 */
	public String uploadLogo(String appid, String appsecret,MultipartFile file){
        String result = null;
        try {
        	WeChatToken token = getToken();
            String accessToken = token.getAccessToken();//ʹ������ķ�ʽ��ȡ��token
           // �ϴ��ļ�����·��
           String action = "http://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token="
                   + accessToken + "&type=image";

           URL url = new URL(action);
//           if (!file.exists() || !file.isFile()) {
//               throw new IOException("�ϴ����ļ�������");
//           }
           HttpURLConnection con = (HttpURLConnection) url.openConnection();
           con.setRequestMethod("POST"); // ��Post��ʽ�ύ����Ĭ��get��ʽ
           con.setDoInput(true);
           con.setDoOutput(true);
           con.setUseCaches(false); // post��ʽ����ʹ�û���

           // ��������ͷ��Ϣ
           con.setRequestProperty("Connection", "Keep-Alive");
           con.setRequestProperty("Charset", "UTF-8");
           // ���ñ߽�
           String BOUNDARY = "----------" + System.currentTimeMillis();
           con.setRequestProperty("Content-Type", "multipart/form-data; boundary="
                   + BOUNDARY);

           // ����������Ϣ
           // ��һ���֣�
           StringBuilder sb = new StringBuilder();
           sb.append("--"); // �����������
           sb.append(BOUNDARY);
           sb.append("\r\n");
           sb.append("Content-Disposition: form-data;name=\"file\";filename=\""
                   + file.getOriginalFilename() + "\"\r\n");
           sb.append("Content-Type:application/octet-stream\r\n\r\n");
           byte[] head = sb.toString().getBytes("utf-8");
           // ��������
           OutputStream out = new DataOutputStream(con.getOutputStream());

           // �����ͷ
           out.write(head);
           // �ļ����Ĳ���
           // ���ļ������ļ��ķ�ʽ ���뵽url��
           DataInputStream in = new DataInputStream(file.getInputStream());
           int bytes = 0;
           byte[] bufferOut = new byte[1024];
           while ((bytes = in.read(bufferOut)) != -1) {
               out.write(bufferOut, 0, bytes);
           }
           in.close();

           // ��β����
           byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// ����������ݷָ���
           out.write(foot);
           out.flush();
           out.close();
           StringBuffer buffer = new StringBuffer();
           BufferedReader reader = null;

           try {
               // ����BufferedReader����������ȡURL����Ӧ
               reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
               String line = null;
               while ((line = reader.readLine()) != null) {
                   buffer.append(line);
               }
               if (result == null) {
                   result = buffer.toString();
                   if(result!=null&&!"".equals(result)) {
                	   JSONObject obj = JSONObject.fromObject(result);
                       if(obj!=null) {
                    	   obj.put("errmsg","ok");
                    	   obj.put("errcode", "0");
                       }
                       result = obj.toString();
                   }
                   
               }
           } catch (IOException e) {
               System.out.println("����POST��������쳣��" + e);
               e.printStackTrace();
               throw new IOException("���ݶ�ȡ�쳣");
           } finally {
               if (reader != null) {
                   reader.close();
               }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
	/**
	 * Gets the JSON string that creates the membership card ��ȡ������ȯ��json��
	 * @param logoUrl
	 * @param ServicePhone
	 * @param title
	 * @return json��
	 */
	public String getJsonCard(String logoUrl,String ServicePhone,String title) {
		WxCardGroupon card = new WxCardGroupon();
        WxCardBaseInfo baseInfo = card.getBaseInfo();
        baseInfo.setLogoUrl(logoUrl);
        baseInfo.setDateInfoTimeRange(Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
        baseInfo.setDateInfoFixTerm(2);
        baseInfo.setBrandName("brandname");
        baseInfo.setBindOpenid(false);
        baseInfo.setCanGiveFriend(false);
        baseInfo.setCanShare(true);
        baseInfo.setCodeType(WxCardBaseInfo.CODE_TYPE_QRCODE);
        baseInfo.setColor("Color010");
        baseInfo.setDescription("desc");
        baseInfo.setGetLimit(3);
        baseInfo.setUseCustomCode(false);
        baseInfo.setNotice("ʹ��ʱ�����Ա��ʾ��ȯ");
        baseInfo.setServicePhone(ServicePhone);
        baseInfo.addLocationIdList(123123);
        baseInfo.addLocationIdList(5345);
        baseInfo.setUseLimit(5);
        baseInfo.setQuantity(10000000);
        baseInfo.setTitle(title);
        
        System.out.println(baseInfo.toJsonString());
        ArrayList<Integer> locationIdList = new ArrayList<Integer>();
        locationIdList.add(809809);
        locationIdList.add(423532);
        card.setDealDetail("�Ź����鰡��������������");
        
        System.out.println(locationIdList.getClass().isArray());
        baseInfo.setLocationIdList(locationIdList);
        System.out.println(card.toJsonString());
        return card.toJsonString();
	}
	/**
	 * Gets the JSON string that creates the membership card ��ȡ������Ա����json��
	 * @param logo_url
	 * @param background_pic_url
	 * @param card
	 * @return json��
	 */
	public String getJsonMemberCard(String logo_url,String background_pic_url,WxCardGroupon card) {
        WxCardBaseInfo baseInfo = card.getBaseInfo();
        if(background_pic_url!=null&&!"".equals(background_pic_url)) {
        	card.setBackgroundPicUrl(background_pic_url);
        }
        baseInfo.setLogoUrl(logo_url);
        System.out.println(card.toJsonString());
        return card.toJsonString();
	}
	/**
	 * Gets the JSON string that creates the membership card ��ȡ������Ա����json��
	 * @param logo_url
	 * @return json��
	 */
	public String getJsonMemberCard(String logo_url) {
		WxCardGroupon card = new WxCardGroupon();
        WxCardBaseInfo baseInfo = card.getBaseInfo();
        card.init("MEMBER_CARD");
        card.setSupplyBonus(true);
        card.setSupplyBalance(false);
        card.setPrerogative("��Ա����Ȩ˵��");
        card.setAutoActivate(true);
        card.setCustomField1(new org.json.JSONObject());
        card.setCustomFieldNameType(card.getCustomField1(), "FIELD_NAME_TYPE_LEVEL");
        card.setCustomFieldUrl(card.getCustomField1(), "http://www.qq.com");
        card.setActivateUrl("http://www.qq.com");
        card.setCustomCell1(new org.json.JSONObject());
        card.setCustomCell1Name("ʹ�����2");
        card.setCustomCell1Tips("�������ʾ");
        card.setCustomCell1Url("http://www.qq.com");
        card.setBonusRule(new org.json.JSONObject());
        card.setCostBonusUnit(100);
        card.setIncreaseBonus(1);
        card.setMaxIncreaseBonus(200);
        card.setInitIncreaseBonus(10);
        card.setCostBonusUnit(5);
        card.setReduceMoney(100);
        card.setLeastMoneyToUseBonus(1000);
        card.setMaxReduceBonus(50);
        card.setDiscount(9);
        baseInfo.setLogoUrl(logo_url);
        baseInfo.setBrandName("������");
        baseInfo.setCodeType(WxCardBaseInfo.CODE_TYPE_QRCODE);
        baseInfo.setTitle("�����һ�Ա��");
        baseInfo.setColor("Color010");
        baseInfo.setNotice("ʹ��ʱ�����Ա��ʾ��ȯ");
        baseInfo.setServicePhone("15540061217");
        baseInfo.setDescription("�����������Ż�ͬ��");
        baseInfo.setType("DATE_TYPE_PERMANENT");
        baseInfo.setGetLimit(3);
        baseInfo.setQuantity(10000000);
        baseInfo.setUseCustomCode(false);
        baseInfo.setCanGiveFriend(false);
        ArrayList<Integer> locationIdList = new ArrayList<Integer>();
        locationIdList.add(809809);
        locationIdList.add(423532);
        baseInfo.setLocationIdList(locationIdList);
        System.out.println(card.toJsonString());
        return card.toJsonString();
	}
	/**
	 * Correspond according to the parameters passed in���ݴ������������Ӧ
	 * @param appid
	 * @param appsecret
	 * @param url
	 * @param content
	 * @return ��Ӧjson��
	 */
	public String response(String appid, String appsecret,String url,String content) {
		WeChatToken token = getToken();
		url += token.getAccessToken();
//		System.out.println("url:"+url);
        String line = "";  
        String message = "";  
        String returnData = "";  
        @SuppressWarnings("unused")
		boolean postState = false;  
        BufferedReader bufferedReader = null;  

        try {  
            URL urlObject = new URL(url);  
            HttpURLConnection urlConn = (HttpURLConnection) urlObject.openConnection();  
            urlConn.setDoOutput(true);  
            /*�趨���û���*/         
            urlConn.setRequestProperty("Cache-Control", "no-cache");  
            /*ά�ֳ�����*/  
            urlConn.setRequestProperty("Connection", "Keep-Alive");    
            /*�����ַ���*/  
            urlConn.setRequestProperty("Charset", "UTF-8");  
            /*�趨�����ʽΪjson*/  
            urlConn.setRequestProperty("Content-Type", "application/json;charset=utf-8");  
            /*����ʹ��POST�ķ�ʽ����*/  
            urlConn.setRequestMethod("POST");               
            /*���ò�ʹ�û���*/  
            urlConn.setUseCaches(false);  
            /*�����������*/  
            urlConn.setDoOutput(true);    
            /*������������*/  
            urlConn.setDoInput(true);                
            urlConn.connect();  

            OutputStreamWriter outStreamWriter = new OutputStreamWriter(urlConn.getOutputStream(),"UTF-8");   
            outStreamWriter.write(content);  
            outStreamWriter.flush();  
            outStreamWriter.close();  

            /*��postʧ��*/  
            if((urlConn.getResponseCode() != 200)){
//              returnData = "{\"jsonStrStatus\":0,\"processResults\":[]}";
            	returnData = "{\"errcode\":-10,\"errmsg\":\"no\"}";
                message = "����POSTʧ�ܣ�"+ "code="+urlConn.getResponseCode() + "," + "ʧ����Ϣ��"+ urlConn.getResponseMessage();  
                // ����BufferedReader����������ȡURL����Ӧ  
                InputStream errorStream = urlConn.getErrorStream();   

                if(errorStream != null)  
                {  
                    InputStreamReader inputStreamReader = new InputStreamReader(errorStream,"utf-8");  
                    bufferedReader = new BufferedReader(inputStreamReader);    

                    while ((line = bufferedReader.readLine()) != null) {    
                        message += line;      
                    }           
                    inputStreamReader.close();  
                }  
                errorStream.close();  
                System.out.println("����ʧ�ܣ�������ϢΪ��"+message);                    
            }else{
                /*���ͳɹ����ط��ͳɹ�״̬*/  
                postState = true;  

                // ����BufferedReader����������ȡURL����Ӧ  
                InputStream inputStream = urlConn.getInputStream();    

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");  
                bufferedReader = new BufferedReader(inputStreamReader);    

                while ((line = bufferedReader.readLine()) != null) {    
                    message += line;    
                }          
                returnData = message;  
                inputStream.close();  
                inputStreamReader.close();  

                System.out.println("����POST�ɹ�����������Ϊ��" + returnData);                          
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
		return returnData;
    }
	/**
	 * Create card voucher ������ȯ
	 * @param file
	 * @return ��ά��
	 * @throws IOException 
	 */
	public String creatCard(Integer manager_id, MultipartFile file) throws IOException {
		String QRcode = "";
		WeChatDisposeTools wx = new WeChatDisposeTools();
		ChattingRecordsIO act = new ChattingRecordsIO();
		//�ϴ�logo��ȡ
		JSONObject obj = JSONObject.fromObject(wx.uploadLogo(WeCharEnum.APPID, WeCharEnum.APPSECRET, file));
		//������Ա��
		JSONObject obj1 = JSONObject.fromObject(wx.response(WeCharEnum.APPID, WeCharEnum.APPSECRET,WeCharEnum.CREATE_WX_URL,wx.getJsonCard(obj.getString("url"), "15540061217", "ƭ��û����")));
		if("ok".equals(obj1.getString("errmsg"))) {
			System.out.println("card_id:"+obj1.getString("card_id"));
			QRcode = getQRcode (obj1.getString("card_id"));
			net.sf.json.JSONArray my_member = act.readFileWx("creat_card_"+manager_id);
//        	my_member.put("manager_"+manager_id+"_creat_cardid_"+new Date().getTime(), obj1.toString());
        	act.writeFileByBytesWx("creat_card_"+manager_id, my_member.toString());
			System.out.println("��ȯ�����ɹ���"+QRcode);
		}
		else {
			QRcode = "{\"errcode\":-11,\"errmsg\":\"no\"}";
			System.out.println("��ȯ����ʧ�ܣ�");
		}
		return QRcode;
	}
	/**
	 * Create membership card ������Ա��
	 * @param file
	 * @return ��ά��
	 * @throws IOException 
	 */
	public String creatMemberCard(Integer manager_id,String appid,String appsecret,MultipartFile logo,MultipartFile backgroud,WxCardGroupon card,WxCardCustomField field,Boolean wx_activate,String title) throws IOException {
		String QRcode = "";
		JSONObject obj_json = new JSONObject();
		if(logo!=null) {
			//�ϴ�logo��ȡ
			JSONObject logo_json = JSONObject.fromObject(uploadLogo(appid, appsecret, logo));
			ChattingRecordsIO act = new ChattingRecordsIO();
			if("ok".equals(logo_json.getString("errmsg"))) {
				obj_json.put("logo_url", logo_json.getString("url"));
				JSONObject backgroud_json = JSONObject.fromObject(uploadLogo(appid, appsecret, backgroud));
				String backgroud_url = "";
				if("ok".equals(backgroud_json.getString("errmsg"))) {
					backgroud_url=backgroud_json.getString("url");
					obj_json.put("backgroud_url", backgroud_url);
				}
				//������Ա��
				JSONObject obj1 = JSONObject.fromObject(response(appid, appsecret,WeCharEnum.CREATE_WX_URL,getJsonMemberCard(logo_json.getString("url"),backgroud_url,card)));
				if("ok".equals(obj1.getString("errmsg"))) {
					System.out.println("card_id:"+obj1.getString("card_id"));
					obj_json.put("card_id", obj1.getString("card_id"));
					QRcode = getQRcode (obj1.getString("card_id"));
					JSONObject QRcode_json = JSONObject.fromObject(QRcode);
					if("ok".equals(QRcode_json.getString("errmsg")))
					{
						obj_json.put("ticket",QRcode_json.getString("ticket"));
						obj_json.put("title", title);
						obj_json.put("show_qrcode_url",QRcode_json.getString("show_qrcode_url"));
						if(wx_activate) {
							field.setCardId(obj1.getString("card_id"));
							field.setServiceStatement(new org.json.JSONObject());
							field.setServiceStatementAll("��Ա����", "https://www.qq.com");
							if(setCustomField(appid, appsecret, field)) {
								System.out.println("�����ֶδ����ɹ���");
							}
							else {
								System.out.println("�����ֶδ����ɹ�����ʧ�ܣ�");
							}
						}
						SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						obj_json.put("creat_time", sd.format(new Date()));
						obj_json.put("state", IRole.CANCEL_AFTER_VERIFICATION_Y);
						System.out.println("obj_json:"+obj_json.toString());
						net.sf.json.JSONArray jsonarray = act.readFileWx("creat_member_card_"+manager_id);
						jsonarray.add(obj_json);
			        	act.writeFileByBytesWx("creat_member_card_"+manager_id, jsonarray.toString());
						System.out.println("��Ա�������ɹ���"+jsonarray.toString());
					}
				}
				else {
					QRcode = "{\"errcode\":-7,\"errmsg\":\"no\"}";
					Log.logger.debug("��Ա������ʧ�ܣ�");
					System.out.println("��Ա������ʧ�ܣ�");
				}
			}
			else {
				QRcode = "{\"errcode\":-8,\"errmsg\":\"no\"}";
				Log.logger.debug("������Ա����logo�ϴ�ʧ�ܣ�");
				System.out.println("������Ա����logo�ϴ�ʧ�ܣ�");
			}
		}
		else {
			QRcode = "{\"errcode\":-9,\"errmsg\":\"no\"}";
			Log.logger.debug("������Ա����logoΪ�գ�");
			System.out.println("������Ա����logoΪ�գ�");
		}
		return QRcode;
	}
	/**
	 * Get qr code of delivery card voucher ��ȡͶ�ſ�ȯ��ά��
	 * @param card_id
	 * @return json��
	 */
	public String getQRcode (String card_id) {
        JSONObject json = new JSONObject();
        JSONObject actionInfo = new JSONObject();
        JSONObject card= new JSONObject();
        card.put("card_id",card_id);//д����Ҫͷ���Ŀ����card_id
        actionInfo.put("card", card);
        json.put("action_name", "QR_CARD");
        json.put("action_info",actionInfo);
        System.out.println("-------------:"+json.toString());
        //Ȼ�����post�ύ���ݣ������response�����������е���ͬһ����
        return response(WeCharEnum.APPID, WeCharEnum.APPSECRET,WeCharEnum.CREATE_QRCODE_MEMCARD_URL, json.toString());
	}
	/**
	 * Cancel after verification card voucher ����ĳ����ȯ
	 * @param appid
	 * @param appsecret
	 * @param code
	 */
	public void clearCard(String appid, String appsecret,String code){
        //�⴮url�ǲ�ѯcode�Ľӿڣ��ڿ��ĵ���ʱ��ǿ���Ƽ��Ȳ�ѯ�����Ծ���������
        JSONObject json = new JSONObject();
        json.put("code", code);
        JSONObject obj = JSONObject.fromObject(response(appid, appsecret,WeCharEnum.GET_CODE_URL, json.toString()));
        System.out.println(json);
        //����post����
        if("ok".equals(obj.getString("errmsg"))){
            JSONObject clearJson = new JSONObject();
            clearJson.put("code", code);
            obj = JSONObject.fromObject(response(appid, appsecret,WeCharEnum.CLEAR_URL, clearJson.toString()));
            if("ok".equals(obj.getString("errmsg"))) {
            	System.out.println("�����ɹ���");
            }
            else {
            	System.out.println("����ʧ�ܣ�");
            }
        }
        else {
        	System.out.println("��ȯ״̬�쳣��");
        }
    }
	public boolean deleteCard(String appid, String appsecret,String card_id,int manager_id) throws IOException{
		//�⴮url�ǲ�ѯcode�Ľӿڣ��ڿ��ĵ���ʱ��ǿ���Ƽ��Ȳ�ѯ�����Ծ���������
        JSONObject json = new JSONObject();
        ChattingRecordsIO act = new ChattingRecordsIO();
        JSONObject obj = null;
        json.put("card_id", card_id);
        System.out.println(json);
        boolean flag = false;
        obj = JSONObject.fromObject(response(appid, appsecret,WeCharEnum.DELATE_MEMBERSHIP, json.toString()));
        if("ok".equals(obj.getString("errmsg"))) {
        	obj = JSONObject.fromObject(response(appid, appsecret,WeCharEnum.GET_DETAIL_MEMBER_CARD_URL, json.toString()));
        	String status = obj.getJSONObject("card").getJSONObject("member_card").getJSONObject("base_info").getString("status");
        	System.out.println("status:"+status);
            if("CARD_STATUS_DELETE".equals(status)){
            	flag = true;
            	net.sf.json.JSONArray jsonarray = act.readFileWx("creat_member_card_"+manager_id);
            	net.sf.json.JSONArray jsonarray_new = new net.sf.json.JSONArray();
            	for(Object ob:jsonarray) {
            		JSONObject obj_json = JSONObject.fromObject(ob);
            		if(obj_json.getString("card_id").equals(card_id)) {
            			obj_json.put("state", "0");
            		}
            		jsonarray_new.add(obj_json);
            	}
            	act.writeFileByBytesWx("creat_member_card_"+manager_id, jsonarray_new.toString());
            	System.out.println("�����ɹ���");
            }
            else {
            	System.out.println("��ȯ״̬�쳣��");
            }
        }
        else {
        	System.out.println("����ʧ�ܣ�");
        }
        return flag;
	}
	public String getCordState(String appid, String appsecret,String code) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		return response(appid, appsecret,WeCharEnum.GET_CODE_URL, json.toString());
	}
	/**
	 * Set whitelist ���ð�����
	 * @param url
	 * @param openid
	 * @param username
	 */
	public void setWhiteList(String url,List<String> openid) {
		JSONObject json = new JSONObject();
		json.put("openid", openid);
		System.out.println(json.toString());
		response(WeCharEnum.APPID, WeCharEnum.APPSECRET,url, json.toString());
	}
	/**
     * Parse the request from WeChat (XML) ����΢�ŷ���������XML��
     * 
     * @param request
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        // ����������洢��HashMap��
        Map<String, String> map = new HashMap<String, String>();
        // ��request��ȡ��������
        InputStream inputStream = request.getInputStream();
        // ��ȡ������
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // �õ�xml��Ԫ��
        Element root = document.getRootElement();
        // �õ���Ԫ�ص������ӽڵ�
        List<Element> elementList = root.elements();
        // ���������ӽڵ�
        for (Element e : elementList)
            map.put(e.getName(), e.getText());

        // �ͷ���Դ
        inputStream.close();
        inputStream = null;
        return map;
	}
	/**
	 * Set the open card field ���ÿ����ֶ�
	 * @param appid
	 * @param appsecret
	 * @param field
	 */
	public boolean setCustomField(String appid, String appsecret, WxCardCustomField field) {
		JSONObject customfield_json = JSONObject.fromObject(response(appid, appsecret,WeCharEnum.SET_USER_OPEN_CARD_URL,field.toJsonString()));
		System.out.println("customfield_json��"+customfield_json.toString());
		if("ok".equals(customfield_json.getString("errmsg"))) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * ��ȡ��Ա��Ϣ
	 * @param appid
	 * @param appsecret
	 * @param code_id
	 * @return
	 */
	public String getMemberInformation(String appid, String appsecret,String code_id) {
		JSONObject obj = new JSONObject();
		obj.put("code", code_id);
		obj = JSONObject.fromObject(response(appid, appsecret,WeCharEnum.GET_CODE_URL,obj.toString()));
		if("ok".equals(obj.getString("errmsg"))) {
			obj = JSONObject.fromObject(response(appid, appsecret,WeCharEnum.GET_MEMBER_INFORMATION.replace("OPENID", obj.getString("openid")),obj.toString()));
			obj.put("errcode", "0");
			obj.put("errmsg", "ok");
			obj.put("subscribe_time",numberDateFormat(obj.getString("subscribe_time"),"yyyy-MM-dd HH:mm:ss"));
			String[] str = obj.getString("language").split("_");
			if("zh".equals(str[0])) {
				obj.put("language","����");
			}
			else if("en".equals(str[0])) {
				obj.put("language","Ӣ��");
			}
			else {
				obj.put("language","��������");
			}
			if("1".equals(obj.getString("sex"))) {
				obj.put("sex","��");
			}
			else if("2".equals(obj.getString("sex"))){
				obj.put("sex","Ů");
			}
			else {
				obj.put("sex","δ֪");
			}
			System.out.println("��Ա��Ϣ��"+obj.toString());
			return obj.toString();
		}
		else {
			return "{\"errcode\":-12,\"errmsg\":\"no\"}";
		}
	}
	/**
     * 10λ13λʱ���תString ��ʽ��2018-10-15 16:03:27�� ����
     * @param timestamp
     * @param simpleDateFormatType ʱ������ͣ�"yyyy-MM-dd HH:mm:ss"��
     * @return
     */
    public String numberDateFormat(String timestamp,String simpleDateFormatType){
        SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormatType);//Ҫת����ʱ���ʽ
        String date = null;
        if (timestamp.length() == 13){
            date = sdf.format(Long.parseLong(timestamp));
        }else{
            date = sdf.format(Long.parseLong(timestamp)*1000);
        }
        return date;
    }
    public void setSwipeCard(String card_id) {
    	JSONObject obj = new JSONObject();
    	JSONObject base_info = new JSONObject();
    	JSONObject pay_info = new JSONObject();
    	JSONObject swipe_card = new JSONObject();
    	swipe_card.put("is_swipe_card", true);
    	pay_info.put("swipe_card", swipe_card);
    	base_info.put("pay_info", pay_info);
        obj.put("card_id", card_id);
        obj.put("member_card",base_info);
        System.out.println(obj.toString());
	}
	public static void main(String[] args) {
//		new WeChatDisposeTools().setSwipeCard("ph_gmt7cUVrlRk8swPwx7aDyF-pg");
//		WeChatToken token = new WeChatDisposeTools().getToken("wxab75c494f36ac927", "5d0aa5579700ef88082834ec31794a88");
//		System.out.println(token.getAccessToken());
//		System.out.println(token.getExpiresIn()); 
//		new WeChatDisposeTools().getJsonCard("logoUrl","ServicePhone","title");
		
//		List<String> openid = new ArrayList<String>();
//		openid.add("oiu9I5299zJZLcP-NBqBsjMpX2X8");
//		openid.add("oiu9I56fdcgtwyCA3VcmkDaE6o_8");
//		new WeChatDisposeTools().setWhiteList(WeCharEnum.WHITE_LIST_URL, openid);
//		
//		new WeChatDisposeTools().getJsonMemberCard("logo_url");
//		new WeChatDisposeTools().getCordState(WeCharEnum.APPID, WeCharEnum.APPSECRET,"148156859557");
//		new WeChatDisposeTools().deleteCard(WeCharEnum.APPID, WeCharEnum.APPSECRET,"piu9I53G5FTCcSYRSp9nXyex-AM0");
//		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(sd.format(new Date()));
//		new WeChatDisposeTools().getMemberInformation(WeCharEnum.APPID, WeCharEnum.APPSECRET,"089568932648");
//		System.out.println(new WeChatDisposeTools().numberDateFormat("1591496550","yyyy-MM-dd HH:mm:ss"));
//		new WeChatDisposeTools().setToken();
//		new WeChatDisposeTools().getToken();
//		new WeChatDisposeTools().setAppIdAppSecret(WeCharEnum.APPID, WeCharEnum.APPSECRET);
//		new WeChatDisposeTools().getAppIdAppSecret();
		ChattingRecordsIO cro = new ChattingRecordsIO();
		net.sf.json.JSONArray jsonarray = cro.readFileWx("diploma_project_wechat");
		for(int i=0;i<jsonarray.size();i++) {
			JSONObject obj = jsonarray.getJSONObject(i);
			System.out.println(obj);
		}
	}
}
