package com.abdelwaheb.examens.service;

import com.abdelwaheb.examens.entities.Role;
import com.abdelwaheb.examens.entities.User;

public interface UserService {
	void deleteAllusers();
	void deleteAllRoles();
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);


}
