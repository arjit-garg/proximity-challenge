package com.proximity.challenge.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.proximity.challenge.model.Course;
import com.proximity.challenge.model.Subject;
import com.proximity.challenge.model.Tag;
import com.proximity.challenge.model.Video;
import com.proximity.challenge.model.Webinar;
import com.proximity.challenge.service.impl.FileUploadService;

@RestController
public class FileUploadController {
	
	@Autowired
	FileUploadService fileUploadService;
	
	@RequestMapping("/webinar/{title}")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public List<Webinar> getWebinar(@PathVariable String title) {
		return fileUploadService.getWebinarByTitle(title);
		
	}
	
	@RequestMapping("/video/{title}")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public List<Video> getVideo(@PathVariable String title) {
		return fileUploadService.getVideoByTitle(title);
		
	}
	
	@RequestMapping("/webinar")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public List<Webinar> getAllWebinar() {
		return fileUploadService.getAllWebinar();
		
	}
	
	@RequestMapping("/video")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public List<Video> getAllVideo() {
		return fileUploadService.getAllVideo();
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/uploadVideo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void uploadVideo(@RequestParam("file") MultipartFile file) throws IOException {
			fileUploadService.uploadVideoFile(file);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/uploadWebinar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void uploadWebinar(@RequestParam("file") MultipartFile file) throws IOException {
		
			fileUploadService.uploadFile(file);
		
	}
	
	
	@GetMapping("/viewWebinar/{fileId}")
	public ResponseEntity<ByteArrayResource> viewWebinarFile(@PathVariable Integer fileId){
		Webinar webinar = fileUploadService.getWebinar(fileId).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(webinar.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+webinar.getWebinarTitle()+"\"")
				.body(new ByteArrayResource(webinar.getContent()));
	}
	
	@GetMapping("/viewVideo/{fileId}")
	public ResponseEntity<ByteArrayResource> viewVideoFile(@PathVariable Integer fileId){
		Video video = fileUploadService.getVideo(fileId).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(video.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+video.getVideoTitle()+"\"")
				.body(new ByteArrayResource(video.getContent()));
	}
	

	
	@RequestMapping("/subject")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public List<Subject> getAllSubjects() {
        return fileUploadService.getAllSubjects();
    }

    @RequestMapping("/subject/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public Optional<Subject> getSubject(@PathVariable Integer id){
        return fileUploadService.getSubject(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/subject")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Subject> addSubject(@Valid @RequestBody Subject subject){
        Subject sub = fileUploadService.addSubject(subject);
        return new ResponseEntity(sub, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/subject/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateSubject(@RequestBody Subject check, @PathVariable Integer id){
    	fileUploadService.updateSubject(id, check);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/subject/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteSubject(@PathVariable Integer id){
    	fileUploadService.deleteSubject(id);
    }
	
    @RequestMapping("/course")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public List<Course> getAllCourses() {
        return fileUploadService.getAllCourses();
    }

    @RequestMapping("/course/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public Optional<Course> getCourse(@PathVariable Integer id){
        return fileUploadService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/course")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Course> addCourse(@Valid @RequestBody Course course){
        Course sub = fileUploadService.addCourse(course);
        return new ResponseEntity(sub, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/course/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateCourse(@RequestBody Course check, @PathVariable Integer id){
    	fileUploadService.updateCourse(id, check);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/course/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteCourse(@PathVariable Integer id){
    	fileUploadService.deleteCourse(id);
    }
	
	
	
	@RequestMapping("/tag")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public List<Tag> getAllTags() {
        return fileUploadService.getAllTags();
    }

    @RequestMapping("/tag/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public Optional<Tag> getTag(@PathVariable Integer id){
        return fileUploadService.getTag(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/tag")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Tag> addTag(@Valid @RequestBody Tag tag){
        Tag sub = fileUploadService.addTag(tag);
        return new ResponseEntity(sub, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/tag/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateTag(@RequestBody Tag check, @PathVariable Integer id){
    	fileUploadService.updateTag(id, check);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/tag/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteTag(@PathVariable Integer id){
    	fileUploadService.deleteTag(id);
    }
	
}
