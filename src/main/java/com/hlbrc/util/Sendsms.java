package com.hlbrc.util;
//�ӿ����ͣ��������ߴ������Žӿڣ�֧�ַ�����֤����š�����֪ͨ���ŵȡ�
// �˻�ע�᣺��ͨ���õ�ַ��ͨ�˻�http://sms.ihuyi.com/register.html
// ע�����
//��1�������ڼ䣬����Ĭ�ϵ�ģ����в��ԣ�Ĭ��ģ������ӿ��ĵ���
//��2����ʹ��APIID���鿴APIID���¼�û�����->��֤�����->��Ʒ����->APIID���� APIkey�����ýӿڣ�
//��3���ô���������뻥�����߶��Žӿڲο�ʹ�ã��ͻ��ɸ���ʵ����Ҫ���б�д��

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import org.dom4j.Document;   
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;   
import org.dom4j.Element;   

/**
 * ����6λ�����֤��
 * @author ZY
 *
 */
public class Sendsms {
	
	private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
	public static final String key = "RANDOMCODEKEY";//�ŵ�session�е�key
	public int send(String tel,HttpServletRequest request)
	{
		int ss=0;
		HttpClient client = new HttpClient(); 
		PostMethod method = new PostMethod(Url);

		client.getParams().setContentCharset("GBK");
		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");

		int mobile_code1 = (int)((Math.random()*9+1)*100000);
		String mobile_code = mobile_code1+"";
		try {
		HttpSession session = request.getSession();
		session.removeAttribute(key);
        session.setAttribute(key, mobile_code);
        System.out.println("send��֤�룺"+mobile_code+new Date());
		}
		catch(Exception e) {
			System.out.println("send:�쳣��");
		}
		
	    String content = new String("������֤���ǣ�" + mobile_code + "���벻Ҫ����֤��й¶�������ˡ�");
	    //System.out.println("send:"+content);
		NameValuePair[] data = {//�ύ����
			    new NameValuePair("account", "C92748404"), //�鿴�û����ǵ�¼�û�����->��֤�����->��Ʒ����->APIID
			    // new NameValuePair("password", "ea05f43c26db85059e3507d25aadb9f4"),  //�鿴�������¼�û�����->��֤�����->��Ʒ����->APIKEY
			    new NameValuePair("password", com.hlbrc.util.StringUtil.MD5Encode("ea05f43c26db85059e3507d25aadb9f4")),
			    new NameValuePair("mobile", tel), 
			    new NameValuePair("content", content),
		};
		method.setRequestBody(data);

		try {
			client.executeMethod(method);
			
			String SubmitResult =method.getResponseBodyAsString();

			//System.out.println(SubmitResult);

			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();

			String code = root.elementText("code");
			String msg = root.elementText("msg");
			String smsid = root.elementText("smsid");

			System.out.println(code);
			System.out.println(msg);
			System.out.println(smsid);
			
			
			 if("2".equals(code)){
				ss=1;
			}
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			// Release connection
			method.releaseConnection();
			//client.getConnectionManager().shutdown();
		}
		return ss;
		
	}
	
	
}