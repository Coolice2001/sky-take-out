package com.sky.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author：Coolice
 * @date：Created in 2024/9/20 13:02
 * @description：
 * @modified By：
 * @version:$
 */
@SuppressWarnings({"all"})
@Configuration
@Slf4j
public class RedisConfiguration {

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        log.info("开始创建redis模板对象...");
        RedisTemplate redisTemplate = new RedisTemplate();
        //设置redis的连接工厂对象。将传入的 RedisConnectionFactory 设置给 RedisTemplate。这样，RedisTemplate 就可以利用这个工厂来获取与 Redis 服务器的连接。
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //设置redis key的序列化容器
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
