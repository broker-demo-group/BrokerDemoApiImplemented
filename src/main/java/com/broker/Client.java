package com.broker;

import com.broker.utils.APIKeyHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Client {

    @Autowired
    APIKeyHolder apiKeyHolder;
    public Client(){

    }

}
