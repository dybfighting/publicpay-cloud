package com.publicpay.edu.alipay.service;

import com.publicpay.edu.alipay.bean.AlipayEcoEduKtBillingModifyRequestBizContentBean;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.service
 * @Description: 同步账单状态
 * @date 2018/7/25 下午5:26
 */
public interface AlipaySyncBillService {

    String syncBill(AlipayEcoEduKtBillingModifyRequestBizContentBean alipayEcoEduKtBillingModifyRequestBizContentBean);
}
