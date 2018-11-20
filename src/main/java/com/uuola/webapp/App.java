package com.uuola.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ImportResource("classpath:spring-context.xml")
@EnableTransactionManagement
public class App {

    /**
     * dev mode : program args --spring.resources.static-locations=file:C:/doc/git/uuola-bootapp/src/main/static
     * @param args
     */
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
