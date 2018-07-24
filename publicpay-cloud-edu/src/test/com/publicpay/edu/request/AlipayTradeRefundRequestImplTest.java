package com.publicpay.edu.request;

import com.publicpay.edu.BaseTest;
import com.publicpay.edu.alipay.bean.AlipayTradeRefundRequestBizContentBean;
import com.publicpay.edu.alipay.request.AlipayAbstractRequest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.request
 * @Description: TODO
 * @date 2018/7/24 下午3:38
 */
public class AlipayTradeRefundRequestImplTest extends BaseTest {
    @Resource
    private AlipayAbstractRequest alipayTradeRefundRequestImpl;

    @Test
    public void test() throws Exception {
        AlipayTradeRefundRequestBizContentBean bizContentBean = new AlipayTradeRefundRequestBizContentBean();
        bizContentBean.setOutTradeNo("20150320010101001");
        bizContentBean.setTradeNo("2014112611001004680073956707");
        bizContentBean.setRefundAmount(200.12);
        bizContentBean.setRefundCurrency("USD");
        bizContentBean.setRefundReason("正常退款");
        bizContentBean.setOutRequestNo("HZ01RF001");
        bizContentBean.setOperatorId("OP001");
        bizContentBean.setStoreId("NJ_S_001");
        bizContentBean.setTerminalId("NJ_T_001");
        List<AlipayTradeRefundRequestBizContentBean.GoodsDetail> goodsDetailList = new ArrayList<>();
        AlipayTradeRefundRequestBizContentBean.GoodsDetail goodsDetail = new AlipayTradeRefundRequestBizContentBean.GoodsDetail();
        goodsDetail.setGoodsId("apple-01");
        goodsDetail.setAlipayGoodsId("20010001");
        goodsDetail.setGoodsName("ipad");
        goodsDetail.setQuantity(1);
        goodsDetail.setBody("特价手机");
        goodsDetail.setShowUrl("http://www.alipay.com/xxx.jpg");
        bizContentBean.setGoodsDetail(goodsDetailList);
        List<AlipayTradeRefundRequestBizContentBean.RefundRoyaltyParameters> refundRoyaltyParametersList = new ArrayList<>();
        AlipayTradeRefundRequestBizContentBean.RefundRoyaltyParameters royaltyParameters = new AlipayTradeRefundRequestBizContentBean.RefundRoyaltyParameters();
        royaltyParameters.setRoyaltyType("transfer");
        royaltyParameters.setTransOut("2088101126765726");
        royaltyParameters.setTransOutType("userId");
        royaltyParameters.setTransInType("userId");
        royaltyParameters.setTransIn("2088101126708402");
        royaltyParameters.setAmount(0.1);
        royaltyParameters.setAmountPercentage(100);
        royaltyParameters.setDesc("分账给2088101126708402");
        bizContentBean.setRefundRoyaltyParameters(refundRoyaltyParametersList);
        //        request.setBizContent("{" +
//                "\"out_trade_no\":\"20150320010101001\"," +
//                "\"trade_no\":\"2014112611001004680073956707\"," +
//                "\"refund_amount\":200.12," +
//                "\"refund_currency\":\"USD\"," +
//                "\"refund_reason\":\"正常退款\"," +
//                "\"out_request_no\":\"HZ01RF001\"," +
//                "\"operator_id\":\"OP001\"," +
//                "\"store_id\":\"NJ_S_001\"," +
//                "\"terminal_id\":\"NJ_T_001\"," +
//                "      \"goods_detail\":[{" +
//                "        \"goods_id\":\"apple-01\"," +
//                "\"alipay_goods_id\":\"20010001\"," +
//                "\"goods_name\":\"ipad\"," +
//                "\"quantity\":1," +
//                "\"price\":2000," +
//                "\"goods_category\":\"34543238\"," +
//                "\"body\":\"特价手机\"," +
//                "\"show_url\":\"http://www.alipay.com/xxx.jpg\"" +
//                "        }]," +
//                "      \"refund_royalty_parameters\":[{" +
//                "        \"royalty_type\":\"transfer\"," +
//                "\"trans_out\":\"2088101126765726\"," +
//                "\"trans_out_type\":\"userId\"," +
//                "\"trans_in_type\":\"userId\"," +
//                "\"trans_in\":\"2088101126708402\"," +
//                "\"amount\":0.1," +
//                "\"amount_percentage\":100," +
//                "\"desc\":\"分账给2088101126708402\"" +
//                "        }]" +
//                "  }");
        alipayTradeRefundRequestImpl.service(bizContentBean);
    }
}
