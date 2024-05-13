package com.abdelwaheb.examens.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abdelwaheb.examens.entities.Role;
import com.abdelwaheb.examens.entities.User;
import com.abdelwaheb.examens.repos.RoleRepository;
import com.abdelwaheb.examens.repos.UserRepository;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRep;
	@Autowired
	RoleRepository roleRep;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRep.save(user);
	}

	
	public User addRoleToUser(String username, String rolename) {
		User usr = userRep.findByUsername(username);
		Role r = roleRep.findByRole(rolename);
		usr.getRoles().add(r);
		return usr;
	}

	
	public void deleteAllusers() {
		userRep.deleteAll();
	}

	
	public void deleteAllRoles() {
		roleRep.deleteAll();
	}

	
	public Role addRole(Role role) {
		return roleRep.save(role);
	}

	
	public User findUserByUsername(String username) {
		return userRep.findByUsername(username);
	}
}
