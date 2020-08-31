package com.hlbrc.enums;

/**
 * 枚举
 * @author ZY
 *
 */
public interface IRole {
	/* 身份 */
	//普通管理员
	public final static int MANAGER_COMMON = 11;
	//超级管理员
	public final static int MANAGER_SUPER = 12;
	//会员
	public final static int MEMBER = 21;
	
	/* 表类型 */
	//管理员表
	public final static String MANAGER_TABLE = "MANAGER_TABLE";
	//会员表
	public final static String MEMBER_TABLE = "MEMBER_TABLE";
	
	/* 消息类型 */
	//文本
	public final static int TEXT = 1;
	//文件
	public final static int FILE = 2;
	//视频
	public final static int VIDEO = 3;
	//图(动态或静态)
	public final static int GIF = 4;
	
	/* 图片类型 */
	//头像
	public final static String PRO_HEAD_PROTRAIT = "1";
	//背景
	public final static String PRO_BACKGROUD = "2";
	
	/* 卡券核销状态 */
	//正常
	public final static String CANCEL_AFTER_VERIFICATION_Y = "1";
	//已核销
	public final static String CANCEL_AFTER_VERIFICATION_N = "0";
}
