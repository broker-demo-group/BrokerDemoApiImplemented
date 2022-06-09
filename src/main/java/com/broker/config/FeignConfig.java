package com.broker.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author bowen
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level fignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
