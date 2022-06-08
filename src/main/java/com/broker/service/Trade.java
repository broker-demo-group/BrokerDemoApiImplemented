package com.broker.service;

import com.broker.utils.APIKeyHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Component
public class Trade {
    /**
     *
     *
     *
     *
     * **/
    @Autowired
    private TradeRequestClient tradeRequestClient;

    @Autowired
    private APIKeyHolder apiKeyHolder;

    public Trade(){}
    public String placeOrder(Map<String,Object> orderMap){

        return "";
    }
}
