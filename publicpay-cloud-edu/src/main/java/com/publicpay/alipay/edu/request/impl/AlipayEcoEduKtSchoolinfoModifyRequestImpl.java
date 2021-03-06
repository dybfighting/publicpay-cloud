package com.publicpay.alipay.edu.request.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayEcoEduKtSchoolinfoModifyRequest;
import com.alipay.api.response.AlipayEcoEduKtSchoolinfoModifyResponse;
import com.publicpay.alipay.constant.Constant4AlipayEdu;
import com.publicpay.alipay.bean.AlipayBizContentBean;
import com.publicpay.alipay.edu.request.AlipayAbstractRequest;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.service.impl
 * @Description: 教育缴费学校信息录入接口
 * @date 2018/7/19 上午9:34
 */
@Service
public class AlipayEcoEduKtSchoolinfoModifyRequestImpl extends AlipayAbstractRequest {

    private static final Logger logger = LoggerFactory.getLogger(AlipayEcoEduKtSchoolinfoModifyRequestImpl.class);

    @Override
    public AlipayEcoEduKtSchoolinfoModifyResponse service(AlipayBizContentBean bizContentBean) throws AlipayApiException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        AlipayEcoEduKtSchoolinfoModifyRequest request = new AlipayEcoEduKtSchoolinfoModifyRequest();
        request.setBizContent(bizContentBean.getBitContent());
        request.putOtherTextParam(Constant4AlipayEdu.APP_AUTH_TOKEN, bizContentBean.getAppAuthToken());
        AlipayEcoEduKtSchoolinfoModifyResponse response = execute(request);
        logger.info("响应：{}", ToStringBuilder.reflectionToString(response));
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return response;
    }


}
