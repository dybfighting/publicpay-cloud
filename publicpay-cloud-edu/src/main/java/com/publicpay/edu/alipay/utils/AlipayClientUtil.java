package com.publicpay.edu.alipay.utils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayOpenAuthTokenAppRequest;
import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.utils
 * @Description: TODO
 * @date 2018/7/18 上午10:38
 */
public class AlipayClientUtil {

    private static AlipayClient alipayClient = null;

    public static AlipayClient newInstance(){
        if (alipayClient == null){
            alipayClient = new DefaultAlipayClient(
                    "https://openapi.alipay.com/gateway.do",
                    "app_id",
                    "your private_key",
                    "json","GBK",
                    "alipay_public_key",
                    "RSA2");
        }
        return alipayClient;
    }

    public static String a() throws AlipayApiException {
        AlipayOpenAuthTokenAppRequest request = new AlipayOpenAuthTokenAppRequest();
        request.setBizContent("{" +
                "\"grant_type\":\"authorization_code或者refresh_token\"," +
                "\"code\":\"1cc19911172e4f8aaa509c8fb5d12F56\"," +
                "\"refresh_token\":\"201509BBdcba1e3347de4e75ba3fed2c9abebE36\"" +
                "  }");
        AlipayOpenAuthTokenAppResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }

        return "";
    }
}
