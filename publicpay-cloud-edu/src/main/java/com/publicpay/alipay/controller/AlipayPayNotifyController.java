package com.publicpay.alipay.controller;

import com.publicpay.alipay.edu.service.AlipayPayNotifyService;
import com.publicpay.base.utils.ValidUtil;
import com.publicpay.alipay.bean.AlipayPayNotifyUrlRequestBean;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.publicpay.alipay.constant.Constant4AlipayEdu.ERROR;
import static com.publicpay.alipay.constant.Constant4AlipayEdu.SUCCESS;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.controller
 * @Description: 此通知地址是为了保持教育缴费平台与ISV商户支付状态一致性。
 * 用户支付成功后，支付宝会根据本isv_notify_url，
 * 通过POST请求的形式将支付结果作为参数通知到商户系统，
 * ISV商户可以根据返回的参数更新账单状态。
 * <p>
 * （1）用户支付成功，更新为“缴费成功”
 * （2）给用户完成退款，更新为“退费”
 * （3）发错账单、账单逾期或者已经通过其它渠道完成了支付，更新为“关闭”。
 * <p>
 * 注意事项：
 * （1）关于支付成功的异步回调参数，教育缴费平台将isv的账单号和平台的账单号都放入回调参数（passback_params），平台对参数进行了base64编码，需要解码后才能看到具体的值，参数格式为URL参数（orderNo=&isvOrderNo=）。同时不建议使用异步回调通知里面的out_trade_no，建议使用passback_param这个参数。
 * （2）在用户支付成功后，支付宝教育缴费APP中给用户显示的缴费账单状态为“处理中”，只有将状态更新为“缴费成功”后，用户端才会显示缴费成功，缴费流程才算完成。
 * （3）如果账单需要退款，必须要先将缴费账单的状态更新为“缴费成功”，然后才能再更新为“退费”。
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
