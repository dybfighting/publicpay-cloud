package com.publicpay.alipay.controller;

import com.alipay.api.internal.util.AlipaySignature;
import com.publicpay.alipay.BaseTest;
import com.publicpay.alipay.bean.AlipayPayNotifyUrlRequestBean;
import com.publicpay.alipay.utils.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.controller
 * @Description: 模拟支付通知
 * @date 2018/7/24 下午4:59
 */
public class AlipayPayNotifyControllerTest extends BaseTest {

    @Value("${alipay.privateKey}")
    private String alipayPrivateKey;

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void test() throws Exception{
//		mockMvc.perform(MockMvcRequestBuilders.get("v2/callerCategories/{orgCategoriesCode}"))
//         .andExpect(MockMvcResultMatchers.status().isOk());
//        Map<String, Object> map = new HashMap<>();
//	        map.put("callerCode", "UNIONPAY");
        // 模拟向testRest发送get请求
        AlipayPayNotifyUrlRequestBean alipayPayNotifyUrlRequestBean = new AlipayPayNotifyUrlRequestBean();
        alipayPayNotifyUrlRequestBean.setNotify_time("2016-07-19 14:10:49");
        alipayPayNotifyUrlRequestBean.setNotify_type("trade_status_sync");
        alipayPayNotifyUrlRequestBean.setNotify_id("ac05099524730693a8b330c5ecf72da9786");
        alipayPayNotifyUrlRequestBean.setApp_id("2014072300007148");
        alipayPayNotifyUrlRequestBean.setCharset("utf-8");
        alipayPayNotifyUrlRequestBean.setVersion("1.0");
        alipayPayNotifyUrlRequestBean.setTrade_no("2013112011001004330000121536");
        alipayPayNotifyUrlRequestBean.setOut_trade_no("6823789339978248");
        String passback = Base64.getEncoder().encodeToString("orderNo=uoo234234&isvOrderNo=24werwe&items=1-2|2-1|3-5".getBytes("utf-8"));
        System.out.println(passback);
        alipayPayNotifyUrlRequestBean.setPassback_params(passback);

        Map<String, String> map = CommonUtils.objectToMap(alipayPayNotifyUrlRequestBean);
//        Set set = map.entrySet();
//        set.parallelStream().forEach(e -> System.out.println(e));
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
//                    String valDecode = URLEncoder.encode(val,alipayPayNotifyUrlRequestBean.getCharset());
                    sb.append(key + "=" + val +"&");
                }
            }

        }
        sb.delete(sb.length()-1,sb.length());
        String resultstr = sb.toString();
        System.out.println("test,resultstr: "+resultstr);
        String sign = AlipaySignature.rsaSign(resultstr,alipayPrivateKey,alipayPayNotifyUrlRequestBean.getCharset(),"RSA2");
        System.out.println("test,sign: "+sign);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/payNotify")
                .param("notify_time",alipayPayNotifyUrlRequestBean.getNotify_time()).param("notify_type",alipayPayNotifyUrlRequestBean.getNotify_type())
                .param("notify_id",alipayPayNotifyUrlRequestBean.getNotify_id()).param("app_id",alipayPayNotifyUrlRequestBean.getApp_id())
                .param("charset",alipayPayNotifyUrlRequestBean.getCharset()).param("version",alipayPayNotifyUrlRequestBean.getVersion())
                .param("sign_type","RSA2").param("sign",sign)
                .param("trade_no",alipayPayNotifyUrlRequestBean.getTrade_no()).param("out_trade_no",alipayPayNotifyUrlRequestBean.getOut_trade_no())
                .param("passback_params",alipayPayNotifyUrlRequestBean.getPassback_params()))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
//         .andExpect(MockMvcResultMatchers.content().string("abc"));
    }
}
