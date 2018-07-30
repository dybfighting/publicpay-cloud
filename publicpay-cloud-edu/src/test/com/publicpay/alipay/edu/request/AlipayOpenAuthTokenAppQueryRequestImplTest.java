package com.publicpay.alipay.edu.request;

import com.publicpay.alipay.BaseTest;
import com.publicpay.alipay.bean.AlipayBizContentBean;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.request
 * @Description: 查询token权限
 * @date 2018/7/23 下午7:16
 */
public class AlipayOpenAuthTokenAppQueryRequestImplTest extends BaseTest {

    @Resource
    private AlipayAbstractRequest alipayOpenAuthTokenAppQueryRequestImpl;
    @Test
    public void test(){
        AlipayBizContentBean alipayBizContentBean = new AlipayBizContentBean();
        alipayBizContentBean.setAppAuthToken("201807BBb4df09a0be204dd7b21003df9e009X66");
        try {

            System.out.println(alipayOpenAuthTokenAppQueryRequestImpl.service(alipayBizContentBean).getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
