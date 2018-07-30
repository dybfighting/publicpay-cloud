package com.publicpay.base.enums;

/**
 * 缴费通道类型
 * @author yanfei.zhao
 *
 */
public enum ChannelRechargeType {
	
	UNIONPAY("银联","1"),
	IWATER("爱水","2"),
	NORTHSOFT("北软","3"),
	ZOOMKEY("众齐","4"),
	EWIDE("易维","5"),
	JINRUI("金睿","6"),
	SHESHU("舍舒","7"),
	OTHER("其他","0");

	ChannelRechargeType(String key, String value) {
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