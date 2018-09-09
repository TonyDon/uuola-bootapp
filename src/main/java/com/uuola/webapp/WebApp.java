package com.uuola.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ImportResource("classpath:spring-context.xml")
@EnableTransactionManagement
public class WebApp {
    
    public static ApplicationContext SpringContext;

	public static void main(String[] args) {
		WebApp.SpringContext  = SpringApplication.run(WebApp.class, args);
	}
}