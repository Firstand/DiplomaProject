package com.hlbrc.enums;

public interface AppEnum {
	/**
     * ״̬
     */
	/**��ɾ��*/
    public final static String DELETE = "0";
    /**����*/
    public final static String NORMAL = "1";
    
	/**
	 * ��ַ״̬
	 */
	/**��Ĭ�ϵ�ַ*/
	public final static int ADDRESS_NOT_DEFAULT = 0;
	/**Ĭ�ϵ�ַ*/
	public final static int ADDRESS_DEFAULT = 1;
	/**�õ�ַ��ɾ��*/
	public final static int ADDRESS_DEL = 2;
	
	/**
     * �û�״̬
     */
	/**����*/
    public final static String USER_ON_lINE = "1";
    /**����*/
    public final static String USER_OFF_LINE = "2";
    /**����*/
    public final static String USER_NORMAL = "3";
    /**���Ƶ�¼*/
    public final static String USER_LIMIT_LOGIN = "4";
    
    /**
     * ����״̬
     */
    /**ȡ��*/
    public final static String ORDER_CANCEL = "0";
    /**δ֧��*/
    public final static String ORDER_NON_PAYMENT = "1";
    /**��֧��*/
    public final static String ORDER_PAID = "2";
    /**δ����*/
    public final static String ORDER_NOT_SHIPPED = "3";
    /**�ѷ���*/
    public final static String ORDER_SHIPPED = "4";
    /**�˻�*/
    public final static String ORDER_REFUND = "5";
    /**���*/
    public final static String ORDER_FINISHED = "6";
    
    /**
     * �û���ַ�Ƿ�Ĭ��
     */
    /**�û�Ĭ��*/
    public final static String USER_DEFAULT = "1";
    /**�û���Ĭ��*/
    public final static String USER_NOT_DEFAULT = "2";
    
    /**
     * ��ַ��ǩ
     */
    /**��*/
    public final static String ADDRES_LABRL_HONE = "1";
    /**��˾*/
    public final static String ADDRES_LABRL_COMPANY = "2";
    /**ѧУ*/
    public final static String ADDRES_LABRL_SCHOOL = "3";
    /**�Զ���*/
    public final static String ADDRES_LABRL_CUSTOM = "4";
    
    /**
     * ��ʾ��Ϣ
     */
    /**�ɹ�*/
    public final static String SUCCEED = "ok";
    /**ʧ��*/
    public final static String FAIL = "no";
    /**�绰�Ų�����*/
    public final static String TEL_NOT_EXISTS = "no_0";
    /**�绰�����Ѵ���*/
    public final static String TEL_ALREADY_EXISTS = "no_1";
    /**�绰�����Ѹı�*/
    public final static String TEL_BEEN_CHANGED = "no_2";
    /**�����ַ�Ѵ���*/
    public final static String EMAIL_ALREADY_EXISTS = "no_3";
    /**�����ַ�Ѹı�*/
    public final static String EMAIL_BEEN_CHANGED = "no_4";
    
	
}
