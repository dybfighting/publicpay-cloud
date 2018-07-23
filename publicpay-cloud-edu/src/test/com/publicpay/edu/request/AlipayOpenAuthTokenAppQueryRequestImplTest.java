package com.publicpay.edu.request;

import com.alipay.api.AlipayApiException;
import com.publicpay.edu.BaseTest;
import com.publicpay.edu.alipay.bean.AlipayBizContentBean;
import com.publicpay.edu.alipay.request.AlipayAbstractRequest;
import org.junit.Test;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;

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
        alipayBizContentBean.setAppAuthToken("201807BB174206f064a549a0b48496d880310X66");
        try {

            System.out.println(alipayOpenAuthTokenAppQueryRequestImpl.service(alipayBizContentBean).getBody());
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
