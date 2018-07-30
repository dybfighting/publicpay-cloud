package com.publicpay.alipay.edu.service.impl;

import com.alipay.api.internal.util.AlipaySignature;
import com.publicpay.alipay.edu.service.AlipayPayNotifyService;
import com.publicpay.alipay.bean.AlipayPayNotifyUrlRequestBean;
import com.publicpay.alipay.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Base64;
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

    /**
     * 第一步： 在通知返回参数列表中，除去sign、sign_type两个参数外，凡是通知返回回来的参数皆是待验签的参数。
     * 第二步： 将剩下参数进行url_decode, 然后进行字典排序，组成字符串，得到待签名字符串：
     * 第三步： 将签名参数（sign）使用base64解码为字节码串。
     * 第四步： 使用RSA的验签方法，通过签名字符串、签名参数（经过base64解码）及支付宝公钥验证签名。
     * 第五步：在步骤四验证签名正确后，必须再严格按照如下描述校验通知数据的正确性。
     * <p>
     *  TODO 验证参数
     * 1、商户需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号；
     * 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额）；
     * 3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）；
     * 4、验证app_id是否为该商户本身。
     *
     * @param alipayPayNotifyUrlRequestBean
     * @return
     * @throws Exception
     */
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

       String passbackParams =  alipayPayNotifyUrlRequestBean.getPassback_params();
        /**
         * 关于支付成功的异步回调参数，教育缴费平台将isv的账单号和平台的账单号都放入回调参数（passback_params），
         * 平台对参数进行了base64编码，需要解码后才能看到具体的值，参数格式为URL参数（orderNo=&isvOrderNo=）。
         * 同时不建议使用异步回调通知里面的out_trade_no，建议使用passback_param这个参数。
         * TODO
         */
       String dePassbackParams = new String(Base64.getDecoder().decode(passbackParams));
       String[] pbpb = dePassbackParams.split("&");
        /**
         * 缴费项序号，如果缴费项是多选模式，此项为必填，建议从1开始的连续数字，
         用户支付成功后，通过passback_params参数带回已选择的缴费项。例如:orderNo=uoo234234&isvOrderNo=24werwe&items=1-2|2-1|3-5
         1-2|2-1|3-5 表示：缴费项序列号-缴费项数|缴费项序列号-缴费项数
         TODO
         */
       String[] orderKV = pbpb[0].split("=");
       String[] isvOrderNoKV = pbpb[1].split("=");





       return null;
    }
}
