package com.publicpay.alipay.edu.request.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayEcoEduKtBillingQueryRequest;
import com.alipay.api.response.AlipayEcoEduKtBillingQueryResponse;
import com.publicpay.alipay.bean.AlipayBizContentBean;
import com.publicpay.alipay.constant.Constant4AlipayEdu;
import com.publicpay.alipay.edu.request.AlipayAbstractRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

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
        request.putOtherTextParam(Constant4AlipayEdu.APP_AUTH_TOKEN, bizContentBean.getAppAuthToken());
        AlipayEcoEduKtBillingQueryResponse response = execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return response;
    }
}
