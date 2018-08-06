package com.publicpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource(value = {
		"classpath:alipay-edu.properties"})
public class EduApplication {

	public static void main(String[] args) {

		SpringApplication.run(EduApplication.class, args);

	}


}
