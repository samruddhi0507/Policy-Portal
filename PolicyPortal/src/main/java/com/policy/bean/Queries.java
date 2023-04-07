package com.policy.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "queries")
public class Queries {

	@Id
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "query_id")
	private int queryId;

	@Column(name = "question")
	private String question;

	@Column(name = "answer")
	private String answer;

	public Queries() {
		
	}

	public Queries(String userName, int queryId, String question, String answer) {
		super();
		this.userName = userName;
		this.queryId = queryId;
		this.question = question;
		this.answer = answer;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getQueryId() {
		return queryId;
	}

	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}


}
