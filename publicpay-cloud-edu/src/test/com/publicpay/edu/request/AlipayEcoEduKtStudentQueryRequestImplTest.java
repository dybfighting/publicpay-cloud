package com.publicpay.edu.request;

import com.alipay.api.AlipayApiException;
import com.publicpay.edu.BaseTest;
import com.publicpay.edu.alipay.bean.AlipayEcoEduKtStudentQueryRequestBizContentBean;
import com.publicpay.edu.alipay.request.AlipayAbstractRequest;
import org.junit.Test;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;

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
    public void test() throws InvocationTargetException, AlipayApiException, IllegalAccessException, NoSuchMethodException {
        AlipayEcoEduKtStudentQueryRequestBizContentBean bizContentBean = new AlipayEcoEduKtStudentQueryRequestBizContentBean();

        bizContentBean.setIsvPid("2088121212121212");
        bizContentBean.setSchoolNo("36010300000008");
        bizContentBean.setSchoolPid("20880012939123234423");
        bizContentBean.setStudentNo("1212");
        bizContentBean.setAppAuthToken("201807BB174206f064a549a0b48496d880310X66");
        alipayEcoEduKtStudentQueryRequestImpl.service(bizContentBean);
//   "{" +
//                "\"isv_pid\":\"2088121212121212\"," +
//                "\"school_pid\":\"2088101117955611\"," +
//                "\"school_no\":\"11010100000001\"," +
//                "\"student_no\":\"57de63cb1ef157595c005467\"" +
//                "  }");
    }
}
