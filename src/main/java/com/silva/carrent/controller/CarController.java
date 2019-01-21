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

	@RequestMapping(value="/cars", method = RequestMethod.GET)
	public List<Car> getCars() {
		return service.getCars();
	}
	
	@RequestMapping(value = "/cars/{id}", method = RequestMethod.GET)
	public Car getCar(@PathVariable("id") String carId) {
		return service.getCar(carId);
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public User login(@RequestParam("username") String username, 
			@RequestParam("password") String password) throws UserNotLoggedInException {
		User user = service.checkCredentials(username, password);
		if(user == null){
			throw new UserNotLoggedInException();
		}
		return user;
	}
	
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
	
	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleException(Exception exception){
		ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
		return new ResponseEntity<Object>(
			      errorResponse, new HttpHeaders(), errorResponse.getHttpStatus());
	}
}
