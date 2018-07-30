package com.publicpay.edu.alipay.enums;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.enums
 * @Description: 支付宝交易状态
 * @date 2018/7/30 上午10:34
 */
public enum  AlipayTradeStatusEnum {

    WAIT_BUYER_PAY("交易创建，等待买家付款"),
    TRADE_CLOSED("未付款交易超时关闭，或支付完成后全额退款"),
    TRADE_SUCCESS("交易支付成功"),
    TRADE_FINISHED("交易结束，不可退款");
    private String desc;
    AlipayTradeStatusEnum(String desc){
        this.desc = desc;
    }
}
