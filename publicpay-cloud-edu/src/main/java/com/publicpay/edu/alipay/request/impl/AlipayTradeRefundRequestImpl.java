package com.publicpay.edu.alipay.request.impl;

import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.publicpay.edu.alipay.bean.AlipayBizContentBean;
import com.publicpay.edu.alipay.request.AlipayAbstractRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.request.impl
 * @Description: 支付宝退款接口
 * @date 2018/7/24 下午2:26
 */
@Service
public class AlipayTradeRefundRequestImpl extends AlipayAbstractRequest {

    private static final Logger logger = LoggerFactory.getLogger(AlipayTradeRefundRequestImpl.class);
    @Override
    public AlipayTradeRefundResponse service(AlipayBizContentBean bizContentBean) throws Exception {
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent(bizContentBean.getBitContent());
        AlipayTradeRefundResponse response = execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        preHandleResponse(response);
        return response;
    }
}
