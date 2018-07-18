package com.publicpay.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@PropertySource(value = {
//		"classpath:redis.properties"})
public class EduApplication {

	public static void main(String[] args) {

		SpringApplication.run(EduApplication.class, args);

	}

}
