package com.silva.carrent.model;

public class Car {
	private Integer id;
	private String name;
	private String specification;
	private String place;
	private String price;
	
	public Car(){
		
	}
	
	public Car(Integer id, String name, String specification,
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
