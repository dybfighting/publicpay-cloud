package com.publicpay.edu.alipay.enums;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.enums
 * @Description: 账单状态同步接口status
 * 状态：1:缴费成功，2:关闭账单，3、退费
 * @date 2018/7/27 下午3:09
 */
public enum  AlipayModifyBillStatusEnum {
    PAY_SUCCESS("1","缴费成功"),BILL_CLOSED("2","关闭账单"),REFUND("3","退费");
    private String value;
    private String desc;
    AlipayModifyBillStatusEnum(String value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
