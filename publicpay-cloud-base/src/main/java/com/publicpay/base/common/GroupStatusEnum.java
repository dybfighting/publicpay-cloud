package com.publicpay.base.common;


/**
 * 分组状态
 * @author yanfei.zhao
 *
 */
public enum GroupStatusEnum {
    
    CLOSE("关闭","0"),
    OPEN("开通","1");

    GroupStatusEnum(String key, String value) {
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
