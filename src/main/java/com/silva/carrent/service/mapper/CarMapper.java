/**
 * @author 	Leandro Silva
 * @date 	21.01.2019
 * @version	1.0
 * 
 * Class maps entity class to response class
 */
package com.silva.carrent.service.mapper;

import java.util.ArrayList;
import java.util.List;

import com.silva.carrent.db.CarEntity;
import com.silva.carrent.model.Car;

public class CarMapper {
	
	/**
	 * Maps to response class
	 * @param carEntity
	 * @return car
	 */
	public static Car mapToCar(CarEntity carEntity){
		if(carEntity == null){
			return null;
		}
		Car car = new Car();
		car.setId(carEntity.getId());
		car.setName(carEntity.getName());
		car.setSpecification(carEntity.getSpecification());
		car.setPlace(carEntity.getPlace());
		car.setPrice(carEntity.getPrice());
		return car;
	}
	
	/**
	 * Maps to response class
	 * @param carEntityList
	 * @return carList
	 */
	public static List<Car> mapToCarList(List<CarEntity> carEntityList){
		List<Car> carList = new ArrayList<>();
		if(carEntityList == null || carEntityList.isEmpty()){
			return carList;
		}
		for(CarEntity carEntity : carEntityList){
			carList.add(mapToCar(carEntity));
		}
		return carList;
	}

}
