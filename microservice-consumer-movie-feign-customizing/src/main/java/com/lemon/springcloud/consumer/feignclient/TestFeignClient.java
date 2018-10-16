package com.lemon.springcloud.consumer.feignclient;

import com.lemon.springcloud.feignconfiguration.FeignWithoutHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/10/6
 */
@FeignClient(name = "xxx",url = "http://localhost:8761/",configuration = FeignWithoutHystrix.class)
public interface TestFeignClient {
    @GetMapping("/eureka/apps/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
