package com.example.core.config;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@PropertySource("classpath:application.yaml")
public class RedisConfig {

    @Value("${spring.data.redis.host}")
    private String host;

    @Value("${spring.data.redis.port}")
    private Integer port;

    @Value("${spring.data.redis.password}")
    private String password;

    @Value("${spring.data.redis.username}")
    private String username;

    @Value("${spring.data.redis.havePassword}")
    private String havePassword;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory redisConnection = new JedisConnectionFactory();
        redisConnection.setHostName(host);
        redisConnection.setPort(port);
        redisConnection.setClientName(username);
        if (havePassword.equals("YES")) {
            redisConnection.setPassword(new String(Base64.decodeBase64(password)));
        }
        return redisConnection;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        return template;
    }

}
