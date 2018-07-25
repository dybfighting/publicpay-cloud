package com.publicpay.edu.alipay.service;

import com.publicpay.edu.alipay.bean.AlipayPayNotifyUrlRequestBean;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.service
 * @Description: TODO
 * @date 2018/7/25 上午9:11
 */
public interface AlipayPayNotifyService {
    String alipayPayNotify(AlipayPayNotifyUrlRequestBean alipayPayNotifyUrlRequestBean)throws Exception;
}
