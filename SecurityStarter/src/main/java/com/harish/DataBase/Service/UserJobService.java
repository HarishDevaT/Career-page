package com.harish.DataBase.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harish.DataBase.Entities.ApplicationEntity;
import com.harish.DataBase.Entities.ApplicationId;
import com.harish.DataBase.Entities.JobEntity;
import com.harish.DataBase.Entities.UserEntity;
import com.harish.DataBase.Repository.ApplicationRepository;
import com.harish.DataBase.Repository.JobsRepository;
import com.harish.DataBase.Repository.UserRepository;

@Service
public class UserJobService {
	
	@Autowired
	UserRepository userRepo ;
	
	@Autowired 
	JobsRepository jobsRepo ;

	@Autowired
	JWTService jwtService ;
	
	@Autowired
    ApplicationRepository applicationRepo ;
	
	public String applyJob(int jobId) {
		Optional<UserEntity> userDetails = Optional.ofNullable(userRepo.findByUserName("deva"));
		Optional<JobEntity> jobDetails = jobsRepo.findById(jobId);
		if(userDetails==null||jobDetails==null)return "Failed To Apply" ;
		ApplicationEntity application = new ApplicationEntity(userDetails.get(),jobDetails.get(),"Applied","Ongoing",LocalDate.now(),LocalDate.now());
		applicationRepo.save(application);
		return "Job Applied" ;
	}

	public ApplicationEntity viewJob(int jobId) {
		Optional<UserEntity> userDetails = Optional.ofNullable(userRepo.findByUserName("deva"));
		ApplicationId applicationId = new ApplicationId(userDetails.get().getId(),jobId) ;
		Optional<ApplicationEntity> application = applicationRepo.findById(applicationId);
		if(application==null)return null;
		return application.get();
    }

	public List<ApplicationEntity> viewAllJob() {
		return applicationRepo.findAll();
	}

	
}
