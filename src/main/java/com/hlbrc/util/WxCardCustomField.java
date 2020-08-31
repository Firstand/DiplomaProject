package com.hlbrc.util;

import java.util.List;

public class WxCardCustomField {
	protected org.json.JSONObject obj = null;
	public WxCardCustomField() {
		obj = new org.json.JSONObject();
	}
	public String toJsonString()
    {
        return obj.toString();
    }
	public void setCardId(String card_id) {
		obj.put("card_id", card_id);
	}
	public void setRequiredForm(org.json.JSONObject required_form) {
		obj.put("required_form", required_form);
	}
	public org.json.JSONObject getRequiredForm() {
		return obj.optJSONObject("required_form");
	}
	public void setOptionalForm(org.json.JSONObject optional_form) {
		obj.put("optional_form", optional_form);
	}
	public org.json.JSONObject getOptionalForm() {
		return obj.optJSONObject("optional_form");
	}
	public void setRequiredFormCanModify(boolean can_modify) {
		getRequiredForm().put("can_modify", can_modify);
	}
	public void setOptionalFormCanModify(boolean can_modify) {
		getOptionalForm().put("can_modify", can_modify);
	}
	static String MOBILE = "USER_FORM_INFO_FLAG_MOBILE";//手机号
	static String SEX = "USER_FORM_INFO_FLAG_SEX";//性别
	static String NAME = "USER_FORM_INFO_FLAG_NAME";//姓名
	static String BIRTHDAY = "USER_FORM_INFO_FLAG_BIRTHDAY";//生日
	static String IDCARD = "USER_FORM_INFO_FLAG_IDCARD";//身份证
	static String EMAIL = "USER_FORM_INFO_FLAG_EMAIL";//邮箱
	static String LOCATION = "USER_FORM_INFO_FLAG_LOCATION";//详细地址
	static String BACKGRO = "USER_FORM_INFO_FLAG_EDUCATION_BACKGRO";//教育背景
	static String INDUSTRY = "USER_FORM_INFO_FLAG_INDUSTRY";//行业
	static String INCOME = "USER_FORM_INFO_FLAG_INCOME";//收入
	static String HABIT = "USER_FORM_INFO_FLAG_HABIT";//兴趣爱好
	public void setRequiredFormCommonFieldIdList(List<String> common_field_id_list) {
		getRequiredForm().put("common_field_id_list", common_field_id_list);
	}
	public void setOptionalFormCommonFieldIdList(List<String> common_field_id_list) {
		getOptionalForm().put("common_field_id_list", common_field_id_list);
	}
	public void setRequiredFormCustomFieldList(List<String> custom_field_list) {
		getRequiredForm().put("custom_field_list", custom_field_list);
	}
	public void setOptionalFormCustomFieldList(List<String> custom_field_list) {
		getOptionalForm().put("custom_field_list", custom_field_list);
	}
	public void setRequiredFormRichFieldList(org.json.JSONArray rich_field_list) {
		getRequiredForm().put("rich_field_list", rich_field_list);
	}
	public org.json.JSONArray getRequiredFormRichFieldList() {
		return getRequiredForm().optJSONArray("rich_field_list");
	}
	public void setOptionalFormRichFieldList(org.json.JSONArray rich_field_list) {
		getOptionalForm().put("rich_field_list", rich_field_list);
	}
	public org.json.JSONArray getOptionalFormRichFieldList() {
		return getOptionalForm().optJSONArray("rich_field_list");
	}
	static String RADIO = "FORM_FIELD_RADIO";//单选
	static String SELECT = "FORM_FIELD_SELECT";//选择项
	static String CHECK_BOX = "FORM_FIELD_CHECK_BOX";//多选
	public void setRequiredFormRichFieldListAll(String type,String name,List<String> values) {
		org.json.JSONObject all = new org.json.JSONObject();
		all.put("type", type);
		all.put("name", name);
		all.put("values", values);
		getRequiredFormRichFieldList().put(all);
	}
	public void setOptionalFormRichFieldListAll(String type,String name,List<String> values) {
		org.json.JSONObject all = new org.json.JSONObject();
		all.put("type", type);
		all.put("name", name);
		all.put("values", values);
		getOptionalFormRichFieldList().put(all);
	}
	public void setServiceStatement(org.json.JSONObject service_statement) {
		obj.put("service_statement", service_statement);
	}
	public org.json.JSONObject getServiceStatement() {
		return obj.optJSONObject("service_statement");
	}
	public void setBindOldCard(org.json.JSONObject bind_old_card) {
		obj.put("bind_old_card", bind_old_card);
	}
	public org.json.JSONObject getBindOldCard() {
		return obj.optJSONObject("bind_old_card");
	}
	public void setServiceStatementAll(String name,String url) {
		getServiceStatement().put("name", name);
		getServiceStatement().put("url", url);
	}
	public void setBindOldCardAll(String name,String url) {
		getBindOldCard().put("name", name);
		getBindOldCard().put("url", url);
	}
	public void setCode(String code) {
		obj.put("code", code);
	}
}
