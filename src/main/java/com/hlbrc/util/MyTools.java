package com.hlbrc.util;

import java.util.Map;

import org.springframework.ui.Model;
/**
 * 自定义工具
 * @author ZY
 *
 */
public class MyTools {
	/**
	 * 数据回显
	 * @param model
	 * @param m
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setModel(Model model,Map m)
	{
		model.addAllAttributes(m);
	}
	/**
	 * 判别身份证格式
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
