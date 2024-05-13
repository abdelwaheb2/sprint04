package com.abdelwaheb.examens;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.abdelwaheb.examens.entities.Examen;
import com.abdelwaheb.examens.entities.Role;
import com.abdelwaheb.examens.entities.User;
import com.abdelwaheb.examens.service.ExamenService;
import com.abdelwaheb.examens.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class ExamensApplication implements CommandLineRunner  {
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired 
	UserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Password Encoded BCRYPT :******************** ");
		//System.out.println(passwordEncoder.encode("123"));
		repositoryRestConfiguration.exposeIdsFor(Examen.class);
	}
	
	/*@PostConstruct
	void init_users() {
	//ajouter les rôles
	userService.addRole(new Role(null,"ADMIN"));
	userService.addRole(new Role(null,"AGENT"));
	userService.addRole(new Role(null,"USER"));
	//ajouter les users
	userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"abdelwaheb","123",true,null));
	userService.saveUser(new User(null,"user1","123",true,null));
	//ajouter les rôles aux users
	userService.addRoleToUser("admin", "ADMIN");
	userService.addRoleToUser("abdelwaheb", "USER");
	userService.addRoleToUser("abdelwaheb", "AGENT");
	userService.addRoleToUser("user1", "USER");
	}*/


	
	@Autowired 
	ExamenService examenservice;

	public static void main(String[] args) {
		SpringApplication.run(ExamensApplication.class, args);
	}
	
	

}
