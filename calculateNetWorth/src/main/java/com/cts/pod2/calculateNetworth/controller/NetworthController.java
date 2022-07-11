package com.cts.pod2.calculateNetworth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pod2.calculateNetworth.exceptions.PortfolioDetailsNotFoundException;
import com.cts.pod2.calculateNetworth.feignclient.AuthorizationClient;
import com.cts.pod2.calculateNetworth.model.PortfolioDetails;
import com.cts.pod2.calculateNetworth.service.PortfolioDetailService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/calculateNetworth")
@Slf4j
@CrossOrigin(origins = "*")
public class NetworthController {

	@Autowired
	private PortfolioDetailService portfolioDetailService;

	@Autowired
	private AuthorizationClient authorizationClient;

	@GetMapping(value = "/viewAsset", produces = MediaType.APPLICATION_JSON_VALUE)
	public PortfolioDetails getAssetById(@RequestHeader("Authorization") String authorization) throws PortfolioDetailsNotFoundException{
		int pid = authorizationClient.getUserId(authorization);
		log.info("finding portfolio by id...");
		return portfolioDetailService.findByPfid(pid);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public double calculateNetworth(@RequestHeader("Authorization") String authorization) throws PortfolioDetailsNotFoundException {
		int pid = authorizationClient.getUserId(authorization);
		log.info("calculating networth....");
		return portfolioDetailService.getcalculateNetworth(pid, authorization);
	}

}
