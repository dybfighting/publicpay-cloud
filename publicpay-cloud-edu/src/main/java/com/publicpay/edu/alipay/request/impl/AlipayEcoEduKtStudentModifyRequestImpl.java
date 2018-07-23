package com.publicpay.edu.alipay.request.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayEcoEduKtStudentModifyRequest;
import com.alipay.api.response.AlipayEcoEduKtStudentModifyResponse;
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
//        request.setBizContent("{" +
//                "\"isv_pid\":\"2088121212121212\"," +
//                "\"school_pid\":\"2088101117955611\"," +
//                "\"school_no\":\"11010100000001\"," +
//                "\"student_no\":\"57de63cb1ef157595c005467\"," +
//                "\"child_name\":\"张三\"," +
//                "\"student_code\":\"6589154\"," +
//                "\"student_identify\":\"610824197812044680\"," +
//                "      \"users\":[{" +
//                "        \"user_mobile\":\"18291992024\"," +
//                "\"user_name\":\"家长姓名\"," +
//                "\"user_relation\":\"1\"," +
//                "\"user_change_mobile\":\"1300000000\"" +
//                "        }]," +
//                "\"status\":\"U\"" +
//                "  }");
        request.putOtherTextParam(APP_AUTH_TOKEN, bizContentBean.getAppAuthToken());
        AlipayEcoEduKtStudentModifyResponse response = execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return response;
    }
}
