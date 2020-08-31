package com.hlbrc.filter;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * http://www.cnblogs.com/zhuxiaojie/p/6238826.html
 * ���ü�������������request����Я����httpSession
 * ����webSocketȡSession
 * @ClassNmae��RequestListener   
 * @author ZY
 * @date   2020-04-11 15:47:13
 * 
 */
@WebListener
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre)  {
        
        //������request����Я����httpSession
        ((HttpServletRequest) sre.getServletRequest()).getSession();
        
    }
    public RequestListener() {}
 
    @Override
    public void requestDestroyed(ServletRequestEvent arg0)  {}
}