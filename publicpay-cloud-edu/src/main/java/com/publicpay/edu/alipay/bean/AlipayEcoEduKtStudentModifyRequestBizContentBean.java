package com.publicpay.edu.alipay.bean;

import com.publicpay.edu.alipay.annotation.BeanToJson;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

import static com.publicpay.edu.alipay.constant.Constant4AlipayEdu.*;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.bean
 * @Description: 学生信息修改
 * @date 2018/7/23 下午7:41
 */
public class AlipayEcoEduKtStudentModifyRequestBizContentBean extends AlipayBizContentBean {

    @BeanToJson(ISV_PID)
    private String isvPid;//必选	64	已经签约教育缴费的isv的支付宝PID
    @BeanToJson(SCHOOL_PID)
    private String schoolPid;//必选	64	学校用来签约支付宝教育缴费的支付宝PID
    @BeanToJson(SCHOOL_NO)
    private String schoolNo;//必选	64	学校编号，调用alipay.eco.edu.kt.schoolinfo.modify接口录入学校信息时，接口返回的编号
    @BeanToJson(STUDENT_NO)
    private String studentNo;//必选	64	支付宝-中小学-教育缴费生成的学生唯一编号
    @BeanToJson(CHILD_NAME)
    private String childName;//特殊可选	16	修改后的学生姓名 本接口调用时，child_name、student_code、student_identify、users这几个参数至少需要填写其中一个，不能同时为空
    @BeanToJson(STUDENT_CODE)
    private String studentCode;//特殊可选	32	修改后的学号 本接口调用时，child_name、student_code、student_identify、users这几个参数至少需要填写其中一个，不能同时为空
    @BeanToJson(STUDENT_IDENTIFY)
    private String studentIdentify;//特殊可选	32	修改后的身份证号码 本接口调用时，child_name、student_code、student_identify、users这几个参数至少需要填写其中一个，不能同时为空
    @BeanToJson(USERS)
    private List<AlipayEcoEduKtBillingSendRequestBizContentBean.User> users;//特殊可选		孩子的家长信息，最多一次输入20个家长。如果输入的家长信息不存在，则该改学生增加家长信息本接口调用时，child_name、student_code、student_identify、users这几个参数至少需要填写其中一个，不能同时为空
    @BeanToJson(STATUS)
    private String status;//可选	10	区分ISV操作，“D”表示删除，“U”表示更新，区分大小写。 如果为U，则学生名字，学号，身份证至少填写一项

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

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
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

    public List<AlipayEcoEduKtBillingSendRequestBizContentBean.User> getUsers() {
        return users;
    }

    public void setUsers(List<AlipayEcoEduKtBillingSendRequestBizContentBean.User> users) {
        this.users = users;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
