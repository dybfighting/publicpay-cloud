package com.publicpay.edu.alipay.request.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayEcoEduKtSchoolinfoModifyRequest;
import com.alipay.api.response.AlipayEcoEduKtSchoolinfoModifyResponse;
import com.publicpay.edu.alipay.request.AlipayRequestAbstractRequest;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.publicpay.edu.alipay.constant.Constant4AlipayEdu.SCHOOL_NAME;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.service.impl
 * @Description: 教育缴费学校信息录入接口
 * @date 2018/7/19 上午9:34
 */
@Service
public class AlipayEcoEduKtSchoolinfoModifyRequestImpl extends AlipayRequestAbstractRequest {

    private static final Logger logger = LoggerFactory.getLogger(AlipayEcoEduKtSchoolinfoModifyRequestImpl.class);

    @Override
    public void service() throws AlipayApiException {
        AlipayEcoEduKtSchoolinfoModifyRequest request = new AlipayEcoEduKtSchoolinfoModifyRequest();
        request.setBizContent("{" +
                "\"school_name\":\"杭州市西湖第一实验学校\"," +
//                "\"school_icon\":\"http://ecopublic-dev.oss-cn-hangzhou.aliyuncs.com/eco/edu_alipay/school/school.png\"," +
//                "\"school_icon_type\":\"png\"," +
                "\"school_stdcode\":\"3133005132\"," +
                "\"school_type\":\"4\"," +
                "\"province_code\":\"330000\"," +
                "\"province_name\":\"浙江省\"," +
                "\"city_code\":\"330100\"," +
                "\"city_name\":\"杭州市\"," +
                "\"district_code\":\"330106\"," +
                "\"district_name\":\"西湖区\"," +
                "\"isv_no\":\"201600129391238873\"," +
                "\"isv_name\":\"杭州少年宫\"," +
                "\"isv_notify_url\":\"https://isv.com/xxx\"," +
                "\"isv_pid\":\"2088121212121212\"," +
                "\"isv_phone\":\"13300000000\"," +
                "\"school_pid\":\"20880012939123234423\"" +
//                "\"bankcard_no\":\"P0004\"," +
//                "\"bank_uid\":\"20000293230232\"," +
//                "\"bank_notify_url\":\"https://www.xxx.xxx/xx\"," +
//                "\"bank_partner_id\":\"200002924334\"," +
//                "\"white_channel_code\":\"TESTBANK10301\"" +
                "  }");
        JSONObject bizContent = new JSONObject();
        bizContent.put(SCHOOL_NAME,"杭州市西湖第一实验学校");
        request.putOtherTextParam("app_auth_token", "201807BB174206f064a549a0b48496d880310X66");
        AlipayEcoEduKtSchoolinfoModifyResponse response = execute(request);
        logger.info("响应：{}", ToStringBuilder.reflectionToString(response));
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }
}
