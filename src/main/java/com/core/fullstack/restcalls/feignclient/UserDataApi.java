package com.core.fullstack.restcalls.feignclient;

@SpringBootApplication
@EnableFeignClients
public class UserDataApi {
    public static void main(String[] args) {
        SpringApplication.run(UserDataApi.class, args);
    }
}
