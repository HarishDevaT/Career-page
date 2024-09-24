package com.harish.DataBase.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harish.DataBase.Dto.JobDto;
import com.harish.DataBase.Entities.ApplicationEntity;
import com.harish.DataBase.Entities.JobEntity;
import com.harish.DataBase.Mapper.JobsMapper;
import com.harish.DataBase.Repository.JobsRepository;

@Service
public class JobsService {
	
	@Autowired
	JobsRepository jobsRepo ;
	
	@Autowired
	JobsMapper jobsMapper ;

	public List<JobEntity> getJobs() {
		List<JobEntity>  postedJobs = jobsRepo.findAll();
		return postedJobs ;
	}
	
	public Optional<JobEntity> getJobWithId(Integer jobId) {
		Optional<JobEntity> jobDetails = jobsRepo.findById(jobId);
		return jobDetails ;
	}

	public String addJob(JobEntity jobEntity) {
		JobEntity savedJob = jobsRepo.save(jobEntity);
		return "Job added";
	}
	
	public String deleteJob(int jobId) {
		jobsRepo.deleteById(jobId);
		return "Job Deleted";
	}

	
}
