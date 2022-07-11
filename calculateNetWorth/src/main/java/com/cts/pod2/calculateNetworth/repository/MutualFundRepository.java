package com.cts.pod2.calculateNetworth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.pod2.calculateNetworth.model.MutualFund;

public interface MutualFundRepository extends JpaRepository<MutualFund, Integer> {
	public MutualFund findByName(String mfname);
}
