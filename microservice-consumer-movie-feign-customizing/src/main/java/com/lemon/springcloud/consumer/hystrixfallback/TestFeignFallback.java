package com.lemon.springcloud.consumer.hystrixfallback;

import com.lemon.springcloud.consumer.feignclient.TestFeignClient;
import org.springframework.stereotype.Component;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/10/15
 */
@Component
public class TestFeignFallback implements TestFeignClient {
    @Override
    public String findServiceInfoFromEurekaByServiceName(String serviceName) {
        return "haha";
    }
}
