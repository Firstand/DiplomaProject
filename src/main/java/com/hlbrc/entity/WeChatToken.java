package com.hlbrc.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信token 将对象转化为Xml格式保存
 * @author ZY
 */
@XmlRootElement
public class WeChatToken {
  // 接口访问凭证
  private String accessToken;
  // 凭证有效期，单位：秒
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