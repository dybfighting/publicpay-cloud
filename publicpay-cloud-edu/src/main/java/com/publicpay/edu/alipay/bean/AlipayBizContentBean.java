package com.publicpay.edu.alipay.bean;

import com.alibaba.fastjson.JSONObject;
import com.publicpay.edu.alipay.annotation.BeanToJson;
import com.publicpay.edu.alipay.constant.Constant4AlipayEdu;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.publicpay.edu.alipay.constant.Constant4AlipayEdu.APP_AUTH_TOKEN;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.bean
 * @Description: 支付宝BizContent基础bean
 * @date 2018/7/23 下午3:09
 */
public class AlipayBizContentBean {
    private static final  Logger logger = LoggerFactory.getLogger(AlipayBizContentBean.class);

    public static final List<String> filterList = new ArrayList<>();
    static {
        filterList.add(Constant4AlipayEdu.USERS);
        filterList.add(Constant4AlipayEdu.CHARGEITEM);
    }
    @BeanToJson(APP_AUTH_TOKEN)
    private String appAuthToken;


    public String getAppAuthToken() {
        return appAuthToken;
    }

    public void setAppAuthToken(String appAuthToken) {
        this.appAuthToken = appAuthToken;
    }

    /**
     　　* @Description: 通过反射拼装参数
     　　* @param
     　　* @return
     　　* @throws
     　　* @author dyb
     　　* @date 2018/7/20 上午12:06
     　　*/
    public  String getBitContent() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        JSONObject bizContent = new JSONObject();
        Field[] fields = this.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String name = field.getName();
            String type = field.getGenericType().toString();
            if (name.equals("logger")||name.equals("filterList")){
                continue;
            }
            System.out.println("****field:"+name);
            logger.info(field.toString());
            String key = field.getAnnotation(BeanToJson.class).value();
            logger.info("name:{},key:{}",name,key);
            Method method = this.getClass().getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1, name.length()), null);
            if(filterList.contains(name)){
                List<Object> value = (List<Object>) method.invoke(this);
                List<JSONObject> users = getJsonObjects(value);
                bizContent.put(key, users);
            }else if (type.equals("class java.lang.String")){
                String value = (String) method.invoke(this);
                if (StringUtils.isNotBlank(value)){
                    bizContent.put(key,value);
                }
            }else if(type.equals("class java.lang.Double")){
                Double value = (Double) method.invoke(this);
                if (value!=null){
                    bizContent.put(key,value);
                }

            }else if(type.equals("class java.lang.Integer")){
                Integer value = (Integer) method.invoke(this);
                if (value!=null){
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
                String type2 = field2.getGenericType().toString();
                logger.info("类型:{}",type2);
                String key2 = field2.getAnnotation(BeanToJson.class).value();
                try {
                    Method method2 = e.getClass().getMethod("get" + name2.substring(0, 1).toUpperCase() + name2.substring(1, name2.length()), null);
                    if (type2.equals("class java.lang.String")){
                        String value2 = (String) method2.invoke(e);
                        if (StringUtils.isNotBlank(value2)){
                            bizContent2.put(key2,value2);
                        }
                    }else if(type2.equals("class java.lang.Double")){
                        Double value2 = (Double) method2.invoke(e);
                        if (value!=null){
                            bizContent2.put(key2,value2);
                        }

                    }else if(type2.equals("class java.lang.Integer")){
                        Integer value2 = (Integer) method2.invoke(e);
                        if (value!=null){
                            bizContent2.put(key2,value2);
                        }
                    }
                } catch (Exception e1) {
                    logger.error("",e1);
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
            System.out.println(a.getBitContent());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
