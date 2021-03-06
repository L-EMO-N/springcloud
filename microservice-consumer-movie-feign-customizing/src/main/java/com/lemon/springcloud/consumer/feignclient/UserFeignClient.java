package com.lemon.springcloud.consumer.feignclient;

import com.lemon.springcloud.consumer.entity.User;
import com.lemon.springcloud.consumer.hystrixfallbackfactory.HystrixClientFactory;
import com.lemon.springcloud.feignconfiguration.FeignConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/10/5
 */
//fallback 与 fallbackfactory 不能同时使用  此时 fallbackfactory不起作用
@FeignClient(name = "microservice-simple-provider-user",configuration = FeignConfiguration.class/*,fallback = HystrixFallback.class*/,fallbackFactory = HystrixClientFactory.class)
//@RequestMapping("/provider/user")
//@RequestLine("/provider/user")
public interface UserFeignClient {

    @RequestLine("GET /provider/user/getUserById/{id}")
    public User findById(@Param("id") Long id);



}
