import com.broker.BrokerDemoMainApplication;
import com.broker.Client;
import com.broker.service.Trade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = BrokerDemoMainApplication.class)
@AutoConfigureMockMvc
public class tradeTest {
    Client client = BrokerDemoMainApplication.ClientFactory("213214214",null);
    @Test
    public void testTrade(){
        System.out.println(client.getApiKeyHolder().getAutorizationMethod().toString());
    }
    @Test
    public void testPlaceOrder(){
        Trade trade = client.getTrade();
        HashMap<String,Object> orderMap = new HashMap<>();
        orderMap.put("instId","BTC-USDT");
        orderMap.put("tdMode","cash");
        orderMap.put("side","buy");
        orderMap.put("sz","0.005");
        orderMap.put("px","200.00");

        try {
            String res = trade.placeOrderRetrofit(orderMap);
            System.out.println("Retrofit.RequestSuccessful");
            System.out.println(res);
        } catch (IOException e) {
            System.out.println("Retrofit.RequestException");
        }

        try{
            String res = trade.placeOrder(orderMap);
            System.out.println(res);
        }catch (Exception e) {
            System.out.println("Feign.RequestException");
            System.out.println(e.toString());
        }


    }


}
