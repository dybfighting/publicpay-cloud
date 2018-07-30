package com.publicpay.base.common;

import java.util.HashSet;

/**
 * @author Shixy
 */
public enum ReturnCodeEnum {
	//成功
	RESTFUL_SUCCESS			(200, "成功"),
	//处理失败，未知异常
	RESTFU_FAIL				(500, "处理失败，未知异常"),
	TIME_OUT					(420,"请求超时"),
	//请求中的参数验证失败
	REQ_OBJ_INVALID(410, "参数验证失败"),

	// 系统级别提示码	
	SYSTEM_BUSY				(4101 , "系统繁忙，请稍后重试！"),
	USER_NOT_EXIT			(4102, "用户不存在"),
	SIGNATURE_ERROR			(4103, "签名错误"),
	ID_NOT_NULL 			(4104, "id不能为空"),
	CHECK_CODE_ERROR 		(4105, "验证码错误"),
	PSSSWORD_ERROR 			(4106, "密码错误"),
	FILE_IS_EMPTY			(4107, "上传文件为空"),
	OLD_PSSSWORD_ERROR 		(4108, "旧密码错误"),
	UPDATE_PSSSWORD_ERROR 	(4109, "密码修改失败"),
	UPDATE_NOT_EXIST		(4110, "更新数据不存在"),
	NO_SUPPORT		        (4111, "无此业务权限"),
	DEVICE_NOT_EXIT			(4112, "设备不存在"),
	USERNO_INVALID		    (4113, "用户号码无效"),
	NO_DATA		            (4114, "数据不存在"),

	//机具类
	MPOS_BINDED				(4200,"当前机具不可用"),
	MPOS_UNBIND				(4201, "该机具为绑定"),
	SN_NOT_EXISTS			(4202, "该机具序列号不存在"),
	
	//秘钥类
	TRANS_KEYS_EXISTS		(4250, "该机具秘钥已经存在"),

	// 商户类别提示码
	MERCHANTID_ERROR		(4301, "商户号无效"),
	MEMBERSHIP_ERROR		(4302, "会员号无效"),
	AUTHCODE_EXPIRE			(4304, "二维码过期"),
	NO_BINDING_CARD			(4305, "没有绑定卡"),
	UPDATE_PSSSWORD_FAIL 	(4304, "密码修改失败"),
	USER_NAME_EXISTS		(4306, "用户已存在"),
	PHONE_NUMBER_EXISTS		(4307, "用户手机已注册"),
	REAL_AUTH_FAIL		    (4308, "实名认证失败"),
	CHECK_VERSION_FAIL		(4309, "检查更新失败"),

	// 订单类别提示码
	BALANCE_NOT_ENOUGH		(4351, "余额不足"),
	ORDER_CLOSED			(4352, "订单已关闭"),
	ORDER_REVERSED			(4353, "订单已撤销"),
	ORDER_REVERSE_FAIL		(4354, "订单撤销失败"),
	WAIT_BUYER_PAY			(4355, "订单待支付"),
	OUT_TRADE_NO_REPEAT		(4356, "商户订单号重复"),
	INVALID_OUT_TRADE_NO	(4357, "商户订单号无效"),
	INVALID_TRADE_NO		(4358, "支付订单号无效"),
	UNREGISTE_PAY_CARD		(4359, "未开通刷卡支付"),
	PAY_PWD_INVALID			(4360, "验证支付密码失败"),
	PAY_CARD_CODE_INVALID	(4361, "验证付款码失败"),
	ORDER_FILL				(4362, "订单支付失败"),
	ORDER_PAYING		(4363, "支付中"),
	PAYMENTS_NOT_EXIST			(4364, "支付流水不存在"),

	// 账单类型提示码
	NOT_SUPPORT_GEGION 		(4401, "暂不支持该地区"),
	GET_BILL_FAIL	        (4402, "账单获取失败"),
	NO_BILL	        (4403, "账单不存在"),
	EXPORT_BILL_FAIL	        (4404, "账单生成失败"),
	GROUP_NAME_EXIST         (4405, "该名称已存在"),
	EXPORT_SUB_BILL_FAIL	        (4406, "部分账单生成失败"),
	// web 提示码
	LOGIN_TOKEN_INVALID		(4451, "登录会话错误"),
	
	
	
