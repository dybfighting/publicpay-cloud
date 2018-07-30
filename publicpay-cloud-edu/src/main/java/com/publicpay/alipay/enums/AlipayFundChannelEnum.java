package com.publicpay.alipay.enums;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.enums
 * @Description: 支付宝支付渠道
 * @date 2018/7/30 上午10:41
 */
public enum  AlipayFundChannelEnum {
    COUPON("支付宝红包"),ALIPAYACCOUNT("支付宝余额"),POINT("集分宝"),DISCOUNT("折扣券"),
    PCARD("预付卡"),FINANCEACCOUNT("余额宝"),MCARD("商家储值卡"),MDISCOUNT("商户优惠券"),
    MCOUPON("商户红包"),PCREDIT("蚂蚁花呗");
    private String desc;
    AlipayFundChannelEnum(String desc){
        this.desc = desc;
    }
}
