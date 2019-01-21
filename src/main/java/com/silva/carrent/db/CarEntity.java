package com.silva.carrent.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class CarEntity {
	@Id @GeneratedValue
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "specification")
	private String specification;
	@Column(name = "place")
	private String place;
	@Column(name = "price")
	private String price;
	
	public CarEntity(){
		
	}
	
	public CarEntity(Integer id, String name, String specification,
			String place, String price){
		this.id = id;
		this.name = name;
		this.specification = specification;
		this.place = place;
		this.price = price;
		
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
