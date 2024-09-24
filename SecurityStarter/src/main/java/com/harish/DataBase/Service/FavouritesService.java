package com.harish.DataBase.Service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harish.DataBase.Entities.JobEntity;
import com.harish.DataBase.Entities.UserEntity;
import com.harish.DataBase.Repository.JobsRepository;
import com.harish.DataBase.Repository.UserRepository;

@Service
public class FavouritesService {

	@Autowired
	UserRepository userRepo ;
	
	@Autowired 
	JobsRepository jobsRepo ;
	
	@Autowired
	JWTService jwtService ;
	
	public String addFavourites(Integer jobId) {
		Optional<JobEntity> jobDetails = jobsRepo.findById(jobId);
		Optional<UserEntity> userDetails = Optional.ofNullable(userRepo.findByUserName("deva"));
		if(userDetails==null||jobDetails==null)return "Failed To Add Favourites" ;
		userDetails.get().getFavourites().add(jobDetails.get());
		jobDetails.get().getFavouritedUsers().add(userDetails.get());
		userRepo.save(userDetails.get());
		return "Added To Favourites";
	}

	public Set<JobEntity> getFavourites() {
		Optional<UserEntity> userDetails = Optional.ofNullable(userRepo.findByUserName("deva"));
		if(userDetails==null)return null ;
		return userDetails.get().getFavourites() ;
		
	}
	
	public String removeFavourites(int jobId) {

		Optional<UserEntity> userDetails = Optional.ofNullable(userRepo.findByUserName("deva"));
		if(userDetails==null)return "No Users Found" ;
		Optional<JobEntity> jobDetails = jobsRepo.findById(jobId);
		userDetails.get().getFavourites().remove(jobDetails.get());
		userRepo.save(userDetails.get());
		
		return "Favourites Removed" ;
	}
}
