package com.broker.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

import java.util.HashMap;
import java.util.Map;

public interface TradeRequestRetrofit {
    @POST("/api/v5/trade/order")
    Call<HashMap<String,Object>> placeOrder(@HeaderMap Map<String,String> headerMap, @Body Map<String,Object> bodyMap);
}
