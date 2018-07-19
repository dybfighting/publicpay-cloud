package com.publicpay.edu.request;

import com.alipay.api.AlipayApiException;
import com.publicpay.edu.BaseTest;
import com.publicpay.edu.alipay.request.AlipayRequestAbstractRequest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.request
 * @Description: TODO
 * @date 2018/7/19 下午3:12
 */
public class AlipayEcoEduKtSchoolinfoModifyRequestImplTest extends BaseTest{
    @Resource
    private AlipayRequestAbstractRequest alipayEcoEduKtSchoolinfoModifyRequestImpl;
    @Test
    public void test() throws AlipayApiException {
    alipayEcoEduKtSchoolinfoModifyRequestImpl.service();
    }
}
