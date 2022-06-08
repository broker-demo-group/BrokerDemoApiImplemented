package com.broker;

import com.broker.utils.APIKeyHolder;
import com.broker.utils.SignatureGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
@EnableFeignClients
public class BrokerDemoMainApplication {
    public static void main(String[] args){
        
    }

    public static Client ClientFactory(String apiKey,String secertKey,String passPhrase,String[] args){
        ApplicationContext context = SpringApplication.run(BrokerDemoMainApplication.class,args);
        log.info("BrokerDemoMainApplication started succ !!！");
        APIKeyHolder apiKeyHolder = (APIKeyHolder)context.getBean("APIKeyHolder");
        apiKeyHolder.init(apiKey,secertKey,passPhrase);
        return (Client)context.getBean("Client");
    }
}
