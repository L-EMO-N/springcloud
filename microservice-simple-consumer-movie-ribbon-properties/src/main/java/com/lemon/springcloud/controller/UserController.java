package com.lemon.springcloud.controller;

import com.lemon.springcloud.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/10/2
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "consumer/user/getUserById/{id}")
    public User getUserById(@PathVariable("id") Long id){
//        System.out.println("come in !!!!");
        User user = restTemplate.getForObject("http://microservice-simple-provider-user/provider/user/getUserById/" + id, User.class);
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-simple-provider-user");
        System.out.println("===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

        return user;
    }


    @GetMapping("/test")
    public String test(){

        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-simple-provider-user");
        System.out.println("111"+" : "+serviceInstance.getServiceId()+" : "+serviceInstance.getHost()+" : "+serviceInstance.getPort());

        ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("microservice-simple-provider-user2");
        System.out.println("222"+" : " +serviceInstance2.getServiceId() +" : "+serviceInstance2.getHost()+" : "+serviceInstance2.getPort());
        return "1";
    }

}
