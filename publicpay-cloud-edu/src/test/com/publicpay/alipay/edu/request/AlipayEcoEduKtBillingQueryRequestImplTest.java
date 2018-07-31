package com.publicpay.alipay.edu.request;

import com.publicpay.alipay.BaseTest;
import com.publicpay.alipay.bean.AlipayEcoEduKtBillingQueryRequestBizContentBean;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.request
 * @Description: TODO
 * @date 2018/7/23 下午6:03
 */
public class AlipayEcoEduKtBillingQueryRequestImplTest extends BaseTest {
    @Resource
    private AlipayAbstractRequest alipayEcoEduKtBillingQueryRequestImpl;

    @Test
    public void test(){
        AlipayEcoEduKtBillingQueryRequestBizContentBean bizContentBean = new AlipayEcoEduKtBillingQueryRequestBizContentBean();
        bizContentBean.setIsvPid("2088121212121212");
        bizContentBean.setSchoolPid("2088101117955611");
        bizContentBean.setOutTradeNo("58de07de7bb90a437553e464");
        bizContentBean.setAppAuthToken("201807BBc24a7f19028342289ac1f52cad022E66");

//        "{" +
//                "\"isv_pid\":\"2088121212121212\"," +
//                "\"school_pid\":\"2088101117955611\"," +
//                "\"out_trade_no\":\"58de07de7bb90a437553e464\"" +
//                "  }"
        try {
            alipayEcoEduKtBillingQueryRequestImpl.service(bizContentBean);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
