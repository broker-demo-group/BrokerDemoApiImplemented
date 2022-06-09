package com.broker.controller;

import com.broker.feign.AssetFeignService;
import com.broker.utils.SignatureGenerator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bowen
 */
@Slf4j
@RestController
public class AssetController {
    final String apiKey = "a3e0fd84-81be-44a7-b954-a123409d131d";
    final String secretKey = "93EF091F16582590CBF71BDBD81E0C0F";
    final String passPhrase = "";

    @Resource
    AssetFeignService assetFeignService;

    @GetMapping(value = "/asset/currencies")
    public String getCurrencies() {
        Map<String, String> okHead = this.getHead("GET", "/api/v5/asset/currencies");
        return assetFeignService.getCurrencies(okHead);
    }

    private Map<String, String> getHead(String requestMethod, String requestPath) {
        Map<String, String> okHead = new HashMap<>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        String time = df.format(new Date());

        okHead.put("OK-ACCESS-KEY", apiKey);
        okHead.put("OK-ACCESS-SIGN", SignatureGenerator.Generate(time, requestMethod, "", requestPath, secretKey));
        okHead.put("OK-ACCESS-TIMESTAMP", time);
        okHead.put("OK-ACCESS-PASSPHRASE", passPhrase);
//        okHead.put("x-simulated-trading", "1");
        okHead.put("Content-Type", "application/json");

        return okHead;
    }
}
