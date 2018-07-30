package com.publicpay.alipay.edu.service;

import com.alipay.api.AlipayResponse;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.service
 * @Description: TODO
 * @date 2018/7/25 下午5:46
 */
public abstract class AlipayAbstractService {
    public <T extends AlipayResponse> T handleResponse(AlipayResponse alipayResponse){
        if(alipayResponse.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
            alipayResponse.getSubCode();
            alipayResponse.getSubMsg();
        }
        return null;
    }
}
