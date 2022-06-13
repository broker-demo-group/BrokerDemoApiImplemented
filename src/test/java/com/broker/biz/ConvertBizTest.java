package com.broker.biz;

import com.broker.biz.entity.MapParam;
import com.broker.biz.entity.Quote;
import com.broker.service.APIRequestPayload;
import com.broker.utils.APIKeyHolder;
import com.google.gson.Gson;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

class ConvertBizTest {
    APIKeyHolder apiKeyHolder = new APIKeyHolder();

    {
        apiKeyHolder.init("",
                "", "");
    }

    ConvertBiz convertBiz = new ConvertBiz();

    @Test
    void getConvertCurrencies() {
        Map r = convertBiz.getConvertCurrencies(apiKeyHolder);
        System.out.println(r);
    }

    //  正常 有参数 GET
    @Test
    void getConvertCurrencyPair() {
        MapParam param = new MapParam();
        param.addParam("fromCcy", "USDT");
        param.addParam("toCcy", "BTC");
        Map r = convertBiz.getConvertCurrencyPair(apiKeyHolder, param);
        System.out.println(r);
    }

    // 正常 POST
    @Test
    void convertEstimateQuote() {
        MapParam param = new MapParam();
        param.addParam("baseCcy", "ETH");
        param.addParam("quoteCcy", "USDT");
        param.addParam("side", "buy");
        param.addParam("rfqSz", "1000");
        param.addParam("rfqSzCcy", "USDT");
//        UUID.randomUUID();
        param.addParam("clQReqId", "whosyourdaddy");
//        param.addParam("tag", "321");
        Map r = convertBiz.convertEstimateQuote(apiKeyHolder, param);
        val data = (ArrayList) r.get("data");
        String s = data.get(0).toString();
        Quote q = new Gson().fromJson(s, Quote.class);
        System.out.println(q);
        System.out.println(r);
    }

    //   缺少参数 POST
    @Test
    void convertEstimateQuoteError() {
        MapParam param = new MapParam();
        param.addParam("baseCcy", "ETH");
        param.addParam("quoteCcy", "USDT");
        param.addParam("side", "buy");
        param.addParam("rfqSz", "30");
//        param.addParam("rfqSzCcy", "USDT"); //缺失的参数

        Map r = convertBiz.convertEstimateQuote(apiKeyHolder, param);
        System.out.println(r);

//        for (Map.Entry e : r.entrySet()){
//            System.out.println(e.getKey().getClass());
//            System.out.println(e.getValue().getClass());
//        }
    }

    //    Syntax err POST
    @Test
    void convertEstimateQuoteSyntaxError() {
        //  如果出现语法错误，返回「code: , data: ,detailMsg: , error_code: , error_message: , msg: 」
        //  正常格式是 「code= *** ; data= ***; msg= ***」
        APIRequestPayload param = () -> "{side:buy,rfqSz:30,baseCcy:ETH,quoteCcy:USDT,rfqSzCcy:USDT}";
        Map r = convertBiz.convertEstimateQuote(apiKeyHolder, param);
        System.out.println(r);
    }
}