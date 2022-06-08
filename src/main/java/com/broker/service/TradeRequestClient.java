package com.broker.service;

import feign.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@FeignClient(name = "TradeRequestClient", url = "https://aws.okx.com")
public interface TradeRequestClient {
    @PostMapping("/api/v5/trade/order")
    String placeOrder(@RequestHeader Map<String,String> headerMap, @RequestBody Map<String,String> bodyMap);

    @PostMapping("/api/v5/trade/batch-orders")
    String batchOrder(@RequestHeader Map<String,String> headerMap, @RequestBody List<Map<String,String>> bodyMapList);

    @PostMapping("/api/v5/trade/cancel-order")
    String cancelOrder(@RequestHeader Map<String,String> headerMap, @RequestBody Map<String,String> bodyMap);

    @PostMapping("/api/v5/trade/cancel-batch-orders")
    String batchCancelOrder(@RequestHeader Map<String,String> headerMap, @RequestBody List<Map<String,String>> bodyMapList);

    @PostMapping("/api/v5/trade/amend-order")
    String amendOrder(@RequestHeader Map<String,String> headerMap, @RequestBody Map<String,String> bodyMap);

    @PostMapping("/api/v5/trade/close-position")
    String closePosition(@RequestHeader Map<String,String> headerMap, @RequestBody Map<String,String> bodyMap);

    @GetMapping("/api/v5/trade/order")
    String getOrderInfo(@RequestHeader Map<String,String> headerMap, @QueryMap Map<String,String> queryParams);

    @GetMapping("/api/v5/trade/orders-pending")
    String getPendingOrderInfo(@RequestHeader Map<String,String> headerMap, @QueryMap Map<String,String> queryParams);

    @GetMapping("/api/v5/trade/orders-history")
    String getPendingOrderHistory(@RequestHeader Map<String,String> headerMap, @QueryMap Map<String,String> queryParams);

    @GetMapping("/api/v5/trade/orders-history-archive")
    String getPendingOrderHistoryArchieve(@RequestHeader Map<String,String> headerMap, @QueryMap Map<String,String> queryParams);

    @GetMapping("/api/v5/trade/fills")
    String getFills(@RequestHeader Map<String,String> headerMap, @QueryMap Map<String,String> queryParams);

    @GetMapping("/api/v5/trade/fills-history")
    String getFillsHistory(@RequestHeader Map<String,String> headerMap, @QueryMap Map<String,String> queryParams);

    @PostMapping("/api/v5/trade/order-algo")
    String placeOrderAlgo(@RequestHeader Map<String,String> headerMap, @RequestBody Map<String,String> bodyMap);

    @PostMapping("/api/v5/trade/cancel-algos")
    String cancelAlgo(@RequestHeader Map<String,String> headerMap, @RequestBody Map<String,String> bodyMap);

    @PostMapping("/api/v5/trade/cancel-advance-algos")
    String cancelAdvanceAlgo(@RequestHeader Map<String,String> headerMap, @RequestBody Map<String,String> bodyMap);


    @GetMapping("/api/v5/trade/orders-algo-pending")
    String getOrderAlgoPending(@RequestHeader Map<String,String> headerMap, @QueryMap Map<String,String> queryParams);

    @GetMapping("/api/v5/trade/orders-algo-history")
    String getOrderAlgoHistory(@RequestHeader Map<String,String> headerMap, @QueryMap Map<String,String> queryParams);
}
