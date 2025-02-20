package com.example.recommendationservice.repository.redis;

import com.example.recommendationservice.entity.redisCache.SecurityCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenCacheRepository extends CrudRepository<SecurityCache, String> {
}
