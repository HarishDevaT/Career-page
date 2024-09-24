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
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200/")
public class LoginController {

	@Autowired
	UserService userService ;
		
	@PostMapping
	@ResponseBody JSONObject login(@RequestBody UserEntity userEntity) {
		Map<String,String> hmap = new HashMap<>();
		hmap.put("token",userService.verify(userEntity));
		JSONObject jsonObject= new JSONObject(hmap);
		return jsonObject ;
	}
	
}
