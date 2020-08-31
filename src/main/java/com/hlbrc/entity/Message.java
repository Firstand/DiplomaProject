package com.hlbrc.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 信息 实体层
 * @author ZY
 *
 */
public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int message_id;
	//发送者
	private int sender_id;
	//消息内容
	private String content;
	//消息类型
	private int content_type;
	//标识
	private String flag;
	//接收者
	private int accepter_id;
	//发送者表名
	private String table_name_sender;
	//接收者表名
	private String table_name_accepter;
	//时间
	private Timestamp creat_time;
	private String creat_time_str;
	//判断是否是自己
	private boolean isself;
	//关联属性
	private Manager manager;
	
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public int getSender_id() {
		return sender_id;
	}
	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}
	public int getAccepter_id() {
		return accepter_id;
	}
	public void setAccepter_id(int accepter_id) {
		this.accepter_id = accepter_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getContent_type() {
		return content_type;
	}
	public void setContent_type(int content_type) {
		this.content_type = content_type;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getTable_name_sender() {
		return table_name_sender;
	}
	public void setTable_name_sender(String table_name_sender) {
		this.table_name_sender = table_name_sender;
	}
	public String getTable_name_accepter() {
		return table_name_accepter;
	}
	public void setTable_name_accepter(String table_name_accepter) {
		this.table_name_accepter = table_name_accepter;
	}
	public Timestamp getCreat_time() {
		return creat_time;
	}
	public void setCreat_time(Timestamp creat_time) {
		this.creat_time = creat_time;
	}
	public String getCreat_time_str() {
		return creat_time_str;
	}
	public void setCreat_time_str(String creat_time_str) {
		this.creat_time_str = creat_time_str;
	}
	public boolean isIsself() {
		return isself;
	}
	public void setIsself(boolean isself) {
		this.isself = isself;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
}
