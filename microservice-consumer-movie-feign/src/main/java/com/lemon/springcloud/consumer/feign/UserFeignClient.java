package com.lemon.springcloud.consumer.feign;

import com.lemon.springcloud.consumer.entity.User;
import com.lemon.springcloud.consumer.hystrixfallback.HystrixFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/10/4
 */
@FeignClient(name = "microservice-simple-provider-user",fallback = HystrixFallback.class)
//@RequestMapping("/provider/user")  用hystrix时不能使用这个注解
public interface UserFeignClient {
    @GetMapping("/provider/user/getUserById/{id}")
    public User findById(@PathVariable("id")  Long id);


    @PostMapping("/provider/user/user")
    public User postUser( User user);


    @GetMapping("/provider/user/test-user")
    public User getUser(User user);

}


