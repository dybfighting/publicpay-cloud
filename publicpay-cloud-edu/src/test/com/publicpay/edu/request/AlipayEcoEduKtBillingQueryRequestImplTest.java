package com.publicpay.edu.request;

import com.alipay.api.AlipayApiException;
import com.publicpay.edu.BaseTest;
import com.publicpay.edu.alipay.bean.AlipayEcoEduKtBillingQueryRequestBizContentBean;
import com.publicpay.edu.alipay.request.AlipayAbstractRequest;
import org.junit.Test;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;

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
        bizContentBean.setAppAuthToken("201807BB174206f064a549a0b48496d880310X66");

//        "{" +
//                "\"isv_pid\":\"2088121212121212\"," +
//                "\"school_pid\":\"2088101117955611\"," +
//                "\"out_trade_no\":\"58de07de7bb90a437553e464\"" +
//                "  }"
        try {
            alipayEcoEduKtBillingQueryRequestImpl.service(bizContentBean);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
