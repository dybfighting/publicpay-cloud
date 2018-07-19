package com.publicpay.edu.alipay.request.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayOpenAuthTokenAppRequest;
import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.publicpay.edu.alipay.request.AlipayRequestAbstractRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.service
 * @Description: 通过app_auth_code 换取app_auth_token
 * @date 2018/7/18 下午2:07
 */
@Service
public class AlipayOpenAuthTokenAppRequestImpl extends AlipayRequestAbstractRequest {
    private static final Logger logger = LoggerFactory.getLogger(AlipayOpenAuthTokenAppRequestImpl.class);

    @Override
    public void service() throws AlipayApiException {
        AlipayOpenAuthTokenAppRequest request = new AlipayOpenAuthTokenAppRequest();
        request.setBizContent("{" +
                "\"grant_type\":\"authorization_code\"," +
                "\"code\":\"7ae13d574dc640dc92cd15b6efe74X66\"," +
//                "\"refresh_token\":\"201509BBdcba1e3347de4e75ba3fed2c9abebE36\"" +
                "  }");
        AlipayOpenAuthTokenAppResponse response = execute(request);
        String userId = response.getUserId();//商户pid
        String appAuthToken = response.getAppAuthToken();
        String authAppId = response.getAuthAppId();
        String code = response.getCode();
        String subCode = response.getSubCode();
        String msg = response.getMsg();
        String body = response.getBody();
        logger.info("code:{},subCode:{},msg:{},body:{},userId:{},appAuthToken:{},authAppId:{}",code,subCode,msg,body,userId,appAuthToken,authAppId);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }

    }
}
