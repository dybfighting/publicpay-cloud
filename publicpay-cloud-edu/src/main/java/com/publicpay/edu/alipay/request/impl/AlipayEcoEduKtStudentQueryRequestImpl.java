package com.publicpay.edu.alipay.request.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayEcoEduKtStudentQueryRequest;
import com.alipay.api.response.AlipayEcoEduKtStudentQueryResponse;
import com.publicpay.edu.alipay.request.AlipayAbstractRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.request.impl
 * @Description: 学生信息查询
 * @date 2018/7/19 上午10:23
 */
@Service
public class AlipayEcoEduKtStudentQueryRequestImpl extends AlipayAbstractRequest {

    private static final Logger logger = LoggerFactory.getLogger(AlipayEcoEduKtStudentQueryRequestImpl.class);
    @Override
    public AlipayEcoEduKtStudentQueryResponse service(Object obj) throws AlipayApiException {
        AlipayEcoEduKtStudentQueryRequest request = new AlipayEcoEduKtStudentQueryRequest();
        request.setBizContent("{" +
                "\"isv_pid\":\"2088121212121212\"," +
                "\"school_pid\":\"2088101117955611\"," +
                "\"school_no\":\"11010100000001\"," +
                "\"student_no\":\"57de63cb1ef157595c005467\"" +
                "  }");
        request.putOtherTextParam("app_auth_token", "201611BB888ae9acd6e44fec9940d09201abfE16");
        AlipayEcoEduKtStudentQueryResponse response = execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return response;
    }
}
