package com.silva.carrent.service;

import java.util.List;

import com.silva.carrent.db.DAOCar;
import com.silva.carrent.db.DAORent;
import com.silva.carrent.db.DAOUser;
import com.silva.carrent.db.UserEntity;
import com.silva.carrent.model.Car;
import com.silva.carrent.model.User;
import com.silva.carrent.service.mapper.CarMapper;
import com.silva.carrent.service.mapper.RentMapper;
import com.silva.carrent.service.mapper.UserMapper;

public class CarrentServiceImpl implements CarrentService{
	
	private DAOCar daoCar = new DAOCar();
	private DAOUser daoUser = new DAOUser();
	private DAORent daoRent = new DAORent();

	@Override
	public List<Car> getCars() {
		return CarMapper.mapToCarList(daoCar.getCarList());
	}

	@Override
	public Car getCar(String carId) {
		return CarMapper.mapToCar(daoCar.getCarById(Integer.valueOf(carId)));
	}

	@Override
	public User checkCredentials(String username, String password) {
		UserEntity userEntity = daoUser.getUserByUsername(username);
		if(userEntity == null || !userEntity.getPassword().equals(password)){
			return null;
		}
		return UserMapper.mapToUser(userEntity);
	}

	@Override
	public RentCarStatus rentCar(String carId, String userId, String startDate, String endDate) {
		UserEntity userEntity = daoUser.getUserByUserId(userId);
		Car car = getCar(carId);
		if(userEntity == null){
			return RentCarStatus.USER_NOT_LOGGED_IN;
		}
		if(car == null){
			return RentCarStatus.INVALID_INPUT;
		}
		RentCarStatus status = RentMapper.mapToStatus(daoRent.getBookingForCar(Integer.valueOf(carId)),
				startDate,endDate);
		if(status.equals(RentCarStatus.OK)){
			userEntity = calculateMoney(userEntity, car);
			if(!userHasEnoughMoney(userEntity)){
				return RentCarStatus.NOT_ENOUGH_MONEY;
			}
			daoUser.update(userEntity);
			daoRent.rentCar(startDate, endDate, userId, Integer.valueOf(carId));
		}
		return status;
	}
	
	private UserEntity calculateMoney(UserEntity userEntity, Car car){
		Integer payments = Integer.valueOf(userEntity.getPayments());
		Integer price = Integer.valueOf(car.getPrice());
		
		payments = payments + price;
		userEntity.setPayments(String.valueOf(payments));
		return userEntity;
	}
	
	private boolean userHasEnoughMoney(UserEntity userEntity){
		Integer limit = Integer.valueOf(userEntity.getLimit());
		Integer payments = Integer.valueOf(userEntity.getPayments());
		if(payments > limit){
			return false;
		}
		return true;
	}

}
