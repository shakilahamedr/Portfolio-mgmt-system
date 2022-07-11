package com.cts.pod2.calculateNetworth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.pod2.calculateNetworth.model.StockDetail;

public interface StockDetailRepository extends JpaRepository<StockDetail, Integer> {
	public StockDetail findByName(String stockName);
}
