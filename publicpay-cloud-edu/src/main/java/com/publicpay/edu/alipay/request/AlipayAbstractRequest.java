package com.publicpay.edu.alipay.request;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayRequest;
import com.alipay.api.AlipayResponse;
import com.publicpay.edu.alipay.bean.AlipayBizContentBean;
import com.publicpay.edu.alipay.utils.AlipayClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.service
 * @Description: 支付宝教育接口请求抽象类
 * @date 2018/7/18 下午5:51
 */
public abstract class AlipayAbstractRequest {

    private static final Logger logger = LoggerFactory.getLogger(AlipayAbstractRequest.class);


    public abstract <T extends AlipayResponse> T service(AlipayBizContentBean bizContentBean) throws Exception;

    public <T extends AlipayResponse> T execute(AlipayRequest<T> request) throws AlipayApiException {
        AlipayClient alipayClient = AlipayClientUtil.getInstance();
        return alipayClient.execute(request);
    }


}
