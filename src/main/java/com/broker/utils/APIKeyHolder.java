package com.broker.utils;

import org.springframework.stereotype.Component;
import com.broker.utils.AutorizationMethod;
@Component
public class APIKeyHolder {
    private String apiKey;
    private String secretKey;
    private String passPhrase;

    private String accessToken;

    private AutorizationMethod autorizationMethod;
    public APIKeyHolder(){

    }

    public void init(String apiKey,String secertKey,String passPhrase){
        this.apiKey = apiKey;
        this.secretKey = secertKey;
        this.passPhrase = passPhrase;
        autorizationMethod = AutorizationMethod.APIKeyPair;

    }

    public void init(String accessToken){
        this.accessToken = accessToken;
        autorizationMethod = AutorizationMethod.AccessToken;
    }

    public boolean renewToken(String newToken){
        if(autorizationMethod.equals(AutorizationMethod.AccessToken)){
            this.accessToken = newToken;
            return true;
        }
        return false;

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

    public AutorizationMethod getAutorizationMethod(){
        return this.autorizationMethod;
    }
}
