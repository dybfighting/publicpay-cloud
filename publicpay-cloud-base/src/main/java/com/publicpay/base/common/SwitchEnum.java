package com.publicpay.base.common;

/**
 * 开关
 * @author yanfei.zhao
 *
 */
public enum SwitchEnum {
	  
    OPEN("开","1"),
    CLOSE("关","0");

    SwitchEnum(String key, String value) {
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
