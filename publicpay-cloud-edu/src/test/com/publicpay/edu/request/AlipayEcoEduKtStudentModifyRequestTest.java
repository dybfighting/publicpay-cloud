package com.publicpay.edu.request;

import com.alipay.api.AlipayApiException;
import com.publicpay.edu.BaseTest;
import com.publicpay.edu.alipay.bean.AlipayEcoEduKtBillingSendRequestBizContentBean;
import com.publicpay.edu.alipay.bean.AlipayEcoEduKtStudentModifyRequestBizContentBean;
import com.publicpay.edu.alipay.request.AlipayAbstractRequest;
import org.junit.Test;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.request
 * @Description: TODO
 * @date 2018/7/23 下午7:40
 */
public class AlipayEcoEduKtStudentModifyRequestTest extends BaseTest {

    @Resource
    private AlipayAbstractRequest alipayEcoEduKtStudentModifyRequest;

    @Test
    public void test() throws InvocationTargetException, AlipayApiException, IllegalAccessException, NoSuchMethodException {
        AlipayEcoEduKtStudentModifyRequestBizContentBean bizContentBean = new AlipayEcoEduKtStudentModifyRequestBizContentBean();
        bizContentBean.setIsvPid("2088121212121212");
        bizContentBean.setSchoolPid("2088101117955611");
        bizContentBean.setSchoolNo("11010100000001");
        bizContentBean.setStudentNo("57de63cb1ef157595c005467");
        bizContentBean.setChildName("张三");
        bizContentBean.setStudentCode("6589154");
        bizContentBean.setStudentIdentify("610824197812044680");
        List<AlipayEcoEduKtBillingSendRequestBizContentBean.User> users = new ArrayList<>();
        AlipayEcoEduKtBillingSendRequestBizContentBean.User user = new AlipayEcoEduKtBillingSendRequestBizContentBean.User();
        user.setUserName("张三");
        user.setUserMobile("18xxxxxxxxx");
        user.setUserRelation("1");
        user.setUserChangeMobile("13xxxxxxxxx");
        users.add(user);
        bizContentBean.setUsers(users);
        bizContentBean.setStatus("U");
        alipayEcoEduKtStudentModifyRequest.service(bizContentBean);
        //        request.setBizContent("{" +
//                "\"isv_pid\":\"2088121212121212\"," +
//                "\"school_pid\":\"2088101117955611\"," +
//                "\"school_no\":\"11010100000001\"," +
//                "\"student_no\":\"57de63cb1ef157595c005467\"," +
//                "\"child_name\":\"张三\"," +
//                "\"student_code\":\"6589154\"," +
//                "\"student_identify\":\"610824197812044680\"," +
//                "      \"users\":[{" +
//                "        \"user_mobile\":\"18291992024\"," +
//                "\"user_name\":\"家长姓名\"," +
//                "\"user_relation\":\"1\"," +
//                "\"user_change_mobile\":\"1300000000\"" +
//                "        }]," +
//                "\"status\":\"U\"" +
//                "  }");
    }
}