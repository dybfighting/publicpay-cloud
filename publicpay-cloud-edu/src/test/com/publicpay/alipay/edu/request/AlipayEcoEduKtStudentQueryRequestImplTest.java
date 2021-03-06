package com.publicpay.alipay.edu.request;

import com.publicpay.alipay.BaseTest;
import com.publicpay.alipay.bean.AlipayEcoEduKtStudentQueryRequestBizContentBean;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.request
 * @Description: TODO
 * @date 2018/7/23 下午7:07
 */
public class AlipayEcoEduKtStudentQueryRequestImplTest extends BaseTest{
    @Resource
    private AlipayAbstractRequest alipayEcoEduKtStudentQueryRequestImpl;

    @Test
    public void test() throws Exception {
        AlipayEcoEduKtStudentQueryRequestBizContentBean bizContentBean = new AlipayEcoEduKtStudentQueryRequestBizContentBean();

        bizContentBean.setIsvPid("2088121212121212");
        bizContentBean.setSchoolNo("36010300000008");
        bizContentBean.setSchoolPid("20880012939123234423");
        bizContentBean.setStudentNo("1212");
        bizContentBean.setAppAuthToken("201807BBc24a7f19028342289ac1f52cad022E66");
        alipayEcoEduKtStudentQueryRequestImpl.service(bizContentBean);
//   "{" +
//                "\"isv_pid\":\"2088121212121212\"," +
//                "\"school_pid\":\"2088101117955611\"," +
//                "\"school_no\":\"11010100000001\"," +
//                "\"student_no\":\"57de63cb1ef157595c005467\"" +
//                "  }");
    }
}
