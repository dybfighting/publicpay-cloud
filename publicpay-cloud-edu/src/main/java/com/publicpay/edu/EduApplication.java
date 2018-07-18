package com.publicpay.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @author shixy
 */
@SpringBootApplication
@PropertySource(value = {
		"classpath:redis.properties"})
public class EduApplication {

	public static void main(String[] args) {

		SpringApplication.run(EduApplication.class, args);

	}

}
