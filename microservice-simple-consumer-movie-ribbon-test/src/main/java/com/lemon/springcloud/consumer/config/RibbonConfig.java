package com.lemon.springcloud.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/10/8
 */
@Configuration
@ExcludeFromComponentScan
public class RibbonConfig {

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
