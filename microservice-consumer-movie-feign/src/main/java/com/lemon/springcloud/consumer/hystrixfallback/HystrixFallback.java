package com.lemon.springcloud.consumer.hystrixfallback;

import com.lemon.springcloud.consumer.entity.User;
import com.lemon.springcloud.consumer.feign.UserFeignClient;
import org.springframework.stereotype.Component;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/10/10
 */
@Component
public class HystrixFallback implements UserFeignClient {

    @Override
    public User findById( Long id) {
        User user = new User();
        user.setId(0L);
        return user;
    }

    @Override
    public User postUser(User user) {
        user.setId(0L);
        return user;
    }

    @Override
    public User getUser(User user) {
        user.setId(0L);
        return user;
    }
}
