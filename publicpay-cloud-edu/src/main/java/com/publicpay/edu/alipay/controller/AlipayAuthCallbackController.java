package com.publicpay.edu.alipay.controller;

import com.alipay.api.AlipayApiException;
import com.publicpay.edu.alipay.bean.AlipayOpenAuthTokenAppRequestBizContentBean;
import com.publicpay.edu.alipay.request.AlipayAbstractRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;

import static com.publicpay.edu.alipay.constant.Constant4AlipayEdu.AUTHORIZATION_CODE;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.controller
 * @Description: 支付宝授权回调
 * @date 2018/7/18 上午11:43
 */
@RestController
@RequestMapping
public class AlipayAuthCallbackController {

    private static final Logger logger = LoggerFactory.getLogger(AlipayAuthCallbackController.class);

    @Resource
    private AlipayAbstractRequest alipayOpenAuthTokenAppRequestImpl;
    /**
     * 支付宝授权回调接口
     * @param appId
     * @param appAuthCode
     */
    @RequestMapping(value = "/authCallback")
    public String authCallback(@RequestParam(value = "app_id")String appId ,@RequestParam(value = "app_auth_code")String appAuthCode){
//    TODO 返回开发者appId 、商户授权code（有效期24小时）
        logger.info("appId:{},appAuthCode:{}",appId,appAuthCode);
        AlipayOpenAuthTokenAppRequestBizContentBean bizContentBean = new AlipayOpenAuthTokenAppRequestBizContentBean();
        bizContentBean.setCode(appAuthCode);
        bizContentBean.setGrantType(AUTHORIZATION_CODE);
        try {
            alipayOpenAuthTokenAppRequestImpl.service(bizContentBean);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
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
