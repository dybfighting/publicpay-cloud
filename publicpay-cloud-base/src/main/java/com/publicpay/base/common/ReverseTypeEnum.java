package com.publicpay.base.common;

/**
 * 补单类型
 * @author yanfei.zhao
 *
 */
public enum ReverseTypeEnum {
	PAY("支付", "1"), 
	RECHARGE("缴费", "2");

	ReverseTypeEnum(String key, String value) {
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
