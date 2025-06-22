package com.example.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.Permission;

@Repository
public interface PermissoinRepository extends JpaRepository<Permission, Long> {
}
