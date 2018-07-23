package com.publicpay.edu.alipay.request.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayOpenAuthTokenAppQueryRequest;
import com.alipay.api.response.AlipayOpenAuthTokenAppQueryResponse;
import com.publicpay.edu.alipay.request.AlipayAbstractRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.request.impl
 * @Description: alipay.open.auth.token.app.query(查询某个应用授权AppAuthToken的授权信息)
 * @date 2018/7/19 上午11:00
 */
@Service
public class AlipayOpenAuthTokenAppQueryRequestImpl extends AlipayAbstractRequest {

    private static final Logger logger = LoggerFactory.getLogger(AlipayOpenAuthTokenAppQueryRequestImpl.class);
    @Override
    public AlipayOpenAuthTokenAppQueryResponse service(Object obj) throws AlipayApiException {
        AlipayOpenAuthTokenAppQueryRequest request = new AlipayOpenAuthTokenAppQueryRequest();
        request.setBizContent("{" +
                "\"app_auth_token\":\"201509BBeff9351ad1874306903e96b91d248A36\"" +
                "  }");
        AlipayOpenAuthTokenAppQueryResponse response = execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return response;
    }
}
