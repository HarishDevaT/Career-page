package com.harish.DataBase.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harish.DataBase.Entities.ApplicationEntity;
import com.harish.DataBase.Service.AdminApplicationService;

@RestController
@RequestMapping("/admin/job/")
public class AdminApplicationController {
	
	@Autowired
	AdminApplicationService adminApplicationService ;

	@GetMapping("applications")
	List<ApplicationEntity> viewAllApplications() {
		return adminApplicationService.viewAllApplications();
	}
	
	@PutMapping("application/update")
	String updateLevel(@RequestBody ApplicationEntity applicationEntity,String level) {
		return adminApplicationService.updateLevel(applicationEntity,level);
	}
	
	@PutMapping("application/reject")
	String rejectApplication(@RequestBody ApplicationEntity applicationEntity) {
		return adminApplicationService.rejectApplication(applicationEntity);
	}
	
}
