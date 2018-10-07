package com.lemon.springcloud.feignconfiguration;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/10/5
 */
@Configuration
public class FeignConfiguration {

    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }
}