	// 业务调用类型提示码

	// 缴费类型提示码
	RECHARGE_FAILL						(4500, "充值失败"),
	PRE_TRANS_ERROR			    (4501, "上送交易前抛出异常"),
    PAY_FAILL_PASSERROR			(4502, "交易失败,输入的密码、有效期或CVN2有误"),
	NO_BALANCE		            	(4503, "交易失败,您的卡余额不足"),
	ACC_NO_ERROR		        	(4504, "输入的卡号无效，请确认后输入"),
	ALREADY_PAID		        	(4505, "未开账或者已支付(渠道方返回)"),
	SECURITY_VERIFICATION_FAIL	(4506, "安全码验证失败，详询您的发卡行"),
	PASSWORD_ERROR_LIMIT			(4507, "密码输入次数超限"),
	USER_NO_ERROR		        	(4508, "输入号码错误"),
	RECHARGE_CHANNEL_NOT_EXIST			(4509, "缴费通道不存在"),
	RECHARGING			(4510, "充值中"),
	RECHARGE_FAILL_68			(4511, "您的银行卡暂不支持该业务，请向您的银行或95516咨询"),
	CARD_TYPE_NOT_SUPPORT		(4512, "不支持磁条交易，请使用芯片"), 
	NO_RECORDS		(4513, "暂无缴费记录"), 
	QUERY_ORDER_STATUS_ERROT		(4514, "查询订单状态异常"),
	REMOVE_ACCOUNT_FAILD		(4515, "销账失败"), 
	CHANNEL_CATEGORIES_NOT_EXIST			(4516, "缴费单位不存在"),
	FOWID_NOT_FIND			(4517, "未找到对应流水号"),
	REMOVED_ACCOUNT			(4518, "已销帐"),
	
	
	//快捷支付提示码
	VALIDATE_CODE_EXPIRE						(5001, "短信校验码已过期，请重新获取"),  
	REPEAT_REFUND						(5002, "同一笔商户退款请求只能请求一次"),
	NO_ORDER						(5003, "订单不存在"),
	ORDER_PAID						(5004, "订单已支付"),
	
	//二维码支付相关
	BEYOND_LIMIT        (5101, "交易超出限额"),
	NO_RETRY_PAY        (5102, "订单不支持重复支付 "),
	ORDER_COLSED        (5103, "订单已关闭 "),
	AMOUNT_NOT_EQUALS        (5104, "订单金额与首次下单不一致 "),
	TRADE_EXIST_RIST        (5105, "交易存在风险"),
	
	//信用卡相关
	CARD_EXISTENCE  	(6001,"此卡号已存在，请勿重复添加"),
	CARD_NUMBER_ERROR   (6002,"请输入正确信用卡号"),
	BANK_ERROR 			(6003,"不支持该银行"),
	CARD_DISTINGUISH    (6004,"卡识别异常"),
	REPAYMENT_COUNT     (6005,"当月还款笔数已达上限"),
	SYSTEM_ERROR        (9999, "系统错误"),
	
	//热力缴费相关
	ERROR_USER  	(7001,"该类客户不允许交费，请联系热力公司");
	
	/**
	 * The value.
	 */
	private final int value;

	/**
	 * The desc.
	 */
	private final String desc;

	/**
	 * Instantiates a new return status enum.
	 *
	 * @param value
	 * @param desc  the desc
	 */
	private ReturnCodeEnum(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int value() {
		return value;
	}

	/**
	 * Gets the desc.
	 *
	 * @return the desc
	 */
	public String desc() {
		return desc;
	}

	private static HashSet<Integer> hashSet;

	static {
		hashSet = new HashSet<Integer>();
		hashSet.clear();
		for (ReturnCodeEnum returnStatus : ReturnCodeEnum.values()) {
			hashSet.add(returnStatus.value());
		}
	}

	public static boolean isDefined(int value) {
		if (hashSet.contains(value)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 通过code获取msg
	 * @param rCode code
	 * @return msg
	 */
	public static  String getMsgByCode(String rCode) {
		String result = null;
		for (ReturnCodeEnum returnCodeEnum : ReturnCodeEnum.values()) {
			if(String.valueOf(returnCodeEnum.value()).equals(rCode)){
				result=returnCodeEnum.desc();
			}
		}
		return result;
	}
}