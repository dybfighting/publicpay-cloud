package com.publicpay.base.common;

/**
 * @Author: yanfei.zhao
 * @Description:
 * @Date: Create in 18:11 2017/12/4
 */
public enum IsHotAreaEnum {
	YES("是", "1"), 
	NO("否", "0");

	IsHotAreaEnum(String key, String value) {
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
