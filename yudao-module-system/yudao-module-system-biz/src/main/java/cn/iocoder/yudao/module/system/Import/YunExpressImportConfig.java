package cn.iocoder.yudao.module.system.Import;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import top.taolord.yunexpress.application.YunExpressClient;
import top.taolord.yunexpress.infrastructure.config.YunExpressConfig;

import java.util.AbstractMap;
import java.util.Map;

@ComponentScan(basePackages = {"top.taolord.yunexpress"})
public class YunExpressImportConfig {

    @Bean
    public YunExpressClient yunExpressClient() {

        // 构造端点映射
        Map<String, String> endpoints = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("getGoodsType", "/api/Common/GetGoodsType"),
                new AbstractMap.SimpleEntry<>("createOrder", "/api/WayBill/CreateOrder"),
                new AbstractMap.SimpleEntry<>("getOrder", "/api/WayBill/GetOrder"),
                new AbstractMap.SimpleEntry<>("getSender", "/api/WayBill/GetSender"),
                new AbstractMap.SimpleEntry<>("getShippingFeeDetail", "/api/Freight/GetShippingFeeDetail"),
                new AbstractMap.SimpleEntry<>("getTrackInfo", "/api/Tracking/GetTrackInfo"),
                new AbstractMap.SimpleEntry<>("createdOrderSubscribe", "/api/tracking/CreatedOrderSubscribe"),
                new AbstractMap.SimpleEntry<>("cancelOrderSubscribe", "/api/tracking/CancelOrderSubscribe"),
                new AbstractMap.SimpleEntry<>("updateWeight", "/api/WayBill/UpdateWeight"),
                new AbstractMap.SimpleEntry<>("deleteOrder", "/api/WayBill/Delete"),
                new AbstractMap.SimpleEntry<>("getPriceTrial", "/api/Freight/GetPriceTrial")
        );


        YunExpressConfig yunExpressConfig = new YunExpressConfig(
                "ITC0893791","axzc2utvPbfc9UbJDOh+7w==","http://omsapi.uat.yunexpress.com",endpoints
        );
        return new YunExpressClient(yunExpressConfig);
    }
}
