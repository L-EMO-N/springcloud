package com.lemon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/8/2
 */
@SpringBootApplication
@EnableEurekaClient    //只能用于eureka
//@EnableDiscoveryClient   // 还可以用于zk 等其他注册中心
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        System.out.println("********启动成功************");
    }
}
