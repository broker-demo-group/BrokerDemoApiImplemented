package com.broker.service;

import feign.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@FeignClient(name = "TradeRequestClient", url = "https://aws.okx.com")
public interface TradeRequestClient {
    @PostMapping("/api/v5/trade/order")
    String placeOrder(@HeaderMap Map<String,Object> headerMap, @RequestBody Map<String,Object> bodyMap);

    @PostMapping("/api/v5/trade/batch-orders")
    String batchOrder(@HeaderMap Map<String,Object> headerMap, @RequestBody List<Map<String,Object>> bodyMapList);

    @PostMapping("/api/v5/trade/cancel-order")
    String cancelOrder(@HeaderMap Map<String,Object> headerMap, @RequestBody Map<String,Object> bodyMap);

    @PostMapping("/api/v5/trade/cancel-batch-orders")
    String batchCancelOrder(@HeaderMap Map<String,Object> headerMap, @RequestBody List<Map<String,Object>> bodyMapList);

    @PostMapping("/api/v5/trade/amend-order")
    String amendOrder(@HeaderMap Map<String,Object> headerMap, @RequestBody Map<String,Object> bodyMap);

    @PostMapping("/api/v5/trade/close-position")
    String closePosition(@HeaderMap Map<String,Object> headerMap, @RequestBody Map<String,Object> bodyMap);

    @GetMapping("/api/v5/trade/order")
    String getOrderInfo(@HeaderMap Map<String,Object> headerMap, @QueryMap Map<String,Object> queryParams);

    @GetMapping("/api/v5/trade/orders-pending")
    String getPendingOrderInfo(@HeaderMap Map<String,Object> headerMap, @QueryMap Map<String,Object> queryParams);

    @GetMapping("/api/v5/trade/orders-history")
    String getPendingOrderHistory(@HeaderMap Map<String,Object> headerMap, @QueryMap Map<String,Object> queryParams);

    @GetMapping("/api/v5/trade/orders-history-archive")
    String getPendingOrderHistoryArchieve(@HeaderMap Map<String,Object> headerMap, @QueryMap Map<String,Object> queryParams);

    @GetMapping("/api/v5/trade/fills")
    String getFills(@HeaderMap Map<String,Object> headerMap, @QueryMap Map<String,Object> queryParams);

    @GetMapping("/api/v5/trade/fills-history")
    String getFillsHistory(@HeaderMap Map<String,Object> headerMap, @QueryMap Map<String,Object> queryParams);

    @PostMapping("/api/v5/trade/order-algo")
    String placeOrderAlgo(@HeaderMap Map<String,Object> headerMap, @RequestBody Map<String,Object> bodyMap);

    @PostMapping("/api/v5/trade/cancel-algos")
    String cancelAlgo(@HeaderMap Map<String,Object> headerMap, @RequestBody Map<String,Object> bodyMap);

    @PostMapping("/api/v5/trade/cancel-advance-algos")
    String cancelAdvanceAlgo(@HeaderMap Map<String,Object> headerMap, @RequestBody Map<String,Object> bodyMap);


    @GetMapping("/api/v5/trade/orders-algo-pending")
    String getOrderAlgoPending(@HeaderMap Map<String,Object> headerMap, @QueryMap Map<String,Object> queryParams);

    @GetMapping("/api/v5/trade/orders-algo-history")
    String getOrderAlgoHistory(@HeaderMap Map<String,Object> headerMap, @QueryMap Map<String,Object> queryParams);
}
