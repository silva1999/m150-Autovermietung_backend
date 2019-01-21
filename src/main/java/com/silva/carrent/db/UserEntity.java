package com.silva.carrent.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id @GeneratedValue
	@Column(name = "id")
	private Integer id;
	@Column(name = "userId")
	private String userId;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "creditcard")
	private String creditcard;
	@Column(name = "limit")
	private String limit;
	@Column(name = "payments")
	private String payments;
	
	public UserEntity(){
		
	}
	
	public UserEntity(Integer id, String userId, String username, String password,
			String creditCard, String limit, String payments){
		this.userId = userId;
		this.id = id;
		this.username = username;
		this.password = password;
		this.creditcard = creditCard;
		this.limit = limit;
		this.payments = payments;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getPayments() {
		return payments;
	}

	public void setPayments(String payments) {
		this.payments = payments;
	}
	
	
}
