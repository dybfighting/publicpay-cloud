package com.publicpay.edu.alipay.service.impl;

import com.publicpay.edu.alipay.bean.AlipayEcoEduKtBillingModifyRequestBizContentBean;
import com.publicpay.edu.alipay.request.AlipayAbstractRequest;
import com.publicpay.edu.alipay.service.AlipaySyncBillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.service.impl
 * @Description: 同步账单状态  如果失败则查询账单是否同步完成 没完成则再同步 TODO
 * @date 2018/7/26 下午7:30
 */
@Service
public class AlipaySyncBillServiceImpl implements AlipaySyncBillService {

    private static final Logger logger = LoggerFactory.getLogger(AlipaySyncBillServiceImpl.class);
    @Resource
    private AlipayAbstractRequest alipayEcoEduKtBillingModifyRequestImpl;
    @Override
    public String syncBill(AlipayEcoEduKtBillingModifyRequestBizContentBean alipayEcoEduKtBillingModifyRequestBizContentBean) {
        //同步账单 同步失败则调用查询接口
        AlipayEcoEduKtBillingModifyRequestBizContentBean billModifybizContentBean = new AlipayEcoEduKtBillingModifyRequestBizContentBean();

        billModifybizContentBean.setTradeNo("2014112611001004680073956707");
        billModifybizContentBean.setOutTradeNo("20160101909909354354354");
        billModifybizContentBean.setStatus("1");
        billModifybizContentBean.setRefundAmount(200.12);
        billModifybizContentBean.setRefundReason("正常退款");
        billModifybizContentBean.setOutRequestNo("HZ01RF001");
        billModifybizContentBean.setBuyerLogonId("159****5620");
        billModifybizContentBean.setGmtRefund("2015-11-27 15:45:57");
        billModifybizContentBean.setBuyerUserId("2088101117955611");
        billModifybizContentBean.setRefundDetailItemList("{\"fund_channel\":\"ALIPAYACCOUNT\",\"amount\":12.00,\"real_amount\":12.00\"}");

        billModifybizContentBean.setAppAuthToken("201807BB174206f064a549a0b48496d880310X66");

        try {
            alipayEcoEduKtBillingModifyRequestImpl.service(billModifybizContentBean);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}
