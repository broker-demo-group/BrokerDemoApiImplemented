package com.broker.feign;

import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author bowen
 */
@FeignClient(value = "Broker-Demo", url = "https://www.okx.com")
//@FeignClient(value = "Broker-Demo", url = "localhost:81")
public interface SystemFeignService {
    @GetMapping(value = "/api/v5/public/time")
    String getStatus(@RequestHeader Map<String, String> okHead);

    @GetMapping(value = "/api/v5/public/time")
    String getStatus();

}
