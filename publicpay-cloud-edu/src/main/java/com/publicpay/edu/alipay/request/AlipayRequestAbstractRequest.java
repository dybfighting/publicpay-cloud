package com.publicpay.edu.alipay.request;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayRequest;
import com.alipay.api.AlipayResponse;
import com.publicpay.edu.alipay.annotation.BeanToJson;
import com.publicpay.edu.alipay.bean.AlipayEcoEduKtSchoolinfoModifyRequestBizContentBean;
import com.publicpay.edu.alipay.utils.AlipayClientUtil;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.service
 * @Description: TODO
 * @date 2018/7/18 下午5:51
 */
public abstract class AlipayRequestAbstractRequest {

    public abstract void service() throws AlipayApiException;

    public <T extends AlipayResponse> T execute(AlipayRequest<T> request) throws AlipayApiException {
        AlipayClient alipayClient = AlipayClientUtil.getInstance();
        return alipayClient.execute(request);
    }

    public static String getBitContent(Object request) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        JSONObject bizContent = new JSONObject();
        Field[] fields = request.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String name = field.getName();
            String key = field.getAnnotation(BeanToJson.class).value();
            Method method = request.getClass().getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1, name.length()), null);
            String value = (String) method.invoke(request);
            if (StringUtils.isNotBlank(value)){
                bizContent.put(key,value);
            }
        }
        return bizContent.toString();
    }

    public static void main(String[] args) {
        AlipayEcoEduKtSchoolinfoModifyRequestBizContentBean a = new AlipayEcoEduKtSchoolinfoModifyRequestBizContentBean();
        a.setSchoolName("牛");
        try {
            System.out.println(getBitContent(a));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
