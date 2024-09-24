package com.harish.DataBase.Mapper;

import org.springframework.stereotype.Component;

import com.harish.DataBase.Dto.UserDto;
import com.harish.DataBase.Entities.UserEntity;

@Component
public class UserMapper {

	public UserDto mapToUserDto(UserEntity userEntity) {
		UserDto userDto = new UserDto(userEntity.getId(),userEntity.getUserName(),userEntity.getPassword(),userEntity.getEmail() , userEntity.getPhoneNumber(),userEntity.getFavourites());
		return userDto ;
	}
	
	public UserEntity mapToUserEntity(UserDto userDto) {
		UserEntity userEntity = new UserEntity(userDto.getId(),userDto.getUserName(),userDto.getPassword(),userDto.getEmail(),userDto.getPhoneNumber(),userDto.getFavourites());
		return userEntity ;
	}
	
}
