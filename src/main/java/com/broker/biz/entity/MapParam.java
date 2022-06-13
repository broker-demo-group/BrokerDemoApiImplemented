package com.broker.biz.entity;

import com.broker.service.APIRequestPayload;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: bowen
 * @description: 使用Map存储调用接口所需要传递的参数，通过实现 {@link APIRequestPayload}能够在
 * {@link com.broker.service.CommonAPICaller} 中使用；
 * @date: 2022/6/13  8:21 AM
 **/
public class MapParam implements APIRequestPayload {
    Map<String, String> param = new HashMap<>();

    public String addParam(String key, String value) {
        return param.put(key, value);
    }

    @Override
    public String getPayLoadJson() {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (Map.Entry<String, String> e : param.entrySet()) {
            sb.append(e.getKey() + ":" + e.getValue() + ",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("}");
        JsonObject jsonString = new Gson().fromJson(sb.toString(), JsonObject.class);
        return jsonString.toString();
    }
}
