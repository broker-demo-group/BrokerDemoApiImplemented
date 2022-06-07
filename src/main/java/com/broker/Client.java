package com.broker;

public class Client {
    private String apiKey;
    private String secretKey;
    private String passPhrase;
    public Client(String apiKey,String secertKey,String passPhrase){
        this.apiKey = apiKey;
        this.secretKey = secertKey;
        this.passPhrase = passPhrase;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getPassPhrase() {
        return passPhrase;
    }

    public void setPassPhrase(String passPhrase) {
        this.passPhrase = passPhrase;
    }
}
