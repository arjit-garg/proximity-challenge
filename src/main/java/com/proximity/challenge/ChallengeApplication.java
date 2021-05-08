package com.proximity.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.proximity.challenge.model.Role;
import com.proximity.challenge.model.User;
import com.proximity.challenge.service.IService;

@SpringBootApplication
public class ChallengeApplication implements CommandLineRunner{
	
	@Autowired
	private IService<User> userService;
	@Autowired
	private IService<Role> roleService;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		roleService.saveOrUpdate(new Role(1L, "admin"));
		roleService.saveOrUpdate(new Role(2L, "user"));
		
		User user1 = new User();
		user1.setEmail("test@user.com");
		user1.setName("Test User");
		user1.setRole(roleService.findById(2L).get());
		user1.setPassword(new BCryptPasswordEncoder().encode("testuser"));
		userService.saveOrUpdate(user1);
		
		User user2 = new User();
		user2.setEmail("test@admin.com");
		user2.setName("Test Admin");
		user2.setRole(roleService.findById(1L).get());
		user2.setPassword(new BCryptPasswordEncoder().encode("testadmin"));
		userService.saveOrUpdate(user2);
	}
}
