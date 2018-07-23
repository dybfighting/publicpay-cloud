package com.publicpay.edu.alipay.request.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayEcoEduKtStudentModifyRequest;
import com.alipay.api.response.AlipayEcoEduKtStudentModifyResponse;
import com.publicpay.edu.alipay.request.AlipayAbstractRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
    public AlipayEcoEduKtStudentModifyResponse service(Object obj) throws AlipayApiException {
        AlipayEcoEduKtStudentModifyRequest request = new AlipayEcoEduKtStudentModifyRequest();
        request.setBizContent("{" +
                "\"isv_pid\":\"2088121212121212\"," +
                "\"school_pid\":\"2088101117955611\"," +
                "\"school_no\":\"11010100000001\"," +
                "\"student_no\":\"57de63cb1ef157595c005467\"," +
                "\"child_name\":\"张三\"," +
                "\"student_code\":\"6589154\"," +
                "\"student_identify\":\"610824197812044680\"," +
                "      \"users\":[{" +
                "        \"user_mobile\":\"18291992024\"," +
                "\"user_name\":\"家长姓名\"," +
                "\"user_relation\":\"1\"," +
                "\"user_change_mobile\":\"1300000000\"" +
                "        }]," +
                "\"status\":\"U\"" +
                "  }");
        request.putOtherTextParam("app_auth_token", "201611BB888ae9acd6e44fec9940d09201abfE16");
        AlipayEcoEduKtStudentModifyResponse response = execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return response;
    }
}
