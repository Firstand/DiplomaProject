package com.hlbrc.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信appid appsecret 将对象转化为Xml格式保存
 * @author ZY
 *
 */
@XmlRootElement
public class WeChatAppIdAppSecret {
	private String appid;
	private String appsecret;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getAppsecret() {
		return appsecret;
	}
	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	@Override
	public String toString() {
		return "WeCharAppIdAppSecret [appid=" + appid + ", appsecret=" + appsecret + "]";
	}
	
}
