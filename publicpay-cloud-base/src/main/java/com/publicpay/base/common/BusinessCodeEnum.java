package com.publicpay.base.common;

/**
 * @Author: yanfei.zhao
 * @Description: 业务类型
 * @Date: Create in 20:18 2017/11/30
 */
public enum BusinessCodeEnum {
 
    
    WATER("水费","1"),
    POWER("电费","2"),
    GAS("燃气费","3"),
    CREDIT_CARD("信用卡","4"),
    HEAT("热力","5"),
    OTHER("其他","0");

    BusinessCodeEnum(String key, String value) {
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
