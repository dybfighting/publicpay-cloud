package com.publicpay.edu.alipay.request.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayOpenAuthTokenAppRequest;
import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.publicpay.edu.alipay.bean.AlipayBizContentBean;
import com.publicpay.edu.alipay.request.AlipayAbstractRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

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
    public AlipayOpenAuthTokenAppResponse service(AlipayBizContentBean bizContentBean) throws AlipayApiException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        AlipayOpenAuthTokenAppRequest request = new AlipayOpenAuthTokenAppRequest();
        request.setBizContent(bizContentBean.getBitContent());
        AlipayOpenAuthTokenAppResponse response = execute(request);
//        String userId = response.getUserId();//商户pid
//        String appAuthToken = response.getAppAuthToken();
//        String authAppId = response.getAuthAppId();
//        String code = response.getCode();
//        String subCode = response.getSubCode();
//        String msg = response.getMsg();
//        String body = response.getBody();
//        logger.info("code:{},subCode:{},msg:{},body:{},userId:{},appAuthToken:{},authAppId:{}",code,subCode,msg,body,userId,appAuthToken,authAppId);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return response;
    }
}
