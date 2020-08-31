package com.hlbrc.enums;

public interface WeCharEnum {
	/**获取accessToken*/
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    /**创建微信会员卡*/
    public static  final String CREATE_WX_URL = "https://api.weixin.qq.com/card/create?access_token=";
    /**上传图片到微信平台 */
    public static final String UPLOAD_URL="https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=";
    /**更新会员卡*/
    public static final String UPDATE_MEMBERCARD_URL = "https://api.weixin.qq.com/card/update?access_token=";
    /**支付即会员接口*/
    public static final String PAY_IS_MEMBER_URL = "https://api.weixin.qq.com/card/paygiftcard/add?access_token=";
    /**查看卡券详情接口*/
    public static final String GET_DETAIL_MEMBER_CARD_URL = "https://api.weixin.qq.com/card/get?access_token=";
    /**创建投放二维码接口*/
    public static final String CREATE_QRCODE_MEMCARD_URL = "https://api.weixin.qq.com/card/qrcode/create?access_token=" ;
    /**显示二维码图片接口*/
    public static final String SHOW_QRCODE_MEMCARD_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";
    /**创建货架接口*/
    public static final String CREATE_MEMBERCARD_SHELF = "https://api.weixin.qq.com/card/landingpage/create?access_token=";
    /**设置用户激活填写选项*/
    public static final String SET_USER_OPEN_CARD_URL = "https://api.weixin.qq.com/card/membercard/activateuserform/set?access_token=";
    /**获取前端需要展示的ticket*/
    public static final String GET_APP_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=";
    /**对接微信平台微信买单接口地址*/
    public static final String WX_MEM_WX_PAY_URL = "https://api.weixin.qq.com/card/paycell/set?access_token=";
    /**微信平台解码Code地址*/
    public static final String WX_MEM_HANDLE_CODE_URL = "https://api.weixin.qq.com/card/code/decrypt?access_token=";
    /**微信平台拉取会员信息接口*/
    public static final String WX_MEM_USERINFO_URL = "https://api.weixin.qq.com/card/membercard/userinfo/get?access_token=";
    /**微信更新用户会员卡信息接口*/
    public static final String SET_USERINFO_IN_CARD_URL = "https://api.weixin.qq.com/card/membercard/updateuser?access_token=";
    /**微信删除会员卡规则id接口*/
    public static final String DELATE_PIM_RULE_ID_URL = "https://api.weixin.qq.com/card/paygiftcard/delete?access_token=";
    /**销毁会员卡*/
    public static final String DELATE_MEMBERSHIP = "https://api.weixin.qq.com/card/delete?access_token=";
    /**设置白名单*/
    public static final String WHITE_LIST_URL = "https://api.weixin.qq.com/card/testwhitelist/set?access_token=";
    /**查询code*/
    public static final String GET_CODE_URL = "https://api.weixin.qq.com/card/code/get?access_token=";
    /**核销卡券*/
    public static final String CLEAR_URL = "https://api.weixin.qq.com/card/code/consume?access_token=";
    /**获取会员详细信息*/
    public static final String GET_MEMBER_INFORMATION = "https://api.weixin.qq.com/cgi-bin/user/info?openid=OPENID&lang=zh_CN&access_token=";
    /**测试使用的APPID*/
    public  static final String APPID = "wxab75c494f36ac927";
    /**测试使用的APPSECRET*/
    public  static final String APPSECRET ="5d0aa5579700ef88082834ec31794a88";
}
