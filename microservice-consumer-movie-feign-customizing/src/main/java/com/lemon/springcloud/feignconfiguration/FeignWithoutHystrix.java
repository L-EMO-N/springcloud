package com.lemon.springcloud.feignconfiguration;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/10/15
 */
@Configuration
public class FeignWithoutHystrix {

    //默认的feign 是采用 HystrixFeign.builder   通过这种方式可以禁用单个feign对hystrix的支持
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
