package com.hlbrc.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hlbrc.biz.ManagerBiz;
import com.hlbrc.entity.District;
import com.hlbrc.entity.Manager;
import com.hlbrc.enums.IRole;
import com.hlbrc.util.Log;
import com.hlbrc.util.MD5;
import com.hlbrc.util.MyTools;
import com.hlbrc.util.Time;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
/**
 * 主要控制层
 * @author ZY
 *
 */
@SuppressWarnings("restriction")
@Controller
public class MajorAction {
	@Autowired
	ManagerBiz biz_manager;
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping(path="login",method=RequestMethod.GET)
	public String login(){
		return "publics/login.jsp";
	}
	@RequestMapping(path="login",method=RequestMethod.POST)
	public String login(String exampleInputEmail_2,String exampleInputpwd_2,HttpSession session,ModelMap model) {
		try {
			Manager m =  biz_manager.queryByTel(exampleInputEmail_2);
			if(m!=null)
			{
				if(m.getManager_password().equals(MD5.getMD5(Base64.encode(exampleInputpwd_2.getBytes()))))
				{
					List<Manager> manager_not = biz_manager.queryAll_not(m.getManager_tel());
					//创建个人聊天记录表
					biz_manager.creatMessageTable(IRole.MANAGER_TABLE+"_"+m.getManager_id());
					session.setAttribute("manager", m);
					session.setAttribute("manager_not", manager_not);
					return "common_admin/index.jsp";
				}
				else
				{
					model.addAttribute("msg", "密码错误！");
					return "publics/login.jsp";
				}
			}
			else
			{
				model.addAttribute("msg", "用户不存在！");
				return "publics/login.jsp";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.debug("MajorAction中login()方法出错啦！登录失败："+e.getMessage());
			return "error/500.jsp";
		}
	}
	
	/**
	 * 注册
	 * @return
	 */
	@RequestMapping(path="signup",method=RequestMethod.GET)
	public String signup(){
		return "publics/signup.jsp";
	}
	
	@RequestMapping(path="signup",method=RequestMethod.POST)
	public String signup(String u_name,String u_tel,String u_email,String u_verify,String u_id,String pwd,String repwd,HttpSession session,Model model) {
		//数据回显初始化
		Map<String, String> ma = new HashMap<String, String>();
		MyTools mytools = new MyTools();
		ma.put("u_name", u_name);
		ma.put("u_tel", u_tel);
		ma.put("u_email", u_email);
		ma.put("u_id",u_id);
		ma.put("pwd", pwd);
		ma.put("repwd", repwd);
		try {
			//接收验证码
			String random = (String)session.getAttribute("RANDOMCODEKEY");
			System.out.println("手机验证码:"+random);
			if(biz_manager.queryByTel(u_tel)!=null)//判断手机号是否被注册
			{
				ma.put("msg", "该手机号已被注册，请直接登陆!");
				mytools.setModel(model, ma);
				session.removeAttribute("RANDOMCODEKEY");
				return "publics/login.jsp";
			}
			else if(!u_verify.equals(random))//判断手机验证码是否正确
			{
				ma.put("msg", "手机验证码有误，请重新获取！");
				mytools.setModel(model, ma);
				session.removeAttribute("RANDOMCODEKEY");
				return "publics/signup.jsp";
			}
			else if(!pwd.equals(repwd))//判断两次密码是否一致
			{
				ma.put("msg", "两次密码不一致，请更正！");
				mytools.setModel(model, ma);
				session.removeAttribute("RANDOMCODEKEY");
				return "publics/signup.jsp";
			}
			else if(!mytools.cardId(u_id))//判断身份证号是否有误
			{
				ma.put("msg", "身份证号有误，请更正！");
				mytools.setModel(model, ma);
				session.removeAttribute("RANDOMCODEKEY");
				return "publics/signup.jsp";
			}
			else {
				pwd = MD5.getMD5(Base64.encode(pwd.getBytes()));
				//152327199905250023
				//通过身份证号码计算年龄
				String birthday=u_id.substring(6,14);
				int day=Integer.parseInt(u_id.substring(10,14));
				int age=Time.Getyear()-Integer.parseInt(u_id.substring(6,10));
				if(Integer.parseInt(Time.Getmonth()+Time.Getday())<day)
					 age=age-1;		
				//通过身份证号码判断性别
				String sex;
				if(Integer.parseInt(u_id.substring(16,17))%2==0)
					sex="女";
				else
					sex="男";
				int dis_id = Integer.parseInt(u_id.substring(0,6));
				//添加管理员表
				Manager m=new Manager();
				District d = new District();
				d.setDisId(dis_id);
				m.setDistrict(d);
				m.setManager_name(u_name);
				m.setManager_age(age);
				m.setManager_sex(sex);
				m.setManager_password(pwd);
				m.setManager_birth_time(birthday);
				m.setManager_email(u_email);
				m.setManager_tel(u_tel);
				m.setManager_idcard_num(u_id);
				m.setManager_type(1);
				m.setManager_regist_time(new Timestamp(new Date().getTime()));
				try {
					//添加管理员
					biz_manager.insert(m);
					m = biz_manager.queryByTel(u_tel);
					//创建个人聊天记录表
					biz_manager.creatMessageTable(IRole.MANAGER_TABLE+"_"+m.getManager_id());
				} catch (Exception e) {
					e.printStackTrace();
					Log.logger.debug("MajorAction中signup()方法出错啦！管理员注册失败："+e.getMessage());
					return "error/500.jsp";	
				}
				ma.put("msg", "注册成功!");
				mytools.setModel(model, ma);
				return "publics/login.jsp";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			Log.logger.error("MajorAction中signup()方法出错啦！"+e.getMessage());
			ma.put("msg", "网络异常，请和管理员联系");
			mytools.setModel(model, ma);
			return "error/404.jsp";
		 }
	}
	
	/**
	 * 忘记密码页面显示
	 * @param model
	 * @return
	 */
	@RequestMapping(path="forgot_pwd",method=RequestMethod.GET)
	public String forget_pwd(Model model){
		return "publics/forgot-password.jsp";
	}
	
	/**
	 * 忘记密码
	 * @param u_tel
	 * @param flag
	 * @param u_tel1
	 * @param u_tel2
	 * @param u_verify
	 * @param pwd
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(path="forgot_pwd",method=RequestMethod.POST)
	public String forgot_pwd(String u_tel,String flag,String u_tel1,String u_tel2,String u_verify,String pwd,HttpSession session,Model model) {
		//数据回显初始化
		Map<String, String> ma = new HashMap<String, String>();
		MyTools mytools = new MyTools();
		if(flag!=null&&!"".equals(flag)){
			try {
				if("1".equals(flag)&&u_tel!=null&&!"".equals(u_tel)){//验证手机号是否存在
					ma.put("u_tel", u_tel);
					if(biz_manager.queryByTel(u_tel)!=null) {
						mytools.setModel(model, ma);
						return "publics/forgot-password-verify.jsp";
					}
					else{
						ma.put("msg", "账号不存在，请确认手机是否正确！");
						mytools.setModel(model, ma);
					}
				}
				else if("2".equals(flag)&&u_tel1!=null&&!"".equals(u_tel1)){//验证手机验证码是否正确
					ma.put("u_tel", u_tel1);
					//接收验证码
					String random = (String)session.getAttribute("RANDOMCODEKEY");
					System.out.println("手机验证码:"+random);
					if(!u_verify.equals(random))//判断手机验证码是否正确
					{
						ma.put("msg", "手机验证码有误，请重新获取！");
						mytools.setModel(model, ma);
						session.removeAttribute("RANDOMCODEKEY");
						return "publics/forgot-password-verify.jsp";
					}
					else {
						mytools.setModel(model, ma);
						return "publics/forgot-password-update.jsp";
					}
				}
				else if("3".equals(flag)&&u_tel2!=null&&!"".equals(u_tel2)){//修改密码
					ma.put("u_tel", u_tel2);
					Manager manage = biz_manager.queryByTel(u_tel2);
					pwd = MD5.getMD5(Base64.encode(pwd.getBytes()));
					if(!manage.getManager_password().equals(pwd))
					{
						manage.setManager_password(pwd);
						biz_manager.update(manage);
						ma.put("msg", "密码修改成功！");
						mytools.setModel(model, ma);
						return "publics/login.jsp";
					}
					else {
						ma.put("msg", "新密码不可以与旧密码相同，更正或直接登录！");
						mytools.setModel(model, ma);
						return "publics/forgot-password-update.jsp";
					}
				}
				else{
					return "error/404.jsp";	
				}
				
			}catch(Exception e){
				e.printStackTrace();
				Log.logger.debug("MajorAction中forgot_pwd()方法出错啦！密码修改失败："+e.getMessage());
				return "error/500.jsp";	
			}
			
		}
		return "publics/forgot-password.jsp";
		
	}
	
	/**
	 * 主界面
	 * @param session
	 * @return
	 */
	@RequestMapping(path="index",method=RequestMethod.GET)
	public String index(HttpSession session){
		Manager manager = (Manager)session.getAttribute("manager");
		if(manager==null)
		{
			return "publics/login.jsp";
		}
		return "common_admin/index.jsp";
	}
	
	@RequestMapping(path="index",method=RequestMethod.POST)
	public String index(String exampleInputEmail_2,String exampleInputpwd_2) {
		return "common_admin/index.jsp";
		
	}
	/**
	 * 锁定页面显示
	 * @param httpsession
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(path="locked",method=RequestMethod.GET)
	public String locked(HttpSession httpsession,HttpServletRequest request,Model model) {
		Manager m = (Manager)httpsession.getAttribute("manager");
		if(m==null) {
			model.addAttribute("msg","请先登录");
			return "publics/login.jsp";
		}
		else {
//			String path = request.getContextPath();
//			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+ "/";
//			return "redirect:" + basePath + "publics/locked.jsp";
			return "publics/locked.jsp";
		}
	}
	
	/**
	 * 锁定
	 * @param pwd
	 * @param httpsession
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(path="locked",method=RequestMethod.POST)
	public String locked(String pwd,HttpSession httpsession,HttpServletRequest request,Model model) {
		Manager m = (Manager)httpsession.getAttribute("manager");
		if(m==null) {
			model.addAttribute("msg","请先登录");
			return "publics/login.jsp";
		}
		else {
			pwd = MD5.getMD5(Base64.encode(pwd.getBytes()));
			if(pwd.equals(m.getManager_password())) {
				return "common_admin/index.jsp";
			}
			else {
				model.addAttribute("msg", "密码错误！");
//				String path = request.getContextPath();
//				String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+ "/";
//				return "redirect:" + basePath + "publics/locked.jsp";
				return "publics/locked.jsp";
			}
		}
	}
	
	/**
	 * 修改密码页面显示
	 */
	@RequestMapping(path="reset_password",method=RequestMethod.GET)
	public String reset_password(HttpSession httpsession,Model model) {
		Manager m = (Manager)httpsession.getAttribute("manager");
		if(m==null) {
			model.addAttribute("msg","请先登录");
			return "publics/login.jsp";
		}
		else {
			return "publics/reset-password.jsp";
		}
	}
	/**
	 * 修改密码
	 * @param oldpwd
	 * @param newpwd
	 * @param httpsession
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(path="reset_password",method=RequestMethod.POST)
	public String reset_password(String oldpwd,String newpwd,HttpSession httpsession,HttpServletRequest request,Model model) {
		Manager m = (Manager)httpsession.getAttribute("manager");
		if(m==null) {
			model.addAttribute("msg","请先登录");
			return "publics/login.jsp";
		}
		else {
			oldpwd = MD5.getMD5(Base64.encode(oldpwd.getBytes()));
			if(oldpwd.equals(m.getManager_password())) {
				newpwd = MD5.getMD5(Base64.encode(newpwd.getBytes()));
				try {
					m.setManager_password(newpwd);
					biz_manager.update(m);
					model.addAttribute("msg","1");
//					String path = request.getContextPath();
//					String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+ "/";
					httpsession.invalidate();
					return "publics/login.jsp";
				} catch (Exception e) {
					model.addAttribute("msg","密码修改失败！");
					e.printStackTrace();
					return "publics/reset-password.jsp";
				}
			}
			else {
				model.addAttribute("msg", "旧密码不正确，请核对一下！");
				return "publics/reset-password.jsp";
			}
			
		}
	}
	/**
	 * 注销登录
	 * @param request
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+ "/";
		request.getSession().invalidate();
		return "redirect:" + basePath + "login.do";
	}
}
