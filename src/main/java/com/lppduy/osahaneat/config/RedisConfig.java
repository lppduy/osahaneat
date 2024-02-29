package com.lppduy.osahaneat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {

        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName("localhost");
        configuration.setPort(6380); // able to set: database(node), username, password

        return new LettuceConnectionFactory(configuration);
    }

    @Bean
    RedisTemplate<String,Object> redisTemplate(LettuceConnectionFactory redisConnection) {

        RedisTemplate<String,Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnection);

        return template;
    }

}
