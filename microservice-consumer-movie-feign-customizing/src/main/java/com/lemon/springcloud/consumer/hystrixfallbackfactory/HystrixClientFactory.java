package com.lemon.springcloud.consumer.hystrixfallbackfactory;

import com.lemon.springcloud.consumer.entity.User;
import com.lemon.springcloud.consumer.feignclient.UserFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/10/16
 */
@Component
public class HystrixClientFactory  implements FallbackFactory<UserFeignClient>{

    private final static Logger LOGGER = LoggerFactory.getLogger(HystrixClientFactory.class);
    @Override
    public UserFeignClient create(Throwable throwable) {
        LOGGER.info("fallback;reason was: {}", throwable.getMessage());
        //正常表达式
       /* return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                User user =  new User();
                user.setId(-1L);
                return user;
            }
        };*/
       //lamble 表达式
       return id -> {
           User user = new User();
           user.setId(-1L);
           return user;
       };
    }
}
