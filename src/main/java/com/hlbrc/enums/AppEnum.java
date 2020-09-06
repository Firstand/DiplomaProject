package com.hlbrc.enums;

public interface AppEnum {
	/**
     * 状态
     */
	/**已删除*/
    public final static String DELETE = "0";
    /**正常*/
    public final static String NORMAL = "1";
    
	/**
	 * 地址状态
	 */
	/**非默认地址*/
	public final static int ADDRESS_NOT_DEFAULT = 0;
	/**默认地址*/
	public final static int ADDRESS_DEFAULT = 1;
	/**该地址已删除*/
	public final static int ADDRESS_DEL = 2;
	
	/**
     * 用户状态
     */
	/**在线*/
    public final static String USER_ON_lINE = "1";
    /**离线*/
    public final static String USER_OFF_LINE = "2";
    /**正常*/
    public final static String USER_NORMAL = "3";
    /**限制登录*/
    public final static String USER_LIMIT_LOGIN = "4";
    
    /**
     * 订单状态
     */
    /**取消*/
    public final static String ORDER_CANCEL = "0";
    /**未支付*/
    public final static String ORDER_NON_PAYMENT = "1";
    /**已支付*/
    public final static String ORDER_PAID = "2";
    /**未发货*/
    public final static String ORDER_NOT_SHIPPED = "3";
    /**已发货*/
    public final static String ORDER_SHIPPED = "4";
    /**退货*/
    public final static String ORDER_REFUND = "5";
    /**完成*/
    public final static String ORDER_FINISHED = "6";
    
    /**
     * 用户地址是否默认
     */
    /**用户默认*/
    public final static String USER_DEFAULT = "1";
    /**用户非默认*/
    public final static String USER_NOT_DEFAULT = "2";
    
    /**
     * 地址标签
     */
    /**家*/
    public final static String ADDRES_LABRL_HONE = "1";
    /**公司*/
    public final static String ADDRES_LABRL_COMPANY = "2";
    /**学校*/
    public final static String ADDRES_LABRL_SCHOOL = "3";
    /**自定义*/
    public final static String ADDRES_LABRL_CUSTOM = "4";
    
    /**
     * 提示信息
     */
    /**成功*/
    public final static String SUCCEED = "ok";
    /**失败*/
    public final static String FAIL = "no";
    /**电话号不存在*/
    public final static String TEL_NOT_EXISTS = "no_0";
    /**电话号码已存在*/
    public final static String TEL_ALREADY_EXISTS = "no_1";
    /**电话号码已改变*/
    public final static String TEL_BEEN_CHANGED = "no_2";
    /**邮箱地址已存在*/
    public final static String EMAIL_ALREADY_EXISTS = "no_3";
    /**邮箱地址已改变*/
    public final static String EMAIL_BEEN_CHANGED = "no_4";
    
	
}
