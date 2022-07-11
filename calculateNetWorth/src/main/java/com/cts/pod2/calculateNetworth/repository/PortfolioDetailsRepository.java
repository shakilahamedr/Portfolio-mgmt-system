package com.cts.pod2.calculateNetworth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.pod2.calculateNetworth.model.PortfolioDetails;

public interface PortfolioDetailsRepository extends JpaRepository<PortfolioDetails, Integer> {
	public PortfolioDetails findByPortfolioid(int id);

}
