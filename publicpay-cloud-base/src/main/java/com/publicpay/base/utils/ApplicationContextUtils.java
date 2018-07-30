package com.publicpay.base.utils;

import org.springframework.context.ApplicationContext;


public class ApplicationContextUtils {
	
	private static ApplicationContext context ;

	public static ApplicationContext getContext() {
		return context;
	}

	public static void setContext(ApplicationContext context) {
		ApplicationContextUtils.context = context;
	}
	
	//通过名字获取上下文中的bean  
    public static Object getBean(String name){  
        return context.getBean(name);
    }
	

}
