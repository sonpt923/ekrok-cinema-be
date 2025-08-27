package com.example.subcriptionservice.repository;

import com.example.subcriptionservice.entity.Subcription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcriptionRepository extends JpaRepository<Subcription, Long> {
}
