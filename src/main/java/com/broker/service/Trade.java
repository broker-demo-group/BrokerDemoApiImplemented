package com.broker.service;

import com.broker.utils.APIKeyHolder;
import com.broker.utils.AutorizationMethod;
import com.broker.utils.SignatureGenerator;
import com.broker.utils.headerMapBuilder;
import com.google.gson.Gson;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.http.HeaderMap;

import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
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
    public String placeOrderRetrofit(Map<String,Object> orderMap) throws IOException {
        String API_URL = "https://aws.okx.com";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TradeRequestRetrofit service = retrofit.create(TradeRequestRetrofit.class);
        String payload = new Gson().toJson(orderMap);
        String timeStamp = Instant.now().toString();
        Map<String,String> headers;

        if(apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.APIKeyPair)){
            String sign = SignatureGenerator.Generate(timeStamp,"POST",payload,"/api/v5/trade/order",apiKeyHolder.getSecretKey());
            headers = headerMapBuilder.build(apiKeyHolder.getApiKey(),sign,timeStamp, apiKeyHolder.getPassPhrase());
            Call<HashMap<String,Object>> orderCall = service.placeOrder(headers,orderMap);
            Response<HashMap<String,Object>> response= orderCall.execute();
            Request req= orderCall.request();
            System.out.println(req);
            if(response.isSuccessful()){
                return response.body().toString();
            }
            return response.errorBody().string();
        }
        if(apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.AccessToken)){
            headers =headerMapBuilder.build(apiKeyHolder.getAccessToken());
            Call<HashMap<String,Object>> orderCall = service.placeOrder(headers,orderMap);
            Request req= orderCall.request();
            System.out.println(req);
            Response<HashMap<String,Object>> response= orderCall.execute();
            if(response.isSuccessful()){
                return response.body().toString();
            }
            return response.errorBody().string();

        }
        return "Err";
    }
    public String placeOrder(Map<String,Object> orderMap){




        String payload = new Gson().toJson(orderMap);
        String timeStamp = Instant.now().toString();
        Map<String,String> headers;
        String result = "";
        if(apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.APIKeyPair)){
            String sign = SignatureGenerator.Generate(timeStamp,"POST",payload,"/api/v5/trade/order",apiKeyHolder.getSecretKey());
            headers = headerMapBuilder.build(apiKeyHolder.getApiKey(),sign,timeStamp, apiKeyHolder.getPassPhrase());
            result = tradeRequestClient.placeOrder(headers,orderMap);
        }
        if(apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.AccessToken)){
            headers =headerMapBuilder.build(apiKeyHolder.getAccessToken());
            result = tradeRequestClient.placeOrder(headers,orderMap);
        }
        return result;
    }

    public String placeOrderBatch(List<Map<String,Object>> orderList){
        String payload = new Gson().toJson(orderList);
        String timeStamp = Instant.now().toString();
        Map<String,String> headers;
        String result = "";
        if(apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.APIKeyPair)){
            String sign = SignatureGenerator.Generate(timeStamp,"POST",payload,"/api/v5/trade/order",apiKeyHolder.getSecretKey());
            headers = headerMapBuilder.build(apiKeyHolder.getApiKey(),sign,timeStamp, apiKeyHolder.getPassPhrase());
            result = tradeRequestClient.batchOrder(headers,orderList);
        }
        if(apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.AccessToken)){
            headers =headerMapBuilder.build(apiKeyHolder.getAccessToken());
            result = tradeRequestClient.batchOrder(headers,orderList);
        }
        return result;
    }


}
