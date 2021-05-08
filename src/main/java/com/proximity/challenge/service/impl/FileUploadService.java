package com.proximity.challenge.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.proximity.challenge.model.Course;
import com.proximity.challenge.model.Subject;
import com.proximity.challenge.model.Tag;
import com.proximity.challenge.model.Video;
import com.proximity.challenge.model.Webinar;
import com.proximity.challenge.repository.CourseRepository;
import com.proximity.challenge.repository.SubjectRepository;
import com.proximity.challenge.repository.TagRepository;
import com.proximity.challenge.repository.VideoRepository;
import com.proximity.challenge.repository.WebinarRepository;

@Service
public class FileUploadService {
	
	@Autowired
	WebinarRepository webniarRepository;
	
	@Autowired
	VideoRepository videoRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	TagRepository tagRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	
	
	public Webinar uploadFile(MultipartFile file) throws IOException {
		String docName = file.getOriginalFilename();
		
		Webinar web = new Webinar(docName, file.getContentType(), file.getBytes(), file.getSize(), new Date().getTime());
		
		return webniarRepository.save(web);
	}
	
	public Optional<Webinar> getWebinar(Integer id){
		return webniarRepository.findById(id);
	}
	
	public List<Webinar> getWebinarByTitle(String title){
		return webniarRepository.findByWebinarTitle(title);
	}
	
	public List<Webinar> getAllWebinar(){
		return webniarRepository.findAll();
	}
	
	public Video uploadVideoFile(MultipartFile file) throws IOException {
		String docName = file.getOriginalFilename();
		
		Video web = new Video(docName, file.getContentType(), file.getBytes(), file.getSize(), new Date().getTime());
		
		return videoRepository.save(web);
	}
	
	public Optional<Video> getVideo(Integer id){
		return videoRepository.findById(id);
	}
	
	public List<Video> getAllVideo(){
		return videoRepository.findAll();
	}
	
	public List<Video> getVideoByTitle(String title){
		return videoRepository.findByVideoTitle(title);
	}
	
	public void fileUpload(MultipartFile file) throws IllegalStateException, IOException {
		file.transferTo(new File("C:\\Users\\arjit_Garg\\WorkSpace\\"+file.getOriginalFilename()));
		
	}

	public List<Subject> getAllSubjects() {
		// TODO Auto-generated method stub
		return subjectRepository.findAll();
	}

	public Optional<Subject> getSubject(Integer id) {
		// TODO Auto-generated method stub
		return subjectRepository.findById(id);
	}

	public Subject addSubject(@Valid Subject subject) {
		// TODO Auto-generated method stub
		return subjectRepository.save(subject);
	}

	public void updateSubject(Integer id, Subject check) {
		// TODO Auto-generated method stub
		if(subjectRepository.findById(id).isPresent()) {
			subjectRepository.save(check);
		}
		
	}

	public void deleteSubject(Integer id) {
		// TODO Auto-generated method stub
		subjectRepository.deleteById(id);
	}
	
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	public Optional<Course> getCourse(Integer id) {
		// TODO Auto-generated method stub
		return courseRepository.findById(id);
	}

	public Course addCourse(@Valid Course course) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	public void updateCourse(Integer id, Course check) {
		// TODO Auto-generated method stub
		if(courseRepository.findById(id).isPresent()) {
			courseRepository.save(check);
		}
		
	}

	public void deleteCourse(Integer id) {
		// TODO Auto-generated method stub
		courseRepository.deleteById(id);
	}
	
	
	public List<Tag> getAllTags() {
		// TODO Auto-generated method stub
		return tagRepository.findAll();
	}

	public Optional<Tag> getTag(Integer id) {
		// TODO Auto-generated method stub
		return tagRepository.findById(id);
	}

	public Tag addTag(@Valid Tag tag) {
		// TODO Auto-generated method stub
		return tagRepository.save(tag);
	}

	public void updateTag(Integer id, Tag check) {
		// TODO Auto-generated method stub
		if(tagRepository.findById(id).isPresent()) {
			tagRepository.save(check);
		}
		
	}

	public void deleteTag(Integer id) {
		// TODO Auto-generated method stub
		tagRepository.deleteById(id);
	}
	





}
