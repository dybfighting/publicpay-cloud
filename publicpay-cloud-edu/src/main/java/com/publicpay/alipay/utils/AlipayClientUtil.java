package com.publicpay.alipay.utils;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.utils
 * @Description: TODO
 * @date 2018/7/18 上午10:38
 */
public class AlipayClientUtil {

    private static AlipayClient alipayClient = null;
    private static final String DEV_URL="https://openapi.alipaydev.com/gateway.do";
    private static final String PRO_URL="https://openapi.alipay.com/gateway.do";

//    private static ThreadLocal<AlipayClient> threadLocal = new ThreadLocal<AlipayClient>();
    public static AlipayClient getInstance(){
//        AlipayClient alipayClient = threadLocal.get();
        if (alipayClient == null){
             alipayClient = new DefaultAlipayClient(
                    DEV_URL,
                    "2016091900545994",
                    "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCZRdZFEMIFPOnOA1pVnxJsIw074rg9RIckhoX7ltgBITb6lU5ezl180fkS5xX/pPNeV1WDasbWkdWj4cGc4ckjAsrOYSYE4n18XA5u5Cf2Al/SZ51SicWofDH/g2vbOIYdTcKByNArHyoHRQQMCmH7JjWM8tVUojdubpiDt4WE538bC5HUuk+/HuBNXkgZWfF6lhiwU4dNlCiwwFFlQHErEM5dYoVN0ljujvgdiNM+drBqpRC9IyCi/fkwLQ00ofZ5vOV5i/V19tvYzxbhONIa/gIdWYCCddi1o7d57G+RFyb8KjYn4F49gLnktw5Yp8K4tcTSQeOqOHTBFa/AUHUhAgMBAAECggEAPzJqbMPCHALHrGf5gUA7ilbRiBWtPaXZyxeket3xZlXZo2yYicKxDVxORJr/mQ7cQdPksHEAV0x+ODpHaHY4RrVKBdpMoMr6TqJuWQ6941OLSufqGDQySYwb2WzItfUSZ1a+kmDIZF9PJvwv9P7682EHx3wAtgrErEXxoK204d0ldfE9JKEmU8beMgSR53k5bG1X3UiHUnT6ITElcXouFOJ9QPzVhf7IqK60LvmtGnA1K1B+fvwmV5mKM1E2SmE06TP8iNcnPCW4P3l2lJxQp+xO1dHZ2GDbXv0GEae32ewsp0f4keUVOXjF8uo4/dOKcWeuiZ3kqaZ4tUKdVwxwAQKBgQDbkNWJAKeyBYL6DH4cPriOfF+pQi5HBmpP8DZbYr3Kn6HUlNkNQMYkJiO+z0mxc/Bd2tDSZsyKElYgmbOLvzL8iDoDxvhKyF9GCoc65P5SgqDK/BFr8LR5SB6OqD2p/3Vmafm/3QTKa1cbn19sx7+/D0xh4VHukdX0WThap0vSYQKBgQCytN/QHqW8DR5L6t2YXbe3oomJTn/aN5+oJm02KQPqLV9hbmccvChk1r/MIg/zsNHGd+bLgFHgZ+tqMP9MQgicDfZBbnt9LDp0UG8ZX+JN/QEV1obutcSYocE2jLJgX6ELtAE1V3EyBwuN086fWUV2AEjuD37gPQS+72I5g2kawQKBgBVB43qdJp80q2acGQWRCPs6jWRstOBJfbd5kTmtyKQ6akeTlaQT1lsfmixaE09r4ySjD76fF0Ry3AXR+7EW9M/APKWq+NT8q0Sztj38d6bzYK/mUaV6q25mjhbPsRCpW+trbTOnKVSTqd5RwsJcYHMV/xYm43DOi8FZdfxI4C1hAoGBAJvEx1XccPBSqvbXmSInhmz9s07I6u6mD3d9TzKnW68yr3H4zs4gQEFtYq8nfaoXlTKe7sCxcCzfyDa+0LmC0YhdLypniCJae/VI6x4+Er+R6fFEFkdajyvPyt+mkhEpKfJOi8MYHiXSOEL+vZruMHqj0u4W+aux5EId3QtuvR3BAoGAAy3iKE8tF6wVNnPJEicr1IGF84TTSf2ej1yKMMUdQ1ykVKkW0p1k3VIyy+U7dBq0r1VPwRePk76Wi6B/nfqONEKPjTW0kYcXwnzTpIkTTgfcFRKKEBgIDjFvuCImueK2TGORHfGqkd2Wl2P0D7smCkJlDmmaj9VfI8vodOjEGkY=",
                    "json",
                    "GBK",
                    "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoYIvH4/0Lnij5kr2U0igwQqvKRRJNFHZ7LR+jmZYOE/1x254qukD+NKlBKsvww5HGQoqgYQVCXLyakPT9l4Bp3OzzmY74KdmmznQpjDE4SRz2LhP3JoExi14bH1yzP8GdZu+EMxbitfmoTn8DSfvB0OI/snW4l34Zlrm5ZDwr3liMN0ni3Dc5N4YEP95kn+bu+m439IKjtpNtdKgQVJS81Q6rVbqovk53gixQMcB3KLCR2xxNBE1CFnKqYoLAcy5Wg/yPw+NuqPpbgsS4xRlywLsvhRyfYx8IZ/93kMS7sON11sBKWagwziZ/gkRe+1Q+IN5vBMdkC82wLn+OwBV+wIDAQAB",
                    "RSA2");
//             threadLocal.set(alipayClient);
        }
        return alipayClient;
    }

}
