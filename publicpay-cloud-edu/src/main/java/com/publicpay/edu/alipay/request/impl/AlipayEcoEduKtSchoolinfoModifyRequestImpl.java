package com.publicpay.edu.alipay.request.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayEcoEduKtSchoolinfoModifyRequest;
import com.alipay.api.response.AlipayEcoEduKtSchoolinfoModifyResponse;
import com.publicpay.edu.alipay.bean.AlipayEcoEduKtSchoolinfoModifyRequestBizContentBean;
import com.publicpay.edu.alipay.request.AlipayAbstractRequest;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

import static com.publicpay.edu.alipay.constant.Constant4AlipayEdu.APP_AUTH_TOKEN;

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
    public AlipayEcoEduKtSchoolinfoModifyResponse service(Object obj) throws AlipayApiException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        AlipayEcoEduKtSchoolinfoModifyRequestBizContentBean bizContentBean = (AlipayEcoEduKtSchoolinfoModifyRequestBizContentBean) obj;
        AlipayEcoEduKtSchoolinfoModifyRequest request = new AlipayEcoEduKtSchoolinfoModifyRequest();
        request.setBizContent(bizContentBean.getBitContent());
        request.putOtherTextParam(APP_AUTH_TOKEN, bizContentBean.getAppAuthToken());
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
