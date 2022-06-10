import com.broker.BrokerDemoMainApplication;
import com.broker.Client;
import com.broker.service.CommonAPICaller;
import com.broker.service.OAuth;
import com.broker.utils.APIKeyHolder;
import com.broker.utils.DemoElement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = BrokerDemoMainApplication.class)
@AutoConfigureMockMvc
public class testCommonAPICaller {
    Client client = BrokerDemoMainApplication.ClientFactory("213214214",null);
    APIKeyHolder apiKeyHolder;
    String API_URL = "https://aws.okx.com";
    @Test
    public void testCallerPost(){
        apiKeyHolder = client.getApiKeyHolder();
        CommonAPICaller<DemoElement, Map<String,String>> commonAPICaller = new CommonAPICaller<>(API_URL,apiKeyHolder);


        DemoElement demoElement = new DemoElement();
        try {
            Map<String,String> r = commonAPICaller.requestAPI("POST","/api/v5/trade/order",demoElement);
            System.out.println(r);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            Map<String,String> r = commonAPICaller.requestAPI("POST","/api/v5/trade/order",demoElement);
            System.out.println(r);
            r = commonAPICaller.requestAPI("GET","/api/v5/trade/order",demoElement);

            System.out.println(r);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testOauth(){
        OAuth oAuth = new OAuth();
        try {
            String r = oAuth.getAccessToken("dfisovhdsoihiocasoiubcuiysagofewgfo","csuaihcsahc","hsuiaisa");
            System.out.println(r);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
