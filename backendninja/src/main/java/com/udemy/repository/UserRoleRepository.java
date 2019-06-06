package com.udemy.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.entity.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Serializable>{

}
