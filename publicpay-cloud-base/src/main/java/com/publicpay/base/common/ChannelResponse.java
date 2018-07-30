//package com.publicpay.base.common;
//
//import com.publicpay.base.beans.UnionPayBean;
//import org.apache.commons.lang3.builder.ToStringBuilder;
//
//import java.io.Serializable;
//
///**
// * 响应报文工具类
// * @author Shixy
// */
//public class ChannelResponse extends Response implements Serializable {
//
//	private static final long serialVersionUID = -7057101792135081848L;
//
//	private String channelCode; // 通道返回码
//
//	private String channelMsg; // 通道返回信息
//
//	private String orderNo; // 平台订单号
//
//	private String channelOrderNo; // 通道返回订单号
//
//	private String customerNo; // 通道商户号
//
//	public ChannelResponse() {}
//
//	public ChannelResponse(ReturnCodeEnum returnCodeEnum) {
//		super(returnCodeEnum);
//	}
//
//	public ChannelResponse(ReturnCodeEnum returnCodeEnum, Object data) {
//		super(returnCodeEnum, data);
//	}
//
//	public ChannelResponse(ReturnCodeEnum returnCodeEnum, UnionPayBean unionPayBean) {
//		super(returnCodeEnum, unionPayBean);
//	}
//
//	public String getChannelCode() {
//		return channelCode;
//	}
//
//	public void setChannelCode(String channelCode) {
//		this.channelCode = channelCode;
//	}
//
//	public String getChannelMsg() {
//		return channelMsg;
//	}
//
//	public void setChannelMsg(String channelMsg) {
//		this.channelMsg = channelMsg;
//	}
//
//	public String getOrderNo() {
//		return orderNo;
//	}
//
//	public void setOrderNo(String orderNo) {
//		this.orderNo = orderNo;
//	}
//
//	public String getChannelOrderNo() {
//		return channelOrderNo;
//	}
//
//	public void setChannelOrderNo(String channelOrderNo) {
//		this.channelOrderNo = channelOrderNo;
//	}
//
//	public String getCustomerNo() {
//		return customerNo;
//	}
//
//	public void setCustomerNo(String customerNo) {
//		this.customerNo = customerNo;
//	}
//
//	@Override
//	public String toString() {
//		return ToStringBuilder.reflectionToString(this);
//	}
//
//}
