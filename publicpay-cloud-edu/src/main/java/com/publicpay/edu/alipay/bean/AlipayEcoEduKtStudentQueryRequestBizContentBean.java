package com.publicpay.edu.alipay.bean;

import com.publicpay.edu.alipay.annotation.BeanToJson;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static com.publicpay.edu.alipay.constant.Constant4AlipayEdu.*;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.bean
 * @Description: 学生信息查询
 * @date 2018/7/23 下午6:50
 */
public class AlipayEcoEduKtStudentQueryRequestBizContentBean extends AlipayBizContentBean {
    @BeanToJson(ISV_PID)
    private String isvPid;//必选	64	已经签约教育缴费的isv的支付宝PID
    @BeanToJson(SCHOOL_PID)
    private String schoolPid;//必选	64	学校用来签约支付宝教育缴费的支付宝PID
    @BeanToJson(SCHOOL_NO)
    private String schoolNo;//必选	64	学校编号，调用alipay.eco.edu.kt.schoolinfo.modify接口录入学校信息时，接口返回的编号
    @BeanToJson(STUDENT_NO)
    private String studentNo;//必选	64	通过alipay.eco.edu.kt.billing.send发送教育缴费账单时，支付宝返回这个student_no,如果支付宝系统中还没有这个学生，则会根据学生的属性，创建一个全局唯一的学生缴费账号并返回。

    public String getIsvPid() {
        return isvPid;
    }

    public void setIsvPid(String isvPid) {
        this.isvPid = isvPid;
    }

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

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
