package com.publicpay.edu.alipay.enums;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.enums
 * @Description: 账单发送接口status
 * 用于删除孩子，状态为“D”，表示删除孩子，状态“U”表示孩子信息添加或更新。为空则不更新孩子信息
 * @date 2018/7/27 下午2:39
 */
public enum AlipaySendBillParamStatusEnum {
    DELETE("D","删除孩子"),UPDATE("U","表示孩子信息添加或更新");
    private String value;
    private String desc;
    AlipaySendBillParamStatusEnum(String value,String desc){
        this.value = value;
        this.desc = desc;
    }
}
