package com.core.fullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
@SpringBootApplication
public class FullStackDajrApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullStackDajrApplication.class, args);
	}

}
