package com.publicpay.edu.alipay.controller;

import com.publicpay.edu.alipay.bean.AlipayOpenAuthTokenAppRequestBizContentBean;
import com.publicpay.edu.alipay.request.AlipayAbstractRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.publicpay.edu.alipay.constant.Constant4AlipayEdu.AUTHORIZATION_CODE;
import static com.publicpay.edu.alipay.constant.Constant4AlipayEdu.SUCCESS;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.controller
 * @Description: 支付宝授权回调
 * 在授权过程中，建议在拼接授权url的时候，开发者可增加自己的一个自定义信息，便于知道是哪个商户授权。
 * 开发者代替商户发起请求时请务必带上app_auth_token，否则支付宝将认为是本应用替自己发起的请求。请注意app_auth_token是POST请求参数，不是biz_content的子参数；在SDK中带上app_auth_token代码示例
 * request.putOtherTextParam("app_auth_token", "201611BB888ae9acd6e44fec9940d09201abfE16");
 * 开发者代替商户发起请求时，POST公共请求参数中的app_id应填写开发者的app_id；如果业务参数biz_content中需要AppId，则应填写商户的AppId。
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
    public String authCallback(@RequestParam(value = "app_id")String appId , @RequestParam(value = "app_auth_code")String appAuthCode, String merchantNo, HttpServletRequest servletRequest){
//    TODO 返回开发者appId 、商户授权code（有效期24小时）
        logger.info(servletRequest.getQueryString());
        logger.info("appId:{},appAuthCode:{},merchantNo:{}",appId,appAuthCode,merchantNo);
        AlipayOpenAuthTokenAppRequestBizContentBean bizContentBean = new AlipayOpenAuthTokenAppRequestBizContentBean();
        bizContentBean.setCode(appAuthCode);
        bizContentBean.setGrantType(AUTHORIZATION_CODE);
        //获得app_auth_code ,换token,存入该学校的记录当中
        //发送学校信息给支付宝
        //发送账单给支付宝
//        try {
//            alipayOpenAuthTokenAppRequestImpl.service(bizContentBean);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return SUCCESS;
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
