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
 * websock������Ʋ�
 * @author ZY
 *
 */
@ServerEndpoint(value = "/websocket",configurator = GetHttpSessionConfigurator.class)
public class WebSocketService {
	private static SimpleDateFormat df = new SimpleDateFormat("HH:mm E");//����ʱ���ʽ����
	private static SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//����ʱ���ʽ����
	//concurrent�����̰߳�ȫSet���������ÿ���ͻ��˶�Ӧ��WebSocketService����
	//����һ������ļ��ϣ�������ŷ���
	//private static ConcurrentHashMap<String,ConcurrentHashMap<String, WebSocketService>> roomList = new  ConcurrentHashMap<String,ConcurrentHashMap<String, WebSocketService>>();
	private static ConcurrentHashMap<String, WebSocketService> ch = new ConcurrentHashMap<String, WebSocketService>();
	//��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
	private Session session;
	@SuppressWarnings("unused")
	private HttpSession httpSession;
	private String sender;
	
	@Autowired
	ManagerBiz biz_manager;
	@Autowired
	MessageBiz biz_message;
	/**
	 * �û�����
	 * @param session 
	 */
	@OnOpen
	public void onOpen(Session session,EndpointConfig config){
		this.session = session;
		this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		System.out.println("�����ˣ�");
	}
	/**
	 * �û�����ŷ���
	 * @param message
	 */
	public void JoinSender(String message) {
		//���û���������Ϣ����ΪJSON����
		JSONObject obj = JSONObject.fromObject(message);
		String sender = obj.get("sender").toString();
		if(sender!=null&&!"".equals(sender)) {
			if(ch.get(sender)==null) {//��ֹ�ظ�����û�
				ch.put(sender, this);//�����û����뷿����
				System.out.println("����û���");
				System.out.println("ch:"+ch);
			}
		}
	}
	/**
	 * ������Ϣ
	 * @param message
	 * @throws IOException
	 */
	public void sendMessage(String message) throws IOException {
//		System.out.println("׼�����ͣ�");
		if(this.session.isOpen()) {
//			System.out.println("���ͳɹ���");
			this.session.getBasicRemote().sendText(message);
		}
		else {
			System.out.println("����ʧ�ܣ�");
		}
//		System.out.println("-----------------");
    }
	/**
	 * ���յ������û�����Ϣ
	 * @param message
	 * @param session
	 * @throws IOException 
	 */
	@OnMessage
	public void onMessage(String message,Session session) throws IOException{
		//���û���������Ϣ����ΪJSON����
//		System.out.println("message:"+message);
		JSONObject obj = JSONObject.fromObject(message);
		JoinSender(message);
		//������
		sender = obj.get("sender").toString();
//		System.out.println("������:"+sender);
		//������
		String accepter = obj.get("accepter").toString();
//		System.out.println("������:"+accepter);
		//��Ϣ����
		String table_name_sender = obj.get("table_name_sender").toString();
//		System.out.println("table_name_sender:"+table_name_sender);
		String table_name_accepter = obj.get("table_name_accepter").toString();
//		System.out.println("table_name_accepter:"+table_name_accepter);
		if(sender!=null&&!"".equals(sender)&&accepter!=null&&!"".equals(accepter)) {
			//��ȡ�ͻ��˷��͵������е�����---�û�
			obj.put("sender", sender);
			System.out.println("ch:"+ch);
			obj.put("date", df1.format(new Date()));
//			System.out.println(obj);
			try {
				//����Ϣд���ļ�
				ChattingRecordsIO cr = new ChattingRecordsIO();
				if(table_name_sender!=null&&!"".equals(table_name_sender)) {
					obj.put("isSelf", true);//������Ϣ�Ƿ�Ϊ�Լ���
					cr.writeFileByBytes(sender,table_name_accepter,obj.toString());
				}
				if(table_name_accepter!=null&&!"".equals(table_name_accepter)){
					obj.put("isSelf", false);//������Ϣ�Ƿ�Ϊ�Լ���
					cr.writeFileByBytes(accepter,table_name_sender,obj.toString());
				}
				obj.put("date", df.format(new Date()));
				for(String i:ch.keySet()){//�����÷���
	//				System.out.println("��ǰ������:"+i+"�Ƿ�Ϊ�����ߣ�"+sender.equals(i));
					if(sender.equals(i)||accepter.equals(i)) {
						obj.put("isSelf", sender.equals(i));//������Ϣ�Ƿ�Ϊ�Լ���
						System.out.println("��������:"+i+":"+ch.get(i)+"�����ˣ�"+obj);
						ch.get(i).sendMessage(obj.toString());//���÷��� ����Ϣ����
					}
					else {
						System.out.println("����Ϣ���û�"+i+"û��ϵ��");
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
				Log.logger.debug("WebSocketService��onMessage()���������������յ������û�����Ϣ�������ˣ�"+e.getMessage());
			}
		}
		else {
			for(String i:ch.keySet()){//�����÷���
//				System.out.println("�ظ����һ��ڣ�");
				ch.get(i).sendMessage("");//���÷��� ����Ϣ����
			}
		}
	}
	
	/**
	 * �û��Ͽ�
	 * @param session
	 */
	@OnClose
	public void onClose(Session session){
		if(sender!=null&&!"".equals(sender)&&ch!=null) {
			ch.remove(sender);
			System.out.println("�û�"+sender+"�Ͽ����ӣ�");
			System.out.println("�Ͽ����ӵ�ch:"+ch);
		}
		
	}
	
	/**
	 * �û������쳣
	 * @param t
	 */
	@OnError
	public void onError(Session session, Throwable t){
		System.out.println("�û������쳣");
		if(sender!=null&&!"".equals(sender)&&ch!=null) {
			ch.remove(sender);
			System.out.println("�û�"+sender+"�쳣�Ͽ����ӣ�");
			System.out.println("�쳣�Ͽ����Ӻ��ch:"+ch);
		}
//      t.printStackTrace();
	}
	
	/**
	 * ��Ϣ����
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
			Log.logger.debug("WebSocketService��messageDispose()��������������Ϣ������������ˣ�"+e.getMessage());
		}
	}
}
