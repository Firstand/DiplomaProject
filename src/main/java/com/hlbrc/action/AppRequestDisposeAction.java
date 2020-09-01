package com.hlbrc.action;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hlbrc.biz.AppBiz;
import com.hlbrc.entity.AddressExample;

@Controller
public class AppRequestDisposeAction {
	@Autowired
	AppBiz biz_app;
	@RequestMapping(path="queryAddress")
	@ResponseBody
	public String queryAddress(String userid,HttpServletResponse response) {
		//����AddressExample����
		AddressExample address = new AddressExample();
		//����Ҫ��ӵ���������
		AddressExample.Criteria criteria = address.createCriteria();
		System.out.println("-------------------userid="+userid);
		if(userid!=null&&!"".equals(userid)) {
			criteria.andUserIdEqualTo(Integer.valueOf(userid));
		}
		else {
			return "{'RecieveAddressList':''}";
		}
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST,GET");
		return biz_app.queryAddress(address);
	}
}
