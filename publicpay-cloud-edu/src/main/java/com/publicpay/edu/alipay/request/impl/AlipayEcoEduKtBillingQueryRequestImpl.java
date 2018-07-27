package com.publicpay.edu.alipay.request.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayEcoEduKtBillingQueryRequest;
import com.alipay.api.response.AlipayEcoEduKtBillingQueryResponse;
import com.publicpay.edu.alipay.bean.AlipayBizContentBean;
import com.publicpay.edu.alipay.request.AlipayAbstractRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

import static com.publicpay.edu.alipay.constant.Constant4AlipayEdu.APP_AUTH_TOKEN;

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
    public AlipayEcoEduKtBillingQueryResponse service(AlipayBizContentBean bizContentBean) throws AlipayApiException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        AlipayEcoEduKtBillingQueryRequest request = new AlipayEcoEduKtBillingQueryRequest();
        request.setBizContent(bizContentBean.getBitContent());
        request.putOtherTextParam(APP_AUTH_TOKEN, bizContentBean.getAppAuthToken());
        AlipayEcoEduKtBillingQueryResponse response = execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        preHandleResponse(response);
        return response;
    }
}
