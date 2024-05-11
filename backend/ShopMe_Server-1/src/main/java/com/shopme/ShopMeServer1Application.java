package com.shopme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//its a combo of  @Configuration, @EnableAutoConfiguration and @ComponentScan 
@SpringBootApplication(exclude =SecurityAutoConfiguration.class)
public class ShopMeServer1Application{

	public static void main(String[] args) {
		SpringApplication.run(ShopMeServer1Application.class, args);
		
	}

}
