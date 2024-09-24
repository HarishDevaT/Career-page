package com.harish.DataBase.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harish.DataBase.Entities.ApplicationEntity;
import com.harish.DataBase.Entities.ApplicationId;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationEntity,ApplicationId> {
 
}
