package com.publicpay.edu.alipay.bean;

import com.publicpay.edu.alipay.annotation.BeanToJson;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static com.publicpay.edu.alipay.constant.Constant4AlipayEdu.CODE;
import static com.publicpay.edu.alipay.constant.Constant4AlipayEdu.GRANT_TYPE;
import static com.publicpay.edu.alipay.constant.Constant4AlipayEdu.REFRESH_TOKEN;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.bean
 * @Description: 调用授权接口bean，用app_auth_code换token
 * @date 2018/7/23 下午3:04
 */
public class AlipayOpenAuthTokenAppRequestBizContentBean extends AlipayBizContentBean{
    @BeanToJson(GRANT_TYPE)
    private String grantType;
    @BeanToJson(CODE)
    private String code;
    @BeanToJson(REFRESH_TOKEN)
    private String refreshToken;

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
