package com.publicpay.alipay.edu.request.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayEcoEduKtStudentModifyRequest;
import com.alipay.api.response.AlipayEcoEduKtStudentModifyResponse;
import com.publicpay.alipay.bean.AlipayBizContentBean;
import com.publicpay.alipay.edu.request.AlipayAbstractRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

import static com.publicpay.alipay.constant.Constant4AlipayEdu.APP_AUTH_TOKEN;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.request.impl
 * @Description: 学生信息更新
 * @date 2018/7/19 上午10:15
 */
@Service
public class AlipayEcoEduKtStudentModifyRequestImpl extends AlipayAbstractRequest {

    private static final Logger logger = LoggerFactory.getLogger(AlipayEcoEduKtStudentModifyRequestImpl.class);
    @Override
    public AlipayEcoEduKtStudentModifyResponse service(AlipayBizContentBean bizContentBean) throws AlipayApiException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        AlipayEcoEduKtStudentModifyRequest request = new AlipayEcoEduKtStudentModifyRequest();
        request.setBizContent(bizContentBean.getBitContent());
        request.putOtherTextParam(APP_AUTH_TOKEN, bizContentBean.getAppAuthToken());
        AlipayEcoEduKtStudentModifyResponse response = execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        preHandleResponse(response);
        return response;
    }
}
