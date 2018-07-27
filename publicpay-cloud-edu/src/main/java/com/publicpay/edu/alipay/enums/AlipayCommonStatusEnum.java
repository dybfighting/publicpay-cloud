package com.publicpay.edu.alipay.enums;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.enums
 * @Description: TODO
 * @date 2018/7/27 下午1:41
 */
public enum AlipayCommonStatusEnum {
    SUCCESS("Y","成功"),FAILED("N","失败");
    private String value;
    private String desc;
    AlipayCommonStatusEnum(String value,String desc){
        this.value = value;
        this.desc = desc;
    }
}
