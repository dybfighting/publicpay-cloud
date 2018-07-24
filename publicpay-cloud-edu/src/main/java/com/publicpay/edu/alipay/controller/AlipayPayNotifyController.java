package com.publicpay.edu.alipay.controller;

import com.publicpay.edu.alipay.bean.AlipayPayNotifyUrlRequestBean;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.util.*;

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

    @RequestMapping(value = "/payNotify", method = RequestMethod.POST)
    public String payNotify(@Valid AlipayPayNotifyUrlRequestBean alipayPayNotifyUrlRequestBean, BindingResult bindingResult) {
//        String valid = ValidUtil.valid(bindingResult); TODO 拿到开发机换
        String result = "";
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                String message = fieldError.getDefaultMessage();
                result += message == null ? "" : message + ",";
            }
            result = "".equals(result.trim()) ? null : result.substring(0, result.length() - 1);
            return result;
        }

//        AlipaySignature.rsaCheckV2();TODO

        return null;
    }


    public static String checkSign(AlipayPayNotifyUrlRequestBean alipayPayNotifyUrlRequestBean) {
        Map<String, String> map = null;
        try {
            map = BeanUtils.describe(alipayPayNotifyUrlRequestBean);
            map.remove("class");
            map.remove("sign");
            map.remove("sign_type");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        String result = "";
        /**
         *参数移除第一步： 在通知返回参数列表中，除去sign、sign_type两个参数外，凡是通知返回回来的参数皆是待验签的参数。

         第二步： 将剩下参数进行url_decode, 然后进行字典排序，组成字符串，得到待签名字符串：

         body=大乐透2.1&buyer_id=2088102116773037&charset=utf-8&gmt_close=2016-07-19 14:10:46&gmt_payment=2016-07-19 14:10:47&notify_time=2016-07-19 14:10:49&notify_type=trade_status_sync&out_trade_no=0719141034-6418&refund_fee=0.00&subject=大乐透2.1&total_amount=2.00&trade_no=2016071921001003030200089909&trade_status=TRADE_SUCCESS&version=1.0
         第三步： 将签名参数（sign）使用base64解码为字节码串。

         第四步： 使用RSA的验签方法，通过签名字符串、签名参数（经过base64解码）及支付宝公钥验证签名。

         第五步：需要严格按照如下描述校验通知数据的正确性。

         1、商户需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email），4、验证app_id是否为该商户本身。上述1、2、3、4有任何一个验证不通过，则表明本次通知是异常通知，务必忽略。在上述验证通过后商户必须根据支付宝不同类型的业务通知，正确的进行不同的业务处理，并且过滤重复的通知结果数据。在支付宝的业务通知中，只有交易通知状态为TRADE_SUCCESS或TRADE_FINISHED时，支付宝才会认定为买家付款成功。
         */
        try {
            List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(map.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
                @Override
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });

            // 构造签名键值对的格式
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> item : infoIds) {
                if (StringUtils.isNotBlank(item.getKey())) {
                    String key = item.getKey();
                    String val = item.getValue();
                    if (StringUtils.isNotBlank(val)) {
                        String valDecode = URLDecoder.decode(val,alipayPayNotifyUrlRequestBean.getCharset());
                        sb.append(key + "=" + valDecode +"&");
                    }
                }

            }
            sb.delete(sb.length()-1,sb.length());
            result = sb.toString();

            byte[] signBytes = Base64.getDecoder().decode(alipayPayNotifyUrlRequestBean.getSign());

        } catch (Exception e) {
            logger.error("",e);
            return null;
        }
        return result;

    }
}