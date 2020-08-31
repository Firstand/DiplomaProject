package com.hlbrc.entity;

import java.io.Serializable;

/**
 * ÊÐ ÊµÌå²ã
 * @author ZY
 *
 */
public class City implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int cit_id;
	private String cit_name; 
	private Privince privince;
	
	public int getCit_id() {
		return cit_id;
	}
	public void setCit_id(int cit_id) {
		this.cit_id = cit_id;
	}
	public String getCit_name() {
		return cit_name;
	}
	public void setCit_name(String cit_name) {
		this.cit_name = cit_name;
	}
	public Privince getPrivince() {
		return privince;
	}
	public void setPrivince(Privince privince) {
		this.privince = privince;
	}
	
}
