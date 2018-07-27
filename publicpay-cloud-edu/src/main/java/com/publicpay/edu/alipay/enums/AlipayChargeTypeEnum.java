package com.publicpay.edu.alipay.enums;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.enums
 * @Description: 缴费项模式:空或"N"，表示 缴费项不可选， "M"表示缴费项为可选 ，支持 单选和多选。
 * @date 2018/7/27 下午2:13
 */
public enum AlipayChargeTypeEnum {
    OPTIONAL("M","可选"),NOT_OPTIONAL("N","不可选");
    private String value;
    private String desc;
    AlipayChargeTypeEnum(String value,String desc){
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
