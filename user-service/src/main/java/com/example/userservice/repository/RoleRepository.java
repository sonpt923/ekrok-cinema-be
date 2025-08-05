package com.example.userservice.repository;

import com.example.userservice.entity.Role;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByCodeAndIsDeleted(@Param("code") String code,@Param("isDeleted") Boolean isDeleted);

}
