package com.abdelwaheb.examens.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abdelwaheb.examens.entities.User;
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername (String username);
}
