package com.publicpay.base.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * 提示 @Valid 错误信息
 * @author : minchao.du
 * @description :
 * @date : 2017/12/6
 */
public class ValidUtil {
    public static String valid(BindingResult bindingResult){
        String result = "";
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fieldError : fieldErrors){
                String message = fieldError.getDefaultMessage();
                result += message == null? "":message+",";
            }
        }
        result = "".equals(result.trim()) ? null : result.substring(0, result.length() -1);
        return result;
    }
}
