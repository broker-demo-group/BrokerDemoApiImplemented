package com.broker.feign;


import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author bowen
 */
@FeignClient(value = "Broker-asset-Demo", url = "https://www.okx.com")
//@FeignClient(value = "Broker-asset-Demo", url = "localhost:81")
public interface AssetFeignService {

    @GetMapping(value = "/api/v5/asset/currencies")
    String getCurrencies(@RequestHeader Map<String, String> okHead);
}
