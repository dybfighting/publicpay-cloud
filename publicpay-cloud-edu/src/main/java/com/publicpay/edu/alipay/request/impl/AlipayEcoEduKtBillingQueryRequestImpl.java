package com.publicpay.edu.alipay.request.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayEcoEduKtBillingQueryRequest;
import com.alipay.api.response.AlipayEcoEduKtBillingQueryResponse;
import com.publicpay.edu.alipay.request.AlipayAbstractRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.service.impl
 * @Description: 缴费账单查询
 * @date 2018/7/19 上午10:00
 */
@Service
public class AlipayEcoEduKtBillingQueryRequestImpl extends AlipayAbstractRequest {

    private static final Logger logger = LoggerFactory.getLogger(AlipayEcoEduKtBillingQueryRequestImpl.class);

    @Override
    public AlipayEcoEduKtBillingQueryResponse service(Object obj) throws AlipayApiException {
        AlipayEcoEduKtBillingQueryRequest request = new AlipayEcoEduKtBillingQueryRequest();
        request.setBizContent("{" +
                "\"isv_pid\":\"2088121212121212\"," +
                "\"school_pid\":\"2088101117955611\"," +
                "\"out_trade_no\":\"58de07de7bb90a437553e464\"" +
                "  }");
        request.putOtherTextParam("app_auth_token", "201611BB888ae9acd6e44fec9940d09201abfE16");

        AlipayEcoEduKtBillingQueryResponse response = execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return response;
    }
}
