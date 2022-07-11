package com.cts.pod2.calculateNetworth.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pod2.calculateNetworth.vo.MutualFundVO;



//@FeignClient(url = "http://ij007pod2dailymutualfundnav-env-1.eba-kiz67zhi.eu-central-1.elasticbeanstalk.com:8083", name = "MUTUALFUNDNAV-SERVICE")
//@FeignClient(url="http://localhost:8083", name="MutualFundNAV-Service")
@FeignClient(url="${lb.url}:8083", name="MutualFundNAV-Service")
public interface DailyMutualFundNAVClient {

	@GetMapping(value = "/DailyMutualFundNAV/{mutualFundName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public MutualFundVO getMutualFundDetails(@RequestHeader("Authorization") String authorization,
			@PathVariable String mutualFundName);
}
