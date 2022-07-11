package com.cts.dailyshareprice.feigclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

//@FeignClient(url = "http://ij007pod2authorization-env.eba-fsjdukpv.eu-central-1.elasticbeanstalk.com:8081", name = "AUTHORIZATION-SERVICE")
//@FeignClient(url = "http://localhost:8081", name= "Authorization-Service")
@FeignClient(url="${lb.url}:8081", name="Authorization-Service")
public interface AuthorizationClient {
	
	@GetMapping("/getuname")
	public String getUname(@RequestHeader("Authorization") String authorization);

}
