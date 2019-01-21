/**
 * @author 	Leandro Silva
 * @date 	21.01.2019
 * @version	1.0
 * 
 * interface definition of services
 */
package com.silva.carrent.service;

import java.util.List;

import com.silva.carrent.model.Car;
import com.silva.carrent.model.User;

public interface CarrentService {
	public enum RentCarStatus{
		OK, NOT_ENOUGH_MONEY, ALREADY_BOOKED, INVALID_INPUT, USER_NOT_LOGGED_IN
	}
	
	/**
	 * Service returns car list
	 * @return carList
	 */
	public List<Car> getCars();
	
	/**
	 * Service returns car if existing
	 * @param carId
	 * @return car
	 */
	public Car getCar(String carId);
	
	/**
	 * Service checks if credentials are correct
	 * @param username
	 * @param password
	 * @return user
	 */
	public User checkCredentials(String username, String password);
	
	/**
	 * Service creates new booking in database
	 * @param carId
	 * @param userId
	 * @param startDate
	 * @param endDate
	 * @return rentCarStatus
	 */
	public RentCarStatus rentCar(String carId, String userId, String startDate, String endDate);

}
