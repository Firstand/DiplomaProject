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
	 * Gets interface access credentials 获取接口访问凭证,并写到xml文件中
	 * 
	 * @param appid     凭证
	 * @param appsecret 密钥
	 * @return
	 */
	public boolean setToken() {
		WeChatToken token = null;
		ChattingRecordsIO cro = new ChattingRecordsIO();
		net.sf.json.JSONArray jsonarray = cro.readFileWx("diploma_project_wechat");
		for(int i=0;i<jsonarray.size();i++) {
			JSONObject obj = jsonarray.getJSONObject(i);
			String requestUrl = WeCharEnum.ACCESS_TOKEN_URL.replace("APPID", obj.getString("appid")).replace("APPSECRET", obj.getString("appsecret"));
			// 发起GET请求获取凭证
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
					// 获取token失败
					System.err.println("获取token失败 errcode:{} errmsg:{}" + jsonObject.getInt("errcode")
							+ jsonObject.getString("errmsg"));
					return false;
				}
			}
		}
		return false;
	}
	/**
	 * 从xml文件中读取微信Token
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
	 * 储存用户的appid appsecret
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
	 * 储存用户的appid appsecret
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
	 * Send an HTTPS request 发送https请求
	 * 
	 * @param requestUrl    请求地址
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr     提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			conn.setRequestMethod(requestMethod);

			// 当outputStr不为null时向输出流写数据
			if (null != outputStr) {
				OutputStream outputStream = conn.getOutputStream();
				// 注意编码格式
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 从输入流读取返回内容
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			System.err.println("连接超时：" + ce.getMessage());
		} catch (Exception e) {
			jsonObject.put("access_token", "none");
			jsonObject.put("expires_in", 0);
			System.err.println("https请求异常：{}" + e.getMessage());
		}
		return jsonObject;
	}
	/**
	 * Upload the Logo of the card volume 上传卡卷的Logo
	 * @param appid
	 * @param appsecret
	 * @param filePath
	 * @return
	 */
	public String uploadLogo(String appid, String appsecret,MultipartFile file){
        String result = null;
        try {
        	WeChatToken token = getToken();
            String accessToken = token.getAccessToken();//使用上面的方式获取到token
           // 上传文件请求路径
           String action = "http://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token="
                   + accessToken + "&type=image";

           URL url = new URL(action);
//           if (!file.exists() || !file.isFile()) {
//               throw new IOException("上传的文件不存在");
//           }
           HttpURLConnection con = (HttpURLConnection) url.openConnection();
           con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式
           con.setDoInput(true);
           con.setDoOutput(true);
           con.setUseCaches(false); // post方式不能使用缓存

           // 设置请求头信息
           con.setRequestProperty("Connection", "Keep-Alive");
           con.setRequestProperty("Charset", "UTF-8");
           // 设置边界
           String BOUNDARY = "----------" + System.currentTimeMillis();
           con.setRequestProperty("Content-Type", "multipart/form-data; boundary="
                   + BOUNDARY);

           // 请求正文信息
           // 第一部分：
           StringBuilder sb = new StringBuilder();
           sb.append("--"); // 必须多两道线
           sb.append(BOUNDARY);
           sb.append("\r\n");
           sb.append("Content-Disposition: form-data;name=\"file\";filename=\""
                   + file.getOriginalFilename() + "\"\r\n");
           sb.append("Content-Type:application/octet-stream\r\n\r\n");
           byte[] head = sb.toString().getBytes("utf-8");
           // 获得输出流
           OutputStream out = new DataOutputStream(con.getOutputStream());

           // 输出表头
           out.write(head);
           // 文件正文部分
           // 把文件已流文件的方式 推入到url中
           DataInputStream in = new DataInputStream(file.getInputStream());
           int bytes = 0;
           byte[] bufferOut = new byte[1024];
           while ((bytes = in.read(bufferOut)) != -1) {
               out.write(bufferOut, 0, bytes);
           }
           in.close();

           // 结尾部分
           byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
           out.write(foot);
           out.flush();
           out.close();
           StringBuffer buffer = new StringBuffer();
           BufferedReader reader = null;

           try {
               // 定义BufferedReader输入流来读取URL的响应
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
               System.out.println("发送POST请求出现异常！" + e);
               e.printStackTrace();
               throw new IOException("数据读取异常");
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
	 * Gets the JSON string that creates the membership card 获取创建卡券的json串
	 * @param logoUrl
	 * @param ServicePhone
	 * @param title
	 * @return json串
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
        baseInfo.setNotice("使用时向服务员出示此券");
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
        card.setDealDetail("团购详情啊啊啊啊啊！！！");
        
        System.out.println(locationIdList.getClass().isArray());
        baseInfo.setLocationIdList(locationIdList);
        System.out.println(card.toJsonString());
        return card.toJsonString();
	}
	/**
	 * Gets the JSON string that creates the membership card 获取创建会员卡的json串
	 * @param logo_url
	 * @param background_pic_url
	 * @param card
	 * @return json串
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
	 * Gets the JSON string that creates the membership card 获取创建会员卡的json串
	 * @param logo_url
	 * @return json串
	 */
	public String getJsonMemberCard(String logo_url) {
		WxCardGroupon card = new WxCardGroupon();
        WxCardBaseInfo baseInfo = card.getBaseInfo();
        card.init("MEMBER_CARD");
        card.setSupplyBonus(true);
        card.setSupplyBalance(false);
        card.setPrerogative("会员卡特权说明");
        card.setAutoActivate(true);
        card.setCustomField1(new org.json.JSONObject());
        card.setCustomFieldNameType(card.getCustomField1(), "FIELD_NAME_TYPE_LEVEL");
        card.setCustomFieldUrl(card.getCustomField1(), "http://www.qq.com");
        card.setActivateUrl("http://www.qq.com");
        card.setCustomCell1(new org.json.JSONObject());
        card.setCustomCell1Name("使用入口2");
        card.setCustomCell1Tips("激活后显示");
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
        baseInfo.setBrandName("海上找");
        baseInfo.setCodeType(WxCardBaseInfo.CODE_TYPE_QRCODE);
        baseInfo.setTitle("海上找会员卡");
        baseInfo.setColor("Color010");
        baseInfo.setNotice("使用时向服务员出示此券");
        baseInfo.setServicePhone("15540061217");
        baseInfo.setDescription("不可与其他优惠同享");
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
	 * Correspond according to the parameters passed in根据传入参数进行相应
	 * @param appid
	 * @param appsecret
	 * @param url
	 * @param content
	 * @return 响应json串
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
            /*设定禁用缓存*/         
            urlConn.setRequestProperty("Cache-Control", "no-cache");  
            /*维持长连接*/  
            urlConn.setRequestProperty("Connection", "Keep-Alive");    
            /*设置字符集*/  
            urlConn.setRequestProperty("Charset", "UTF-8");  
            /*设定输出格式为json*/  
            urlConn.setRequestProperty("Content-Type", "application/json;charset=utf-8");  
            /*设置使用POST的方式发送*/  
            urlConn.setRequestMethod("POST");               
            /*设置不使用缓存*/  
            urlConn.setUseCaches(false);  
            /*设置容许输出*/  
            urlConn.setDoOutput(true);    
            /*设置容许输入*/  
            urlConn.setDoInput(true);                
            urlConn.connect();  

            OutputStreamWriter outStreamWriter = new OutputStreamWriter(urlConn.getOutputStream(),"UTF-8");   
            outStreamWriter.write(content);  
            outStreamWriter.flush();  
            outStreamWriter.close();  

            /*若post失败*/  
            if((urlConn.getResponseCode() != 200)){
//              returnData = "{\"jsonStrStatus\":0,\"processResults\":[]}";
            	returnData = "{\"errcode\":-10,\"errmsg\":\"no\"}";
                message = "发送POST失败！"+ "code="+urlConn.getResponseCode() + "," + "失败消息："+ urlConn.getResponseMessage();  
                // 定义BufferedReader输入流来读取URL的响应  
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
                System.out.println("发送失败！错误信息为："+message);                    
            }else{
                /*发送成功返回发送成功状态*/  
                postState = true;  

                // 定义BufferedReader输入流来读取URL的响应  
                InputStream inputStream = urlConn.getInputStream();    

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");  
                bufferedReader = new BufferedReader(inputStreamReader);    

                while ((line = bufferedReader.readLine()) != null) {    
                    message += line;    
                }          
                returnData = message;  
                inputStream.close();  
                inputStreamReader.close();  

                System.out.println("发送POST成功！返回内容为：" + returnData);                          
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
		return returnData;
    }
	/**
	 * Create card voucher 创建卡券
	 * @param file
	 * @return 二维码
	 * @throws IOException 
	 */
	public String creatCard(Integer manager_id, MultipartFile file) throws IOException {
		String QRcode = "";
		WeChatDisposeTools wx = new WeChatDisposeTools();
		ChattingRecordsIO act = new ChattingRecordsIO();
		//上传logo获取
		JSONObject obj = JSONObject.fromObject(wx.uploadLogo(WeCharEnum.APPID, WeCharEnum.APPSECRET, file));
		//创建会员卡
		JSONObject obj1 = JSONObject.fromObject(wx.response(WeCharEnum.APPID, WeCharEnum.APPSECRET,WeCharEnum.CREATE_WX_URL,wx.getJsonCard(obj.getString("url"), "15540061217", "骗你没商量")));
		if("ok".equals(obj1.getString("errmsg"))) {
			System.out.println("card_id:"+obj1.getString("card_id"));
			QRcode = getQRcode (obj1.getString("card_id"));
			net.sf.json.JSONArray my_member = act.readFileWx("creat_card_"+manager_id);
//        	my_member.put("manager_"+manager_id+"_creat_cardid_"+new Date().getTime(), obj1.toString());
        	act.writeFileByBytesWx("creat_card_"+manager_id, my_member.toString());
			System.out.println("卡券创建成功！"+QRcode);
		}
		else {
			QRcode = "{\"errcode\":-11,\"errmsg\":\"no\"}";
			System.out.println("卡券创建失败！");
		}
		return QRcode;
	}
	/**
	 * Create membership card 创建会员卡
	 * @param file
	 * @return 二维码
	 * @throws IOException 
	 */
	public String creatMemberCard(Integer manager_id,String appid,String appsecret,MultipartFile logo,MultipartFile backgroud,WxCardGroupon card,WxCardCustomField field,Boolean wx_activate,String title) throws IOException {
		String QRcode = "";
		JSONObject obj_json = new JSONObject();
		if(logo!=null) {
			//上传logo获取
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
				//创建会员卡
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
							field.setServiceStatementAll("会员守则", "https://www.qq.com");
							if(setCustomField(appid, appsecret, field)) {
								System.out.println("开卡字段创建成功！");
							}
							else {
								System.out.println("开卡字段创建成功常见失败！");
							}
						}
						SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						obj_json.put("creat_time", sd.format(new Date()));
						obj_json.put("state", IRole.CANCEL_AFTER_VERIFICATION_Y);
						System.out.println("obj_json:"+obj_json.toString());
						net.sf.json.JSONArray jsonarray = act.readFileWx("creat_member_card_"+manager_id);
						jsonarray.add(obj_json);
			        	act.writeFileByBytesWx("creat_member_card_"+manager_id, jsonarray.toString());
						System.out.println("会员卡创建成功！"+jsonarray.toString());
					}
				}
				else {
					QRcode = "{\"errcode\":-7,\"errmsg\":\"no\"}";
					Log.logger.debug("会员卡创建失败！");
					System.out.println("会员卡创建失败！");
				}
			}
			else {
				QRcode = "{\"errcode\":-8,\"errmsg\":\"no\"}";
				Log.logger.debug("创建会员卡，logo上传失败！");
				System.out.println("创建会员卡，logo上传失败！");
			}
		}
		else {
			QRcode = "{\"errcode\":-9,\"errmsg\":\"no\"}";
			Log.logger.debug("创建会员卡，logo为空！");
			System.out.println("创建会员卡，logo为空！");
		}
		return QRcode;
	}
	/**
	 * Get qr code of delivery card voucher 获取投放卡券二维码
	 * @param card_id
	 * @return json串
	 */
	public String getQRcode (String card_id) {
        JSONObject json = new JSONObject();
        JSONObject actionInfo = new JSONObject();
        JSONObject card= new JSONObject();
        card.put("card_id",card_id);//写上需要头发的卡卷的card_id
        actionInfo.put("card", card);
        json.put("action_name", "QR_CARD");
        json.put("action_info",actionInfo);
        System.out.println("-------------:"+json.toString());
        //然后进行post提交数据，这里的response方法跟上文中的是同一个。
        return response(WeCharEnum.APPID, WeCharEnum.APPSECRET,WeCharEnum.CREATE_QRCODE_MEMCARD_URL, json.toString());
	}
	/**
	 * Cancel after verification card voucher 核销某个卡券
	 * @param appid
	 * @param appsecret
	 * @param code
	 */
	public void clearCard(String appid, String appsecret,String code){
        //这串url是查询code的接口，在看文档的时候，强烈推荐先查询，所以就先试了下
        JSONObject json = new JSONObject();
        json.put("code", code);
        JSONObject obj = JSONObject.fromObject(response(appid, appsecret,WeCharEnum.GET_CODE_URL, json.toString()));
        System.out.println(json);
        //进行post请求
        if("ok".equals(obj.getString("errmsg"))){
            JSONObject clearJson = new JSONObject();
            clearJson.put("code", code);
            obj = JSONObject.fromObject(response(appid, appsecret,WeCharEnum.CLEAR_URL, clearJson.toString()));
            if("ok".equals(obj.getString("errmsg"))) {
            	System.out.println("核销成功！");
            }
            else {
            	System.out.println("核销失败！");
            }
        }
        else {
        	System.out.println("卡券状态异常！");
        }
    }
	public boolean deleteCard(String appid, String appsecret,String card_id,int manager_id) throws IOException{
		//这串url是查询code的接口，在看文档的时候，强烈推荐先查询，所以就先试了下
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
            	System.out.println("核销成功！");
            }
            else {
            	System.out.println("卡券状态异常！");
            }
        }
        else {
        	System.out.println("核销失败！");
        }
        return flag;
	}
	public String getCordState(String appid, String appsecret,String code) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		return response(appid, appsecret,WeCharEnum.GET_CODE_URL, json.toString());
	}
	/**
	 * Set whitelist 设置白名单
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
     * Parse the request from WeChat (XML) 解析微信发来的请求（XML）
     * 
     * @param request
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();
        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();
        // 遍历所有子节点
        for (Element e : elementList)
            map.put(e.getName(), e.getText());

        // 释放资源
        inputStream.close();
        inputStream = null;
        return map;
	}
	/**
	 * Set the open card field 设置开卡字段
	 * @param appid
	 * @param appsecret
	 * @param field
	 */
	public boolean setCustomField(String appid, String appsecret, WxCardCustomField field) {
		JSONObject customfield_json = JSONObject.fromObject(response(appid, appsecret,WeCharEnum.SET_USER_OPEN_CARD_URL,field.toJsonString()));
		System.out.println("customfield_json："+customfield_json.toString());
		if("ok".equals(customfield_json.getString("errmsg"))) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * 获取会员信息
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
				obj.put("language","中文");
			}
			else if("en".equals(str[0])) {
				obj.put("language","英文");
			}
			else {
				obj.put("language","其他语言");
			}
			if("1".equals(obj.getString("sex"))) {
				obj.put("sex","男");
			}
			else if("2".equals(obj.getString("sex"))){
				obj.put("sex","女");
			}
			else {
				obj.put("sex","未知");
			}
			System.out.println("会员信息："+obj.toString());
			return obj.toString();
		}
		else {
			return "{\"errcode\":-12,\"errmsg\":\"no\"}";
		}
	}
	/**
     * 10位13位时间戳转String 格式（2018-10-15 16:03:27） 日期
     * @param timestamp
     * @param simpleDateFormatType 时间戳类型（"yyyy-MM-dd HH:mm:ss"）
     * @return
     */
    public String numberDateFormat(String timestamp,String simpleDateFormatType){
        SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormatType);//要转换的时间格式
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
