/**
 * @author 	Leandro Silva
 * @date 	21.01.2019
 * @version	1.0
 * 
 * Bean class
 */
package com.silva.carrent.model;

public class User {
	private String userId;
	private String username;

	/**
	 * constructor
	 * @param userId
	 * @param username
	 */
	public User(String userId, String username) {
		this.userId = userId;
		this.username = username;
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

}
