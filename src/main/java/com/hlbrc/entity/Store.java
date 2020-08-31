package com.hlbrc.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * √≈µÍ  µÃÂ≤„
 * @author ZY
 *
 */
public class Store implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int store_id;
	private String store_name;
	private String store_address;
	private String store_type;
	private String store_state;
	private String store_manager_id;
	private String store_manager_name;
	private Timestamp store_regist_time;
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getStore_address() {
		return store_address;
	}
	public void setStore_address(String store_address) {
		this.store_address = store_address;
	}
	public String getStore_type() {
		return store_type;
	}
	public void setStore_type(String store_type) {
		this.store_type = store_type;
	}
	public Timestamp getStore_regist_time() {
		return store_regist_time;
	}
	public void setStore_regist_time(Timestamp store_regist_time) {
		this.store_regist_time = store_regist_time;
	}
	public String getStore_state() {
		return store_state;
	}
	public void setStore_state(String store_state) {
		this.store_state = store_state;
	}
	public String getStore_manager_id() {
		return store_manager_id;
	}
	public void setStore_manager_id(String store_manager_id) {
		this.store_manager_id = store_manager_id;
	}
	public String getStore_manager_name() {
		return store_manager_name;
	}
	public void setStore_manager_name(String store_manager_name) {
		this.store_manager_name = store_manager_name;
	}
	
}
