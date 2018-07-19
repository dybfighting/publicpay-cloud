package com.publicpay.edu.alipay.request.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayEcoEduKtBillingModifyRequest;
import com.alipay.api.response.AlipayEcoEduKtBillingModifyResponse;
import com.publicpay.edu.alipay.request.AlipayRequestAbstractRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.service.impl
 * @Description: 教育缴费账单状态同步接口
 * @date 2018/7/19 上午9:50
 */
@Service
public class AlipayEcoEduKtBillingModifyRequestImpl extends AlipayRequestAbstractRequest {

    private static final Logger logger = LoggerFactory.getLogger(AlipayEcoEduKtBillingModifyRequestImpl.class);

    @Override
    public void service() throws AlipayApiException {
        AlipayEcoEduKtBillingModifyRequest request = new AlipayEcoEduKtBillingModifyRequest();
        request.setBizContent("{" +
                        "\"trade_no\":\"2014112611001004680073956707\"," +
                        "\"out_trade_no\":\"20160101909909354354354\"," +
                        "\"status\":\"1\"," +
                        "\"fund_change\":\"Y\"," +
                        "\"refund_amount\":200.12," +
                        "\"refund_reason\":\"正常退款\"," +
                        "\"out_request_no\":\"HZ01RF001\"," +
                        "\"buyer_logon_id\":\"159****5620\"," +
                        "\"gmt_refund\":\"2015-11-27 15:45:57\"," +
                        "\"buyer_user_id\":\"2088101117955611\"," +
                        "\"refund_detail_item_list\":\"{\\r\" +
                "\\t\\\"fund_channel\\\":\\\"ALIPAYACCOUNT\\\",\\r\" +
                "\\t\\\"amount\\\":12.00,\\r\" +
                "\\t\\\"real_amount\\\":12.00\\r\" +
                "\\t\\r\" +
                "}\"" +
                        "  }");
        request.putOtherTextParam("app_auth_token", "201611BB888ae9acd6e44fec9940d09201abfE16");

        AlipayEcoEduKtBillingModifyResponse response = execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }
}
