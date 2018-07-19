package com.publicpay.edu.request;

import com.alipay.api.AlipayApiException;
import com.publicpay.edu.BaseTest;
import com.publicpay.edu.alipay.request.impl.AlipayOpenAuthTokenAppRequestImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.service
 * @Description: TODO
 * @date 2018/7/18 下午5:46
 */
public class AlipayOpenAuthTokenAppRequestImplTest extends BaseTest{
    @Autowired
    AlipayOpenAuthTokenAppRequestImpl alipayOpenAuthTokenAppRequestImpl;

    @Test
    public void testAlipayOpenAuthTokenAppRequestImpl() throws AlipayApiException {
        alipayOpenAuthTokenAppRequestImpl.service();
    }
}
