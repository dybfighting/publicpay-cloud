package com.publicpay.alipay.bean;

import com.publicpay.alipay.annotation.BeanToJson;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

import static com.publicpay.alipay.constant.Constant4AlipayEdu.*;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.bean
 * @Description: 退款请求接口
 * @date 2018/7/24 下午2:30
 */
public class AlipayTradeRefundRequestBizContentBean extends AlipayBizContentBean{
    @BeanToJson(OUT_TRADE_NO)
    private String outTradeNo;//特殊可选	64	订单支付时传入的商户订单号,不能和 trade_no同时为空。
    @BeanToJson(TRADE_NO)
    private String tradeNo;//特殊可选	64	支付宝交易号，和商户订单号不能同时为空
    @BeanToJson(REFUND_AMOUNT)
    private Double refundAmount;//必选	9	需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数
    @BeanToJson(REFUND_CURRENCY)
    private String refundCurrency;//可选	8	订单退款币种信息
    @BeanToJson(REFUND_REASON)
    private String refundReason;//可选	256	退款的原因说明
    @BeanToJson(OUT_REQUEST_NO)
    private String outRequestNo;//可选	64	标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传。
    @BeanToJson(OPERATOR_ID)
    private String operatorId;//可选	30	商户的操作员编号
    @BeanToJson(STORE_ID)
    private String storeId;//可选	32	商户的门店编号
    @BeanToJson(TERMINAL_ID)
    private String terminalId;//可选	32	商户的终端编号
    @BeanToJson(GOODS_DETAIL)
    private List<GoodsDetail> goodsDetail;//可选		退款包含的商品列表信息，Json格式。其它说明详见：“商品明细说明”
    @BeanToJson(REFUND_ROYALTY_PARAMETERS)
    private List<RefundRoyaltyParameters> refundRoyaltyParameters;//可选		退分账明细信息

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundCurrency() {
        return refundCurrency;
    }

    public void setRefundCurrency(String refundCurrency) {
        this.refundCurrency = refundCurrency;
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

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public List<GoodsDetail> getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(List<GoodsDetail> goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public List<RefundRoyaltyParameters> getRefundRoyaltyParameters() {
        return refundRoyaltyParameters;
    }

    public void setRefundRoyaltyParameters(List<RefundRoyaltyParameters> refundRoyaltyParameters) {
        this.refundRoyaltyParameters = refundRoyaltyParameters;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * 可选		退款包含的商品列表信息，Json格式。
     其它说明详见：“商品明细说明”
     */
    public static class GoodsDetail{
        @BeanToJson(GOODS_ID)
        private String goodsId;//必填	32	商品的编号
        @BeanToJson(ALIPAY_GOODS_ID)
        private String alipayGoodsId;//可选	32	支付宝定义的统一商品编号
        @BeanToJson(GOODS_NAME)
        private String goodsName;//必填	256	商品名称
        @BeanToJson(QUANTITY)
        private Integer quantity;//必填	10	商品数量
        @BeanToJson(PRICE)
        private Double price;//必填	9	商品单价，单位为元
        @BeanToJson(GOODS_CATEGORY)
        private String goodsCategory;//可选	24	商品类目
        @BeanToJson(BODY)
        private String body;//可选	1000	商品描述信息
        @BeanToJson(SHOW_URL)
        private String showUrl;//可选	400	商品的展示地址

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public String getAlipayGoodsId() {
            return alipayGoodsId;
        }

        public void setAlipayGoodsId(String alipayGoodsId) {
            this.alipayGoodsId = alipayGoodsId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public String getGoodsCategory() {
            return goodsCategory;
        }

        public void setGoodsCategory(String goodsCategory) {
            this.goodsCategory = goodsCategory;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getShowUrl() {
            return showUrl;
        }

        public void setShowUrl(String showUrl) {
            this.showUrl = showUrl;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }

    /**
     *可选	退分账明细信息
     */
    public static class RefundRoyaltyParameters{
        @BeanToJson(ROYALTY_TYPE)
        private String royaltyType;//可选	32	分账类型.普通分账为：transfer;补差为：replenish;为空默认为分账transfer;
        @BeanToJson(TRANS_OUT)
        private String transOut;//可选	16	支出方账户。如果支出方账户类型为userId，本参数为支出方的支付宝账号对应的支付宝唯一用户号，以2088开头的纯16位数字；如果支出方类型为loginName，本参数为支出方的支付宝登录号；
        @BeanToJson(TRANS_OUT_TYPE)
        private String transOutType;//可选	64	支出方账户类型。userId表示是支付宝账号对应的支付宝唯一用户号;loginName表示是支付宝登录号；
        @BeanToJson(TRANS_IN_TYPE)
        private String transInType;//可选	64	收入方账户类型。userId表示是支付宝账号对应的支付宝唯一用户号;cardSerialNo表示是卡编号;loginName表示是支付宝登录号；
        @BeanToJson(TRANS_IN)
        private String transIn;//可选	16	收入方账户。如果收入方账户类型为userId，本参数为收入方的支付宝账号对应的支付宝唯一用户号，以2088开头的纯16位数字；如果收入方类型为cardSerialNo，本参数为收入方在支付宝绑定的卡编号；如果收入方类型为loginName，本参数为收入方的支付宝登录号；
        @BeanToJson(AMOUNT)
        private Double amount;//可选	9	分账的金额，单位为元
        @BeanToJson(AMOUNT_PERCENTAGE)
        private Integer amountPercentage;//可选	3	分账信息中分账百分比。取值范围为大于0，少于或等于100的整数。
        @BeanToJson(DESC)
        private String desc;//可选	1000	分账描述

        public String getRoyaltyType() {
            return royaltyType;
        }

        public void setRoyaltyType(String royaltyType) {
            this.royaltyType = royaltyType;
        }

        public String getTransOut() {
            return transOut;
        }

        public void setTransOut(String transOut) {
            this.transOut = transOut;
        }

        public String getTransOutType() {
            return transOutType;
        }

        public void setTransOutType(String transOutType) {
            this.transOutType = transOutType;
        }

        public String getTransInType() {
            return transInType;
        }

        public void setTransInType(String transInType) {
            this.transInType = transInType;
        }

        public String getTransIn() {
            return transIn;
        }

        public void setTransIn(String transIn) {
            this.transIn = transIn;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        public Integer getAmountPercentage() {
            return amountPercentage;
        }

        public void setAmountPercentage(Integer amountPercentage) {
            this.amountPercentage = amountPercentage;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }

}
