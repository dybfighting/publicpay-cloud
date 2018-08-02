package com.publicpay.alipay.edu.request.impl;

import com.alipay.api.request.AlipayEcoEduKtParentQueryRequest;
import com.alipay.api.response.AlipayEcoEduKtParentQueryResponse;
import com.publicpay.alipay.bean.AlipayBizContentBean;
import com.publicpay.alipay.constant.Constant4AlipayEdu;
import com.publicpay.alipay.edu.request.AlipayAbstractRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.alipay.edu.request.impl
 * @Description: alipay.eco.edu.kt.parent.query(查询学生家长状态接口)
 * @date 2018/8/2 下午2:54
 */
@Service
@Deprecated
public class AlipayEcoEduKtParentQueryRequestImpl extends AlipayAbstractRequest {

    private static final Logger logger = LoggerFactory.getLogger(AlipayEcoEduKtParentQueryRequestImpl.class);

    @Override
    public AlipayEcoEduKtParentQueryResponse service(AlipayBizContentBean bizContentBean) throws Exception {
        AlipayEcoEduKtParentQueryRequest request = new AlipayEcoEduKtParentQueryRequest();
        request.setBizContent(bizContentBean.getBitContent());
        request.putOtherTextParam(Constant4AlipayEdu.APP_AUTH_TOKEN, bizContentBean.getAppAuthToken());
        AlipayEcoEduKtParentQueryResponse response = execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
            response.getSubCode();
            response.getSubMsg();
        }
        return response;
    }
}
