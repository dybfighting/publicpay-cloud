package com.publicpay.edu.alipay.service.impl;

import com.alipay.api.internal.util.AlipaySignature;
import com.publicpay.edu.alipay.bean.AlipayPayNotifyUrlRequestBean;
import com.publicpay.edu.alipay.service.AlipayPayNotifyService;
import com.publicpay.edu.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.Set;

import static com.alipay.api.AlipayConstants.SIGN_TYPE;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.service.impl
 * @Description: 支付回调
 * @date 2018/7/25 上午9:12
 */
@Service
public class AlipayPayNotifyServiceImpl implements AlipayPayNotifyService {
    private static final Logger logger = LoggerFactory.getLogger(AlipayPayNotifyServiceImpl.class);
    @Value("${alipay.publicKey}")
    private String alipayPubKey;

    @Override
    public String alipayPayNotify(AlipayPayNotifyUrlRequestBean alipayPayNotifyUrlRequestBean) throws Exception {
        //s1 验签
        Map<String, String> map = CommonUtils.objectToMap(alipayPayNotifyUrlRequestBean);
        map.remove(SIGN_TYPE);
        Set set = map.entrySet();
        logger.info("****验签map****");
        set.parallelStream().forEach(e -> logger.info("{}", e));
        boolean checkResult = AlipaySignature.rsaCheckV2(map, alipayPubKey, alipayPayNotifyUrlRequestBean.getCharset(), alipayPayNotifyUrlRequestBean.getSign_type());
        logger.info("checkResult:{}", checkResult);
        Assert.isTrue(checkResult, "支付宝支付异步通知验签错误");
        //s2 验证参数需要严格按照如下描述校验通知数据的正确性。
        //
        // 1、商户需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
        // 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
        // 3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email），
        // 4、验证app_id是否为该商户本身。上述1、2、3、4有任何一个验证不通过，则表明本次通知是异常通知，务必忽略。在上述验证通过后商户必须根据支付宝不同类型的业务通知，正确的进行不同的业务处理，并且过滤重复的通知结果数据。在支付宝的业务通知中，只有交易通知状态为TRADE_SUCCESS或TRADE_FINISHED时，支付宝才会认定为买家付款成功。
        //
        // 注意：
        //
        //状态TRADE_SUCCESS的通知触发条件是商户签约的产品支持退款功能的前提下，买家付款成功；
        //交易状态TRADE_FINISHED的通知触发条件是商户签约的产品不支持退款功能的前提下，买家付款成功；或者，商户签约的产品支持退款功能的前提下，交易已经成功并且已经超过可退款期限。

        //s3 同步账单


        return null;
    }
}
