package com.publicpay.alipay.edu.request;

import com.publicpay.alipay.BaseTest;
import com.publicpay.alipay.bean.AlipayEcoEduKtBillingModifyRequestBizContentBean;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.request
 * @Description: 同步账单状态
 * @date 2018/7/23 下午5:25
 */
public class AlipayEcoEduKtBillingModifyRequestImplTest extends BaseTest {
    @Resource
    private AlipayAbstractRequest alipayEcoEduKtBillingModifyRequestImpl;
    @Test
    public void test(){
        AlipayEcoEduKtBillingModifyRequestBizContentBean bizContentBean = new AlipayEcoEduKtBillingModifyRequestBizContentBean();
        bizContentBean.setTradeNo("2014112611001004680073956707");
        bizContentBean.setOutTradeNo("20160101909909354354354");
        bizContentBean.setStatus("1");
        bizContentBean.setRefundAmount(200.12);
        bizContentBean.setRefundReason("正常退款");
        bizContentBean.setOutRequestNo("HZ01RF001");
        bizContentBean.setBuyerLogonId("159****5620");
        bizContentBean.setGmtRefund("2015-11-27 15:45:57");
        bizContentBean.setBuyerUserId("2088101117955611");
        bizContentBean.setRefundDetailItemList("{\"fund_channel\":\"ALIPAYACCOUNT\",\"amount\":12.00,\"real_amount\":12.00\"}");

        bizContentBean.setAppAuthToken("201807BBc24a7f19028342289ac1f52cad022E66");
        //
//   "{" +
//                        "\"trade_no\":\"2014112611001004680073956707\"," +
//                        "\"out_trade_no\":\"20160101909909354354354\"," +
//                        "\"status\":\"1\"," +
//                        "\"fund_change\":\"Y\"," +
//                        "\"refund_amount\":200.12," +
//                        "\"refund_reason\":\"正常退款\"," +
//                        "\"out_request_no\":\"HZ01RF001\"," +
//                        "\"buyer_logon_id\":\"159****5620\"," +
//                        "\"gmt_refund\":\"2015-11-27 15:45:57\"," +
//                        "\"buyer_user_id\":\"2088101117955611\"," +
//                        "\"refund_detail_item_list\":\"{\\r\" +
//                "\\t\\\"fund_channel\\\":\\\"ALIPAYACCOUNT\\\",\\r\" +
//                "\\t\\\"amount\\\":12.00,\\r\" +
//                "\\t\\\"real_amount\\\":12.00\\r\" +
//                "\\t\\r\" +
//                "}\"" +
//                        "  }"
        try {
            alipayEcoEduKtBillingModifyRequestImpl.service(bizContentBean);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
