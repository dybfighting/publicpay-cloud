package com.publicpay.alipay.bean;

import com.publicpay.alipay.annotation.BeanToJson;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static com.publicpay.alipay.constant.Constant4AlipayEdu.*;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.alipay.bean
 * @Description: 查询学生家长状态接口业务参数bean
 * @date 2018/8/2 下午3:07
 */
public class AlipayEcoEduKtParentQueryRequestBizContentBean extends AlipayBizContentBean {
    @BeanToJson(SCHOOL_PID)
    private String schoolPid;//学校支付宝pid
    @BeanToJson(SCHOOL_NO)
    private String schoolNo;//学校编码，录入学校接口返回的school_no参数
    @BeanToJson(PARTNER_ID)
    private String partnerId;//Isv的支付宝pid
    @BeanToJson(CHILD_NAME)
    private String childName;//孩子或学生姓名
    @BeanToJson(USER_MOBILE)
    private String userMobile;//用户手机号，发账单时填写users数组中的一个手机号。结果返回用户是否通过此手机号添加此学生的缴费账户。user_mobile、student_code 、student_identify 必须并且只能填一项。
    @BeanToJson(STUDENT_CODE)
    private String studentCode;//学生的学号，一个学校的学号必须是唯一。结果返回用户是否通过此学号添加此学生的缴费账户。user_mobile、student_code 、student_identify 必须并且只能填一项。
    @BeanToJson(STUDENT_IDENTIFY)
    private String studentIdentify;//学生的身份证号，使用身份证规则验证。结果返回用户是否通过此身份证号添加此学生的缴费账户。user_mobile、student_code 、student_identify 必须并且只能填一项。

    public String getSchoolPid() {
        return schoolPid;
    }

    public void setSchoolPid(String schoolPid) {
        this.schoolPid = schoolPid;
    }

    public String getSchoolNo() {
        return schoolNo;
    }

    public void setSchoolNo(String schoolNo) {
        this.schoolNo = schoolNo;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentIdentify() {
        return studentIdentify;
    }

    public void setStudentIdentify(String studentIdentify) {
        this.studentIdentify = studentIdentify;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
