package com.hlbrc.filter;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * http://www.cnblogs.com/zhuxiaojie/p/6238826.html
 * 配置监听器，将所有request请求都携带上httpSession
 * 用于webSocket取Session
 * @ClassNmae：RequestListener   
 * @author ZY
 * @date   2020-04-11 15:47:13
 * 
 */
@WebListener
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre)  {
        
        //将所有request请求都携带上httpSession
        ((HttpServletRequest) sre.getServletRequest()).getSession();
        
    }
    public RequestListener() {}
 
    @Override
    public void requestDestroyed(ServletRequestEvent arg0)  {}
}