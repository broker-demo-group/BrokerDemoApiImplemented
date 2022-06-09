package com.broker.controller;

import com.broker.feign.SystemFeignService;
import java.util.Map;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bowen
 */
@Slf4j
@RestController
public class SystemController {
    @Resource
    SystemFeignService systemFeignService;

    @GetMapping("system/status")
    public String getStatus(@RequestHeader Map<String, String> head) {

        return systemFeignService.getStatus();
    }


    @GetMapping("system/test")
    public String test() {
        return "test";
    }
}
