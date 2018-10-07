package com.lemon.springcloud.consumer.controller;

import com.lemon.springcloud.consumer.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/8/2
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "consumer/user/getUserById/{id}")
    public User getUserById(@PathVariable("id") Long id){
        System.out.println("come  in !!!!");
        User user = restTemplate.getForObject("http://localhost:8080/provider/user/getUserById/"+id,User.class);
        return user;
    }

}
