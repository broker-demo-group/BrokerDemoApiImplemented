package com.broker.biz;

import com.broker.utils.APIKeyHolder;
import org.junit.jupiter.api.Test;

import java.util.Map;

class AssetBizTest {

    APIKeyHolder apiKeyHolder = new APIKeyHolder();

    {
        apiKeyHolder.init("",
                "", "");
    }

    AssetBiz assetBiz = new AssetBiz();

    //    正常 无参数 GET
    @Test
    void getAccountBalance() {
        Map r = assetBiz.getAccountBalance(apiKeyHolder);
        System.out.println(r);
    }

    @Test
    void getAccountPosition() {
        Map r = assetBiz.getAccountBalance(apiKeyHolder);
        System.out.println(r);
    }
}