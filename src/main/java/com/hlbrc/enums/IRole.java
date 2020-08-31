package com.hlbrc.enums;

/**
 * ö��
 * @author ZY
 *
 */
public interface IRole {
	/* ��� */
	//��ͨ����Ա
	public final static int MANAGER_COMMON = 11;
	//��������Ա
	public final static int MANAGER_SUPER = 12;
	//��Ա
	public final static int MEMBER = 21;
	
	/* ������ */
	//����Ա��
	public final static String MANAGER_TABLE = "MANAGER_TABLE";
	//��Ա��
	public final static String MEMBER_TABLE = "MEMBER_TABLE";
	
	/* ��Ϣ���� */
	//�ı�
	public final static int TEXT = 1;
	//�ļ�
	public final static int FILE = 2;
	//��Ƶ
	public final static int VIDEO = 3;
	//ͼ(��̬��̬)
	public final static int GIF = 4;
	
	/* ͼƬ���� */
	//ͷ��
	public final static String PRO_HEAD_PROTRAIT = "1";
	//����
	public final static String PRO_BACKGROUD = "2";
	
	/* ��ȯ����״̬ */
	//����
	public final static String CANCEL_AFTER_VERIFICATION_Y = "1";
	//�Ѻ���
	public final static String CANCEL_AFTER_VERIFICATION_N = "0";
}
