package com.example.movieservice.repository;

import com.example.movieservice.entity.Movie;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT m.* FROM Movie m WHERE m.id = :id AND m.is_deleted = :isDeleted", nativeQuery = true)
    Movie findByIdAndIsDeleted(@Param("id") Long id, @Param("isDeleted") Boolean isDeleted);

}
