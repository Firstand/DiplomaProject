package com.hlbrc.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;

import com.hlbrc.action.WebSocketService;
 
/**
* @Author: ZY
* @Description:
* @Date: 2020/05/08
* @Modified By:
* @Modified Date:
*/
public class TimerUtil implements ServletContextListener {
	public static void main(String[] args) {
		timer1();
//		timer2();
//		timer3();
//		timer4();
//		timer5();
	}
 
	/**
	* �趨2000�����ִ��
	*/
	public static void timer1(){
		Timer nTimer = new Timer();
		nTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("----�趨Ҫָ������-----");
				System.gc();
				cancel();
			}
		},2000);
	}
 
	/**
	* �ӳ�5000���룬ÿ1000����ִ��һ��
	*/
	public static void timer2() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
			System.out.println("-------�ӳ�5000���룬ÿ1000����ִ��һ��--------");
			}
		}, 5000, 1000);
	}
	
	/**
	* �ӳ�5000���룬ÿ1Сʱִ��һ��
	*/
	public static void timer3() {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				System.err.println("-------���ڸ��������û���΢��Token--------");
				WeChatDisposeTools wcd = new WeChatDisposeTools();
				wcd.setToken();
			}
		}, 10000, 1000 * 60 * 60 * 2);
	}
 
	/**
	* ����24��00ִ������
	* java.util.Timer.scheduleAtFixedRate(TimerTask task, Date firstTime, long period)
	*/
	public static void timer4() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 24);
		calendar.set(Calendar.MINUTE, 40);
		calendar.set(Calendar.SECOND, 0);
		Date time = calendar.getTime();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sd.format(time));
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				System.out.println("-------�趨Ҫָ������--------");
				WebSocketService web_socket = new WebSocketService();
				web_socket.messageDispose();
			}
		}, time, 1000 * 60 * 60 * 24);// �����趨����ʱÿ��̶�ִ��
		//1000 * 60 * 60 * 24
	}
	
//	session.removeAttribute("sessionname")�����SESSION���ĳ������. 
//	session.invalidate()����SESSIONʧЧ. 
	public void removeSessionAttributr(HttpServletRequest request){
		Enumeration<String> em = request.getSession().getAttributeNames();  //�õ�session�����е�������
		while (em.hasMoreElements()) {
			request.getSession().removeAttribute(em.nextElement().toString()); //����ɾ��session�е�ֵ
		}
	}
	
	//�������رյ�ʱ��ִ�е�
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
	
	//������������ʱ��ִ�е�
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		timer4();
		timer3();
	}
}