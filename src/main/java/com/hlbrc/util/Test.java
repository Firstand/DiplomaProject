package com.hlbrc.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Test {

	public static void main(String[] args) {
//		WxCardCustomField wx = new WxCardCustomField();
//		wx.setRequiredForm(new JSONObject());
//		wx.setRequiredFormCanModify(false);
//		wx.setRequiredFormRichFieldList(new JSONArray());
//		List<String> values = new ArrayList<String>();
//		values.add("����");
//		values.add("�赸");
//		values.add("����");
//		wx.setRequiredFormRichFieldListAll("FORM_FIELD_RADIO", "��Ȥ", values);
//		values = new ArrayList<String>();
//		values.add("������");
//		values.add("����");
//		values.add("��������");
//		wx.setRequiredFormRichFieldListAll("FORM_FIELD_SELECT", "ϲ��", values);
//		List<String> list = new ArrayList<String>();
//		list.add("USER_FORM_INFO_FLAG_MOBILE");
//		wx.setRequiredFormCommonFieldIdList(list);
//		System.out.println(wx.toJsonString());
		int mobile_code = (int)((Math.random()*9+1)*100000);
		String o = new Date().getTime()+""+mobile_code;
		System.out.println(o);
	}

}
