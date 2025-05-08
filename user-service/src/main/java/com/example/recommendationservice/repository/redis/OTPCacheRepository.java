package com.example.recommendationservice.repository.redis;

import com.example.recommendationservice.entity.redisCache.OTPCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OTPCacheRepository extends CrudRepository<OTPCache, String> {
}
