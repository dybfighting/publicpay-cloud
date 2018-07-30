package com.publicpay.base.common;


/**
 * 二维码支付枚举类
 * @author yanfei.zhao
 *
 */
public enum QrCodePayTypeEnum {
    
    QRCODE("二维码支付","1"),
    BARCODE("条码支付","2");

    QrCodePayTypeEnum(String key, String value) {
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
