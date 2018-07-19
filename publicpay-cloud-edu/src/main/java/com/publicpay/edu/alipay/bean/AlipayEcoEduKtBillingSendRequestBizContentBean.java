package com.publicpay.edu.alipay.bean;

import com.publicpay.edu.alipay.annotation.BeanToJson;

import java.util.List;

import static com.publicpay.edu.alipay.constant.Constant4AlipayEdu.*;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.bean
 * @Description: TODO
 * @date 2018/7/19 下午10:41
 */
public class AlipayEcoEduKtBillingSendRequestBizContentBean {

    @BeanToJson(SCHOOL_PID)
    private String school_pid;
    @BeanToJson(USERS)
    private List<User> users;

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
