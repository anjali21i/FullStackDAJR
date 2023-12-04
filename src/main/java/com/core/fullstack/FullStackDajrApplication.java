package com.core.fullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@Configuration
@EnableFeignClients
@SpringBootApplication
public class FullStackDajrApplication {

	@Value("${application.env}")
	String appEnv;

	public static void main(String[] args) {
		SpringApplication.run(FullStackDajrApplication.class, args);
	}

	@Bean
	public CookieSerializer cookieSerializer() {
		
		DefaultCookieSerializer serializer = new DefaultCookieSerializer();
		serializer.setCookieName("BUILDSESSION");
		serializer.setCookiePath("/");
		if(appEnv.equalsIgnoreCase("dev")) {
			serializer.setDomainName("localhost");
		} else {
			serializer.setDomainName("test21i.com");
			serializer.setUseHttpOnlyCookie(true);
			serializer.setUseSecureCookie(true);
		}
		return serializer;
	}

}
