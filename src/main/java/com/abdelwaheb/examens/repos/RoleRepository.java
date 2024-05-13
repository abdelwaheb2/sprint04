package com.abdelwaheb.examens.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abdelwaheb.examens.entities.Role;
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}
