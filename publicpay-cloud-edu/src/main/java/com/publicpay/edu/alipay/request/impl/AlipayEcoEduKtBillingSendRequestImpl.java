package com.publicpay.edu.alipay.request.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayEcoEduKtBillingSendRequest;
import com.alipay.api.response.AlipayEcoEduKtBillingSendResponse;
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
 * @Description: 教育缴费账单发送接口
 * @date 2018/7/19 上午9:45
 */
@Service
public class AlipayEcoEduKtBillingSendRequestImpl extends AlipayAbstractRequest {

    private static final Logger logger = LoggerFactory.getLogger(AlipayEcoEduKtBillingSendRequestImpl.class);
    @Override
    public AlipayEcoEduKtBillingSendResponse service(AlipayBizContentBean bizContentBean) throws AlipayApiException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        AlipayEcoEduKtBillingSendRequest request = new AlipayEcoEduKtBillingSendRequest();
        request.setBizContent(bizContentBean.getBitContent());
        request.putOtherTextParam(APP_AUTH_TOKEN, bizContentBean.getAppAuthToken());
        AlipayEcoEduKtBillingSendResponse response = execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        preHandleResponse(response);
        return response;
    }
}
