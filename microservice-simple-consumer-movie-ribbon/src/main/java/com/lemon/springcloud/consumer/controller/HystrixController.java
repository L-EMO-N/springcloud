package com.lemon.springcloud.consumer.controller;

import com.lemon.springcloud.consumer.user.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * hystrix 测试类
 * @author luolin
 * @date 2018/10/8
 */
@RestController
@RequestMapping("/hystirx")
public class HystrixController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    @HystrixCommand(fallbackMethod = "getUserByIdFallback")
    public User getUserById(@PathVariable  Long id){
        return restTemplate.getForObject("http://microservice-simple-provider-user/provider/user/getUserById//"+id,User.class);
    }

    public User getUserByIdFallback( Long id){
        User user = new User();
        user.setId(0L);
        return user;
    }

}

