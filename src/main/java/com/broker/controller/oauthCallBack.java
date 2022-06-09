package com.broker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Controller

public class oauthCallBack {

    @ResponseBody
    @GetMapping("/testMap")
    public Map<String,String> callbackHander(@RequestParam("code") String code, @RequestParam("state") String state){
        Map<String,String> map = new HashMap<>();
        map.put("sucessful","true");
        map.put("time", Instant.now().toString());
        return map;
    }
}
