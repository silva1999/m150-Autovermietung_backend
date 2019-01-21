package com.silva.carrent.db;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class DAORentTest {
	
	private DAORent underTest = new DAORent();
	
	@Test
	//@Ignore
	public void rentCar_shouldSaveEntry(){
		underTest.rentCar("10.01.2019", "11.01.2019", "okebeh999", 1);
	}
	
	@Test
	@Ignore
	public void getBookingForCar_shouldGetEntry(){
		List<RentEntity> restEntryList = underTest.getBookingForCar(1);
		Assert.assertTrue(!restEntryList.isEmpty());
	}

}
