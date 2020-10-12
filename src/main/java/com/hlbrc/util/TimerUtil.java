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
	* 设定2000毫秒后执行
	*/
	public static void timer1(){
		Timer nTimer = new Timer();
		nTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("----设定要指定任务-----");
				System.gc();
				cancel();
			}
		},2000);
	}
 
	/**
	* 延迟5000毫秒，每1000毫秒执行一次
	*/
	public static void timer2() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
			System.out.println("-------延迟5000毫秒，每1000毫秒执行一次--------");
			}
		}, 5000, 1000);
	}
	
	/**
	* 延迟5000毫秒，每1小时执行一次
	*/
	public static void timer3() {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				System.err.println("-------正在更新所有用户的微信Token--------");
				WeChatDisposeTools wcd = new WeChatDisposeTools();
				wcd.setToken();
			}
		}, 10000, 1000 * 60 * 60 * 2);
	}
 
	/**
	* 设置24：00执行任务
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
				System.out.println("-------设定要指定任务--------");
				WebSocketService web_socket = new WebSocketService();
				web_socket.messageDispose();
			}
		}, time, 1000 * 60 * 60 * 24);// 这里设定将延时每天固定执行
		//1000 * 60 * 60 * 24
	}
	
//	session.removeAttribute("sessionname")是清除SESSION里的某个属性. 
//	session.invalidate()是让SESSION失效. 
	public void removeSessionAttributr(HttpServletRequest request){
		Enumeration<String> em = request.getSession().getAttributeNames();  //得到session中所有的属性名
		while (em.hasMoreElements()) {
			request.getSession().removeAttribute(em.nextElement().toString()); //遍历删除session中的值
		}
	}
	
	//服务器关闭的时候执行的
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
	
	//服务器启动的时候执行的
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		timer4();
		timer3();
	}
}