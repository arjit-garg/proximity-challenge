package com.proximity.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proximity.challenge.model.Video;
import com.proximity.challenge.model.Webinar;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer>{
	
	public List<Video> findByVideoTitle(String videoTitle);

}
