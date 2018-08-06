package com.publicpay.alipay.utils;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.utils
 * @Description: TODO
 * @date 2018/7/18 上午10:38
 */
public class AlipayClientUtil {

    private static AlipayClient alipayClient = null;

    private static final Properties props = new Properties();

    static {
        InputStream io = null;
        try {
            io = AlipayClientUtil.class.getClassLoader().getResourceAsStream("alipay-edu.properties");
            props.load(io);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
                SourceReleaseUtil.release(io, null, null, null);
        }
    }
    private static final String DEV_URL=props.getProperty("alipay.gateway");
    private static final String APP_ID = props.getProperty("alipay.auth_app_id");
    private static final String PRIVATE_KEY = props.getProperty("alipay.publicpay_edu_private_key");
    private static final String ALIPAY_PUBLIC_KEY = props.getProperty("alipay.publicKey");

//    private static final String PRO_URL="https://openapi.alipay.com/gateway.do";
//    private static ThreadLocal<AlipayClient> threadLocal = new ThreadLocal<AlipayClient>();

    public static AlipayClient getInstance(){
//        AlipayClient alipayClient = threadLocal.get();
        if (alipayClient == null){
             alipayClient = new DefaultAlipayClient(
                    DEV_URL,
                     APP_ID,
                    PRIVATE_KEY,
                    "json",
                    "GBK",
                     ALIPAY_PUBLIC_KEY,
                    "RSA2");
//             threadLocal.set(alipayClient);
        }
        return alipayClient;
    }

}
