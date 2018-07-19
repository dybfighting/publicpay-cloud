package com.publicpay.edu.alipay.bean;

import com.publicpay.edu.alipay.annotation.BeanToJson;
import static com.publicpay.edu.alipay.constant.Constant4AlipayEdu.*;
/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.bean
 * @Description: TODO
 * @date 2018/7/19 下午9:01
 */
public class AlipayEcoEduKtSchoolinfoModifyRequestBizContentBean {
    @BeanToJson(SCHOOL_NAME)
    private String schoolName;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
