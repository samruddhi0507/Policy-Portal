package com.policy.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "policies")
public class Policies {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "policy_id")
	private int policyId;

	@Column(name = "policy_name")
	private String policyName;

	@Column(name = "category")
	private String category;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "tenure_in_years")
	private int tenureInYears;

	public Policies() {

	}

	public Policies(int policyId, String policyName, String category, Double amount, int tenureInYears) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.category = category;
		this.amount = amount;
		this.tenureInYears = tenureInYears;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public int getTenureInYears() {
		return tenureInYears;
	}

	public void setTenureInYears(int tenureInYears) {
		this.tenureInYears = tenureInYears;
	}

}
