/**
 * @author 	Leandro Silva
 * @date 	21.01.2019
 * @version	1.0
 * 
 * Class maps entity class to response class
 */
package com.silva.carrent.service.mapper;

import com.silva.carrent.db.UserEntity;
import com.silva.carrent.model.User;

public class UserMapper {
	
	/**
	 * Map to response class
	 * @param userEntity
	 * @return user
	 */
	public static User mapToUser(UserEntity userEntity){
		if(userEntity == null){
			return null;
		}
		return new User(userEntity.getUserId(),
				userEntity.getUsername());
	}

}
