package com.core.fullstack.restcalls.feignclient;

@FeignClient(name = "provider", url = "http://provider-url.com")
public interface ApiCallClient {

    @GetMapping("/userApiCall")
    ResponseEntity<String> getFromProvider();
  
}
