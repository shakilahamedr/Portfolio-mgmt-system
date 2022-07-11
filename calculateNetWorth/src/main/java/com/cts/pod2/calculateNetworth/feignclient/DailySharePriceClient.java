package com.cts.pod2.calculateNetworth.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pod2.calculateNetworth.vo.StockDetailsVO;

//@FeignClient(url = "Ij007pod2dailyshareprice-env.eba-y2bi6rf3.eu-central-1.elasticbeanstalk.com:8082", name = "DAILYSHAREPRICE-SERVICE")
//@FeignClient(url="http://localhost:8082", name="DailySharePrice-Service")
@FeignClient(url="${lb.url}:8082", name="SharePrice-Service")
public interface DailySharePriceClient {
	
	@GetMapping(value="/DailySharePrice/{stockName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StockDetailsVO getStockDetail(@RequestHeader("Authorization") String authorization,@PathVariable String stockName);

}
