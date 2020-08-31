package com.hlbrc.action;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.hlbrc.biz.ManagerBiz;
import com.hlbrc.biz.MessageBiz;
import com.hlbrc.entity.Manager;
import com.hlbrc.entity.Message;
import com.hlbrc.util.ChattingRecordsIO;
import com.hlbrc.util.Log;


/**
 * 即時通訊控制层
 * @author ZY
 *
 */
@Controller
public class ChatsAction {
	@Autowired
	ManagerBiz biz_manager;
	@Autowired
	MessageBiz biz_message;
	/**
	 * 进入聊天室
	 * @param session
	 * @return
	 */
	@RequestMapping(path="chats",method=RequestMethod.GET)
	public String chats(HttpSession session,Model model) {
		System.out.println("111111111111111111---chatsget-----1111111111111111111");
		//判断是否登录成功
		Manager manager = (Manager)session.getAttribute("manager");
		if(manager==null){
			model.addAttribute("msg","请先登录！");
			return "publics/login.jsp";
		}
		else {
			try {
				@SuppressWarnings("unchecked")
				List<Manager> manager_not  = (List<Manager>) session.getAttribute("manager_not");
				if(manager_not!=null) {
					ChattingRecordsIO cr = new ChattingRecordsIO();
					for(Manager mana:manager_not) {
						List<Message> chat_list =  cr.readOneFile("Manager_"+mana.getManager_tel(),"manager_table_"+mana.getManager_id());
						int i=0;
						for(Message msg:chat_list) {
							if(msg.isIsself()) {
								i++;
							}
						}
						mana.setManager_context_num(i);
						int t = chat_list.size()>0?chat_list.size():0;
						if(t>0) {
							mana.setManager_context_finally(chat_list.get(t-1).getContent());
						}
					}
					session.setAttribute("manager_not", manager_not);
				}
				session.setAttribute("uname","Manager_"+manager.getManager_tel());
				session.setAttribute("table_name_sender","manager_table_"+manager.getManager_id());
			} catch (Exception e) {
				e.printStackTrace();
				Log.logger.debug("ChatsAction中chats()方法出错啦！method=RequestMethod.GET："+e.getMessage());
				return "error/404.jsp";	
			}
		}
		return "common_admin/chats.jsp";
	}
	
