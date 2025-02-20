package com.example.recommendationservice.repository;

import com.example.recommendationservice.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissoinRepository extends JpaRepository<Permission, Long> {
}
