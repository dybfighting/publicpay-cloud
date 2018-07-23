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
    private String grantType;//必选	20	authorization_code表示换取app_auth_token。refresh_token表示刷新app_auth_token。
    @BeanToJson(CODE)
    private String code;//可选	40	授权码，如果grant_type的值为authorization_code。该值必须填写
    @BeanToJson(REFRESH_TOKEN)
    private String refreshToken;//可选	40	刷新令牌，如果grant_type值为refresh_token。该值不能为空。该值来源于此接口的返回值app_refresh_token（至少需要通过grant_type=authorization_code调用此接口一次才能获取）

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