	/**
	 * 聊天处理
	 * @param u_tel
	 * @param model
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(path="chats",method=RequestMethod.POST)
	@ResponseBody 
	public Object chats(String u_tel,HttpSession session,HttpServletResponse response,Model model) {
		System.out.println("111111111111111111---chatspost-----1111111111111111111");
		Map<String,String> resultMap=new HashMap<String,String>(); //u_nickname uname table_name_sender
		Map<String,Manager> resultMap_0=new HashMap<String,Manager>(); //manager1
		Map<String,List<Manager>> resultMap_1=new HashMap<String,List<Manager>>(); //manager_not
		Map<String,List<Message>> resultMap_2=new HashMap<String,List<Message>>(); //chat_list
		@SuppressWarnings("rawtypes")
		Map<String,Map> resultMap_3=new HashMap<String,Map>(); //chat_list
		Manager manager = (Manager)session.getAttribute("manager"); 
		if(manager==null){
			model.addAttribute("msg","请先登录！");
			return  "publics/login.jsp"; 
		} 
		else { 
			try { // 把用户发来的消息解析为JSON对象
				Manager manager1 = biz_manager.queryByTel(u_tel);
				session.setAttribute("manager1", manager1);
				resultMap.put("u_nickname", manager1.getManager_name());
				resultMap.put("uname","Manager_"+manager.getManager_tel());
				resultMap.put("table_name_sender","manager_table_"+manager.getManager_id());
				ChattingRecordsIO cr = new ChattingRecordsIO();
				List<Message> chat_list =  cr.readOneFile("Manager_"+manager.getManager_tel(),"manager_table_"+manager1.getManager_id());
				@SuppressWarnings("unchecked")
				List<Manager> manager_not = (List<Manager>) session.getAttribute("manager_not");
				for(Manager mana:manager_not) {
					if(mana.getManager_id()==manager1.getManager_id()) {
						mana.setManager_context_num(0);
					}
					List<Message> chat_lists =  cr.readOneFile("Manager_"+manager.getManager_tel(),"manager_table_"+mana.getManager_id());
					int t = chat_lists.size()>0?chat_lists.size():0;
					if(t>0) {
						mana.setManager_context_finally(chat_lists.get(t-1).getContent());
					}
				}
				SimpleDateFormat sd = new SimpleDateFormat("HH:mm E");
				for(Message msg:chat_list) {
					msg.setCreat_time_str(sd.format(msg.getCreat_time()));
				}
				//查询个人聊天记录
				Message message = new Message();
				message.setSender_id(manager.getManager_id());
				message.setAccepter_id(manager1.getManager_id());
				message.setManager(manager);
				List<Message> list_message = biz_message.getMessage(message);
				//添加json值
				resultMap_0.put("manager1",manager1);
				Cookie cookie = new Cookie("resultMap_4",JSONArray.toJSONString(manager1.getProfileimg()));
				cookie.setMaxAge(30 * 60);// 设置为30min
	            cookie.setPath("/");
	            response.addCookie(cookie);
				resultMap_1.put("manager_not", manager_not);
				resultMap_2.put("chat_list",chat_list);
				resultMap_2.put("list_message",list_message);
				resultMap_3.put("resultMap",resultMap);
				System.out.println("resultMap:"+resultMap_3.get("resultMap"));
				resultMap_3.put("resultMap_0",resultMap_0);
				System.out.println("resultMap:"+resultMap_3.get("resultMap_0"));
				resultMap_3.put("resultMap_1",resultMap_1);
				System.out.println("resultMap_1:"+resultMap_3.get("resultMap_1"));
				resultMap_3.put("resultMap_2",resultMap_2);
				System.out.println("resultMap_2:"+resultMap_3.get("resultMap_2"));
			} 
			catch (Exception e) 
			{  
				e.printStackTrace();
				Log.logger.debug("ChatsAction中chats()方法出错啦！method=RequestMethod.POST："+e.getMessage());
				return "error/404.jsp";	
			} 
		} 
		return JSONArray.toJSONString(resultMap_3);
	 }
	/**
	 * 删除选中的聊天消息
	 * @param choices
	 * @param httpsession
	 * @return
	 */
	@RequestMapping(path="delete_messages")
	@ResponseBody
	public Object delete_messages(String choices,HttpSession httpsession) {
		Manager manager = (Manager) httpsession.getAttribute("manager");
		Manager manager1 = (Manager) httpsession.getAttribute("manager1");
		Map<String,List<Message>> list_message_map = new HashMap<String, List<Message>>();
		Map<String,String> flag_map = new HashMap<String, String>();
		@SuppressWarnings("rawtypes")
		Map<String,Map> map = new HashMap<String, Map>();
		if(manager!=null) {
			String[] array = choices.split(",");
			try {
				biz_message.deleteMessage(array, "manager_table_"+manager.getManager_id());
				
				Message message = new Message();
				message.setSender_id(manager.getManager_id());
				message.setAccepter_id(manager1.getManager_id());
				message.setManager(manager);
				List<Message> list_message = biz_message.getMessage(message);
				list_message_map.put("list_message",list_message);
			} catch (Exception e) {
				e.printStackTrace();
				Log.logger.debug("ChatsAction中delete_messages()方法出错啦！聊天记录删除失败！"+e.getMessage());
				flag_map.put("flag", "0");
			}
			flag_map.put("flag", "1");
		}
		else {
			flag_map.put("flag", "0");
		}
		map.put("list_message_map", list_message_map);
		map.put("flag_map",flag_map);
		return JSONArray.toJSONString(map);
	}
	@RequestMapping(path="contact_card")
	public String contact_card() {
		return "common_admin/contact-card.jsp";
	}
}
	
