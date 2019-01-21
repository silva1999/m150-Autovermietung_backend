package com.silva.carrent.service.mapper;

import com.silva.carrent.db.UserEntity;
import com.silva.carrent.model.User;

public class UserMapper {
	
	public static User mapToUser(UserEntity userEntity){
		if(userEntity == null){
			return null;
		}
		return new User(userEntity.getUserId(),
				userEntity.getUsername());
	}

}
