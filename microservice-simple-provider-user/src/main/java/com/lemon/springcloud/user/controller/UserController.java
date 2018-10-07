package com.lemon.springcloud.user.controller;

import com.lemon.springcloud.user.dao.UserDao;
import com.lemon.springcloud.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/8/2
 */

@RestController
@RequestMapping("/provider/user")
public class UserController {

    @Autowired
    private UserDao userDao;

@GetMapping(value = "/getUserById/{id}")
    public User getUserByid(@PathVariable("id") long id){
        return userDao.findOne(id);
    }

    @PostMapping("/user")
    public User postUser(@RequestBody  User user){
        return user;
    }

    //该请求不会成功
    @GetMapping("/test-user")
    public User getUser(User user) {
        return user;
    }

}
