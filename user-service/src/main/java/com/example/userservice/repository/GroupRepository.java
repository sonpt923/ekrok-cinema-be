package com.example.userservice.repository;

import com.example.userservice.entity.Group;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    Group findByCodeAndStatus(@Param("code") String code, @Param("status") Boolean status);

    @Query(value = "SELECT gr.* FROM group gr WHERE gr.code = :code AND gr.is_deleted = :isDeleted", nativeQuery = true)
    Group findByCodeAndIsDeleted(@Param("code") String code, @Param("isDeleted") Boolean isDeleted);

    @Query(value = "SELECT gr.* FROM group gr INNER JOIN group_user gu ON gr.id = gu.group_id INNER JOIN User u ON gu.user_id = u.id" +
            " WHERE u.username = :username AND gr.is_deleted = :isDeleted", nativeQuery = true)
    List<Group> findByUsername(String username, Boolean isDeleted);

}
