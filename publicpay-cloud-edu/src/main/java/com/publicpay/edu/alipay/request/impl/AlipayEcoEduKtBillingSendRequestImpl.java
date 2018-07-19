package com.publicpay.edu.alipay.request.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayEcoEduKtBillingSendRequest;
import com.alipay.api.response.AlipayEcoEduKtBillingSendResponse;
import com.publicpay.edu.alipay.request.AlipayRequestAbstractRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.service.impl
 * @Description: 教育缴费账单发送接口
 * @date 2018/7/19 上午9:45
 */
@Service
public class AlipayEcoEduKtBillingSendRequestImpl extends AlipayRequestAbstractRequest {

    private static final Logger logger = LoggerFactory.getLogger(AlipayEcoEduKtBillingSendRequestImpl.class);
    @Override
    public void service() throws AlipayApiException {
        AlipayEcoEduKtBillingSendRequest request = new AlipayEcoEduKtBillingSendRequest();
        request.setBizContent("{" +
                "      \"users\":[{" +
                "        \"user_mobile\":\"18xxxxxxxxx\"," +
                "\"user_name\":\"张三\"," +
                "\"user_relation\":\"1\"," +
                "\"user_change_mobile\":\"13xxxxxxxxx\"" +
                "        }]," +
                "\"school_pid\":\"20880012939123234423\"," +
                "\"school_no\":\"11010100000002\"," +
                "\"child_name\":\"张晓晓\"," +
                "\"grade\":\"高一\"," +
                "\"class_in\":\"3班\"," +
                "\"student_code\":\"2098453900091\"," +
                "\"student_identify\":\"310193199905289483\"," +
                "\"out_trade_no\":\"20160232343253253453\"," +
                "\"charge_bill_title\":\"学生开学收费项\"," +
                "\"charge_type\":\"M\"," +
                "      \"charge_item\":[{" +
                "        \"item_name\":\"校服费\"," +
                "\"item_price\":8.88," +
                "\"item_serial_number\":1," +
                "\"item_maximum\":5," +
                "\"item_mandatory\":\"N\"" +
                "        }]," +
                "\"amount\":88.88," +
                "\"gmt_end\":\"2016-01-01 13:13:13\"," +
                "\"end_enable\":\"Y\"," +
                "\"partner_id\":\"201600129391238873\"" +
                "  }");
        request.putOtherTextParam("app_auth_token", "201611BB888ae9acd6e44fec9940d09201abfE16");

        AlipayEcoEduKtBillingSendResponse response = execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }
}
