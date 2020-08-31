package com.hlbrc.util;

import java.util.Map;

import org.springframework.ui.Model;
/**
 * �Զ��幤��
 * @author ZY
 *
 */
public class MyTools {
	/**
	 * ���ݻ���
	 * @param model
	 * @param m
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setModel(Model model,Map m)
	{
		model.addAllAttributes(m);
	}
	/**
	 * �б����֤��ʽ
	 * @param u_id
	 * @return
	 */
	public boolean cardId(String u_id) {
	   String regex = "/(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)/";
	   if(u_id.matches(regex))
	       return true;
	   else
	       return false;
	}
}
