package com.hlbrc.biz;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.hlbrc.entity.Accountgroup;
import com.hlbrc.entity.Address;
import com.hlbrc.entity.AddressExample;
import com.hlbrc.entity.City;
import com.hlbrc.entity.District;
import com.hlbrc.entity.Privince;
import com.hlbrc.entity.Profileimg;
import com.hlbrc.entity.Store;
import com.hlbrc.entity.User;
import com.hlbrc.entity.UserExample;
import com.hlbrc.enums.AppEnum;
import com.hlbrc.mapper.IAccountgroupMapper;
import com.hlbrc.mapper.IAddressMapper;
import com.hlbrc.mapper.ICityMapper;
import com.hlbrc.mapper.IDistrictMapper;
import com.hlbrc.mapper.IManagerMapper;
import com.hlbrc.mapper.IPrivinceMapper;
import com.hlbrc.mapper.IProfileimgMapper;
import com.hlbrc.mapper.IStoreMapper;
import com.hlbrc.mapper.IUserMapper;
import com.hlbrc.util.ChattingRecordsIO;
import com.hlbrc.util.QqEmailSendMessage;
import com.hlbrc.util.Sendsms;
import com.hlbrc.util.Time;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * app请求处理逻辑层
 * @author ZY
 *
 */
@Service("AppBiz")
@Transactional(readOnly = true)
public class AppBiz {
	@Autowired
	private IAddressMapper address_mapper;
	@Autowired
	private IPrivinceMapper privince_mapper;
	@Autowired
	private ICityMapper city_mapper;
	@Autowired
	private IDistrictMapper district_mapper;
	@Autowired
	private IManagerMapper manager_mapper;
	@Autowired
	private IUserMapper user_mapper;
	@Autowired
	private IProfileimgMapper pro_file_img_mapper;
	@Autowired
	private IAccountgroupMapper account_group_mapper;
	@Autowired
	private IStoreMapper store_mapper;
	/**
	 * 查询用户地址
	 * @param address
	 * @return
	 */
	public String queryAddress(AddressExample address) {
		List<Address> List_address = address_mapper.selectByExample(address);
		JSONArray array = new JSONArray();
		JSONObject obj = null;
		for(Address a:List_address) {
			obj = new JSONObject();
			District district = district_mapper.selectByPrimaryKey(a.getDisId());
			City city = city_mapper.selectByPrimaryKey(district.getCitId());
			Privince privince = privince_mapper.selectByPrimaryKey(city.getProId());
			obj.accumulate("RecieveAddressID", a.getAddressid());
			obj.accumulate("RecieveName", a.getName());
			obj.accumulate("MobilePhone", a.getTel());
			obj.accumulate("RecieverProvinceID", privince.getProId());
			obj.accumulate("RecieverCityID", city.getCitId());
			obj.accumulate("RecieverCountyID", district.getDisId());
			obj.accumulate("RecieverAddress", a.getAddressDetail());
			obj.accumulate("Remark", a.getRemark());
			obj.accumulate("CreateTime2", a.getCreatTime());
			obj.accumulate("CustomerEnterID", 126);
			if(a.getIsDefault()==AppEnum.ADDRESS_DEL) {
				obj.accumulate("Disable", 1);
			}
			else {
				obj.accumulate("Disable", 0);
			}
			obj.accumulate("RecieverProvinceName", privince.getProName());
			obj.accumulate("RecieverCityName", city.getCitName());
			obj.accumulate("RecieverCountyName", district.getDisName());
			obj.accumulate("PostCode", a.getPastTode());
			obj.accumulate("IsDefault", a.getIsDefault());
			array.add(obj);
		}
		obj = new JSONObject();
		obj.accumulate("RecieveAddressList", array);
		return obj.toString();
	}
	/**
	 * 添加用户地址
	 * @param message
	 * @return
	 */
	@Transactional(rollbackFor=Throwable.class)
	public String insertAddress(String message) {
		JSONObject obj = new JSONObject();
		JSONObject obj1 = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			obj = JSONObject.fromObject(message);
			Address address = new Address();
			address.setAddressDetail(obj.getString("RecieverAddress"));
			address.setCreatTime(new Date());
			address.setDisId(obj.getInt("RecieverCountyID"));
			address.setIsDefault(obj.getInt("IsDefault"));
			address.setName(obj.getString("RecieveName"));
			address.setPastTode(obj.getString("PostCode"));
			address.setRemark(obj.getString("Remark"));
			address.setTel(obj.getString("MobilePhone"));
			address.setUserId(obj.getInt("UserId"));
			if(address_mapper.insert(address)>0) {
				obj1.accumulate("msg", AppEnum.SUCCEED);
			}
			else {
				obj1.accumulate("msg", AppEnum.FAIL);
			}
		}
		else {
			obj1.accumulate("msg", AppEnum.FAIL);
		}
		return obj1.toString();
	}
	/**
	 * 修改用户地址
	 * @param message
	 * @return
	 */
	@Transactional(rollbackFor=Throwable.class)
	public String updateAddress(String message) {
		JSONObject obj = new JSONObject();
		JSONObject obj1 = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			obj = JSONObject.fromObject(message);
			Address address = new Address();
			address.setAddressid(obj.getInt("RecieveAddressID"));
			address.setAddressDetail(obj.getString("RecieverAddress"));
			address.setCreatTime(new Date());
			address.setDisId(obj.getInt("RecieverCountyID"));
			address.setIsDefault(obj.getInt("IsDefault"));
			address.setName(obj.getString("RecieveName"));
			address.setPastTode(obj.getString("PostCode"));
			address.setRemark(obj.getString("Remark"));
			address.setTel(obj.getString("MobilePhone"));
			address.setUserId(obj.getInt("UserId"));
			if(address_mapper.updateByPrimaryKeySelective(address)>0) {
				obj1.accumulate("msg", "ok");
			}
			else {
				obj1.accumulate("msg", AppEnum.FAIL);
			}
		}
		else {
			obj1.accumulate("msg", AppEnum.FAIL);
		}
		return obj1.toString();
	}
	/**
	 * 删除用户地址
	 * @param message
	 * @return
	 */
	@Transactional(rollbackFor=Throwable.class)
	public String deleteAddress(String message) {
		JSONObject obj = new JSONObject();
		JSONObject obj1 = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			obj = JSONObject.fromObject(message);
			if(address_mapper.deleteByPrimaryKey(obj.getInt("RecieveAddressID"))>0) {
				obj1.accumulate("msg", AppEnum.SUCCEED);
			}
			else {
				obj1.accumulate("msg", AppEnum.FAIL);
			}
		}
		else {
			obj1.accumulate("msg", AppEnum.FAIL);
		}
		return obj1.toString();
	}
	/**
	 * 设置默认地址
	 * @param message
	 * @return
	 */
	@Transactional(rollbackFor=Throwable.class)
	public String setAddressStatus(String message) {
		JSONObject obj = new JSONObject();
		JSONObject obj1 = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			obj = JSONObject.fromObject(message);
			AddressExample example = new AddressExample();
			Address ads = new Address();
			ads.setAddressid(obj.getInt("RecieveAddressID"));
			ads.setIsDefault(AppEnum.ADDRESS_DEFAULT);
			int i = address_mapper.updateByPrimaryKeySelective(ads);
			int j = 0;
			List<Address> list = address_mapper.selectByExample(example);
			for(Address address:list) {
				if(address.getIsDefault()==AppEnum.ADDRESS_DEFAULT&&address.getAddressid()!=obj.getInt("RecieveAddressID")) {
					ads = new Address();
					ads.setAddressid(address.getAddressid());
					ads.setIsDefault(AppEnum.ADDRESS_NOT_DEFAULT);
					j = address_mapper.updateByPrimaryKeySelective(ads);
					break;
				}
			}
			if(i>0&&j>0) {
				obj1.accumulate("msg", AppEnum.SUCCEED);
			}
			else {
				obj1.accumulate("msg", AppEnum.FAIL);
			}
		}
		else {
			obj1.accumulate("msg", AppEnum.FAIL);
		}
		return obj1.toString();
	}
	/**
	 * 用户登录
	 * @param message
	 * @return
	 * @throws Exception 
	 */
	public String login(String message) throws Exception {
		JSONObject obj = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			obj = JSONObject.fromObject(message);
			criteria.andUserTelEqualTo(obj.getString("Phone"));
			criteria.andPasswordEqualTo(obj.getString("Password"));
			List<User> list = user_mapper.selectByExample(example);
			if(list!=null&&list.size()>0) {
				for(User user:list) {
					obj.accumulate("msg", AppEnum.SUCCEED);
					obj.accumulate("UserAccountID", user.getUserId());
					obj.accumulate("UserNo", user.getUserNo());
					obj.accumulate("UserName", user.getUserName());
					obj.accumulate("Mobile", user.getUserTel());
					obj.accumulate("Phone", user.getUserTel());
					obj.accumulate("BelongID", 70);
					obj.accumulate("FromEnterpriseID", user.getFromEnterpriseId());
					obj.accumulate("CustomerType", user.getUserGrade());
					obj.accumulate("Status", user.getUserState());
					obj.accumulate("LastLoginTime", user.getLastLoginTime());
					obj.accumulate("LastLoginIP", user.getLastLoginIp());
					obj.accumulate("LoginTime", user.getFirstLoginTime());
					obj.accumulate("LoginIP", user.getFirstLoginIp());
					Profileimg profileimg =  pro_file_img_mapper.queryImg(user.getUserId());
					String domain_name = new ChattingRecordsIO().readFile("Super", "my_domain_name");
					if(profileimg!=null) {
						obj.accumulate("HeadImageUrl", domain_name+"/pro_head_portrait/"+profileimg.getPro_file_img_path());
					}
					else {
						obj.accumulate("HeadImageUrl", "");
					}
					obj.accumulate("CreateTime", user.getUserRegistTime());
					obj.accumulate("IsTax", user.getIsTax());
					if(user.getUserState()!=Integer.getInteger(AppEnum.USER_LIMIT_LOGIN)) {
						obj.accumulate("IsEffectiveAccount", 1);
					}
					else {
						obj.accumulate("IsEffectiveAccount", 0);
					}
					Accountgroup accountgroup = account_group_mapper.selectByPrimaryKey(user.getAccountGroupId());
					if(accountgroup!=null) {
						obj.accumulate("AccountGroup", accountgroup.getAccountGroupNo());
					}
					else {
						obj.accumulate("AccountGroup", "");
					}
					obj.accumulate("Disable", user.getDisable());
					obj.accumulate("OrderRefundRate", user.getOrderRefundRate());
					obj.accumulate("RewardAmountRate", user.getRewardAmountRate());
					Store store = store_mapper.queryById(user.getStoreId());
					if(store!=null) {
						obj.accumulate("DepartmentName", store.getStore_name());
						obj.accumulate("Salesman", store.getStore_manager_name());
						obj.accumulate("SalesmanTEL", store.getManager_tel());
						obj.accumulate("Salessuper", store.getManager_second_name());
						obj.accumulate("SalessuperTEL", store.getManager_second_tel());
					}
					else {
						obj.accumulate("DepartmentName", "");
					}
					obj.accumulate("PlantLandlineNumber", user.getFixedLineTelephonne());
					obj.accumulate("AddPriceRatio", 0.1);
					obj.accumulate("Password", user.getPassword());
					break; 
				}
			}
			else {
				obj.accumulate("msg", AppEnum.FAIL);
			}

		}
		else {
			obj.accumulate("msg", AppEnum.FAIL);
		}
		return obj.toString();
	}
	/**
	 * 注册
	 * @param message
	 * @return
	 */
	public String signup(String message) {
		JSONObject obj = new JSONObject();
		JSONObject obj1 = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			obj = JSONObject.fromObject(message);
			criteria.andEmailEqualTo(obj.getString("Phone"));
			List<User> list = user_mapper.selectByExample(example);
			if(list!=null&&list.size()>0) {
				User user = new User();
				user.setAccountGroupId(1);
				user.setFromEnterpriseId(obj.getString("FromEnterpriseID"));
				user.setIsTax(1);
				String userIdcardNum = obj.getString("UserIdcardNum");
				if(userIdcardNum!=null&&!"".equals(userIdcardNum)) {
					//152327199905250023
					//通过身份证号码计算年龄
					String birthday=userIdcardNum.substring(6,14);
					int day=Integer.parseInt(userIdcardNum.substring(10,14));
					int age=Time.Getyear()-Integer.parseInt(userIdcardNum.substring(6,10));
					if(Integer.parseInt(Time.Getmonth()+Time.Getday())<day)
						 age=age-1;		
					//通过身份证号码判断性别
					String sex;
					if(Integer.parseInt(userIdcardNum.substring(16,17))%2==0)
						sex="女";
					else
						sex="男";
					user.setUserAge(age);
					user.setUserBirthTime(birthday);
					user.setUserSex(sex);
				}
				user.setUserIdcardNum(obj.getString("UserIdcardNum"));
				user.setUserName(obj.getString("UserName"));
				user.setUserNo(obj.getString("UserNo"));
				user.setUserRegistTime(new Date());
				user.setUserState(AppEnum.ADDRESS_DEFAULT);
				user.setUserTel(obj.getString("Phone"));
				user.setEmail(obj.getString("Email"));
				if(user_mapper.insert(user)>0) {
					obj1.accumulate("msg", AppEnum.SUCCEED);
				}
				else {
					obj1.accumulate("msg", AppEnum.FAIL);
				}
			}
			else {
				obj1.accumulate("msg", AppEnum.TEL_ALREADY_EXISTS);//手机号已存在
			}
		}
		else {
			obj1.accumulate("msg", AppEnum.FAIL);
		}
		return obj1.toString();
	}
	/**
	 * 验证旧密码 先校验手机号是否存在，然后校验密码是否正确
	 * @param message
	 * @return
	 */
	public String verifyOldPwd(String message,HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		JSONObject obj1 = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			obj = JSONObject.fromObject(message);
			criteria.andUserTelEqualTo(obj.getString("Phone"));
			List<User> list = user_mapper.selectByExample(example);
			if(list!=null&&list.size()>0) {
				criteria.andPasswordEqualTo(obj.getString("Password"));
				list = user_mapper.selectByExample(example);
				if(list!=null) {
					request.getSession().setAttribute("appPhoneVerOld", obj.getString("Phone"));
					obj1.accumulate("msg", AppEnum.SUCCEED);
				}
				else {
					obj1.accumulate("msg", AppEnum.FAIL);
				}
			}
			else {
				obj1.accumulate("msg", AppEnum.TEL_NOT_EXISTS);
			}
		}
		else {
			obj1.accumulate("msg", AppEnum.FAIL);
		}
		return obj1.toString();
	}
	/**
	 * 通过手机号修改密码
	 * @param message
	 * @return
	 */
	public String updatePwd(String message,HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		JSONObject obj1 = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			UserExample example = new UserExample();
			User user = new User();
			UserExample.Criteria criteria = example.createCriteria();
			obj = JSONObject.fromObject(message);
			if(request.getSession().getAttribute("appPhoneVerOld").equals(obj.getString("Phone"))) {
				user.setPassword(obj.getString("Password"));
				criteria.andUserTelEqualTo(obj.getString("Phone"));
				if(user_mapper.updateByExampleSelective(user, example)>0) {
					obj1.accumulate("msg", AppEnum.SUCCEED);
				}
				else {
					obj1.accumulate("msg", AppEnum.FAIL);
				}
			}
			else {
				obj1.accumulate("msg", AppEnum.TEL_BEEN_CHANGED);
			}
		}
		else {
			obj1.accumulate("msg", AppEnum.FAIL);
		}
		return obj1.toString();
	}
	/**
	 * 发送手机验证码
	 * @param message
	 * @param request
	 * @return
	 */
	public String sendTelVerifyCode(String message,HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		JSONObject obj1 = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			obj = JSONObject.fromObject(message);
			criteria.andEmailEqualTo(obj.getString("Email"));
			List<User> list = user_mapper.selectByExample(example);
			if(list==null&&list.size()>0) {
				Sendsms s = new Sendsms();
				int d = s.send(obj.getString("Phone"),request);
				String random = (String)request.getSession().getAttribute("RANDOMCODEKEY");
				System.out.println("Tel验证码:"+random+new Date());
				if(d>0){
					request.getSession().setAttribute("appPhone",obj.getString("Phone"));
					obj1.accumulate("msg", AppEnum.SUCCEED);
				}
				else{
					obj1.accumulate("msg", AppEnum.FAIL);
				}
			}
			else {
				obj1.accumulate("msg", AppEnum.TEL_ALREADY_EXISTS);//手机号已存在
			}
		}
		else {
			obj1.accumulate("msg", AppEnum.FAIL);
		}
		return obj1.toString();
	}
	/**
	 * 校验手机号
	 * @param message
	 * @param request
	 * @return
	 */
	public String verifyTel(String message,HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		JSONObject obj1 = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			obj = JSONObject.fromObject(message);
			if(request.getSession().getAttribute("appPhone").equals(obj.getString("Phone"))) {
				if(request.getSession().getAttribute("RANDOMCODEKEY").equals(obj.getString("VerifyCode"))){
					obj1.accumulate("msg", AppEnum.SUCCEED);
				}
				else {
					obj1.accumulate("msg", AppEnum.FAIL);
				}
			}
			else {
				obj1.accumulate("msg", AppEnum.TEL_BEEN_CHANGED);
			}
		}
		else {
			obj1.accumulate("msg", AppEnum.FAIL);
		}
		return obj1.toString();
	}
	/**
	 * 发送邮箱验证码
	 * @param message
	 * @return
	 */
	public String sendEmailVerifyCode(String message,HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		JSONObject obj1 = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			obj = JSONObject.fromObject(message);
			request.getSession().setAttribute("appEmail", obj.getString("Email"));
			if(QqEmailSendMessage.sendEmail(obj.getString("Email"),request)) {
				obj1.accumulate("msg", AppEnum.SUCCEED);
			}
			else {
				obj1.accumulate("msg", AppEnum.FAIL);
			}
		}
		else {
			obj1.accumulate("msg", AppEnum.FAIL);
		}
		return obj1.toString();
	}
	/**
	 * 校验邮箱
	 * @param message
	 * @return
	 */
	public String verifyEmail(String message,HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		JSONObject obj1 = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			obj = JSONObject.fromObject(message);
			if(request.getSession().getAttribute("appEmail").equals(obj.getString("Email"))) {
				if(request.getSession().getAttribute("appEmailVerifyCode").equals(obj.getString("VerifyCode"))) {
					obj1.accumulate("msg", AppEnum.SUCCEED);
				}
				else {
					obj1.accumulate("msg", AppEnum.FAIL);
				}
			}
			else {
				obj1.accumulate("msg", AppEnum.EMAIL_BEEN_CHANGED);//邮箱地址改变了
			}
		}
		else {
			obj1.accumulate("msg", AppEnum.FAIL);
		}
		return obj1.toString();
	}
	/**
	 * 提交订单
	 * @param message
	 * @return
	 */
	public String submitOrder(String message,HttpSession session) {
		JSONObject obj = new JSONObject();
		if(message!=null&&!"".equals(message)) {
//			obj = JSONObject.fromObject(message);
//			System.out.println(obj.toString());
//			obj = new JSONObject();
			JSONObject obj2 = new JSONObject();
			int mobile_code = (int)((Math.random()*9+1)*100000);
			String o = new Date().getTime()+""+mobile_code;
			System.err.println("----------payOrder---------orderNo:"+o);
			session.setAttribute("appOrderNo", o);
			obj2.accumulate("OrderNo", o);
			obj2.accumulate("TotalAmount", 56.25);
			obj2.accumulate("payMoney", 56);
			obj.accumulate("Order", obj2);
			obj.accumulate("TotalMoney", 0);
			obj2 = new JSONObject();
			obj2.accumulate("AcountBalance", 100);
			obj2.accumulate("HasPassword", true);
			obj.accumulate("AcountBalance", obj2);
			obj.accumulate("msg", AppEnum.SUCCEED);
		}
		else {
			obj.accumulate("msg", AppEnum.FAIL);
		}
		return obj.toString();
	}
	
	/**
	 * 订单支付处理
	 * @param message
	 * @param session
	 * @return
	 * @throws AlipayApiException
	 */
	public Object orderDispose(String message,HttpSession session) throws AlipayApiException {
		if(message!=null&&!"".equals(message)) {
			String APP_ID="2016101700706515";
			String APP_PRIVATE_KEY="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCd+NY0eJo0g9AxP9iydi0yxODQKij2xB3oRTGLi+rv20TS/ausa+36ZRgqsnPbrB1h3zf1tmXKXLwcnwmGTWIT6nZpbf5SqysheXwGE+GwtG1H5OwrgAI7Cs3oL0xJtXhbfmaqPhrDCd258fLCl+9ZnavlAIGTaR/vhd+55YC/v+voP2Jyl2xHdU8oZMhDNyWxks+mmuIVEg8dOYsd1OeYPzuaMN5FguwdK2K7Uv4MMbZRIGN2TRfIhxJJKJ+ClZIbAggRLn0MSJJtgIe0Ftky85eabJE4aT+yyQ4ul5d3cWGMltTIRlkQ98xkdIgjgrVqUMohHqnwJ6SIbAGQa4klAgMBAAECggEAPfg4p3rMG1++EyPVsSR01J6xBlgTm8IRbWV/axunPRKKLC7A4rGwOHLiCRXaJ0mceSFkxWoZAkpgrOWiieHfYKqwaulwRCPLlqUehw/TkEsnN3XRQ7tCpMC3R6cOSTf8EABE6/HS88HyDhigv790cHZO0VXift5VXdPpkPY8DHvwP85Ji4dRSgoRuMW/ZkszLxcrInNP2xGdjWW9TOXfHmxcIsIa+A0tTl3RPGhBUgvcoYtA33ZtgcynjQbnPcqer7bLbWbbEx5T23uvnZ3TsNLr878AgWGlwpwmkiFg1FIpZASOh4NFw8vG3tAUnmh6pVgn3ADk3c3Qlq3WIfqjgQKBgQDu/e1f12CB+mtdCTpsOyan+zT2aIW9epv94aO1Hab1djuJ9e+UbZJye+DHuJHS+hTSrU8MvGmgieb+mzEyZ+TdhTa5Z/FCbuhgRCFvPFKpopSWOVv35yOwV5K+tXKcRCpQGb4BNgUioqvtJ2O6ATbBLjcxSlHutK4SwyCcYcAiYQKBgQCpNtlhWs9jSs4F+AR4F3PxXfWhTfNYBUgbVu+Yxmdcd5hine33SJF+9j+bN7bTM62Yp7ZZei1DC2v0jiW/DGR8M61X63HHyzyJuwu4NvKqMf8vhBspUgwA7h4XfSDFA5c6z4r2Zv2tad6rmj1KnnobY8r/6Js7whMw/27Gx1JlRQKBgQCLTYdnLesa2BRsjkx3eaL2lv4wAoyx/R2fxj3d/AKtYNUjfS7AnX2XLY2/3F1jVFF+23YQPmJzKO5zyZHLh7NnS5ayS1vdFThtpEi4xbiJGDLzvUtWHGw5BVKLxsefPjxLpDWUDyC/J4J/IU6HxN1djMqu+Fr5gGdWmFYR0QhlAQKBgF6aa64iNxAsIkL0BoudkRTAkzM7gXEUgtvGHu4q/l6T/n4kDYbS64Uv5x/AZlZt7gAKw8gCpot1N0Xisve81fEacy9UUqiA17eo+0RidAjzKthF42mWlV9vwSMgsdFz0Hjwz6AytGDfb75A3UN6lon5oOSyBxfByTj7ldNMXKSBAoGBAJsNGGZQjNbVZ4OC7O2/AQJC3KHRVT1M3R9h8iqIoOCaN7WKnyT1KckxI/w6AGlFLufsqUkzaHtpJM3DjuToyK8uaVJSuwiUBJpKpWCa72iwcUZE3nIINR27xMkNSbL0Op9KkgQoXHtWdLdc3diFLa4XGl9rcx1lloy/rFl48a4s";
			String ALIPAY_PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsfe5XGMHIJ6kMSxqfJ5O2hQs8OgGoXap3jsn1CeUP7t0FHoYEWdUuokjQR/NIUdAWQx9U0I4GqKJJ+pCm2lTuCJ/fXEEvMyJZSbzugw6/rtFhR+lKpRgjf+NMWRM630az+o/M0eOdXaiza+sEGjwKLAYqXjDw3aA89YpDF3livSmRJY8ySOW+p+Q1L+2beB5xdc71NVmAPX2fKKP8cB0qks6xzB3JvV+QVe91Leg1yOsjiSWi5LBOfuV3Y5reEUSEzUkm/hK2kV3AZJZpVx5i1GwZK91yw3GjamxI7EoOyzm8UhxJAxc8gpjaK7ZnyxBEQ/fX+MEuBjGnK/iCthcPQIDAQAB";
			//签名方式
			String sign_type="RSA2";
			//编码格式
			String CHARSET="utf-8";
			//正式环境支付宝网关，如果是沙箱环境需更改成https://openapi.alipaydev.com/gateway.do
			//正式环境支付宝网关：https://openapi.alipay.com/gateway.do
			String url="https://openapi.alipaydev.com/gateway.do";
			//实例化客户端
			AlipayClient alipayClient = new DefaultAlipayClient(url, APP_ID, APP_PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY,sign_type);
			//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
			AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
			//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
			
			String orderNo = session.getAttribute("appOrderNo")+"";
			if(orderNo!=null&&!"".equals(orderNo)) {
				System.err.println("----------payOrder---------orderNo:"+orderNo);
				//请保证OutTradeNo值每次保证唯一
				AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
				model.setBody("购物商城");
				model.setSubject("java App支付");
				model.setOutTradeNo(orderNo);
				model.setTimeoutExpress("30m");
				model.setTotalAmount(message);
				model.setProductCode("QUICK_MSECURITY_PAY");
				request.setBizModel(model);
				request.setNotifyUrl("https://hlbrc.utools.club/DiplomaProject/payOrderBack.do");//商户外网可以访问的异步地址
				try {
			        //这里和普通的接口调用不同，使用的是sdkExecute
			        AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
			        System.err.println("body==="+response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
			        return response.getBody();
				}catch (AlipayApiException e) {
			        e.printStackTrace();
				}
			}
		}
		return null;
	}
}
