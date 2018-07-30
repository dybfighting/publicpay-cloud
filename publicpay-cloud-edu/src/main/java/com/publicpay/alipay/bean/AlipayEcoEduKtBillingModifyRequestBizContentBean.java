package com.publicpay.alipay.bean;

import com.publicpay.alipay.annotation.BeanToJson;
import com.publicpay.alipay.constant.Constant4AlipayEdu;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.bean
 * @Description: 教育缴费账单状态同步接口
 * @date 2018/7/20 下午3:25
 */
public class AlipayEcoEduKtBillingModifyRequestBizContentBean extends AlipayBizContentBean{
    @BeanToJson(Constant4AlipayEdu.TRADE_NO)
    private String tradeNo;//特殊可选	64	支付宝返回的交易号
    @BeanToJson(Constant4AlipayEdu.OUT_TRADE_NO)
    private String outTradeNo;//特殊可选	64	isv系统的订单号
    @BeanToJson(Constant4AlipayEdu.STATUS)
    private String status;//必选	1	状态：1:缴费成功，2:关闭账单，3、退费 如果为退款状态，需要填写以下字段,字段都是支付宝退款返回的必填参数
    @BeanToJson(Constant4AlipayEdu.FUND_CHANGE)
    private String fundChange;//可选	1	本次退款是否发生了资金变化
    @BeanToJson(Constant4AlipayEdu.REFUND_AMOUNT)
    private Double refundAmount;//可选	9	需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数
    @BeanToJson(Constant4AlipayEdu.REFUND_REASON)
    private String refundReason;//可选	256	退款原因，商家根据客户实际退款原因填写
    @BeanToJson(Constant4AlipayEdu.OUT_REQUEST_NO)
    private String outRequestNo;//可选	65	标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
    @BeanToJson(Constant4AlipayEdu.BUYER_LOGON_ID)
    private String buyerLogonId;//可选	100	退款时，支付宝返回的用户的登录id
    @BeanToJson(Constant4AlipayEdu.GMT_REFUND)
    private String gmtRefund;//可选	64	支付宝返回的退款时间，而不是商户退款申请的时间
    @BeanToJson(Constant4AlipayEdu.BUYER_USER_ID)
    private String buyerUserId;//可选	28	支付宝返回的买家支付宝用户id
    @BeanToJson(Constant4AlipayEdu.REFUND_DETAIL_ITEM_LIST)
    private String refundDetailItemList;//可选	2000	支付宝返回的退款资金渠道，json格式字符串

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFundChange() {
        return fundChange;
    }

    public void setFundChange(String fundChange) {
        this.fundChange = fundChange;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
    }

    public String getBuyerLogonId() {
        return buyerLogonId;
    }

    public void setBuyerLogonId(String buyerLogonId) {
        this.buyerLogonId = buyerLogonId;
    }

    public String getGmtRefund() {
        return gmtRefund;
    }

    public void setGmtRefund(String gmtRefund) {
        this.gmtRefund = gmtRefund;
    }

    public String getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(String buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public String getRefundDetailItemList() {
        return refundDetailItemList;
    }

    public void setRefundDetailItemList(String refundDetailItemList) {
        this.refundDetailItemList = refundDetailItemList;
    }

    @Override
    public String toString() {
        return  ToStringBuilder.reflectionToString(this);
    }
}
