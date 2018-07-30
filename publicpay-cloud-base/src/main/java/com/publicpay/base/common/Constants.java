package com.publicpay.base.common;

    /**
     * 用于定义系统公用常量
     * @author shixy 2017/12/7.
     */
    public class Constants {
    	
    /**系统默认提交数据方式*/
    public static final String CONTENT_TYPE_DEFAULT = "application/json;charset=UTF-8";

    /**系统运行环境*/
    public static final String SYS_ENV_DEV = "dev";

    public static final String STATUS_OPEN = "1";
    public static final String STATUS_DEL = "0";

    public static final String JPUSH_ACCOUNT_BIND_STATUS = "1";
    public static final String JPUSH_ACCOUNT_UNBIND_STATUS = "0";

    public static final String TRUE = "1";
    public static final String FALSE = "0";
    public static final String CONTENT = "content";
    public static final String DEC_CONTENT = "decryptContent";//解密后的content内容

    /**RedisKey前缀--秘钥*/
    public static final String PUBLICPAY_KEY_PREFIX = "PUBLICPAY_KEY_PREFIX_";
    public static final String KEY_PRI = "PUBLICPAY_KEY_PRI_";
    public static final String KEY_PUB = "PUBLICPAY_KEY_PUB_";
    public static final String KEY_PRI_THIRD = "PUBLICPAY_KEY_PRI_THIRD_";
    public static final String KEY_PUB_THIRD = "PUBLICPAY_KEY_PUB_THIRD_";
    public static final String KEY_DES = "PUBLICPAY_KEY_DES_";
    
    /**RedisKey前缀--ACCESSTOKEN */
    public static final Long ACCESSTOKEN_EXPIRY_DATE = 7*24*60*60L;
    public static final String ACCESSTOKEN_PREFIX = "PUBLICPAY_ACCESSTOKEN_";

    /**请求状态*/
    public final static String STATUS_SUCCESS = "SUCCESS";
    public final static String STATUS_FAILED = "FAILED";
    
    /**接口调用类型*/
    public static final String USER = "USER";
    public static final String ORG = "ORG";
    public static final String DEVICE = "DEVICE";

    //缴费路由所有者
    public static final String ALL = "ALL";

}
