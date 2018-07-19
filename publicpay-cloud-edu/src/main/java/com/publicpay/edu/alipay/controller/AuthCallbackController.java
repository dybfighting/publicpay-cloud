package com.publicpay.edu.alipay.controller;

import com.alipay.api.AlipayApiException;
import com.publicpay.edu.alipay.request.AlipayRequestAbstractRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.controller
 * @Description: 支付宝授权回调
 * @date 2018/7/18 上午11:43
 */
@RestController
@RequestMapping
public class AuthCallbackController {

    private static final Logger logger = LoggerFactory.getLogger(AuthCallbackController.class);

    @Resource
    private AlipayRequestAbstractRequest alipayOpenAuthTokenAppRequestImpl;
    /**
     * 支付宝授权回调接口
     * @param appId
     * @param appAuthCode
     */
    @RequestMapping(value = "/authCallback")
    public String authCallback(@RequestParam(value = "app_id")String appId ,@RequestParam(value = "app_auth_code")String appAuthCode){
//    TODO 返回开发这appId 、商户授权code（有效期24小时）
        logger.info("appId:{},appAuthCode:{}",appId,appAuthCode);
        try {
            alipayOpenAuthTokenAppRequestImpl.service();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 网关 用来接收支付宝通知
     * @param s
     */
    @RequestMapping(value = "/gate")
    public void gate(@RequestBody String s){
        logger.info(s);
    }

}
