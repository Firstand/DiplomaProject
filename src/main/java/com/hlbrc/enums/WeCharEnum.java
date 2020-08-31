package com.hlbrc.enums;

public interface WeCharEnum {
	/**��ȡaccessToken*/
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    /**����΢�Ż�Ա��*/
    public static  final String CREATE_WX_URL = "https://api.weixin.qq.com/card/create?access_token=";
    /**�ϴ�ͼƬ��΢��ƽ̨ */
    public static final String UPLOAD_URL="https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=";
    /**���»�Ա��*/
    public static final String UPDATE_MEMBERCARD_URL = "https://api.weixin.qq.com/card/update?access_token=";
    /**֧������Ա�ӿ�*/
    public static final String PAY_IS_MEMBER_URL = "https://api.weixin.qq.com/card/paygiftcard/add?access_token=";
    /**�鿴��ȯ����ӿ�*/
    public static final String GET_DETAIL_MEMBER_CARD_URL = "https://api.weixin.qq.com/card/get?access_token=";
    /**����Ͷ�Ŷ�ά��ӿ�*/
    public static final String CREATE_QRCODE_MEMCARD_URL = "https://api.weixin.qq.com/card/qrcode/create?access_token=" ;
    /**��ʾ��ά��ͼƬ�ӿ�*/
    public static final String SHOW_QRCODE_MEMCARD_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";
    /**�������ܽӿ�*/
    public static final String CREATE_MEMBERCARD_SHELF = "https://api.weixin.qq.com/card/landingpage/create?access_token=";
    /**�����û�������дѡ��*/
    public static final String SET_USER_OPEN_CARD_URL = "https://api.weixin.qq.com/card/membercard/activateuserform/set?access_token=";
    /**��ȡǰ����Ҫչʾ��ticket*/
    public static final String GET_APP_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=";
    /**�Խ�΢��ƽ̨΢���򵥽ӿڵ�ַ*/
    public static final String WX_MEM_WX_PAY_URL = "https://api.weixin.qq.com/card/paycell/set?access_token=";
    /**΢��ƽ̨����Code��ַ*/
    public static final String WX_MEM_HANDLE_CODE_URL = "https://api.weixin.qq.com/card/code/decrypt?access_token=";
    /**΢��ƽ̨��ȡ��Ա��Ϣ�ӿ�*/
    public static final String WX_MEM_USERINFO_URL = "https://api.weixin.qq.com/card/membercard/userinfo/get?access_token=";
    /**΢�Ÿ����û���Ա����Ϣ�ӿ�*/
    public static final String SET_USERINFO_IN_CARD_URL = "https://api.weixin.qq.com/card/membercard/updateuser?access_token=";
    /**΢��ɾ����Ա������id�ӿ�*/
    public static final String DELATE_PIM_RULE_ID_URL = "https://api.weixin.qq.com/card/paygiftcard/delete?access_token=";
    /**���ٻ�Ա��*/
    public static final String DELATE_MEMBERSHIP = "https://api.weixin.qq.com/card/delete?access_token=";
    /**���ð�����*/
    public static final String WHITE_LIST_URL = "https://api.weixin.qq.com/card/testwhitelist/set?access_token=";
    /**��ѯcode*/
    public static final String GET_CODE_URL = "https://api.weixin.qq.com/card/code/get?access_token=";
    /**������ȯ*/
    public static final String CLEAR_URL = "https://api.weixin.qq.com/card/code/consume?access_token=";
    /**��ȡ��Ա��ϸ��Ϣ*/
    public static final String GET_MEMBER_INFORMATION = "https://api.weixin.qq.com/cgi-bin/user/info?openid=OPENID&lang=zh_CN&access_token=";
    /**����ʹ�õ�APPID*/
    public  static final String APPID = "wxab75c494f36ac927";
    /**����ʹ�õ�APPSECRET*/
    public  static final String APPSECRET ="5d0aa5579700ef88082834ec31794a88";
}
