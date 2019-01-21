/**
 * @author 	Leandro Silva
 * @date 	21.01.2019
 * @version	1.0
 * 
 * Entity class represents table in database.
 */
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
	
	/**
	 * default constructor
	 */
	public UserEntity(){
		
	}
	
	/**
	 * Constructor
	 * @param id
	 * @param userId
	 * @param username
	 * @param password
	 * @param creditCard
	 * @param limit
	 * @param payments
	 */
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

	/**
	 * Getter method returns userId
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Setter method sets userId
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Getter method returns entity id
	 * @return entity id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter method sets entity id
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter method returns username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setter method sets username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Getter method returns password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter method sets password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter method returns creditcard
	 * @return creditcard
	 */
	public String getCreditcard() {
		return creditcard;
	}

	/**
	 * Setter method sets creditcard
	 * @param creditcard
	 */
	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	/**
	 * Getter method returns limit
	 * @return limit
	 */
	public String getLimit() {
		return limit;
	}

	/**
	 * Setter method sets limit
	 * @param limit
	 */
	public void setLimit(String limit) {
		this.limit = limit;
	}

	/**
	 * Getter method returns payments
	 * @return payments
	 */
	public String getPayments() {
		return payments;
	}

	/**
	 * Setter method sets payments
	 * @param payments
	 */
	public void setPayments(String payments) {
		this.payments = payments;
	}
	
	
}
