package com.publicpay.base.common;


/**
 * 广告类型
 * @author yanfei.zhao
 *
 */
public enum AdTypeEnum {
    
	STAND_BY("待机","1"),
	PERMANENT("常驻","2"),
	LOGO("LOGO","3");

    AdTypeEnum(String key, String value) {
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
