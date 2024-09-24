package com.harish.DataBase.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harish.DataBase.Entities.ApplicationEntity;
import com.harish.DataBase.Service.UserJobService;

@RestController
@RequestMapping("/user/job")
public class UserJobApplicationController {

	@Autowired
	UserJobService userJobsService ;
	
	@PostMapping("/apply")
	String applyJob(@RequestParam("id") String jobId) {
		return userJobsService.applyJob(Integer.parseInt(jobId)) ;
	}
	
	@GetMapping("/applied/**")
	ApplicationEntity viewJob(@RequestParam("id") String jobId) {
		return userJobsService.viewJob(Integer.parseInt(jobId)) ;
	}
	
	@GetMapping("/applied")
	List<ApplicationEntity> viewAllJob() {
		return userJobsService.viewAllJob() ;
	}
	
}

