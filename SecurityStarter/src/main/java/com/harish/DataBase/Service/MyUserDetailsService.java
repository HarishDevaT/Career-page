package com.harish.DataBase.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.harish.DataBase.Dto.UserDto;
import com.harish.DataBase.Entities.UserEntity;
import com.harish.DataBase.Entities.UserPrincipal;
import com.harish.DataBase.Mapper.UserMapper;
import com.harish.DataBase.Repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository repo;
	
//	@Autowired
//	UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user = repo.findByUserName(username);
		
//		UserDto userdto = userMapper.mapToUserDto(user);
//		System.out.println(userdto.getPassword());
		
		if(user==null) {
			System.out.println("User Not Found");
			throw new UsernameNotFoundException("UserNotFound");
		}
		
		
		return new UserPrincipal(user) ;
	}

}
