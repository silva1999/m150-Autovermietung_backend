package com.silva.carrent.service;

import java.util.List;

import com.silva.carrent.model.Car;
import com.silva.carrent.model.User;

public interface CarrentService {
	public enum RentCarStatus{
		OK, NOT_ENOUGH_MONEY, ALREADY_BOOKED, INVALID_INPUT, USER_NOT_LOGGED_IN
	}
	
	public List<Car> getCars();
	public Car getCar(String carId);
	public User checkCredentials(String username, String password);
	public RentCarStatus rentCar(String carId, String userId, String startDate, String endDate);

}
