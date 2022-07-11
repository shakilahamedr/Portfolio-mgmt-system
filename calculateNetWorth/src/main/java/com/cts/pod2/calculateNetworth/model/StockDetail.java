package com.cts.pod2.calculateNetworth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="stockdetail")
public class StockDetail {
	

	@Id
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="units")
	private int units;
	
	@ManyToOne
	@JoinColumn(name="portfolio_id")
	@JsonBackReference
	private PortfolioDetails portfolioDetails;
	
	public StockDetail(int stId, String stockName, int stockCount) {
		super();
		this.id = stId;
		this.name = stockName;
		this.units = stockCount;
	}
	
}
