package com.example.userservice.repository;

import com.example.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u.* FROM User u WHERE u.username = :username OR u.email = :username ", nativeQuery = true)
    User findUserByUsernameOrEmail(@Param("username") String username);

    @Query(value = "SELECT u.* FROM User u WHERE u.username =:username ", nativeQuery = true)
    User findUserByUsername(@Param("username") String username);

    @Query(value = "SELECT u.* FROM User u WHERE u.phone =:phone", nativeQuery = true)
    User findUserByPhone(@Param("phone") String phone);


}
