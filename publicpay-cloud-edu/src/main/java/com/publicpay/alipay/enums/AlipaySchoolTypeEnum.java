package com.publicpay.alipay.enums;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.enums
 * @Description: 学校类型
 * @date 2018/7/27 下午1:44
 */
public enum AlipaySchoolTypeEnum {
    NURSERY("1","托儿所"),
    KINDERGARTEN("2","幼儿园"),
    PRIMARY_SCHOOL("3","小学"),
    MIDDLE_SCHOOL("4","初中"),
    HIGH_SCHOOL("5","高中");

    private String value;
    private String desc;
    AlipaySchoolTypeEnum(String value,String desc){
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
