package com.publicpay.base.common;


/**
 * 公共状态
 * @author yanfei.zhao
 *
 */
public enum CommonStatusEnum {
    
    ACTIVE("可用","1"),
    INACTIVE("不可用","0");

    CommonStatusEnum(String key, String value) {
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
