package com.silva.carrent.db;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class DAOCarTest {
	
	private DAOCar underTest = new DAOCar();
	
	@Test
	@Ignore
	public void getCarList_shouldReturnList(){
		List<CarEntity> carList = underTest.getCarList();
		Assert.assertTrue(!carList.isEmpty());
	}
	
	@Test
	@Ignore
	public void getCarById_shouldReturnCar(){
		List<CarEntity> carList = underTest.getCarList();
		Assert.assertTrue(!carList.isEmpty());
		
		CarEntity car = underTest.getCarById(carList.get(0).getId());
		Assert.assertTrue(car != null);
	}
	
	@Test
	@Ignore
	public void getCarById_shouldReturnNull(){
		CarEntity car = underTest.getCarById(0);
		Assert.assertTrue(car == null);
	}

}
