package com.lemon.springcloud.consumer.feign;

import com.lemon.springcloud.consumer.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/10/4
 */
@FeignClient("microservice-simple-provider-user")
@RequestMapping("/provider/user")
public interface UserFeignClient {
    @GetMapping("/getUserById/{id}")
    public User findById(@PathVariable("id")  Long id);


    @PostMapping("/user")
    public User postUser( User user);


    @GetMapping("/test-user")
    public User getUser(User user);

}


