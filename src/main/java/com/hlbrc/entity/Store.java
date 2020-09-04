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
	public String getManager_tel() {
		return manager_tel;
	}
	public void setManager_tel(String manager_tel) {
		this.manager_tel = manager_tel;
	}
	public String getManager_second_id() {
		return manager_second_id;
	}
	public void setManager_second_id(String manager_second_id) {
		this.manager_second_id = manager_second_id;
	}
	public String getManager_second_name() {
		return manager_second_name;
	}
	public void setManager_second_name(String manager_second_name) {
		this.manager_second_name = manager_second_name;
	}
	public String getManager_second_tel() {
		return manager_second_tel;
	}
	public void setManager_second_tel(String manager_second_tel) {
		this.manager_second_tel = manager_second_tel;
	}
	private String store_manager_id;
	private String store_manager_name;
	private String manager_tel;
	private String manager_second_id;
	private String manager_second_name;
	private String manager_second_tel;
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
