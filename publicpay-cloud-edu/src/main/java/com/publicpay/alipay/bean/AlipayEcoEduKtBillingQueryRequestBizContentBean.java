package com.publicpay.alipay.bean;

import com.publicpay.alipay.annotation.BeanToJson;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static com.publicpay.alipay.constant.Constant4AlipayEdu.*;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.bean
 * @Description: 缴费账单查询
 * @date 2018/7/23 下午5:54
 */
public class AlipayEcoEduKtBillingQueryRequestBizContentBean extends AlipayBizContentBean {
    @BeanToJson(ISV_PID)
    private String isvPid;//必选	64	Isv pid
    @BeanToJson(SCHOOL_PID)
    private String schoolPid;//必选	64	学校支付宝pid
    @BeanToJson(OUT_TRADE_NO)
    private String outTradeNo;//64	ISV调用发送账单接口，返回给商户的order_no

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

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
