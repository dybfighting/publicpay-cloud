package com.publicpay.edu.alipay.controller;

import com.publicpay.base.utils.ValidUtil;
import com.publicpay.edu.alipay.bean.AlipayPayNotifyUrlRequestBean;
import com.publicpay.edu.alipay.service.AlipayPayNotifyService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.publicpay.edu.alipay.constant.Constant4AlipayEdu.ERROR;
import static com.publicpay.edu.alipay.constant.Constant4AlipayEdu.SUCCESS;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.controller
 * @Description: 此通知地址是为了保持教育缴费平台与ISV商户支付状态一致性。
 * 用户支付成功后，支付宝会根据本isv_notify_url，
 * 通过POST请求的形式将支付结果作为参数通知到商户系统，
 * ISV商户可以根据返回的参数更新账单状态。
 * @date 2018/7/19 下午1:47
 */
@RestController
public class AlipayPayNotifyController {

    private static final Logger logger = LoggerFactory.getLogger(AlipayPayNotifyController.class);
    @Autowired
    private AlipayPayNotifyService alipayPayNotifyService;
    @RequestMapping(value = "/payNotify", method = RequestMethod.POST)
    public String payNotify(@Valid AlipayPayNotifyUrlRequestBean alipayPayNotifyUrlRequestBean, BindingResult bindingResult) {
        String valid = ValidUtil.valid(bindingResult);
        if (StringUtils.isNotBlank(valid)){
            return valid;
        }
        logger.info("支付回调传入参数：{}",alipayPayNotifyUrlRequestBean);
        try {
            alipayPayNotifyService.alipayPayNotify(alipayPayNotifyUrlRequestBean);
        } catch (Exception e) {
            logger.error("",e);
            return ERROR;
        }


        return SUCCESS;
    }



}