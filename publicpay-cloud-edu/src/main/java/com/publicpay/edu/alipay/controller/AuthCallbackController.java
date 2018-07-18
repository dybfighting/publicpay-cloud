package com.publicpay.edu.alipay.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.controller
 * @Description: 支付宝授权回调
 * @date 2018/7/18 上午11:43
 */
@Controller
@RequestMapping
public class AuthCallbackController {

    private static final Logger logger = LoggerFactory.getLogger(AuthCallbackController.class);

    @RequestMapping(value = "/authCallback")
    public void authCallback(@RequestParam(value = "app_id")String appId ,@RequestParam(value = "app_auth_code")String appAuthCode){
//    TODO 返回开发这appId 、商户授权code（有效期24小时）
        logger.info("appId:{},appAuthCode:{}",appId,appAuthCode);
    }
    @RequestMapping(value = "/gate")
    public void gate(@RequestBody String s){
        logger.info(s);
    }

}
