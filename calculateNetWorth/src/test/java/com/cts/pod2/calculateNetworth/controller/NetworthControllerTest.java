package com.cts.pod2.calculateNetworth.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.pod2.calculateNetworth.feignclient.AuthorizationClient;
import com.cts.pod2.calculateNetworth.model.MutualFund;
import com.cts.pod2.calculateNetworth.model.PortfolioDetails;
import com.cts.pod2.calculateNetworth.model.StockDetail;
import com.cts.pod2.calculateNetworth.service.PortfolioDetailService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(NetworthController.class)
class NetworthControllerTest {
	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper mapper;
	@MockBean
	private PortfolioDetailService portfolioDetailService;
	@MockBean
	private AuthorizationClient authorizationClient;

	MutualFund mutualFund = new MutualFund(21, "CPE", 10);
	StockDetail stockDetail = new StockDetail(10, "CTS", 10);


	@Test
	void testViewAsset() throws Exception {
		
		List<MutualFund> mfList = new ArrayList<>();
		mfList.add(mutualFund);
		List<StockDetail> sdList = new ArrayList<>();
		sdList.add(stockDetail);
		PortfolioDetails portfolioDetails = new PortfolioDetails(101, sdList, mfList);

		Map<String, String> map = new HashMap<>();
		map.put("Authorization", "token");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAll(map);

		Mockito.when(portfolioDetailService.findByPfid(portfolioDetails.getPortfolioid())).thenReturn(portfolioDetails);

		mockMvc.perform(MockMvcRequestBuilders.get("/calculateNetworth/viewAsset").headers(httpHeaders)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void testCalculateNetworth() throws Exception {
		List<MutualFund> mfList = new ArrayList<>();
		mfList.add(mutualFund);
		List<StockDetail> sdList = new ArrayList<>();
		sdList.add(stockDetail);

		Map<String, String> map = new HashMap<>();
		map.put("Authorization", "token");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAll(map);

		mockMvc.perform(MockMvcRequestBuilders.get("/calculateNetworth/").headers(httpHeaders)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}