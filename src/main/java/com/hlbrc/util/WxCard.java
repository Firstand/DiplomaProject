package com.hlbrc.util;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jackylian
 */
public abstract class WxCard
{

    protected WxCardBaseInfo m_baseInfo;
    protected org.json.JSONObject m_requestData;
    protected org.json.JSONObject m_data;
    protected String m_cardType;

    public WxCard()
    {
        m_baseInfo = new WxCardBaseInfo();
        m_requestData = new org.json.JSONObject();
    }
    
    public void init(String cardType)
    {
        m_cardType = cardType;
        org.json.JSONObject obj = new org.json.JSONObject();
        obj.put("card_type", m_cardType.toUpperCase());
        m_data = new org.json.JSONObject();
        m_data.put("base_info", m_baseInfo.m_data);
        obj.put(m_cardType.toLowerCase(), m_data);
        m_requestData.put("card", obj);
    }
    
    public org.json.JSONObject getJSONObject()
    {
        return m_requestData;
    }

    public String toJsonString()
    {
        return m_requestData.toString();
    }
    
    public String toString()
    {
        return toJsonString();
    }

    public WxCardBaseInfo getBaseInfo()
    {
        return m_baseInfo;
    }
    
    public void setBackgroundPicUrl(String background_pic_url) {
    	m_data.put("background_pic_url", background_pic_url);
	}
    
    public void setPrerogative(String prerogative) {
    	m_data.put("prerogative", prerogative);
	}
    
    public void setAutoActivate(boolean auto_activate) {
		m_data.put("auto_activate", auto_activate);
	}
    
    public void setWxActivate(boolean wx_activate) {
    	m_data.put("wx_activate", wx_activate);
	}
    
    public void setSupplyBonus(boolean supply_bonus) {
    	m_data.put("supply_bonus", supply_bonus);
	}
    
    public void setBonusUrl(String bonus_url) {
    	m_data.put("bonus_url", bonus_url);
	}
    
    public void setSupplyBalance(boolean supply_balance) {
    	m_data.put("supply_balance", supply_balance);
	}
    
    public void setBalanceUrl(String balance_url) {
    	m_data.put("balance_url", balance_url);
	}
    
    public void setCustomField1(org.json.JSONObject custom_field1) {
    	m_data.put("custom_field1", custom_field1);
	}
    
    public org.json.JSONObject getCustomField1() {
    	return m_data.optJSONObject("custom_field1");
	}
    
    public void setCustomField2(org.json.JSONObject custom_field2) {
    	m_data.put("custom_field2", custom_field2);
	}
    
    public org.json.JSONObject getCustomField2() {
    	return m_data.optJSONObject("custom_field2");
	}
    
    public void setCustomField3(org.json.JSONObject custom_field3) {
    	m_data.put("custom_field3", custom_field3);
	}
    
    public org.json.JSONObject getCustomField3() {
    	return m_data.optJSONObject("custom_field3");
	}
    
    public void setCustomFieldNameType(org.json.JSONObject custom_field,String name_type) {
    	custom_field.put("name_type", name_type);
	}
    
    public void setCustomFieldName(org.json.JSONObject custom_field,String name) {
    	custom_field.put("name", name);
	}
    
    public void setCustomFieldUrl(org.json.JSONObject custom_field,String url) {
    	custom_field.put("url", url);
	}
    
    public void setBonusCleared(String bonus_cleared) {
    	m_data.put("bonus_cleared", bonus_cleared);
	}
    
    public void setBonusRules(String bonus_rules) {
    	m_data.put("bonus_rules", bonus_rules);
	}
    
    public void setBalanceRules(String balance_rules) {
    	m_data.put("balance_rules", balance_rules);
	}
    
    public void setActivateUrl(String activate_url) {
    	m_data.put("activate_url", activate_url);
	}
    
    public void setActivateAppBrandUserName(String activate_app_brand_user_name) {
    	m_data.put("activate_app_brand_user_name", activate_app_brand_user_name);
	}
    
    public void setActivateAppBrandPass(String activate_app_brand_pass) {
    	m_data.put("activate_app_brand_pass", activate_app_brand_pass);
	}
    
    public void setCustomCell1(org.json.JSONObject custom_cell1) {
    	m_data.put("custom_cell1", custom_cell1);
	}
    
    public org.json.JSONObject getCustomCell1() {
    	return m_data.optJSONObject("custom_cell1");
	}
    
    public void setCustomCell1Name(String name) {
    	getCustomCell1().put("name", name);
	}
    
    public void setCustomCell1Tips(String tips) {
    	getCustomCell1().put("tips", tips);
	}
    
    public void setCustomCell1Url(String url) {
    	getCustomCell1().put("url", url);
	}
    
    public void setBonusRule(org.json.JSONObject bonus_rule) {
    	m_data.put("bonus_rule", bonus_rule);
	}
    
    public org.json.JSONObject getBonusRule() {
    	return m_data.optJSONObject("bonus_rule");
	}
    
    public void setCostMoneyUnit(int cost_money_unit) {
    	getBonusRule().put("cost_money_unit", cost_money_unit);
	}
    
    public void setIncreaseBonus(int increase_bonus) {
    	getBonusRule().put("increase_bonus", increase_bonus);
	}
    
    public void setMaxIncreaseBonus(int max_increase_bonus) {
    	getBonusRule().put("max_increase_bonus", max_increase_bonus);
	}
    
    public void setInitIncreaseBonus(int init_increase_bonus) {
    	getBonusRule().put("init_increase_bonus", init_increase_bonus);
	}
    
    public void setCostBonusUnit(int cost_bonus_unit) {
    	getBonusRule().put("cost_bonus_unit", cost_bonus_unit);
	}
    
    public void setReduceMoney(int reduce_money) {
    	getBonusRule().put("reduce_money", reduce_money);
	}
    
    public void setLeastMoneyToUseBonus(int least_money_to_use_bonus) {
    	getBonusRule().put("least_money_to_use_bonus", least_money_to_use_bonus);
	}
    
    public void setMaxReduceBonus(int max_reduce_bonus) {
    	getBonusRule().put("max_reduce_bonus", max_reduce_bonus);
	}
    
    public void setDiscount(int discount) {
    	m_data.put("discount", discount);
	}

}
