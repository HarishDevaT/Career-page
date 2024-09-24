package com.harish.DataBase.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.harish.DataBase.Entities.ApplicationEntity;
import com.harish.DataBase.Repository.ApplicationRepository;

@Service
public class AdminApplicationService {
	
	ApplicationRepository applicationRepo ;

	public List<ApplicationEntity> viewAllApplications() {
		 List<ApplicationEntity> applications = applicationRepo.findAll();
		 return applications ;
	}

	public String updateLevel(ApplicationEntity applicationEntity,String level) {
		Optional<ApplicationEntity> application = applicationRepo.findById(applicationEntity.getId());
		if(application!=null) {
			application.get().setLevel(level);
			applicationRepo.save(application.get()) ;
			application.get().setLastUpdateOn(LocalDate.now());
			return "Status Upgraded";
		}
		return "No Application Found" ;
	}

	public String rejectApplication(ApplicationEntity applicationEntity) {
		Optional<ApplicationEntity> application = applicationRepo.findById(applicationEntity.getId());
		if(application!=null) {
			application.get().setStatus("rejected");
			application.get().setLastUpdateOn(LocalDate.now());
			applicationRepo.save(application.get()) ;
			return "Application Rejected";
		}
		return "No Application Found" ;
	}

}
