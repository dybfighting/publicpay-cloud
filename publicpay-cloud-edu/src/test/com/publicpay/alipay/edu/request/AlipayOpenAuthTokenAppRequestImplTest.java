package com.publicpay.alipay.edu.request;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.publicpay.alipay.BaseTest;
import com.publicpay.alipay.bean.AlipayOpenAuthTokenAppRequestBizContentBean;
import com.publicpay.alipay.constant.Constant4AlipayEdu;
import com.publicpay.alipay.edu.request.impl.AlipayOpenAuthTokenAppRequestImpl;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.service
 * @Description: 获取token
 * @date 2018/7/18 下午5:46
 */
public class AlipayOpenAuthTokenAppRequestImplTest extends BaseTest{
    @Autowired
    AlipayOpenAuthTokenAppRequestImpl alipayOpenAuthTokenAppRequestImpl;

    @Test
    public void testAlipayOpenAuthTokenAppRequestImpl() throws AlipayApiException {
        AlipayOpenAuthTokenAppRequestBizContentBean bizContentBean = new AlipayOpenAuthTokenAppRequestBizContentBean();
        bizContentBean.setGrantType(Constant4AlipayEdu.AUTHORIZATION_CODE);
        bizContentBean.setCode("b2284d679aac4f978465818892b38X66");
//        bizContentBean.setRefreshToken("");
        //        request.setBizContent("{" +
//                "\"grant_type\":\"authorization_code\"," +
//                "\"code\":\"7ae13d574dc640dc92cd15b6efe74X66\"," +
////                "\"refresh_token\":\"201509BBdcba1e3347de4e75ba3fed2c9abebE36\"" +
//                "  }");
        try {
            AlipayOpenAuthTokenAppResponse alipayOpenAuthTokenAppResponse = alipayOpenAuthTokenAppRequestImpl.service(bizContentBean);
//            alipayOpenAuthTokenAppResponse.getAuthAppId();
//            alipayOpenAuthTokenAppResponse.getAppAuthToken();
//            alipayOpenAuthTokenAppResponse.getAppRefreshToken();
            System.out.println(ToStringBuilder.reflectionToString(alipayOpenAuthTokenAppResponse));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
