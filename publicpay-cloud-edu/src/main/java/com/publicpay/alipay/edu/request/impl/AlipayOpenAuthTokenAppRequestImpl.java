package com.publicpay.alipay.edu.request.impl;

import com.alipay.api.request.AlipayOpenAuthTokenAppRequest;
import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.publicpay.alipay.bean.AlipayBizContentBean;
import com.publicpay.alipay.edu.request.AlipayAbstractRequest;
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
public class AlipayOpenAuthTokenAppRequestImpl extends AlipayAbstractRequest {
    private static final Logger logger = LoggerFactory.getLogger(AlipayOpenAuthTokenAppRequestImpl.class);

    @Override
    public AlipayOpenAuthTokenAppResponse service(AlipayBizContentBean bizContentBean) throws Exception {
        AlipayOpenAuthTokenAppRequest request = new AlipayOpenAuthTokenAppRequest();
        request.setBizContent(bizContentBean.getBitContent());
        AlipayOpenAuthTokenAppResponse response = execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        preHandleResponse(response);
        return response;
    }
}
