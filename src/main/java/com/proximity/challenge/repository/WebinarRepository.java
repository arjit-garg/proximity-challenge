package com.proximity.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proximity.challenge.model.Webinar;

@Repository
public interface WebinarRepository extends JpaRepository<Webinar, Integer>{
	
	
	public List<Webinar> findByWebinarTitle(String webinarTitle);

}
