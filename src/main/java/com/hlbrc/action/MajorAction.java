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
 * ��Ҫ���Ʋ�
 * @author ZY
 *
 */
@SuppressWarnings("restriction")
@Controller
public class MajorAction {
	@Autowired
	ManagerBiz biz_manager;
	
	/**
	 * ��¼
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
					//�������������¼��
					biz_manager.creatMessageTable(IRole.MANAGER_TABLE+"_"+m.getManager_id());
					session.setAttribute("manager", m);
					session.setAttribute("manager_not", manager_not);
					return "common_admin/index.jsp";
				}
				else
				{
					model.addAttribute("msg", "�������");
					return "publics/login.jsp";
				}
			}
			else
			{
				model.addAttribute("msg", "�û������ڣ�");
				return "publics/login.jsp";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.debug("MajorAction��login()��������������¼ʧ�ܣ�"+e.getMessage());
			return "error/500.jsp";
		}
	}
	
	/**
	 * ע��
	 * @return
	 */
	@RequestMapping(path="signup",method=RequestMethod.GET)
	public String signup(){
		return "publics/signup.jsp";
	}
	
	@RequestMapping(path="signup",method=RequestMethod.POST)
	public String signup(String u_name,String u_tel,String u_email,String u_verify,String u_id,String pwd,String repwd,HttpSession session,Model model) {
		//���ݻ��Գ�ʼ��
		Map<String, String> ma = new HashMap<String, String>();
		MyTools mytools = new MyTools();
		ma.put("u_name", u_name);
		ma.put("u_tel", u_tel);
		ma.put("u_email", u_email);
		ma.put("u_id",u_id);
		ma.put("pwd", pwd);
		ma.put("repwd", repwd);
		try {
			//������֤��
			String random = (String)session.getAttribute("RANDOMCODEKEY");
			System.out.println("�ֻ���֤��:"+random);
			if(biz_manager.queryByTel(u_tel)!=null)//�ж��ֻ����Ƿ�ע��
			{
				ma.put("msg", "���ֻ����ѱ�ע�ᣬ��ֱ�ӵ�½!");
				mytools.setModel(model, ma);
				session.removeAttribute("RANDOMCODEKEY");
				return "publics/login.jsp";
			}
			else if(!u_verify.equals(random))//�ж��ֻ���֤���Ƿ���ȷ
			{
				ma.put("msg", "�ֻ���֤�����������»�ȡ��");
				mytools.setModel(model, ma);
				session.removeAttribute("RANDOMCODEKEY");
				return "publics/signup.jsp";
			}
			else if(!pwd.equals(repwd))//�ж����������Ƿ�һ��
			{
				ma.put("msg", "�������벻һ�£��������");
				mytools.setModel(model, ma);
				session.removeAttribute("RANDOMCODEKEY");
				return "publics/signup.jsp";
			}
			else if(!mytools.cardId(u_id))//�ж����֤���Ƿ�����
			{
				ma.put("msg", "���֤�������������");
				mytools.setModel(model, ma);
				session.removeAttribute("RANDOMCODEKEY");
				return "publics/signup.jsp";
			}
			else {
				pwd = MD5.getMD5(Base64.encode(pwd.getBytes()));
				//152327199905250023
				//ͨ�����֤�����������
				String birthday=u_id.substring(6,14);
				int day=Integer.parseInt(u_id.substring(10,14));
				int age=Time.Getyear()-Integer.parseInt(u_id.substring(6,10));
				if(Integer.parseInt(Time.Getmonth()+Time.Getday())<day)
					 age=age-1;		
				//ͨ�����֤�����ж��Ա�
				String sex;
				if(Integer.parseInt(u_id.substring(16,17))%2==0)
					sex="Ů";
				else
					sex="��";
				int dis_id = Integer.parseInt(u_id.substring(0,6));
				//��ӹ���Ա��
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
					//��ӹ���Ա
					biz_manager.insert(m);
					m = biz_manager.queryByTel(u_tel);
					//�������������¼��
					biz_manager.creatMessageTable(IRole.MANAGER_TABLE+"_"+m.getManager_id());
				} catch (Exception e) {
					e.printStackTrace();
					Log.logger.debug("MajorAction��signup()����������������Աע��ʧ�ܣ�"+e.getMessage());
					return "error/500.jsp";	
				}
				ma.put("msg", "ע��ɹ�!");
				mytools.setModel(model, ma);
				return "publics/login.jsp";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			Log.logger.error("MajorAction��signup()������������"+e.getMessage());
			ma.put("msg", "�����쳣����͹���Ա��ϵ");
			mytools.setModel(model, ma);
			return "error/404.jsp";
		 }
	}
	
