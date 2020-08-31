package com.hlbrc.util;
//接口类型：互亿无线触发短信接口，支持发送验证码短信、订单通知短信等。
// 账户注册：请通过该地址开通账户http://sms.ihuyi.com/register.html
// 注意事项：
//（1）调试期间，请用默认的模板进行测试，默认模板详见接口文档；
//（2）请使用APIID（查看APIID请登录用户中心->验证码短信->产品总览->APIID）及 APIkey来调用接口；
//（3）该代码仅供接入互亿无线短信接口参考使用，客户可根据实际需要自行编写；

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
 * 生成6位随机验证码
 * @author ZY
 *
 */
public class Sendsms {
	
	private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
	public static final String key = "RANDOMCODEKEY";//放到session中的key
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
        System.out.println("send验证码："+mobile_code+new Date());
		}
		catch(Exception e) {
			System.out.println("send:异常啦");
		}
		
	    String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");
	    //System.out.println("send:"+content);
		NameValuePair[] data = {//提交短信
			    new NameValuePair("account", "C92748404"), //查看用户名是登录用户中心->验证码短信->产品总览->APIID
			    // new NameValuePair("password", "ea05f43c26db85059e3507d25aadb9f4"),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
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