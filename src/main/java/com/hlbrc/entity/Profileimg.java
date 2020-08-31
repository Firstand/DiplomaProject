package com.hlbrc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户头像/背景 实体层
 * @author ZY
 *
 */
public class Profileimg implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int pro_file_img_id;
	private String pro_file_img_path;
	private String pro_file_img_type;
	private Manager manager;
	private Date creat_time; 
	public int getPro_file_img_id() {
		return pro_file_img_id;
	}
	public void setPro_file_img_id(int pro_file_img_id) {
		this.pro_file_img_id = pro_file_img_id;
	}
	public String getPro_file_img_path() {
		return pro_file_img_path;
	}
	public void setPro_file_img_path(String pro_file_img_path) {
		this.pro_file_img_path = pro_file_img_path;
	}
	public String getPro_file_img_type() {
		return pro_file_img_type;
	}
	public void setPro_file_img_type(String pro_file_img_type) {
		this.pro_file_img_type = pro_file_img_type;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Date getCreat_time() {
		return creat_time;
	}
	public void setCreat_time(Date creat_time) {
		this.creat_time = creat_time;
	}
}
