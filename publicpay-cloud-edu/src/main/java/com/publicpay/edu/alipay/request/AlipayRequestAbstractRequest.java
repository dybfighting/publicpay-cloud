package com.publicpay.edu.alipay.request;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayRequest;
import com.alipay.api.AlipayResponse;
import com.publicpay.edu.alipay.annotation.BeanToJson;
import com.publicpay.edu.alipay.bean.AlipayEcoEduKtBillingSendRequestBizContentBean;
import com.publicpay.edu.alipay.utils.AlipayClientUtil;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.service
 * @Description: TODO
 * @date 2018/7/18 下午5:51
 */
public abstract class AlipayRequestAbstractRequest {

    public static final List<String> list = new ArrayList<>();
    static {
        list.add("users");
    }
    public abstract void service() throws AlipayApiException;

    public <T extends AlipayResponse> T execute(AlipayRequest<T> request) throws AlipayApiException {
        AlipayClient alipayClient = AlipayClientUtil.getInstance();
        return alipayClient.execute(request);
    }

    /**
     * 通过反射拼装参数
     * @param request
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static String getBitContent(Object request) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        JSONObject bizContent = new JSONObject();
        Field[] fields = request.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String name = field.getName();
            String key = field.getAnnotation(BeanToJson.class).value();
            Method method = request.getClass().getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1, name.length()), null);
            if(list.contains(name)){
                List<Object> value = (List<Object>) method.invoke(request);
                List<JSONObject> users = getJsonObjects(value);
                bizContent.put(key, JSONArray.toJSONString(users));
            }else{
                String value = (String) method.invoke(request);
                if (StringUtils.isNotBlank(value)){
                    bizContent.put(key,value);
                }

            }
        }
        return bizContent.toString();
    }

    /**
     *
     * @param value
     * @return
     */
    private static List<JSONObject> getJsonObjects(List<Object> value) {
        return value.parallelStream().map(e->{
                        Field[] fields2 =  e.getClass().getDeclaredFields();
                        JSONObject bizContent2 = new JSONObject();
                        for (int j = 0; j < fields2.length; j++) {
                            Field field2 = fields2[j];
                            String name2 = field2.getName();
                            String key2 = field2.getAnnotation(BeanToJson.class).value();
                            String value2 = null;
                            try {
                                Method method2 = e.getClass().getMethod("get" + name2.substring(0, 1).toUpperCase() + name2.substring(1, name2.length()), null);
                                value2 = (String) method2.invoke(e);
                            } catch (NoSuchMethodException e1) {
                                e1.printStackTrace();
                            } catch (IllegalAccessException e1) {
                                e1.printStackTrace();
                            } catch (InvocationTargetException e1) {
                                e1.printStackTrace();
                            }
                            if (StringUtils.isNotBlank(value2)){
                                bizContent2.put(key2,value2);
                            }
                        }
                        return bizContent2;
                        }).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        AlipayEcoEduKtBillingSendRequestBizContentBean a = new AlipayEcoEduKtBillingSendRequestBizContentBean();
        a.setSchool_pid("123");
        AlipayEcoEduKtBillingSendRequestBizContentBean.User user= new AlipayEcoEduKtBillingSendRequestBizContentBean.User();
        user.setUserName("丁");
        List<AlipayEcoEduKtBillingSendRequestBizContentBean.User> users = new ArrayList<AlipayEcoEduKtBillingSendRequestBizContentBean.User>();
        users.add(user);
        a.setUsers(users);
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
