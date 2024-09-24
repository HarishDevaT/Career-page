package com.harish.DataBase.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harish.DataBase.Entities.JobEntity;

@Repository
public interface JobsRepository extends JpaRepository<JobEntity,Integer> {

}
