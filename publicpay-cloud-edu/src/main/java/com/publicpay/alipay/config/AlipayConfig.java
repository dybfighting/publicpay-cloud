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
    private String isv_app_id;
    private String isv_pid;
    private String gateway;

    public String getIsv_app_id() {
        return isv_app_id;
    }

    public void setIsv_app_id(String isv_app_id) {
        this.isv_app_id = isv_app_id;
    }

    public String getIsv_pid() {
        return isv_pid;
    }

    public void setIsv_pid(String isv_pid) {
        this.isv_pid = isv_pid;
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
