package com.springSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class App {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(App.class, args);
	}
}