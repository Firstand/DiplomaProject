package com.hlbrc.action;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.hlbrc.entity.Manager;
import com.hlbrc.enums.WeCharEnum;
import com.hlbrc.util.ChattingRecordsIO;
import com.hlbrc.util.WeChatDisposeTools;
import com.hlbrc.util.WeixinUtils;
import com.hlbrc.util.WxCardBaseInfo;
import com.hlbrc.util.WxCardCustomField;
import com.hlbrc.util.WxCardGroupon;

import net.sf.json.JSONObject;

@Controller
public class MembershipAction{
	@RequestMapping(path="create_card",method=RequestMethod.GET)
	public String creat_card(HttpSession httpsession,Model model) {
		Manager manager = (Manager)httpsession.getAttribute("manager");
		if(manager==null){
			model.addAttribute("msg","请先登录！");
			return "publics/login.jsp";
		}
		else {
			return "common_admin/member/create_membercard.jsp";
		}
		
	}
	@RequestMapping(path="create_card",method=RequestMethod.POST)
	@ResponseBody
	public String creat_card(String brand_name,String title,Boolean supply_bonus,Boolean supply_balance,String color,Integer code_type,Integer quantity,String select_time,Date begin_timestamp
			,Date end_timestamp,String notice,String description,String prerogative,String custom_cell_name,String custom_cell_tips,@RequestParam(value="input_logo",required=false) MultipartFile input_logo,
			@RequestParam(value="input_background",required=false) MultipartFile input_background,Boolean auto_activate,Boolean wx_activate,String[] optional_form,String[] required_form,HttpServletRequest request,HttpSession httpsession,Model model) throws IOException {
		System.out.println("-----------进来了----------------");
		//判断是否登录成功
		JSONObject obj = new JSONObject();
		Manager manager = (Manager)httpsession.getAttribute("manager");
		if(manager==null){
			model.addAttribute("msg","请先登录！");
			obj.put("msg", "-1");
		}
		else {
			WeChatDisposeTools wx = new WeChatDisposeTools();
			System.out.println("brand_name:"+brand_name);
			//上传logo,创建会员卡
			WxCardGroupon card = new WxCardGroupon();
	        WxCardBaseInfo baseInfo = card.getBaseInfo();
	        card.init("MEMBER_CARD");
	        card.setSupplyBonus(supply_bonus);
	        card.setSupplyBalance(supply_balance);
	        card.setPrerogative(prerogative);
	        card.setCustomCell1(new org.json.JSONObject());
	        card.setCustomCell1Name(custom_cell_name);
	        card.setCustomCell1Tips(custom_cell_tips);
	        card.setCustomCell1Url("https://www.qq.com");
	        card.setAutoActivate(auto_activate);//非必填，但是变相 必填.true自动激活
	        card.setWxActivate(wx_activate);//非必填，变相必填，当为true时，会员卡支持一键开卡，不允许同时传入activate_url字段，否则设置wx_activate失效
	        if(!wx_activate) {
	        	card.setActivateUrl("https://www.qq.com");//非必填，变相必填
	        }
	        baseInfo.setBrandName(brand_name);
	        baseInfo.setTitle(title);
	        baseInfo.setColor(color);
	        baseInfo.setCodeType(code_type);
	        baseInfo.setQuantity(quantity);
	        baseInfo.setType(select_time);
	        if(!"DATE_TYPE_PERMANENT".equals(select_time)) {
	        	baseInfo.setDateInfoTimeRange(begin_timestamp, end_timestamp);
	        }
	        baseInfo.setNotice(notice);
	        baseInfo.setDescription(description);
	        baseInfo.setPayInfo();
	        baseInfo.setIsSwipeCard(true);
//	        baseInfo.setIsPayAndQrcode(true);
	        System.out.println("-----------------------card:"+card.toJsonString());
	        WxCardCustomField wf = new WxCardCustomField();
	        if(wx_activate) {
		        List<String> optional_form_list = new ArrayList<String>();
		        List<String> required_form_list = new ArrayList<String>();
		        wf.setOptionalForm(new org.json.JSONObject());
		        wf.setRequiredForm(new org.json.JSONObject());
		        wf.setOptionalFormRichFieldList(new org.json.JSONArray());
		        wf.setRequiredFormRichFieldList(new org.json.JSONArray());
		        if(required_form!=null) {
		        	for(int i=0;i<required_form.length;i++) {
			        	if("USER_FORM_INFO_FLAG_INDUSTRY".equals(required_form[i])) {
			        		List<String> values = new ArrayList<String>();
			        		String required_form_industry_input = request.getParameter("required_form_industry_input");
			        		String required_form_industry_select = request.getParameter("required_form_industry_select");
			        		if(required_form_industry_input!=null&&required_form_industry_select!=null&&!"".equals(required_form_industry_select)&&!"".equals(required_form_industry_input)) {
			        			String [] str = required_form_industry_input.split(",");
			        			for(String s:str) {
			        				values.add(s);
			        			}
			        			wf.setRequiredFormRichFieldListAll(required_form_industry_select, required_form[i], values);
			        		}
			        		else {
			        			required_form_list.add(required_form[i]);
			        		}
			        		
			        	}
			        	else if("USER_FORM_INFO_FLAG_INCOME".equals(required_form[i])) {
			        		List<String> values = new ArrayList<String>();
			        		String required_form_income_input = request.getParameter("required_form_income_input");
			        		String required_form_income_select = request.getParameter("required_form_income_select");
			        		if(required_form_income_input!=null&&required_form_income_select!=null&&!"".equals(required_form_income_select)&&!"".equals(required_form_income_input)) {
			        			String [] str = required_form_income_input.split(",");
			        			for(String s:str) {
			        				values.add(s);
			        			}
			        			wf.setRequiredFormRichFieldListAll(required_form_income_select, required_form[i], values);
			        		}
			        		else {
			        			required_form_list.add(required_form[i]);
			        		}
			        	}
			        	else if("USER_FORM_INFO_FLAG_HABIT".equals(required_form[i])) {
			        		List<String> values = new ArrayList<String>();
			        		String required_form_habit_input = request.getParameter("required_form_habit_input");
			        		String required_form_habit_select = request.getParameter("required_form_habit_select");
			        		if(required_form_habit_input!=null&&required_form_habit_select!=null&&!"".equals(required_form_habit_select)&&!"".equals(required_form_habit_input)) {
			        			String [] str = required_form_habit_input.split(",");
			        			for(String s:str) {
			        				values.add(s);
			        			}
			        			wf.setRequiredFormRichFieldListAll(required_form_habit_select, required_form[i], values);
			        		}
			        		else {
			        			required_form_list.add(required_form[i]);
			        		}
			        	}
			        	else {
			        		required_form_list.add(required_form[i]);
			        	}
			        }
			        wf.setRequiredFormCommonFieldIdList(required_form_list);
			        wf.setRequiredFormCanModify(false);
		        }
		        if(optional_form!=null) {
		        	for(int i=0;i<optional_form.length;i++) {
			        	if("USER_FORM_INFO_FLAG_INDUSTRY".equals(optional_form[i])) {
			        		List<String> values = new ArrayList<String>();
			        		String optional_form_industry_input = request.getParameter("optional_form_industry_input");
			        		String optional_form_industry_select = request.getParameter("optional_form_industry_select");
			        		if(optional_form_industry_input!=null&&optional_form_industry_select!=null&&!"".equals(optional_form_industry_select)&&!"".equals(optional_form_industry_input)) {
			        			String [] str = optional_form_industry_input.split(",");
			        			for(String s:str) {
			        				values.add(s);
			        			}
			        			wf.setOptionalFormRichFieldListAll(optional_form_industry_select, optional_form[i], values);
			        		}
			        		else {
			        			optional_form_list.add(optional_form[i]);
			        		}
			        		
			        	}
			        	else if("USER_FORM_INFO_FLAG_INCOME".equals(optional_form[i])) {
			        		List<String> values = new ArrayList<String>();
			        		String optional_form_income_input = request.getParameter("optional_form_income_input");
			        		String optional_form_income_select = request.getParameter("optional_form_income_select");
			        		if(optional_form_income_input!=null&&optional_form_income_select!=null&&!"".equals(optional_form_income_select)&&!"".equals(optional_form_income_input)) {
			        			String [] str = optional_form_income_input.split(",");
			        			for(String s:str) {
			        				values.add(s);
			        			}
			        			wf.setOptionalFormRichFieldListAll(optional_form_income_select, optional_form[i], values);
			        		}
			        		else {
			        			optional_form_list.add(optional_form[i]);
			        		}
			        		
			        	}
			        	else if("USER_FORM_INFO_FLAG_HABIT".equals(optional_form[i])) {
			        		List<String> values = new ArrayList<String>();
			        		String optional_form_habit_input = request.getParameter("optional_form_habit_input");
			        		String optional_form_habit_select = request.getParameter("optional_form_habit_select");
			        		if(optional_form_habit_input!=null&&optional_form_habit_select!=null&&!"".equals(optional_form_habit_select)&&!"".equals(optional_form_habit_input)) {
			        			String [] str = optional_form_habit_input.split(",");
			        			for(String s:str) {
			        				values.add(s);
			        			}
			        			wf.setOptionalFormRichFieldListAll(optional_form_habit_select, optional_form[i], values);
			        		}
			        		else {
			        			optional_form_list.add(optional_form[i]);
			        		}
			        	}
			        	else {
			        		optional_form_list.add(optional_form[i]);
			        	}
			        }
			        wf.setOptionalFormCommonFieldIdList(optional_form_list);
			        wf.setOptionalFormCanModify(false);
		        }
		        System.out.println("--------------wf:"+wf.toJsonString());
	        }
	        JSONObject creat_member_card = JSONObject.fromObject(wx.creatMemberCard(manager.getManager_id(),WeCharEnum.APPID,WeCharEnum.APPSECRET,input_logo,input_background,card,wf,wx_activate,brand_name+"—"+title));
	        if("ok".equals(creat_member_card.getString("errmsg"))) {
		        obj.put("msg", "1");
			}
	        else {
				if("-9".equals(creat_member_card.getString("errcode"))) {
					obj.put("msg", "2");
				}
				else if("-8".equals(creat_member_card.getString("errcode"))) {
					obj.put("msg", "3");
				}
				else if("-7".equals(creat_member_card.getString("errcode"))) {
					obj.put("msg", "4");
				}
				else {
					obj.put("msg", "5");
				}
			}
		}
		return obj.toString();
	}
	
