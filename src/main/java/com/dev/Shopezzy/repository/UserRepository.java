package com.dev.Shopezzy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.Shopezzy.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
	

}