	/**
	 * ��������ҳ����ʾ
	 * @param model
	 * @return
	 */
	@RequestMapping(path="forgot_pwd",method=RequestMethod.GET)
	public String forget_pwd(Model model){
		return "publics/forgot-password.jsp";
	}
	
	/**
	 * ��������
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
		//���ݻ��Գ�ʼ��
		Map<String, String> ma = new HashMap<String, String>();
		MyTools mytools = new MyTools();
		if(flag!=null&&!"".equals(flag)){
			try {
				if("1".equals(flag)&&u_tel!=null&&!"".equals(u_tel)){//��֤�ֻ����Ƿ����
					ma.put("u_tel", u_tel);
					if(biz_manager.queryByTel(u_tel)!=null) {
						mytools.setModel(model, ma);
						return "publics/forgot-password-verify.jsp";
					}
					else{
						ma.put("msg", "�˺Ų����ڣ���ȷ���ֻ��Ƿ���ȷ��");
						mytools.setModel(model, ma);
					}
				}
				else if("2".equals(flag)&&u_tel1!=null&&!"".equals(u_tel1)){//��֤�ֻ���֤���Ƿ���ȷ
					ma.put("u_tel", u_tel1);
					//������֤��
					String random = (String)session.getAttribute("RANDOMCODEKEY");
					System.out.println("�ֻ���֤��:"+random);
					if(!u_verify.equals(random))//�ж��ֻ���֤���Ƿ���ȷ
					{
						ma.put("msg", "�ֻ���֤�����������»�ȡ��");
						mytools.setModel(model, ma);
						session.removeAttribute("RANDOMCODEKEY");
						return "publics/forgot-password-verify.jsp";
					}
					else {
						mytools.setModel(model, ma);
						return "publics/forgot-password-update.jsp";
					}
				}
				else if("3".equals(flag)&&u_tel2!=null&&!"".equals(u_tel2)){//�޸�����
					ma.put("u_tel", u_tel2);
					Manager manage = biz_manager.queryByTel(u_tel2);
					pwd = MD5.getMD5(Base64.encode(pwd.getBytes()));
					if(!manage.getManager_password().equals(pwd))
					{
						manage.setManager_password(pwd);
						biz_manager.update(manage);
						ma.put("msg", "�����޸ĳɹ���");
						mytools.setModel(model, ma);
						return "publics/login.jsp";
					}
					else {
						ma.put("msg", "�����벻�������������ͬ��������ֱ�ӵ�¼��");
						mytools.setModel(model, ma);
						return "publics/forgot-password-update.jsp";
					}
				}
				else{
					return "error/404.jsp";	
				}
				
			}catch(Exception e){
				e.printStackTrace();
				Log.logger.debug("MajorAction��forgot_pwd()�����������������޸�ʧ�ܣ�"+e.getMessage());
				return "error/500.jsp";	
			}
			
		}
		return "publics/forgot-password.jsp";
		
	}
	
	/**
	 * ������
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
	 * ����ҳ����ʾ
	 * @param httpsession
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(path="locked",method=RequestMethod.GET)
	public String locked(HttpSession httpsession,HttpServletRequest request,Model model) {
		Manager m = (Manager)httpsession.getAttribute("manager");
		if(m==null) {
			model.addAttribute("msg","���ȵ�¼");
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
	 * ����
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
			model.addAttribute("msg","���ȵ�¼");
			return "publics/login.jsp";
		}
		else {
			pwd = MD5.getMD5(Base64.encode(pwd.getBytes()));
			if(pwd.equals(m.getManager_password())) {
				return "common_admin/index.jsp";
			}
			else {
				model.addAttribute("msg", "�������");
//				String path = request.getContextPath();
//				String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+ "/";
//				return "redirect:" + basePath + "publics/locked.jsp";
				return "publics/locked.jsp";
			}
		}
	}
	
	/**
	 * �޸�����ҳ����ʾ
	 */
	@RequestMapping(path="reset_password",method=RequestMethod.GET)
	public String reset_password(HttpSession httpsession,Model model) {
		Manager m = (Manager)httpsession.getAttribute("manager");
		if(m==null) {
			model.addAttribute("msg","���ȵ�¼");
			return "publics/login.jsp";
		}
		else {
			return "publics/reset-password.jsp";
		}
	}
	/**
	 * �޸�����
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
			model.addAttribute("msg","���ȵ�¼");
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
					model.addAttribute("msg","�����޸�ʧ�ܣ�");
					e.printStackTrace();
					return "publics/reset-password.jsp";
				}
			}
			else {
				model.addAttribute("msg", "�����벻��ȷ����˶�һ�£�");
				return "publics/reset-password.jsp";
			}
			
		}
	}
	/**
	 * ע����¼
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
