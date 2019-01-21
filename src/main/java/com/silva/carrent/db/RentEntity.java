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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rent")
public class RentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "startDate")
	private String startDate;
	@Column(name = "endDate")
	private String endDate;
	@ManyToOne
	@JoinColumn(name = "carId")
	private CarEntity carEntity;
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserEntity userEntity;

	/**
	 * default constructor
	 */
	public RentEntity() {

	}

	/**
	 * constructor
	 * @param id
	 * @param startDate
	 * @param endDate
	 * @param car
	 * @param user
	 */
	public RentEntity(Integer id, String startDate, String endDate, CarEntity car, UserEntity user) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.carEntity = car;
		this.userEntity = user;
	}

	/**
	 * Getter method returns id
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter method sets id
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter method returns startDate
	 * @return startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Setter method sets startDate
	 * @param startDate
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * Getter method returns endDate
	 * @return endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * Setter method sets endDate
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * Getter method returns carEntity
	 * @return carEntity
	 */
	public CarEntity getCarEntity() {
		return carEntity;
	}

	/**
	 * Setter method sets carEntity
	 * @param carEntity
	 */
	public void setCarEntity(CarEntity carEntity) {
		this.carEntity = carEntity;
	}

	/**
	 * Getter method returns userEntity
	 * @return userEntity
	 */
	public UserEntity getUserEntity() {
		return userEntity;
	}

	/**
	 * Setter method sets userEntity
	 * @param userEntity
	 */
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

}
