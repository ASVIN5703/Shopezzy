package com.dev.Shopezzy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.Shopezzy.model.UserModel;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
	
	Optional<UserModel> findOneByEmailAndPassword(String email, String password);
	
	UserModel findByEmail(String email);

}
