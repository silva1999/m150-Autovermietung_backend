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
@Table(name = "car")
public class CarEntity {
	@Id
	@GeneratedValue
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

	/**
	 * default constructor
	 */
	public CarEntity() {

	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param name
	 * @param specification
	 * @param place
	 * @param price
	 */
	public CarEntity(Integer id, String name, String specification, String place, String price) {
		this.id = id;
		this.name = name;
		this.specification = specification;
		this.place = place;
		this.price = price;

	}

	/**
	 * Getter method returns carId
	 * 
	 * @return carId
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter method sets carId
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter method returns name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method sets name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter method returns specification
	 * 
	 * @return car specification
	 */
	public String getSpecification() {
		return specification;
	}

	/**
	 * Setter method sets specification
	 * 
	 * @param specification
	 */
	public void setSpecification(String specification) {
		this.specification = specification;
	}

	/**
	 * Getter method returns place
	 * 
	 * @return place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * Setter method sets place
	 * 
	 * @param place
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * Getter method returns price
	 * 
	 * @return price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * Setter method sets price
	 * 
	 * @param price
	 */
	public void setPrice(String price) {
		this.price = price;
	}
}
