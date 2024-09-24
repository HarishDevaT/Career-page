package com.harish.DataBase.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.harish.DataBase.Dto.UserDto;
import com.harish.DataBase.Entities.UserEntity;
import com.harish.DataBase.Service.UserService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/signup")
@CrossOrigin(origins = "http://localhost:4200/")
public class SignUpController {

	@Autowired
	UserService userService ;
	
	@Autowired
	LoginController loginController ;
	
	@PostMapping
	@ResponseBody JSONObject addUser(@RequestBody UserEntity userEntity) {
		final String password = userEntity.getPassword();
		Map<String,String> hmap = new HashMap<>();
		JSONObject jsonObject ;
		try {
			userService.addUser(userEntity);
		}
		catch(Exception e) {
			hmap.put("status","error occured");
			jsonObject= new JSONObject(hmap);
			return jsonObject ;
		}
		hmap.put("status","user added");
		jsonObject= new JSONObject(hmap);
		return jsonObject;
	}
}
