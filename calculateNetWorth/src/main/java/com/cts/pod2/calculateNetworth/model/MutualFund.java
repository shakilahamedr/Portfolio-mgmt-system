package com.cts.pod2.calculateNetworth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
@ToString
@Entity
@Table(name = "mutualfund")
@ApiModel(description ="Mutual fund entity ")
public class MutualFund {

	public MutualFund(Integer mfId, String mutualFundName, Integer mutualFundUnits) {
		super();
		this.id = mfId;
		this.name = mutualFundName;
		this.units = mutualFundUnits;
	}

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	@ApiModelProperty(notes="Mutual Fund Name should contain only Alphabets")
	private String name;
	
	@Column(name = "units")
	private Integer units;

	@ManyToOne
	@JoinColumn(name = "portfolio_id")
	@JsonBackReference
	private PortfolioDetails portfolioDetails;

}
