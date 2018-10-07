package com.lemon.springcloud.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/8/2
 */
@Configuration
public class Config {

    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }
}
