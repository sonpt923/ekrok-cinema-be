package com.example.userservice.repository;

import com.example.userservice.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupUserRepository extends JpaRepository<Group, Long> {
}
