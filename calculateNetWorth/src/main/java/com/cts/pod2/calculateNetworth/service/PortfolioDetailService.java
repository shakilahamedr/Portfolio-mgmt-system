package com.cts.pod2.calculateNetworth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pod2.calculateNetworth.exceptions.PortfolioDetailsNotFoundException;
import com.cts.pod2.calculateNetworth.feignclient.DailyMutualFundNAVClient;
import com.cts.pod2.calculateNetworth.feignclient.DailySharePriceClient;
import com.cts.pod2.calculateNetworth.model.MutualFund;
import com.cts.pod2.calculateNetworth.model.PortfolioDetails;
import com.cts.pod2.calculateNetworth.model.StockDetail;
import com.cts.pod2.calculateNetworth.repository.PortfolioDetailsRepository;
import com.cts.pod2.calculateNetworth.vo.MutualFundVO;
import com.cts.pod2.calculateNetworth.vo.StockDetailsVO;

@Service
public class PortfolioDetailService {

	@Autowired
	private PortfolioDetailsRepository portfolioDetailsRepository;
	
	@Autowired
	private DailySharePriceClient sharePriceClient;
	
	@Autowired
	private DailyMutualFundNAVClient mutualFundClient;

	public List<PortfolioDetails> getAll() throws PortfolioDetailsNotFoundException{
		return portfolioDetailsRepository.findAll();
	}

	public PortfolioDetails findByPfid(int id) throws PortfolioDetailsNotFoundException {
		PortfolioDetails pfDetail = portfolioDetailsRepository.findByPortfolioid(id);
		if (pfDetail == null) {
			throw new PortfolioDetailsNotFoundException("Portfolio Details Not Available");
		}
		return pfDetail;
	}

	public double getcalculateNetworth(int id,String authorization) throws PortfolioDetailsNotFoundException {
		double totalNetworth=0.0;
		PortfolioDetails pfDetail = findByPfid(id);
		List<StockDetail> stockDetail = pfDetail.getStockDetailList();
		List<MutualFund> mutualFund = pfDetail.getMutualFundList();
		for (StockDetail stock : stockDetail) {
			StockDetailsVO stockDetailsVO=sharePriceClient.getStockDetail(authorization,stock.getName());
			totalNetworth += stockDetailsVO.getStockValue() * stock.getUnits();
		}
		for (MutualFund mfund : mutualFund) {
			MutualFundVO mutualFundVO=mutualFundClient.getMutualFundDetails(authorization,mfund.getName());
			totalNetworth += mutualFundVO.getMutualFundValue() * mfund.getUnits();
		}

		return totalNetworth;
	}

}
