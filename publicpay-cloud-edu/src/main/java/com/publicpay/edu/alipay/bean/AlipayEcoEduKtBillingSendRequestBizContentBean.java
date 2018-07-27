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
public class AlipayEcoEduKtBillingSendRequestBizContentBean extends AlipayBizContentBean{

    @BeanToJson(USERS)
    private List<User> users;//孩子的家长信息，最多一次输入10个家长，此字段做为识别家长的孩子用，与student_identify、student_code至少选一个
    @BeanToJson(SCHOOL_PID)
    private String school_pid;//学校支付宝pid
    @BeanToJson(SCHOOL_NO)
    private String schoolNo;//学校编码，录入学校接口返回的参数
    @BeanToJson(CHILD_NAME)
    private String childName;//孩子名字
    @BeanToJson(GRADE)
    private String grade;//孩子所在年级
    @BeanToJson(CLASS_IN)
    private String classIn;//孩子所在班级
    @BeanToJson(STUDENT_CODE)
    private String studentCode;//特殊可选	20	学生的学号，只支持字母和数字类型，一般以教育局学号为准，作为学生的唯一标识。此字段与student_identify、家长user_mobile至少选一个
    @BeanToJson(STUDENT_IDENTIFY)
    private String studentIdentify;//	特殊可选	18	学生的身份证号，如果ISV有学生身份证号，则同步身份证号作为学生唯一标识。此字段与student_code、家长user_mobile至少选一个。大陆身份证必须是18位 ， 其它地区或国家的身份证开头需要加"IC"开头区分并且不超过18位，但查询账单的时候不要带"IC"

    @BeanToJson(STATUS)
    private String status;//用于删除孩子，状态为“D”，表示删除孩子，状态“U”表示孩子信息添加或更新。为空则不更新孩子信息

    @BeanToJson(OUT_TRADE_NO)
    private String outTradeNo;//必选	128	ISV端的缴费账单编号
    @BeanToJson(CHARGE_BILL_TITLE)
    private String chargeBillTitle;//必选	512	缴费账单名称
    @BeanToJson(CHARGE_TYPE)
    private String chargeType;//可选	1	缴费项模式：空或"N"，表示缴费项不可选，"M"表示缴费项为可选 ，支持单选和多选。
    @BeanToJson(CHARGE_ITEM)
    private List<ChargeItem> chargeItem;//可选		缴费详情：输入json格式字符串。Json定义：key填写缴费项名称，value填写缴费项金额，金额保留2位小数
    @BeanToJson(AMOUNT)
    private Double amount;//可选	11	总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]，如果是非多选项，是要和缴费项的总和相同，多选模式不做验证
    @BeanToJson(GMT_END)
    private String gmtEnd;//必选	19	缴费截止时间，格式"yyyy-MM-dd HH:mm:ss"，日期要大于当前时间。请注意，过期时间不宜设置过短。
    @BeanToJson(END_ENABLE)
    private String endEnable;//必选	1	截止日期是否生效，与gmt_end发布配合使用,N为gmt_end不生效，用户过期后仍可以缴费；Y为gmt_end生效，用户过期后，不能再缴费。
    @BeanToJson(PARTNER_ID)
    private String partnerId;//必选	128	Isv支付宝pid, 支付宝签约后，返回给ISV编号

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ChargeItem{
        @BeanToJson(ITEM_NAME)
        private String itemName;//必填	32	缴费项名称
        @BeanToJson(ITEM_PRICE)
        private Double itemPrice;//必填	11	缴费项金额
        @BeanToJson(ITEM_SERIAL_NUMBER)
        private Integer itemSerialNumber;//可选	10	缴费项序号，如果缴费项是多选模式，此项为必填，建议从1开始的连续数字，用户支付成功后，通过passback_params参数带回已选择的缴费项。例如:orderNo=uoo234234&isvOrderNo=24werwe&items=1-2|2-1|3-51-2|2-1|3-5 表示：缴费项序列号-缴费项数|缴费项序列号-缴费项数
        @BeanToJson(ITEM_MAXIMUM)
        private Integer itemMaximum;//可选	1	缴费项最大可选数 如果缴费项是多选模式，此参数生效，范围是1-9，如果为空，则最大项默认为9
        @BeanToJson(ITEM_MANDATORY)
        private String itemMandatory;//可选	1	缴费项是否必选 如果缴费项是多选模式，此参数生效。 “Y”表示必填，“N”或空表示非必填。

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public Double getItemPrice() {
            return itemPrice;
        }

        public void setItemPrice(Double itemPrice) {
            this.itemPrice = itemPrice;
        }

        public Integer getItemSerialNumber() {
            return itemSerialNumber;
        }

        public void setItemSerialNumber(Integer itemSerialNumber) {
            this.itemSerialNumber = itemSerialNumber;
        }

        public Integer getItemMaximum() {
            return itemMaximum;
        }

        public void setItemMaximum(Integer itemMaximum) {
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
        private String userMobile;//孩子家长的手机号，可根据此手机号推送账单消息给家长，如果有此家长，则家长手机号必填
        @BeanToJson(USER_NAME)
        private String userName;//家长姓名
        @BeanToJson(USER_RELATION)
        private String userRelation;//孩子与家长的关系： 1、爸爸 2、妈妈 3、爷爷 4、奶奶 5、外公 6、外婆 7、家长
        @BeanToJson(USER_CHANGE_MOBILE)
        private String userChangeMobile;//用户变更手机号，替换旧的手机号，只有修改手机号时，此项才需要填

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
            return ToStringBuilder.reflectionToString(this);
        }
    }
}
