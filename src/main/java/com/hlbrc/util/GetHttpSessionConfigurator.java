package com.hlbrc.util;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

/**
 * ����websocket��Э����HttpЭ���ǲ�ͬ�ģ�
 * ����������޷�ֱ���õ�session��
 * ������������Ҫ����ģ���Ȼ���websocketЭ�����õĳ���Ҳ��û��
 * ��дmodifyHandshake��HandshakeRequest request���Ի�ȡhttpSession
 * @ClassNmae��GetHttpSessionConfigurator   
 * @author ZY
 * @date   2020-04-11 15:47:13
 * 
 */
public class GetHttpSessionConfigurator extends Configurator{
    @Override
    public void modifyHandshake(ServerEndpointConfig sec,HandshakeRequest request, HandshakeResponse response) {
        
        HttpSession httpSession=(HttpSession) request.getHttpSession();
        
        sec.getUserProperties().put(HttpSession.class.getName(),httpSession);
        
    }
}