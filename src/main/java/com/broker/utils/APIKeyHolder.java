package com.broker.utils;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class APIKeyHolder {
    private String apiKey;
    private String secretKey;
    private String passPhrase;

    public APIKeyHolder(){

    }

    public void init(String apiKey,String secertKey,String passPhrase){
        this.apiKey = apiKey;
        this.secretKey = secertKey;
        this.passPhrase = passPhrase;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getPassPhrase() {
        return passPhrase;
    }
}
