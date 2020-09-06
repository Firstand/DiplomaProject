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
	 * ��ѯ��ַ
	 * @param userid
	 * @param response
	 * @return
	 */
	@RequestMapping(path="queryAddress")
	@ResponseBody
	public String queryAddress(String userid,HttpServletResponse response) {
		try {
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
		}catch (Exception e) {
			Log.logger.debug("��ѯ��ַ�����ˣ���"+e.getMessage());
			return "{'RecieveAddressList':''}";
		}
	}
	/**
	 * �޸ĵ�ַ
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
			Log.logger.debug("�޸ĵ�ַ�����ˣ���"+e.getMessage());
			return "{'RecieveAddressList':''}";
		}
	}
	/**
	 * ������ַ
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
			Log.logger.debug("������ַ�����ˣ���"+e.getMessage());
			return "{'RecieveAddressList':''}";
		}
	}
	/**
	 * ɾ����ַ
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
			Log.logger.debug("ɾ����ַ�����ˣ���"+e.getMessage());
			return "{'RecieveAddressList':''}";
		}
	}
	/**
	 * ���õ�ַĬ��״̬
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
			Log.logger.debug("���õ�ַĬ��״̬�����ˣ���"+e.getMessage());
			return "{'RecieveAddressList':''}";
		}
	}
	/**
	 * ��¼
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
			Log.logger.debug("app��¼�����ˣ���"+e.getMessage());
			return "{'msg':'no'}";
		}
	}
	/**
	 * �ύ����
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
			Log.logger.debug("app�ύ���������ˣ���"+e.getMessage());
			return "{'msg':'no'}";
		}
	}
	/**
	 * ֧������
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
			Log.logger.debug("app�ύ���������ˣ���"+e.getMessage());
			return "{'msg':'no'}";
		}
	}
	/**
	 * ֧������
	 * @param message
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws AlipayApiException 
	 */
	@RequestMapping(path="payOrderBack")
	@ResponseBody
	public void payOrderBack(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
		//��ȡ֧����POST����������Ϣ
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
		    //����������δ����ڳ�������ʱʹ�á�
		  valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
		  params.put(name, valueStr);
		}
		//�м�alipaypublickey��֧�����Ĺ�Կ����ȥopen.alipay.com��ӦӦ���²鿴��
		//boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
		String charset = "utf-8";
		String alipaypublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsfe5XGMHIJ6kMSxqfJ5O2hQs8OgGoXap3jsn1CeUP7t0FHoYEWdUuokjQR/NIUdAWQx9U0I4GqKJJ+pCm2lTuCJ/fXEEvMyJZSbzugw6/rtFhR+lKpRgjf+NMWRM630az+o/M0eOdXaiza+sEGjwKLAYqXjDw3aA89YpDF3livSmRJY8ySOW+p+Q1L+2beB5xdc71NVmAPX2fKKP8cB0qks6xzB3JvV+QVe91Leg1yOsjiSWi5LBOfuV3Y5reEUSEzUkm/hK2kV3AZJZpVx5i1GwZK91yw3GjamxI7EoOyzm8UhxJAxc8gpjaK7ZnyxBEQ/fX+MEuBjGnK/iCthcPQIDAQAB";//֧������Կ
		boolean flag = AlipaySignature.rsaCheckV1(params, alipaypublicKey, charset,"RSA2");
		System.err.println("-------------flag:"+flag);
		
	}
	
}
