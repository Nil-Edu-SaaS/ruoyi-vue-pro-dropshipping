package cn.iocoder.yudao.module.system.controller.yunExpress.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "dev.yuntu")
public class YunTuConfigProperties {

    public String customerId;
    public String apiSecret;
    public String baseUrl;
    //获取商品类型
    public String getGoodsType;
    //获取价格
    public String getPriceTrial;
    //运单申请
    public String createOrder;
    //查询运单
    public String getOrder;
    //查询发件人信息
    public String getSender;
    //查询物流运费明细
    public String getShippingFeeDetail;
    //查询物流轨迹信息
    public String getTrackInfo;
    //按单号订阅轨迹
    public String createdOrderSubscribe;
    //修改订单预报重量
    public String updateWeight;
    //删除订单
    public String deleteOrder;
}
