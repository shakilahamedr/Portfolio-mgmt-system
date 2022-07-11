package com.cts.pod2.calculateNetworth;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.pod2.calculateNetworth.controller.NetworthController;
import com.cts.pod2.calculateNetworth.service.PortfolioDetailService;

@SpringBootTest
class CalculateNetworthApplicationTests {

	@Autowired
    private NetworthController networthController;
    @Autowired
    private  PortfolioDetailService portfolioService;
  
     @Test
     void contextLoads() throws Exception {
            assertThat(networthController).isNotNull();
            assertThat(portfolioService).isNotNull();
      }
	

}
