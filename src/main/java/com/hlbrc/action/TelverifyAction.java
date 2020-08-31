package com.hlbrc.action;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hlbrc.util.Log;
import com.hlbrc.util.Sendsms;

/**
 * 手机号效验控制层
 * @author ZY
 *
 */
@Controller
public class TelverifyAction {
	/**
	 * 验证码处理
	 * @param request
	 * @param response
	 * @param verify
	 * @return
	 */
	@RequestMapping(path="telverify")
	public String telverify(HttpServletRequest request, HttpServletResponse response,String verify) 
	{
		try {
			HttpSession session = request.getSession();
			response.setCharacterEncoding("utf-8");
			if(verify.trim()!="")
			{
				Sendsms s = new Sendsms();
				int d = s.send(verify,request);
				String random = (String)session.getAttribute("RANDOMCODEKEY");
				System.out.println("Tel验证码:"+random+new Date());
				PrintWriter out=response.getWriter();
				if(d==1)
				{
					out.print(1);
				}
				else
				{
					out.print(0);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			Log.logger.debug("TelverifyAction中telverify()方法出错啦！电话验证码发送失败："+e.getMessage());
			return "error/404.jsp";	
		}
		return "";
	}
}
