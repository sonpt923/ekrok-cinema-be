package com.example.recommendationservice.entity.redisCache;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash(value = "user-session")
public class TokenCache {

    @Id
    @Indexed
    private String id;

    @TimeToLive
    private Long timeToLive;

    private String value;

}
