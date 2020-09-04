package com.hlbrc.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 管理员/普通管理员 实体层
 * @author ZY
 *
 */
public class Manager implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int manager_id;
	private int manager_age;
	private int manager_type;
	private String manager_name;
	private String manager_sex;
	private String manager_password;
	private String manager_birth_time;
	private String manager_email;
	private String manager_tel;
	private String manager_idcard_num;
	private String manager_img_path;
	private int manager_context_num;
	private int manager_state;
	private String fixed_line_telephonne;
	private String from_enterprise_id;
	private Timestamp first_login_time;
	private String first_login_ip;
	private Timestamp last_login_time;
	private String last_login_ip;
	private int is_effective_account;
	private int is_tax;
	private int disable;
	private int account_group_id;
	private double order_refund_rate;
	private double reward_amount_rate;
	private String manager_context_finally;
	private Timestamp manager_regist_time;
	private District district;
	private City city;
	private Privince privince;
	private List<Profileimg> profileimg;

	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public int getManager_age() {
		return manager_age;
	}
	public void setManager_age(int manager_age) {
		this.manager_age = manager_age;
	}
	public String getManager_sex() {
		return manager_sex;
	}
	public void setManager_sex(String manager_sex) {
		this.manager_sex = manager_sex;
	}
	public String getManager_password() {
		return manager_password;
	}
	public void setManager_password(String manager_password) {
		this.manager_password = manager_password;
	}
	public String getManager_birth_time() {
		return manager_birth_time;
	}
	public void setManager_birth_time(String manager_birth_time) {
		this.manager_birth_time = manager_birth_time;
	}
	public String getManager_email() {
		return manager_email;
	}
	public void setManager_email(String manager_email) {
		this.manager_email = manager_email;
	}
	public String getManager_tel() {
		return manager_tel;
	}
	public void setManager_tel(String manager_tel) {
		this.manager_tel = manager_tel;
	}
	public String getManager_idcard_num() {
		return manager_idcard_num;
	}
	public void setManager_idcard_num(String manager_idcard_num) {
		this.manager_idcard_num = manager_idcard_num;
	}
	public int getManager_context_num() {
		return manager_context_num;
	}
	public void setManager_context_num(int manager_context_num) {
		this.manager_context_num = manager_context_num;
	}
	public String getManager_context_finally() {
		return manager_context_finally;
	}
	public void setManager_context_finally(String manager_context_finally) {
		this.manager_context_finally = manager_context_finally;
	}
	public Timestamp getManager_regist_time() {
		return manager_regist_time;
	}
	public void setManager_regist_time(Timestamp manager_regist_time) {
		this.manager_regist_time = manager_regist_time;
	}
	public String getManager_img_path() {
		return manager_img_path;
	}
	public void setManager_img_path(String manager_img_path) {
		this.manager_img_path = manager_img_path;
	}
	public int getManager_type() {
		return manager_type;
	}
	public void setManager_type(int manager_type) {
		this.manager_type = manager_type;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Privince getPrivince() {
		return privince;
	}
	public void setPrivince(Privince privince) {
		this.privince = privince;
	}
	public List<Profileimg> getProfileimg() {
		return profileimg;
	}
	public void setProfileimg(List<Profileimg> profileimg) {
		this.profileimg = profileimg;
	}
	public int getManager_state() {
		return manager_state;
	}
	public void setManager_state(int manager_state) {
		this.manager_state = manager_state;
	}
	public String getFixed_line_telephonne() {
		return fixed_line_telephonne;
	}
	public void setFixed_line_telephonne(String fixed_line_telephonne) {
		this.fixed_line_telephonne = fixed_line_telephonne;
	}
	public String getFrom_enterprise_id() {
		return from_enterprise_id;
	}
	public void setFrom_enterprise_id(String from_enterprise_id) {
		this.from_enterprise_id = from_enterprise_id;
	}
	public Timestamp getFirst_login_time() {
		return first_login_time;
	}
	public void setFirst_login_time(Timestamp first_login_time) {
		this.first_login_time = first_login_time;
	}
	public String getFirst_login_ip() {
		return first_login_ip;
	}
	public void setFirst_login_ip(String first_login_ip) {
		this.first_login_ip = first_login_ip;
	}
	public Timestamp getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Timestamp last_login_time) {
		this.last_login_time = last_login_time;
	}
	public String getLast_login_ip() {
		return last_login_ip;
	}
	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}
	public int getIs_effective_account() {
		return is_effective_account;
	}
	public void setIs_effective_account(int is_effective_account) {
		this.is_effective_account = is_effective_account;
	}
	public int getIs_tax() {
		return is_tax;
	}
	public void setIs_tax(int is_tax) {
		this.is_tax = is_tax;
	}
	public int getDisable() {
		return disable;
	}
	public void setDisable(int disable) {
		this.disable = disable;
	}
	public int getAccount_group_id() {
		return account_group_id;
	}
	public void setAccount_group_id(int account_group_id) {
		this.account_group_id = account_group_id;
	}
	public double getOrder_refund_rate() {
		return order_refund_rate;
	}
	public void setOrder_refund_rate(double order_refund_rate) {
		this.order_refund_rate = order_refund_rate;
	}
	public double getReward_amount_rate() {
		return reward_amount_rate;
	}
	public void setReward_amount_rate(double reward_amount_rate) {
		this.reward_amount_rate = reward_amount_rate;
	}
	
}
