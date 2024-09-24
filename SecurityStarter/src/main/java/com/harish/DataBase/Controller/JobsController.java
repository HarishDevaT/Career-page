package com.harish.DataBase.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harish.DataBase.Entities.JobEntity;
import com.harish.DataBase.Service.JobsService;

@RestController
@RequestMapping("/jobs")
public class JobsController {

	@Autowired
	JobsService jobsService ;
	
	@GetMapping
	List<JobEntity> getJobs(){
		 List<JobEntity>  jobsPosted = jobsService.getJobs(); 
		return jobsPosted ;
		
	}
	
	@GetMapping("/")
	Optional<JobEntity> getParticularJob(@RequestParam("id") String jobId){
		 return jobsService.getJobWithId(Integer.parseInt(jobId)); 
	}
	
}
