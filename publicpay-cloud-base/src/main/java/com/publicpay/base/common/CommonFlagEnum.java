package com.publicpay.base.common;


/**
 * 公共标识
 * @author yanfei.zhao
 *
 */
public enum CommonFlagEnum {
    
    TRUE("是","1"),
    FALSE("否","0");

    CommonFlagEnum(String key, String value) {
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
