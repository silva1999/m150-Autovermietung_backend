/**
 * @author 	Leandro Silva
 * @date 	21.01.2019
 * @version	1.0
 * 
 * 
 * Test class
 */
package com.silva.carrent.db;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class DAOUserTest {
	
	private DAOUser underTest = new DAOUser();
	
	@Test
	@Ignore
	public void getUserByUsername_shouldReturnUserInfo(){
		UserEntity userEntity = underTest.getUserByUsername("max99");
		Assert.assertTrue(userEntity != null);
	}
	
	@Test
	@Ignore
	public void getUserByUsername_shouldReturnNull(){
		UserEntity userEntity = underTest.getUserByUsername("unknown");
		Assert.assertTrue(userEntity == null);
	}
	
	@Test
	@Ignore
	public void getUserById_shouldReturnUserInfo(){
		UserEntity userEntity = underTest.getUserByUserId("okaybeh22");
		Assert.assertTrue(userEntity != null);
	}
	
	@Test
	@Ignore
	public void getUserById_shouldReturnNull(){
		UserEntity userEntity = underTest.getUserByUserId("unknown");
		Assert.assertTrue(userEntity == null);
	}
	
	@Test
	@Ignore
	public void update_shouldUpdateUserInfo(){
		UserEntity userEntity = underTest.getUserByUsername("max99");
		Assert.assertTrue(userEntity != null);
		
		String old = userEntity.getPayments();
		userEntity.setPayments("1000");
		underTest.update(userEntity);
		
		userEntity = underTest.getUserByUsername("max99");
		Assert.assertTrue(userEntity != null);
		Assert.assertTrue(userEntity.getPayments() != old);
		
	}

}
