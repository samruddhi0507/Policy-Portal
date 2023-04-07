package com.policy.bean;


	import java.util.Date;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	@Entity(name = "approvals")
	public class Approvals {
		@Id
		@Column(name = "user_name")
		private String userName;

		@Column(name = "policy_id")
		private Integer policyId;
		
		@GeneratedValue(strategy = GenerationType.TABLE)
		@Column(name = "request_id")
		private Integer requestId;

		@Column(name = "date")
		private Date date;

		@Column(name = "status")
		private String status;

		public Approvals() {

		}

		public Approvals(String userName, Integer policyId, Integer requestId, Date date, String status) {
			super();
			this.userName = userName;
			this.policyId = policyId;
			this.requestId = requestId;
			this.date = date;
			this.status = status;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public Integer getPolicyId() {
			return policyId;
		}

		public void setPolicyId(Integer policyId) {
			this.policyId = policyId;
		}

		public Integer getRequestId() {
			return requestId;
		}

		public void setRequestId(Integer requestId) {
			this.requestId = requestId;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		

	}

