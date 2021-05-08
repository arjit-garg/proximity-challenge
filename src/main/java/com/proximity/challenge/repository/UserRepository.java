package com.proximity.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proximity.challenge.model.User;
import com.proximity.challenge.model.Video;
import com.proximity.challenge.model.Webinar;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("FROM User WHERE email=:email")
	User findByEmail(@Param("email") String email);

}
