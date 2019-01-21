/**
 * @author 	Leandro Silva
 * @date 	21.01.2019
 * @version	1.0
 * 
 * This class contains all endpoints. This is also the interface for the frontend application.
 */
package com.silva.carrent.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.silva.carrent.exception.CarAlreadyBookedException;
import com.silva.carrent.exception.InputNotCorrectException;
import com.silva.carrent.exception.NotEnoughMoneyException;
import com.silva.carrent.exception.UserNotLoggedInException;
import com.silva.carrent.model.Car;
import com.silva.carrent.model.User;
import com.silva.carrent.service.CarrentService;
import com.silva.carrent.service.CarrentService.RentCarStatus;
import com.silva.carrent.service.CarrentServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class CarController {
	
	private CarrentService service = new CarrentServiceImpl();

	/**
	 * Service returns all cars
	 * @return car list
	 */
	@RequestMapping(value="/cars", method = RequestMethod.GET)
	public List<Car> getCars() {
		return service.getCars();
	}
	
	/**
	 * Service returns car if existing
	 * @param carId
	 * @return car
	 */
	@RequestMapping(value = "/cars/{id}", method = RequestMethod.GET)
	public Car getCar(@PathVariable("id") String carId) {
		return service.getCar(carId);
	}
	
	/**
	 * This service checks the credentials of an user.
	 * @param username
	 * @param password
	 * @return user credentials
	 * @throws UserNotLoggedInException
	 */
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public User login(@RequestParam("username") String username, 
			@RequestParam("password") String password) throws UserNotLoggedInException {
		User user = service.checkCredentials(username, password);
		if(user == null){
			throw new UserNotLoggedInException();
		}
		return user;
	}
	
	/**
	 * Service to rent a car.
	 * @param carId
	 * @param userId
	 * @param startdate
	 * @param enddate
	 * @throws Exception
	 */
	@RequestMapping(value = "/rent/{id}", method = RequestMethod.POST)
	public void rentCar(@PathVariable("id") String carId,
			@RequestParam("userId") String userId, @RequestParam("startdate") String startdate,
			@RequestParam("enddate") String enddate) throws Exception{
		RentCarStatus status = service.rentCar(carId, userId, startdate, enddate);
		switch(status){
			case ALREADY_BOOKED: throw new CarAlreadyBookedException();
			case INVALID_INPUT: throw new InputNotCorrectException();
			case NOT_ENOUGH_MONEY: throw new NotEnoughMoneyException();
			case USER_NOT_LOGGED_IN: throw new UserNotLoggedInException();
		}
	}
	
	/**
	 * This method handles all exceptions
	 * @param exception
	 * @return exception
	 */
	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleException(Exception exception){
		ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
		return new ResponseEntity<Object>(
			      errorResponse, new HttpHeaders(), errorResponse.getHttpStatus());
	}
}
