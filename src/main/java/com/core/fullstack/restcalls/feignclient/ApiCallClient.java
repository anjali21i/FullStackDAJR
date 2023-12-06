package com.core.fullstack.restcalls.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "provider", url = "http://provider-url.com")
public interface ApiCallClient {

    @GetMapping("/userApiCall")
    ResponseEntity<String> getFromProvider();
  
}
