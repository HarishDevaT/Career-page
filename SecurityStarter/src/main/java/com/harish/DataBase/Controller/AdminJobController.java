package com.harish.DataBase.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harish.DataBase.Entities.JobEntity;
import com.harish.DataBase.Service.JobsService;

@RestController
@RequestMapping("/admin/job")
public class AdminJobController {

	@Autowired
	JobsService jobsService ;
	
	@PostMapping("/add")
	String addJob(JobEntity jobEntity){
		return jobsService.addJob(jobEntity);
	}
	
	@DeleteMapping("/delete/**")
	String deleteJob(@RequestParam("id") String jobId) {
		if(jobId==null)return "Id must not be null";
		return jobsService.deleteJob(Integer.parseInt(jobId));
	}
	
    
	
	
	
}
