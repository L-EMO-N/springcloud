package com.lemon.springcloud.consumer.controller;

import com.lemon.springcloud.consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/10/8
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/list-all")
    public List<User> listAll(){

        // 做个测试  添加一个注解

        // 当服务器端返回数据为list的时候，客户端接收到的是linkedhashmap  可以通过对象数组形式接受
        //再转化为list，然后操作里面的数据  否则会抛异常


        /*List<User> list = restTemplate.getForObject("http://microservice-simple-provider-user/provider/user/list-all", List.class);
        for(User user : list){
            System.out.println(user.getId());
        }*/
        User[] users = restTemplate.getForObject("http://microservice-simple-provider-user/provider/user/list-all", User[].class);
        List<User> list = Arrays.asList(users);
    /*    for(User user : list){
            System.out.println(user.getUsername());
        }*/
        return  list;
    }
}
