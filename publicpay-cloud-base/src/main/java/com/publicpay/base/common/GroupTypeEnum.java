package com.publicpay.base.common;


/**
 * 分组类型
 * @author yanfei.zhao
 *
 */
public enum GroupTypeEnum {
    
    UNKNOWN("未分组","0"),
    DEFAULT("默认分组","1"),
    CUSTOM("自定义分组","2"),;

    GroupTypeEnum(String key, String value) {
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
