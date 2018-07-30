package com.publicpay.alipay.enums;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.enums
 * @Description: 支付宝查询订单状态
 * @date 2018/7/27 下午3:31
 */
public enum AlipayOrderStatusEnum {
    NOT_PAY("待缴费"),PAYING("支付中"),PAY_SUCCESS("支付成功，处理中"),BILLING_SUCCESS("缴费成功"),
    TIMEOUT_CLOSED("逾期关闭账单"),ISV_CLOSED("账单关闭");

    private String desc;
    AlipayOrderStatusEnum(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
