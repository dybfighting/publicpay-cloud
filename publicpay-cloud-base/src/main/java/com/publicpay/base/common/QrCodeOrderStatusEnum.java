package com.publicpay.base.common;


/**
 * 二维码支付订单状态枚举类
 * @author yanfei.zhao
 *
 */
public enum QrCodeOrderStatusEnum {
    
    SUCCESS("支付成功","00"),
    FAIL("支付失败","01"),
    CLOSE("订单关闭","02"),
    WAITING("等待支付","03");

    QrCodeOrderStatusEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    private String value;
    private String key;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
    
    
}
