package com.harish.DataBase.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harish.DataBase.Entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findByUserName(String username);

}
