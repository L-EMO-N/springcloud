package com.lemon.springcloud.consumer;

import com.lemon.springcloud.consumer.config.ExcludeFromComponentScan;
import com.lemon.springcloud.consumer.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/9/25
 *
 *
 */
@SpringBootApplication
@EnableEurekaClient //eureka
// 这是第一种方式 将config放在application 扫描范围外
//@RibbonClient(name = "microservice-simple-provider-user",configuration =TestConfiguration.class )
//这是第二种方式  通过配置规避
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ExcludeFromComponentScan.class)})
@RibbonClient(name = "microservice-simple-provider-user",configuration =RibbonConfig.class ) //ribbon
@EnableCircuitBreaker  //hystrix
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        System.out.println("****************ribbon启动成功**********");
    }
}
