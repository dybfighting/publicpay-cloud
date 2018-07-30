package com.publicpay.alipay.annotation;

import java.lang.annotation.*;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.annotation
 * @Description: 用来转json
 * @date 2018/7/19 下午9:03
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BeanToJson {
    String value() default "";
}
