package com.publicpay.alipay.enums;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.enums
 * @Description: 截止日期是否生效，与gmt_end发布配合使用,N为gmt_end不生效，用户过期后仍可以缴费；Y为gmt_end生效，用户过期后，不能再缴费。
 * @date 2018/7/27 下午4:53
 */
public enum AlipayEndEnableEnum {
    NOT_EFFECT("N","不生效"),EFFECT("Y","生效");
    private String value;
    private String desc;
    AlipayEndEnableEnum(String value,String desc){
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
