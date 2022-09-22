package com.example.Project.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Project.entity.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Long> {
  
	// Log-in
	@Query(value = "select * from user where username = :username and password = :password",nativeQuery = true)
	Optional<UserEntity> findByUsernameAndPassword(String username,String password);
	
	// forgot password
	Optional<UserEntity> findByUseremail(String useremail);

	Optional<UserEntity> findById(Long user_id);
    
	
}
