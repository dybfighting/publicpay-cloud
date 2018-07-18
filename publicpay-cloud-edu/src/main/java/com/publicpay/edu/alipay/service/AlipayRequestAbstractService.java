package com.publicpay.edu.alipay.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayRequest;
import com.alipay.api.AlipayResponse;
import com.publicpay.edu.alipay.utils.AlipayClientUtil;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.service
 * @Description: TODO
 * @date 2018/7/18 下午5:51
 */
public abstract class AlipayRequestAbstractService {

    public abstract void service() throws AlipayApiException;

    public <T extends AlipayResponse> T execute(AlipayRequest<T> var1) throws AlipayApiException {
        AlipayClient alipayClient = AlipayClientUtil.getInstance();
        return alipayClient.execute(var1);
    }
}
