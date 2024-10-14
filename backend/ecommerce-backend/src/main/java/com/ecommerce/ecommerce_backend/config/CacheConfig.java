// package com.ecommerce.ecommerce_backend.config;

// import org.springframework.cache.annotation.EnableCaching;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.redis.cache.RedisCacheConfiguration;
// import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
// import org.springframework.data.redis.connection.RedisConnectionFactory;
// import org.springframework.data.redis.core.RedisTemplate;
// import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
// import org.springframework.data.redis.serializer.StringRedisSerializer;

// @Configuration
// @EnableCaching
// public class CacheConfig {

//     @Bean
//     public RedisConnectionFactory redisConnectionFactory() {
//         return new LettuceConnectionFactory();
//     }

//     @Bean
//     public RedisTemplate<String, Object> redisTemplate() {
//         RedisTemplate<String, Object> template = new RedisTemplate<>();
//         template.setConnectionFactory(redisConnectionFactory());
//         template.setKeySerializer(new StringRedisSerializer());
//         template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//         return template;
//     }

//     @Bean
//     public RedisCacheConfiguration cacheConfiguration() {
//         return RedisCacheConfiguration.defaultCacheConfig()
//                 .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
//                 .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
//     }
// }
