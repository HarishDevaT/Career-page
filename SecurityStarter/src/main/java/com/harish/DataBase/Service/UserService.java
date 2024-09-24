package com.harish.DataBase.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.harish.DataBase.Dto.UserDto;
import com.harish.DataBase.Entities.UserEntity;
import com.harish.DataBase.Mapper.UserMapper;
import com.harish.DataBase.Repository.UserRepository;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	AuthenticationManager authManager ;
	
	@Autowired
	UserRepository repo ;
	
	@Autowired
	private JWTService jwtService ;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
	
	@Override
	public UserEntity addUser(UserEntity userEntity) throws Exception {
		userEntity.setPassword(encoder.encode(userEntity.getPassword()));
		UserEntity savedUser ;
		try {
			savedUser = repo.save(userEntity);
		}
	    catch(Exception e) {
	    	 throw new Exception(e);
	     }
		return userEntity;
	}

	public String verify(UserEntity userEntity) {
		Authentication authentication = 
				authManager.authenticate(new UsernamePasswordAuthenticationToken(userEntity.getUserName(),userEntity.getPassword()));
		if(authentication.isAuthenticated())
			return jwtService.generateToken(userEntity.getUserName()) ;
		return "Fauiler";
	}
	
}
