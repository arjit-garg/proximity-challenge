package com.proximity.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proximity.challenge.model.Course;
import com.proximity.challenge.model.Webinar;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

}
