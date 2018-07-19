package com.publicpay.edu.alipay.bean;

import com.publicpay.edu.alipay.annotation.BeanToJson;
import org.apache.commons.lang3.builder.ToStringBuilder;

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
    private String schoolName;//必选	256	学校名称
    @BeanToJson(SCHOOL_ICON)
    private String schoolIcon;//可选	256	学校的校徽或logo，在学校展示页面作为学校的标识。该字段为图片的链接地址，只支持png或jpg图片格式，图片高度为108，宽度为108 ，不大于20k。注意：此链接要求公网可以访问，否则无法正常展示。
    @BeanToJson(SCHOOL_ICON_TYPE)
    private String schoolIconType;//特殊可选	10	如果填写了school_icon参数，则此字段不能为空。目前只支持png和jpg两种格式
    @BeanToJson(SCHOOL_STDCODE)
    private String schoolStdcode;//可选	16	学校(机构)标识码（由教育部按照国家标准及编码规则编制，可以在教育局官网查询）
    @BeanToJson(SCHOOL_TYPE)
    private String schoolType;//必选	6	学校的类型：1：代表托儿所； 2：代表幼儿园；3：代表小学；4：代表初中；5：代表高中。如果学校兼有多种属性，可以连写，比如：45：代表兼有初中部高中部；34：代表兼有小学部初中部
    @BeanToJson(PROVINCE_CODE)
    private String provinceCode;//必选	8	省份的国家编码（国家统计局出版的行政区划代码 http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/）
    @BeanToJson(PROVINCE_NAME)
    private String provinceName;//必选	32	省名称
    @BeanToJson(CITY_CODE)
    private String cityCode;//必选	16	城市的国家编码（国家统计局出版的行政区划代码 http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/）
    @BeanToJson(CITY_NAME)
    private String cityName;//必选	64	城市名称
    @BeanToJson(DISTRICT_CODE)
    private String districtCode;//必选	16	区县的国家编码（国家统计局出版的行政区划代码 http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/）
    @BeanToJson(DISTRICT_NAME)
    private String districtName;//必选	64	区县名称
    @BeanToJson(ISV_NO)
    private String isvNo;//可选	128	注意：本参数从1.3版本开始已经废弃，不再需要传递。由支付宝提供的给已经签约的isv的编码，业务上一般直接采用isv的支付宝PID。
    @BeanToJson(ISV_NAME)
    private String isvName;//必选	256	商家名称，每个接入教育缴费的ISV商家名称，由ISV自己提供
    @BeanToJson(ISV_NOTIFY_URL)
    private String isvNotifyUrl;//必选	256	此通知地址是为了保持教育缴费平台与ISV商户支付状态一致性。用户支付成功后，支付宝会根据本isv_notify_url，通过POST请求的形式将支付结果作为参数通知到商户系统，ISV商户可以根据返回的参数更新账单状态。
    @BeanToJson(ISV_PID)
    private String isvPid;//必选	128	填写已经签约教育缴费的isv的支付宝PID
    @BeanToJson(ISV_PHONE)
    private String isvPhone;//必选	20	ISV联系电话,用于账单详情页面显示
    @BeanToJson(SCHOOL_PID)
    private String schoolPid;//必选	128	学校用来签约支付宝教育缴费的支付宝PID
    @BeanToJson(BANKCARD_NO)
    private String bankcardNo;//可选	32	对应集团到卡模式的银行编号.学校与支付宝后台签约时，由学校提交给支付宝的编号
    @BeanToJson(BANK_UID)
    private String bankUid;//可选	32	与浙江网商交易见证平台有交互的ISV在创建账户获得的member_id，由网商分配
    @BeanToJson(BANK_NOTIFY_URL)
    private String bankNotifyUrl;//可选	256	与浙江网商交易见证平台有交互ISV输入网商交易异步通知回调URL，教育缴费同步账单信息给网商，网商会回调此url，ISV即可获取网商相关的参数，根据教育缴费平台账单发送接口返回的 order_no和网商返回的outer_trade_no来对应账单信息。
    @BeanToJson(BANK_PARTNER_ID)
    private String bankPartnerId;//可选	32	与浙江网商交易见证平台有交互的ISV,由交易见证平台分配给合作方业务平台 签约唯一ID ，由网商分配给ISV的渠道参数
    @BeanToJson(WHITE_CHANNEL_CODE)
    private String whiteChannelCode;//可选	32	与浙江网商交易见证平台有交互的ISV,由网商分配给ISV的渠道参数

    public String getSchoolIcon() {
        return schoolIcon;
    }

    public void setSchoolIcon(String schoolIcon) {
        this.schoolIcon = schoolIcon;
    }

    public String getSchoolIconType() {
        return schoolIconType;
    }

    public void setSchoolIconType(String schoolIconType) {
        this.schoolIconType = schoolIconType;
    }

    public String getSchoolStdcode() {
        return schoolStdcode;
    }

    public void setSchoolStdcode(String schoolStdcode) {
        this.schoolStdcode = schoolStdcode;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getIsvNo() {
        return isvNo;
    }

    public void setIsvNo(String isvNo) {
        this.isvNo = isvNo;
    }

    public String getIsvName() {
        return isvName;
    }

    public void setIsvName(String isvName) {
        this.isvName = isvName;
    }

    public String getIsvNotifyUrl() {
        return isvNotifyUrl;
    }

    public void setIsvNotifyUrl(String isvNotifyUrl) {
        this.isvNotifyUrl = isvNotifyUrl;
    }

    public String getIsvPid() {
        return isvPid;
    }

    public void setIsvPid(String isvPid) {
        this.isvPid = isvPid;
    }

    public String getIsvPhone() {
        return isvPhone;
    }

    public void setIsvPhone(String isvPhone) {
        this.isvPhone = isvPhone;
    }

    public String getSchoolPid() {
        return schoolPid;
    }

    public void setSchoolPid(String schoolPid) {
        this.schoolPid = schoolPid;
    }

    public String getBankcardNo() {
        return bankcardNo;
    }

    public void setBankcardNo(String bankcardNo) {
        this.bankcardNo = bankcardNo;
    }

    public String getBankUid() {
        return bankUid;
    }

    public void setBankUid(String bankUid) {
        this.bankUid = bankUid;
    }

    public String getBankNotifyUrl() {
        return bankNotifyUrl;
    }

    public void setBankNotifyUrl(String bankNotifyUrl) {
        this.bankNotifyUrl = bankNotifyUrl;
    }

    public String getBankPartnerId() {
        return bankPartnerId;
    }

    public void setBankPartnerId(String bankPartnerId) {
        this.bankPartnerId = bankPartnerId;
    }

    public String getWhiteChannelCode() {
        return whiteChannelCode;
    }

    public void setWhiteChannelCode(String whiteChannelCode) {
        this.whiteChannelCode = whiteChannelCode;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return  ToStringBuilder.reflectionToString(this);
    }
}
