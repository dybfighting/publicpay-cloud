package com.publicpay.alipay.config;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.alipay.config
 * @Description: alipay配置
 * @date 2018/8/6 上午10:54
 */
@Configuration
@ConfigurationProperties(prefix = "alipay")
public class AlipayConfig {

    private String publicpay_edu_public_key;
    private String publicpay_edu_private_key;
    private String publicKey;
    private String dev_app_id;
    private String merchant_uid;
    private String app_auth_token;
    private String auth_app_id;
    private String gateway;
    private String aaa;

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    public String getPublicpay_edu_public_key() {
        return publicpay_edu_public_key;
    }

    public void setPublicpay_edu_public_key(String publicpay_edu_public_key) {
        this.publicpay_edu_public_key = publicpay_edu_public_key;
    }

    public String getPublicpay_edu_private_key() {
        return publicpay_edu_private_key;
    }

    public void setPublicpay_edu_private_key(String publicpay_edu_private_key) {
        this.publicpay_edu_private_key = publicpay_edu_private_key;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getDev_app_id() {
        return dev_app_id;
    }

    public void setDev_app_id(String dev_app_id) {
        this.dev_app_id = dev_app_id;
    }

    public String getMerchant_uid() {
        return merchant_uid;
    }

    public void setMerchant_uid(String merchant_uid) {
        this.merchant_uid = merchant_uid;
    }

    public String getApp_auth_token() {
        return app_auth_token;
    }

    public void setApp_auth_token(String app_auth_token) {
        this.app_auth_token = app_auth_token;
    }

    public String getAuth_app_id() {
        return auth_app_id;
    }

    public void setAuth_app_id(String auth_app_id) {
        this.auth_app_id = auth_app_id;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
