package com.publicpay.base.enums;

/**
 * 支付通道枚举类
 * @author yanfei.zhao
 *
 */
public enum ChannelPayType {
	
	CARDINFO("刷卡支付","1"),//卡友刷卡
	YEEPAY("快捷支付","2"),//易宝快捷支付
	QRCODE("二维码支付","3"),//易宝快捷支付
	OTHER("其他","4");//其他
	
	ChannelPayType(String key, String value) {
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
