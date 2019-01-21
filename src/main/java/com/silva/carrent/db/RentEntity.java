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
	
	public RentEntity(){
		
	}
	
	public RentEntity(Integer id, String startDate, String endDate, CarEntity car, UserEntity user){
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.carEntity = car;
		this.userEntity = user;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public CarEntity getCarEntity() {
		return carEntity;
	}
	public void setCarEntity(CarEntity carEntity) {
		this.carEntity = carEntity;
	}
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
	
	
}
