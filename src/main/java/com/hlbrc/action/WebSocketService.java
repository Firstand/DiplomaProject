package com.hlbrc.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;

import com.hlbrc.biz.ManagerBiz;
import com.hlbrc.biz.MessageBiz;
import com.hlbrc.entity.Manager;
import com.hlbrc.entity.Message;
import com.hlbrc.util.ChattingRecordsIO;
import com.hlbrc.util.GetHttpSessionConfigurator;
import com.hlbrc.util.Log;

import net.sf.json.JSONObject;

/**
 * websock服务控制层
 * @author ZY
 *
 */
@ServerEndpoint(value = "/websocket",configurator = GetHttpSessionConfigurator.class)
public class WebSocketService {
	private static SimpleDateFormat df = new SimpleDateFormat("HH:mm E");//创建时间格式对象
	private static SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//创建时间格式对象
	//concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketService对象。
	//创建一个房间的集合，用来存放房间
	//private static ConcurrentHashMap<String,ConcurrentHashMap<String, WebSocketService>> roomList = new  ConcurrentHashMap<String,ConcurrentHashMap<String, WebSocketService>>();
	private static ConcurrentHashMap<String, WebSocketService> ch = new ConcurrentHashMap<String, WebSocketService>();
	//与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;
	@SuppressWarnings("unused")
	private HttpSession httpSession;
	private String sender;
	
	@Autowired
	ManagerBiz biz_manager;
	@Autowired
	MessageBiz biz_message;
	/**
	 * 用户接入
	 * @param session 
	 */
	@OnOpen
	public void onOpen(Session session,EndpointConfig config){
		this.session = session;
		this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		System.out.println("进来了！");
	}
	/**
	 * 用户加入放房间
	 * @param message
	 */
	public void JoinSender(String message) {
		//把用户发来的消息解析为JSON对象
		JSONObject obj = JSONObject.fromObject(message);
		String sender = obj.get("sender").toString();
		if(sender!=null&&!"".equals(sender)) {
			if(ch.get(sender)==null) {//防止重复添加用户
				ch.put(sender, this);//将此用户加入房间中
				System.out.println("添加用户！");
				System.out.println("ch:"+ch);
			}
		}
	}
	/**
	 * 发送消息
	 * @param message
	 * @throws IOException
	 */
	public void sendMessage(String message) throws IOException {
//		System.out.println("准备发送！");
		if(this.session.isOpen()) {
//			System.out.println("发送成功！");
			this.session.getBasicRemote().sendText(message);
		}
		else {
			System.out.println("发送失败！");
		}
//		System.out.println("-----------------");
    }
	/**
	 * 接收到来自用户的消息
	 * @param message
	 * @param session
	 * @throws IOException 
	 */
	@OnMessage
	public void onMessage(String message,Session session) throws IOException{
		//把用户发来的消息解析为JSON对象
//		System.out.println("message:"+message);
		JSONObject obj = JSONObject.fromObject(message);
		JoinSender(message);
		//发送者
		sender = obj.get("sender").toString();
//		System.out.println("发送者:"+sender);
		//接收者
		String accepter = obj.get("accepter").toString();
//		System.out.println("接收者:"+accepter);
		//消息表名
		String table_name_sender = obj.get("table_name_sender").toString();
//		System.out.println("table_name_sender:"+table_name_sender);
		String table_name_accepter = obj.get("table_name_accepter").toString();
//		System.out.println("table_name_accepter:"+table_name_accepter);
		if(sender!=null&&!"".equals(sender)&&accepter!=null&&!"".equals(accepter)) {
			//获取客户端发送的数据中的内容---用户
			obj.put("sender", sender);
			System.out.println("ch:"+ch);
			obj.put("date", df1.format(new Date()));
//			System.out.println(obj);
			try {
				//将消息写入文件
				ChattingRecordsIO cr = new ChattingRecordsIO();
				if(table_name_sender!=null&&!"".equals(table_name_sender)) {
					obj.put("isSelf", true);//设置消息是否为自己的
					cr.writeFileByBytes(sender,table_name_accepter,obj.toString());
				}
				if(table_name_accepter!=null&&!"".equals(table_name_accepter)){
					obj.put("isSelf", false);//设置消息是否为自己的
					cr.writeFileByBytes(accepter,table_name_sender,obj.toString());
				}
				obj.put("date", df.format(new Date()));
				for(String i:ch.keySet()){//遍历该房间
	//				System.out.println("当前房间有:"+i+"是否为发送者："+sender.equals(i));
					if(sender.equals(i)||accepter.equals(i)) {
						obj.put("isSelf", sender.equals(i));//设置消息是否为自己的
						System.out.println("服务器给:"+i+":"+ch.get(i)+"发送了！"+obj);
						ch.get(i).sendMessage(obj.toString());//调用方法 将消息推送
					}
					else {
						System.out.println("该消息和用户"+i+"没关系！");
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
				Log.logger.debug("WebSocketService中onMessage()方法出错啦！接收到来自用户的消息出问题了："+e.getMessage());
			}
		}
		else {
			for(String i:ch.keySet()){//遍历该房间
//				System.out.println("回复，我还在！");
				ch.get(i).sendMessage("");//调用方法 将消息推送
			}
		}
	}
	
	/**
	 * 用户断开
	 * @param session
	 */
	@OnClose
	public void onClose(Session session){
		if(sender!=null&&!"".equals(sender)&&ch!=null) {
			ch.remove(sender);
			System.out.println("用户"+sender+"断开连接！");
			System.out.println("断开连接的ch:"+ch);
		}
		
	}
	
	/**
	 * 用户连接异常
	 * @param t
	 */
	@OnError
	public void onError(Session session, Throwable t){
		System.out.println("用户连接异常");
		if(sender!=null&&!"".equals(sender)&&ch!=null) {
			ch.remove(sender);
			System.out.println("用户"+sender+"异常断开连接！");
			System.out.println("异常断开连接后的ch:"+ch);
		}
//      t.printStackTrace();
	}
	
	/**
	 * 消息处理
	 */
	public void messageDispose() {
		try {
			List<Manager> manager_all_list = biz_manager.queryAll();
			for(Manager mana:manager_all_list) {
				ChattingRecordsIO cr = new ChattingRecordsIO();
				List<List<Message>> all_chat_list = cr.readAllFile("Manager_"+mana.getManager_tel());
				for(List<Message> chat_list:all_chat_list) {
					if(chat_list.size()>0) {
						System.out.println("chat_list:"+chat_list);
						System.out.println("chat_list.size():"+chat_list.size());
						biz_message.insertMessage(chat_list,"manager_table_"+mana.getManager_id());
					}
				}
				cr.clearAllFile("Manager_"+mana.getManager_tel());
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.debug("WebSocketService中messageDispose()方法出错啦！消息处理处理出问题了："+e.getMessage());
		}
	}
}
