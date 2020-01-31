package com.example.demo.security.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.security.model.ERole;
import com.example.demo.security.model.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
	Optional<Role> findByName(ERole name);
}