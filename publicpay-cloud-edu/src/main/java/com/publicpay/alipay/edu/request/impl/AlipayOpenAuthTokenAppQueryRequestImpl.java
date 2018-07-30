package com.publicpay.alipay.edu.request.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayOpenAuthTokenAppQueryRequest;
import com.alipay.api.response.AlipayOpenAuthTokenAppQueryResponse;
import com.publicpay.alipay.bean.AlipayBizContentBean;
import com.publicpay.alipay.edu.request.AlipayAbstractRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

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
    public AlipayOpenAuthTokenAppQueryResponse service(AlipayBizContentBean bizContentBean) throws AlipayApiException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        AlipayOpenAuthTokenAppQueryRequest request = new AlipayOpenAuthTokenAppQueryRequest();
        request.setBizContent(bizContentBean.getBitContent());
        AlipayOpenAuthTokenAppQueryResponse response = execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }

        return response;
    }
}
