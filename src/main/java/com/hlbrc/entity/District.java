package com.hlbrc.entity;

import java.io.Serializable;

/**
 * Çø ÊµÌå²ã
 * @author ZY
 *
 */
public class District implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int dis_id;
	private String dis_name;
	private City city;
	
	public int getDis_id() {
		return dis_id;
	}
	public void setDis_id(int dis_id) {
		this.dis_id = dis_id;
	}
	public String getDis_name() {
		return dis_name;
	}
	public void setDis_name(String dis_name) {
		this.dis_name = dis_name;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	
}
