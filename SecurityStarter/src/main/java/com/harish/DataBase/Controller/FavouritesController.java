package com.harish.DataBase.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harish.DataBase.Entities.JobEntity;
import com.harish.DataBase.Service.FavouritesService;

@RestController
@RequestMapping("users/favourites")
public class FavouritesController {
	
	@Autowired
	FavouritesService favService ;

	@GetMapping
	Set<JobEntity> getFavourites(){
		Set<JobEntity> e = favService.getFavourites() ;
		for(JobEntity i : e) {
			System.out.println(i.getTitle());
		}
		return favService.getFavourites() ;
	}
	
	@PostMapping
	String addFavourites(@RequestParam("id") String jobId) {
		return favService.addFavourites(Integer.parseInt(jobId));
	}
	
	@DeleteMapping
	String removeFavourites(@RequestParam("id") String jobId) {
		return favService.addFavourites(Integer.parseInt(jobId));
	}
}
