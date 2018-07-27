package com.publicpay.edu.request;

import com.alipay.api.AlipayApiException;
import com.publicpay.edu.BaseTest;
import com.publicpay.edu.alipay.bean.AlipayEcoEduKtSchoolinfoModifyRequestBizContentBean;
import com.publicpay.edu.alipay.enums.AlipaySchoolTypeEnum;
import com.publicpay.edu.alipay.request.AlipayAbstractRequest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.request
 * @Description: 录入学校
 * @date 2018/7/19 下午3:12
 */
public class AlipayEcoEduKtSchoolinfoModifyRequestImplTest extends BaseTest{
    @Resource
    private AlipayAbstractRequest alipayEcoEduKtSchoolinfoModifyRequestImpl;
    @Test
    public void test() throws AlipayApiException {
        AlipayEcoEduKtSchoolinfoModifyRequestBizContentBean bizContentBean = new AlipayEcoEduKtSchoolinfoModifyRequestBizContentBean();
        bizContentBean.setSchoolName("杭州市西湖第一实验学校");
        bizContentBean.setSchoolStdcode("3133005132");
        bizContentBean.setSchoolType(AlipaySchoolTypeEnum.MIDDLE_SCHOOL.getValue());
        bizContentBean.setProvinceCode("330000");
        bizContentBean.setProvinceName("杭州市");
        bizContentBean.setCityCode("330100");
        bizContentBean.setCityName("杭州市");
        bizContentBean.setDistrictCode("330106");
        bizContentBean.setDistrictName("西湖区");
//        bizContentBean.setIsvNo("201600129391238873");
        bizContentBean.setIsvName("杭州少年宫");
        bizContentBean.setIsvNotifyUrl("http://127.0.0.1:8192/payNotify");
        bizContentBean.setIsvPid("2088121212121212");
        bizContentBean.setIsvPhone("13300000000");
        bizContentBean.setSchoolPid("2088102176300662");
        bizContentBean.setAppAuthToken("201807BBb4df09a0be204dd7b21003df9e009X66");
//        "{" +
//                "\"school_name\":\"杭州市西湖第一实验学校\"," +
////                "\"school_icon\":\"http://ecopublic-dev.oss-cn-hangzhou.aliyuncs.com/eco/edu_alipay/school/school.png\"," +
////                "\"school_icon_type\":\"png\"," +
//                "\"school_stdcode\":\"3133005132\"," +
//                "\"school_type\":\"4\"," +
//                "\"province_code\":\"330000\"," +
//                "\"province_name\":\"浙江省\"," +
//                "\"city_code\":\"330100\"," +
//                "\"city_name\":\"杭州市\"," +
//                "\"district_code\":\"330106\"," +
//                "\"district_name\":\"西湖区\"," +
//                "\"isv_no\":\"201600129391238873\"," +
//                "\"isv_name\":\"杭州少年宫\"," +
//                "\"isv_notify_url\":\"https://isv.com/xxx\"," +
//                "\"isv_pid\":\"2088121212121212\"," +
//                "\"isv_phone\":\"13300000000\"," +
//                "\"school_pid\":\"20880012939123234423\"" +
////                "\"bankcard_no\":\"P0004\"," +
////                "\"bank_uid\":\"20000293230232\"," +
////                "\"bank_notify_url\":\"https://www.xxx.xxx/xx\"," +
////                "\"bank_partner_id\":\"200002924334\"," +
////                "\"white_channel_code\":\"TESTBANK10301\"" +
//                "  }")
        try {
            alipayEcoEduKtSchoolinfoModifyRequestImpl.service(bizContentBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
