package com.publicpay.base.enums;

/**
 * 订单状态
 * @author yanfei.zhao
 *
 */
public enum OrderStatus {
	
	INIT, // 初始化
	WAIT_PAYING, // 待支付
	PAY_SUCCESS, // 支付成功
	PAY_FAIL, // 支付失败
	RECHARGEING, //缴费中
	SUCCESS, // 成功
	FAIL // 失败
	
}
