package com.example.paymentservice.repository;

import com.example.paymentservice.entity.ChairType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChairTypeRepository extends JpaRepository<ChairType, Long> {
}
