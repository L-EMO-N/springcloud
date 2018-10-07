package com.lemon.springcloud.consumer.controller;

import com.lemon.springcloud.consumer.entity.User;
import com.lemon.springcloud.consumer.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/10/4
 */
@RestController
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/getUserById/{id}")
    public User findById(@PathVariable  Long id){
        return userFeignClient.findById(id);
    }

    @GetMapping("/testPost")
    public User testPost(User user){
        return userFeignClient.postUser(user);
    }

    @GetMapping("/test-user")
    public User getUser(User user){
        return userFeignClient.getUser(user);
    }
}
