package com.broker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class BrokerDemoMainApplication {
    public static void main(String[] args){
        ApplicationContext context = SpringApplication.run(BrokerDemoMainApplication.class, args);
        log.info("BrokerDemoMainApplication started succ !!！");

    }
}
