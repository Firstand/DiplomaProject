package com.hlbrc.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.hlbrc.biz.AppBiz;
import com.hlbrc.entity.AddressExample;
import com.hlbrc.util.Log;

@Controller
public class AppRequestDisposeAction {
	@Autowired
	AppBiz biz_app;
	/**
	 * 查询地址
	 * @param userid
	 * @param response
	 * @return
	 */
	@RequestMapping(path="queryAddress")
	@ResponseBody
	public String queryAddress(String userid,HttpServletResponse response) {
		try {
			//创建AddressExample对象
			AddressExample address = new AddressExample();
			//创建要添加的条件对象
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
		}catch (Exception e) {
			Log.logger.debug("查询地址出错了！："+e.getMessage());
			return "{'RecieveAddressList':''}";
		}
	}
	/**
	 * 修改地址
	 * @param message
	 * @param response
	 * @return
	 */
	@RequestMapping(path="updateAddress")
	@ResponseBody
	public String updateAddress(String message,HttpServletResponse response) {
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST,GET");
			return biz_app.updateAddress(message);
		}catch (Exception e) {
			Log.logger.debug("修改地址出错了！："+e.getMessage());
			return "{'RecieveAddressList':''}";
		}
	}
	/**
	 * 新增地址
	 * @param message
	 * @param response
	 * @return
	 */
	@RequestMapping(path="insertAddress")
	@ResponseBody
	public String insertAddress(String message,HttpServletResponse response) {
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST,GET");
			return biz_app.insertAddress(message);
		}catch (Exception e) {
			Log.logger.debug("新增地址出错了！："+e.getMessage());
			return "{'RecieveAddressList':''}";
		}
	}
	/**
	 * 删除地址
	 * @param message
	 * @param response
	 * @return
	 */
	@RequestMapping(path="deleteAddress")
	@ResponseBody
	public String deleteAddress(String message,HttpServletResponse response) {
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST,GET");
			return biz_app.deleteAddress(message);
		}catch (Exception e) {
			Log.logger.debug("删除地址出错了！："+e.getMessage());
			return "{'RecieveAddressList':''}";
		}
	}
	/**
	 * 设置地址默认状态
	 * @param message
	 * @param response
	 * @return
	 */
	@RequestMapping(path="setStatusAddress")
	@ResponseBody
	public String setStatusAddress(String message,HttpServletResponse response) {
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST,GET");
			return biz_app.setAddressStatus(message);
		}catch (Exception e) {
			Log.logger.debug("设置地址默认状态出错了！："+e.getMessage());
			return "{'RecieveAddressList':''}";
		}
	}
	/**
	 * 登录
	 * @param message
	 * @param response
	 * @return
	 */
	@RequestMapping(path="appLogin")
	@ResponseBody
	public String appLogin(String message,HttpServletResponse response) {
		try {
			System.out.println("----------------message:"+message);
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST,GET");
			return biz_app.login(message);
		}catch (Exception e) {
			e.printStackTrace();
			Log.logger.debug("app登录出错了！："+e.getMessage());
			return "{'msg':'no'}";
		}
	}
	/**
	 * 提交订单
	 * @param message
	 * @param response
	 * @return
	 */
	@RequestMapping(path="submitOrder")
	@ResponseBody
	public String submitOrder(String message,HttpServletResponse response,HttpSession session) {
		try {
			System.err.println("----------------message:"+message);
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST,GET");
			return biz_app.submitOrder(message,session);
		}catch (Exception e) {
			e.printStackTrace();
			Log.logger.debug("app提交订单出错了！："+e.getMessage());
			return "{'msg':'no'}";
		}
	}
	/**
	 * 支付订单
	 * @param message
	 * @param response
	 * @return
	 */
	@RequestMapping(path="payOrder")
	@ResponseBody
	public Object payOrder(String message,HttpServletResponse response,HttpSession session) {
		try {
			System.err.println("---------payOrder-------message:"+message);
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST,GET");
			return biz_app.orderDispose(message,session);
		}catch (Exception e) {
			e.printStackTrace();
			Log.logger.debug("app提交订单出错了！："+e.getMessage());
			return "{'msg':'no'}";
		}
	}
	/**
	 * 支付订单
	 * @param message
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws AlipayApiException 
	 */
	@RequestMapping(path="payOrderBack")
	@ResponseBody
	public void payOrderBack(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
		    String name = (String) iter.next();
		    String[] values = (String[]) requestParams.get(name);
		    String valueStr = "";
		    for (int i = 0; i < values.length; i++) {
		        valueStr = (i == values.length - 1) ? valueStr + values[i]
		                    : valueStr + values[i] + ",";
		    }
		    //乱码解决，这段代码在出现乱码时使用。
		  valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
		  params.put(name, valueStr);
		}
		//切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
		//boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
		String charset = "utf-8";
		String alipaypublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsfe5XGMHIJ6kMSxqfJ5O2hQs8OgGoXap3jsn1CeUP7t0FHoYEWdUuokjQR/NIUdAWQx9U0I4GqKJJ+pCm2lTuCJ/fXEEvMyJZSbzugw6/rtFhR+lKpRgjf+NMWRM630az+o/M0eOdXaiza+sEGjwKLAYqXjDw3aA89YpDF3livSmRJY8ySOW+p+Q1L+2beB5xdc71NVmAPX2fKKP8cB0qks6xzB3JvV+QVe91Leg1yOsjiSWi5LBOfuV3Y5reEUSEzUkm/hK2kV3AZJZpVx5i1GwZK91yw3GjamxI7EoOyzm8UhxJAxc8gpjaK7ZnyxBEQ/fX+MEuBjGnK/iCthcPQIDAQAB";//支付宝公钥
		boolean flag = AlipaySignature.rsaCheckV1(params, alipaypublicKey, charset,"RSA2");
		System.err.println("-------------flag:"+flag);
		
	}
	
}