	//只需要加上下面这段即可,注意不能忘记注解	
	@InitBinder	
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
        binder.registerCustomEditor(int.class, new PropertyEditorSupport()
        {
           
            @Override
            public String getAsText()
            {
                return getValue().toString();
            }
           
            @Override
            public void setAsText(String text)throws IllegalArgumentException
            {
                System.out.println(text + "...........................................");
                setValue(Integer.parseInt(text));
            }
           
        });
	}
	//解析微信发来的请求（XML）
	@RequestMapping(path="wx_puch_dispose",method=RequestMethod.GET)
	public String wx_puch_dispose(HttpServletRequest request, HttpServletResponse response) {
		System.err.println("---------------wx_puch_dispose进来了get------------------");
		try {
			//获取微信服务器发来的参数， 并将token、timestamp、nonce三个参数进行字典序排序 
			//将三个参数字符串拼接成一个字符串进行sha1加密
			//开发者获得加密后的字符串可与signature对比，标识该请求来源于微信       
			String signature = request.getParameter("signature");        
			String timestamp = request.getParameter("timestamp");        
			String nonce = request.getParameter("nonce");        
			String echostr = request.getParameter("echostr");        
			//check方法用来排序以及比较        
			if (WeixinUtils.check(timestamp,nonce,signature)){           
				PrintWriter out = null;            
				try {                
					out = response.getWriter();                
					out.print(echostr);            
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					out.flush();//刷新文件流             
					out.close();//关闭文件流            
				}            
				System.out.println("接入成功");
			}
		}
		catch (NullPointerException e) {
			return "publics/login.jsp";
		}
		return null;//无需返回值，返回null即可
	}
	@RequestMapping(path="wx_puch_dispose",method=RequestMethod.POST)
	public void wx_puch_dispose(HttpServletRequest request) throws Exception {
		System.err.println("---------------wx_puch_dispose进来了post------------------");
		WeChatDisposeTools wx = new WeChatDisposeTools();
		Map<String,String> map = wx.parseXml(request);
		for(String key:map.keySet()) {
			System.out.println("key:"+key+"value:"+map.get(key));
		}
	}
	//查看会员卡
	@RequestMapping("examine_membercard")
	public String examine_membercard(HttpServletRequest request) throws Exception {
		return "common_admin/member/examine_membercard.jsp";
	}
	//管理会员卡
	@RequestMapping("putin_membercard")
	public String putin_membercard(HttpSession httpsession,Model model) throws Exception {
		ChattingRecordsIO cro = new ChattingRecordsIO();
		Manager manager = (Manager)httpsession.getAttribute("manager");
		if(manager==null){
			model.addAttribute("msg","请先登录！");
			return "publics/login.jsp";
		}
		else {
			net.sf.json.JSONArray array = cro.readFileWx("creat_member_card_"+manager.getManager_id());
			System.out.println("array:"+array);
			httpsession.setAttribute("array", array);
			return "common_admin/member/putin_membercard.jsp";
		}
	}
	//核销会员卡
	@RequestMapping("deleteCard")
	public String deleteCard(String cardid,HttpSession httpsession,Model model) throws Exception {
		Manager manager = (Manager)httpsession.getAttribute("manager");
		if(manager==null){
			model.addAttribute("msg","请先登录！");
			return "publics/login.jsp";
		}
		else {
			WeChatDisposeTools wcdt = new WeChatDisposeTools();
			if(wcdt.deleteCard(WeCharEnum.APPID,WeCharEnum.APPSECRET, cardid, manager.getManager_id())) {
				model.addAttribute("msg","核销成功！");
			}
			else {
				model.addAttribute("msg","核销失败！");
			}
		}
		return "forward:putin_membercard.do";
	}
	//查看某会员详细信息
	@RequestMapping(path="inquire_member",method=RequestMethod.GET)
	public String inquire_member(HttpSession httpsession,Model model){
		Manager manager = (Manager)httpsession.getAttribute("manager");
		if(manager==null){
			model.addAttribute("msg","请先登录！");
			return "publics/login.jsp";
		}
		else {
			return "common_admin/member/inquire_member.jsp";
		}
	}
	@RequestMapping(path="inquire_member",method=RequestMethod.POST)
	@ResponseBody
	public String inquire_member(HttpSession httpsession,String code_id,Model model){
		Manager manager = (Manager)httpsession.getAttribute("manager");
		JSONObject obj = new JSONObject();
		if(manager==null){
			obj.put("msg", "-1");
		}
		else {
			WeChatDisposeTools wcdt = new WeChatDisposeTools();
			JSONObject member = JSONObject.fromObject(wcdt.getMemberInformation(WeCharEnum.APPID, WeCharEnum.APPSECRET, code_id));
			if("ok".equals(member.getString("errmsg"))) {
				obj.put("msg", "1");
				obj.put("member", member.toString());
			}
			else {
				obj.put("msg", "0");
			}
		}
		return obj.toString();
	}
	@RequestMapping(path="setappid_appsecret",method=RequestMethod.GET)
	public String setappid_appsecret() {
		return "";
	}
	@RequestMapping(path="setappid_appsecret",method=RequestMethod.POST)
	public String setappid_appsecret(HttpSession httpsession,Model model) {
		Manager manager = (Manager)httpsession.getAttribute("manager");
		if(manager==null){
			model.addAttribute("msg","请先登录！");
			return "publics/login.jsp";
		}
		else {
			WeChatDisposeTools wcdt = new WeChatDisposeTools();
			wcdt.setAppIdAppSecret(WeCharEnum.APPID, WeCharEnum.APPSECRET);
			return "common_admin/index.jsp";
		}
	}
}
