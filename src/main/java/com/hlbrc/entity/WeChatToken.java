package com.hlbrc.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * ΢��token ������ת��ΪXml��ʽ����
 * @author ZY
 */
@XmlRootElement
public class WeChatToken {
  // �ӿڷ���ƾ֤
  private String accessToken;
  // ƾ֤��Ч�ڣ���λ����
  private int expiresIn;
 
  public String getAccessToken() {
    return accessToken;
  }
 
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }
 
  public int getExpiresIn() {
    return expiresIn;
  }
 
  public void setExpiresIn(int expiresIn) {
    this.expiresIn = expiresIn;
  }

@Override
public String toString() {
	return "WeChatToken [accessToken=" + accessToken + ", expiresIn=" + expiresIn + "]";
}
}