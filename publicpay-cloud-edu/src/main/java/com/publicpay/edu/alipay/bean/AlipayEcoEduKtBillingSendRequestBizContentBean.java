package com.publicpay.edu.alipay.bean;

import com.publicpay.edu.alipay.annotation.BeanToJson;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

import static com.publicpay.edu.alipay.constant.Constant4AlipayEdu.*;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.bean
 * @Description: 教育缴费账单发送接口请求bean
 * @date 2018/7/19 下午10:41
 */
public class AlipayEcoEduKtBillingSendRequestBizContentBean {

    @BeanToJson(USERS)
    private List<User> users;
    @BeanToJson(SCHOOL_PID)
    private String school_pid;
    @BeanToJson(SCHOOL_NO)
    private String schoolNo;
    @BeanToJson(CHILD_NAME)
    private String childName;
    @BeanToJson(GRADE)
    private String grade;
    @BeanToJson(CLASS_IN)
    private String classIn;
    @BeanToJson(STUDENT_CODE)
    private String studentCode;
    @BeanToJson(STUDENT_IDENTIFY)
    private String studentIdentify;
    @BeanToJson(OUT_TRADE_NO)
    private String outTradeNo;
    @BeanToJson(CHARGE_BILL_TITLE)
    private String chargeBillTitle;
    @BeanToJson(CHARGE_TYPE)
    private String chargeType;
    @BeanToJson(CHARGE_ITEM)
    private List<ChargeItem> chargeItem;
    @BeanToJson(AMOUNT)
    private String amount;
    @BeanToJson(GMT_END)
    private String gmtEnd;
    @BeanToJson(END_ENABLE)
    private String endEnable;
    @BeanToJson(PARTNER_ID)
    private String partnerId;

    public String getSchoolNo() {
        return schoolNo;
    }

    public void setSchoolNo(String schoolNo) {
        this.schoolNo = schoolNo;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClassIn() {
        return classIn;
    }

    public void setClassIn(String classIn) {
        this.classIn = classIn;
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

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getChargeBillTitle() {
        return chargeBillTitle;
    }

    public void setChargeBillTitle(String chargeBillTitle) {
        this.chargeBillTitle = chargeBillTitle;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public List<ChargeItem> getChargeItem() {
        return chargeItem;
    }

    public void setChargeItem(List<ChargeItem> chargeItem) {
        this.chargeItem = chargeItem;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getGmtEnd() {
        return gmtEnd;
    }

    public void setGmtEnd(String gmtEnd) {
        this.gmtEnd = gmtEnd;
    }

    public String getEndEnable() {
        return endEnable;
    }

    public void setEndEnable(String endEnable) {
        this.endEnable = endEnable;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getSchool_pid() {
        return school_pid;
    }

    public void setSchool_pid(String school_pid) {
        this.school_pid = school_pid;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    public static class ChargeItem{
        @BeanToJson(ITEM_NAME)
        private String itemName;
        @BeanToJson(ITEM_PRICE)
        private String itemPrice;
        @BeanToJson(ITEM_SERIAL_NUMBER)
        private String itemSerialNumber;
        @BeanToJson(ITEM_MAXIMUM)
        private String itemMaximum;
        @BeanToJson(ITEM_MANDATORY)
        private String itemMandatory;

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getItemPrice() {
            return itemPrice;
        }

        public void setItemPrice(String itemPrice) {
            this.itemPrice = itemPrice;
        }

        public String getItemSerialNumber() {
            return itemSerialNumber;
        }

        public void setItemSerialNumber(String itemSerialNumber) {
            this.itemSerialNumber = itemSerialNumber;
        }

        public String getItemMaximum() {
            return itemMaximum;
        }

        public void setItemMaximum(String itemMaximum) {
            this.itemMaximum = itemMaximum;
        }

        public String getItemMandatory() {
            return itemMandatory;
        }

        public void setItemMandatory(String itemMandatory) {
            this.itemMandatory = itemMandatory;
        }



        @Override
        public String toString() {
            return  ToStringBuilder.reflectionToString(this);
        }


    }
    public static class User{
        @BeanToJson(USER_MOBILE)
        private String userMobile;
        @BeanToJson(USER_NAME)
        private String userName;
        @BeanToJson(USER_RELATION)
        private String userRelation;
        @BeanToJson(USER_CHANGE_MOBILE)
        private String userChangeMobile;

        public String getUserMobile() {
            return userMobile;
        }

        public void setUserMobile(String userMobile) {
            this.userMobile = userMobile;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserRelation() {
            return userRelation;
        }

        public void setUserRelation(String userRelation) {
            this.userRelation = userRelation;
        }

        public String getUserChangeMobile() {
            return userChangeMobile;
        }

        public void setUserChangeMobile(String userChangeMobile) {
            this.userChangeMobile = userChangeMobile;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userMobile='" + userMobile + '\'' +
                    ", userName='" + userName + '\'' +
                    ", userRelation='" + userRelation + '\'' +
                    ", userChangeMobile='" + userChangeMobile + '\'' +
                    '}';
        }
    }
}
