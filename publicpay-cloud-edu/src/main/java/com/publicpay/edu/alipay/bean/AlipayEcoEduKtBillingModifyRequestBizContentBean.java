package com.publicpay.edu.alipay.bean;

import com.publicpay.edu.alipay.annotation.BeanToJson;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static com.publicpay.edu.alipay.constant.Constant4AlipayEdu.*;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.bean
 * @Description: 教育缴费账单状态同步接口
 * @date 2018/7/20 下午3:25
 */
public class AlipayEcoEduKtBillingModifyRequestBizContentBean extends AlipayBizContentBean{
    @BeanToJson(TRADE_NO)
    private String tradeNo;
    @BeanToJson(OUT_TRADE_NO)
    private String outTradeNo;
    @BeanToJson(STATUS)
    private String status;
    @BeanToJson(FUND_CHANGE)
    private String fundChange;
    @BeanToJson(REFUND_AMOUNT)
    private String refundAmount;
    @BeanToJson(REFUND_REASON)
    private String refundReason;
    @BeanToJson(OUT_REQUEST_NO)
    private String outRequestNo;
    @BeanToJson(BUYER_LOGON_ID)
    private String buyerLogonId;
    @BeanToJson(GMT_REFUND)
    private String gmtRefund;
    @BeanToJson(BUYER_USER_ID)
    private String buyerUserId;
    @BeanToJson(REFUND_DETAIL_ITEM_LIST)
    private String refundDetailItemList;

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

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
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
