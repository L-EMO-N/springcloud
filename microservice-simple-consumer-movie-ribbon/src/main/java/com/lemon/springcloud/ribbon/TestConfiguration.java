package com.lemon.springcloud.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/9/25
 */
@Configuration
//@RibbonClient(name = "microservice-simple-provider-user",configuration =TestConfiguration.class )
public class TestConfiguration {

    @Autowired
    private IClientConfig config;

    @Bean
    public IRule ribbonRule(IClientConfig config) {

        return new RandomRule();
    }
}
