package com.publicpay.edu.alipay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
@Controller
public class AlipayPayNotifyController {

    @RequestMapping(value = "payNotify",method = RequestMethod.POST)
    public String payNotify(){

        return null;
    }
}
