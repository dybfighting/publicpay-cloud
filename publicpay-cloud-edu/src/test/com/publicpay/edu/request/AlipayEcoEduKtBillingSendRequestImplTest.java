package com.publicpay.edu.request;

import com.publicpay.edu.BaseTest;
import com.publicpay.edu.alipay.bean.AlipayEcoEduKtBillingSendRequestBizContentBean;
import com.publicpay.edu.alipay.request.AlipayAbstractRequest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.request
 * @Description: 发送账单
 * @date 2018/7/23 下午3:49
 */
public class AlipayEcoEduKtBillingSendRequestImplTest extends BaseTest {

    @Resource
    private AlipayAbstractRequest alipayEcoEduKtBillingSendRequestImpl;

    @Test
    public void test(){
        AlipayEcoEduKtBillingSendRequestBizContentBean bizContentBean = new AlipayEcoEduKtBillingSendRequestBizContentBean();
        List<AlipayEcoEduKtBillingSendRequestBizContentBean.User> users = new ArrayList<>();
        AlipayEcoEduKtBillingSendRequestBizContentBean.User user = new AlipayEcoEduKtBillingSendRequestBizContentBean.User();
        user.setUserName("张三");
        user.setUserMobile("18742212348");
        user.setUserRelation("1");
//        user.setUserChangeMobile("13xxxxxxxxx");
        users.add(user);
        bizContentBean.setUsers(users);
        bizContentBean.setSchool_pid("2088102176300662");
        bizContentBean.setSchoolNo("36010300000008");
        bizContentBean.setChildName("张晓晓");
        bizContentBean.setGrade("高一");
        bizContentBean.setClassIn("3班");
        bizContentBean.setStudentCode("2098453900091");
        bizContentBean.setStudentIdentify("310193199905289483");
        bizContentBean.setOutTradeNo("20160232343253253453");
        bizContentBean.setChargeBillTitle("学生开学收费项");
        bizContentBean.setChargeType("M");
        List<AlipayEcoEduKtBillingSendRequestBizContentBean.ChargeItem> chargeItems = new ArrayList<>();
        AlipayEcoEduKtBillingSendRequestBizContentBean.ChargeItem chargeItem = new AlipayEcoEduKtBillingSendRequestBizContentBean.ChargeItem();
        chargeItem.setItemName("校服费");
        chargeItem.setItemPrice(8.88);
        chargeItem.setItemSerialNumber(1);
        chargeItem.setItemMaximum(5);
        chargeItem.setItemMandatory("N");
        chargeItems.add(chargeItem);
        bizContentBean.setChargeItem(chargeItems);
        bizContentBean.setAmount(88.88);
        bizContentBean.setGmtEnd("2016-01-01 13:13:13");
        bizContentBean.setEndEnable("Y");
        bizContentBean.setPartnerId("201600129391238873");

        bizContentBean.setAppAuthToken("201807BB174206f064a549a0b48496d880310X66");

        try {
            alipayEcoEduKtBillingSendRequestImpl.service(bizContentBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //        "{" +
//                "      \"users\":[{" +
//                "        \"user_mobile\":\"18xxxxxxxxx\"," +
//                "\"user_name\":\"张三\"," +
//                "\"user_relation\":\"1\"," +
//                "\"user_change_mobile\":\"13xxxxxxxxx\"" +
//                "        }]," +
//                "\"school_pid\":\"20880012939123234423\"," +
//                "\"school_no\":\"11010100000002\"," +
//                "\"child_name\":\"张晓晓\"," +
//                "\"grade\":\"高一\"," +
//                "\"class_in\":\"3班\"," +
//                "\"student_code\":\"2098453900091\"," +
//                "\"student_identify\":\"310193199905289483\"," +
//                "\"out_trade_no\":\"20160232343253253453\"," +
//                "\"charge_bill_title\":\"学生开学收费项\"," +
//                "\"charge_type\":\"M\"," +
//                "\"charge_item\":[{" +
//                "\"item_name\":\"校服费\"," +
//                "\"item_price\":8.88," +
//                "\"item_serial_number\":1," +
//                "\"item_maximum\":5," +
//                "\"item_mandatory\":\"N\"" +
//                "        }]," +
//                "\"amount\":88.88," +
//                "\"gmt_end\":\"2016-01-01 13:13:13\"," +
//                "\"end_enable\":\"Y\"," +
//                "\"partner_id\":\"201600129391238873\"" +
//                "  }"
    }
}
