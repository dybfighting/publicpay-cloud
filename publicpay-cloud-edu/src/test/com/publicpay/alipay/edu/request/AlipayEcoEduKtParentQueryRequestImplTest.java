package com.publicpay.alipay.edu.request;

import com.publicpay.alipay.BaseTest;
import com.publicpay.alipay.bean.AlipayEcoEduKtParentQueryRequestBizContentBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.alipay.edu.request
 * @Description: 查询学生家长状态接口
 * @date 2018/8/2 下午3:01
 */
public class AlipayEcoEduKtParentQueryRequestImplTest extends BaseTest {
    @Autowired
    private AlipayAbstractRequest  alipayEcoEduKtParentQueryRequestImpl;
    @Test
    public void test() throws Exception {
        AlipayEcoEduKtParentQueryRequestBizContentBean bizContentBean = new AlipayEcoEduKtParentQueryRequestBizContentBean();

        bizContentBean.setSchoolPid("2088102176300662");
        bizContentBean.setSchoolNo("36010300000008");
        bizContentBean.setChildName("张三");
        bizContentBean.setPartnerId("2088121212121212");
        bizContentBean.setUserMobile("13300000000");
        bizContentBean.setAppAuthToken("201807BBc24a7f19028342289ac1f52cad022E66");
        alipayEcoEduKtParentQueryRequestImpl.service(bizContentBean);
    }
}
