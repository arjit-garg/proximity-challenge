package com.proximity.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proximity.challenge.model.Tag;
import com.proximity.challenge.model.Webinar;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer>{

}
