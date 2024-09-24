package com.harish.DataBase.Service;

import com.harish.DataBase.Dto.UserDto;
import com.harish.DataBase.Entities.UserEntity;

public interface UserServiceInterface {

	//UserDto addUser(UserDto userDto) throws Exception;
	//UserDto getUser(UserDto userDto);

	UserEntity addUser(UserEntity userEntity) throws Exception;
}
