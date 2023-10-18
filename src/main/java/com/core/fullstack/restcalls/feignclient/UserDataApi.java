package com.core.fullstack.restcalls.feignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserDataApi {
    public static void main(String[] args) {
        SpringApplication.run(UserDataApi.class, args);
    }
}
