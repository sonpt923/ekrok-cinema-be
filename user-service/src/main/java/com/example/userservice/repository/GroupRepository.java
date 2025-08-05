package com.example.userservice.repository;

import com.example.userservice.entity.Group;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    Group findByCodeAndStatus(@Param("code") String code, @Param("status") Boolean status);

}
