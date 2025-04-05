package cn.iocoder.yudao.module.system.controller.yunExpress;

import cn.hutool.json.JSONObject;
import cn.iocoder.yudao.module.system.controller.yunExpress.config.YunTuConfigProperties;
import cn.iocoder.yudao.module.system.controller.yunExpress.model.RequestModel;
import cn.iocoder.yudao.module.system.service.yunExpress.GoodsService;
import cn.iocoder.yudao.module.system.service.yunExpress.OrderService;
import cn.iocoder.yudao.module.system.service.yunExpress.PriceTrialService;
import cn.iocoder.yudao.module.system.service.yunExpress.ShippingFeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import java.util.Base64;
import java.util.HashMap;

@Tag(name = "管理后台 - 云途")
@RestController
@RequestMapping("/system/yuntu")
@Validated
@Slf4j
public class YunTuApiUtils {

    private final YunTuConfigProperties yunTuConfigProperties;

    @Autowired
    public YunTuApiUtils(YunTuConfigProperties yunTuConfigProperties) {
        this.yunTuConfigProperties = yunTuConfigProperties;
    }

    @Resource
    private GoodsService goodsService;

    @Resource
    private PriceTrialService priceTrialService;

    @Resource
    private OrderService orderService;

    @Resource
    private ShippingFeeService shippingFeeService;

    /**
     * 查询货品类型
     * @return
     */
    @GetMapping("/getGoodsType")
    @PermitAll
    @Operation(summary = "云途物流-查询货品类型")
    public String getGoodsType() {
        String token = buildToken(yunTuConfigProperties.customerId,yunTuConfigProperties.apiSecret);
        RequestModel tokenModelBuilder = RequestModel.builder()
                .baseUrl(yunTuConfigProperties.getBaseUrl())
                .url(yunTuConfigProperties.getGetGoodsType())
                .authorization(token).build();
        JSONObject result = goodsService.getGoodsType(tokenModelBuilder);
        log.info("【云途接口】-查询货品类型接口返回结果：",result);
        return result.toString();
    }

    /**
     * 查询价格
     * @return
     */
    @GetMapping("/getPriceTrial")
    @PermitAll
    @Operation(summary = "云途物流-查询价格")
    public String getPriceTrial() {
        String token = buildToken(yunTuConfigProperties.customerId,yunTuConfigProperties.apiSecret);
        HashMap<String, Object> param = new HashMap<>();
        param.put("CountryCode","AD");
        param.put("Weight","1");
        RequestModel tokenModelBuilder = RequestModel.builder()
                .baseUrl(yunTuConfigProperties.getBaseUrl())
                .url(yunTuConfigProperties.getGetPriceTrial())
                .authorization(token)
                .params(param).build();
        JSONObject result = priceTrialService.getGetPriceTrial(tokenModelBuilder);
        log.info("【云途接口】-查询价格接口返回结果：",result);
        return result.toString();
    }

    /**
     * 运单申请
     * @return
     */
    @PostMapping("/createOrder")
    @PermitAll
    @Operation(summary = "云途物流-运单申请")
    public String createOrder() {
        String token = buildToken(yunTuConfigProperties.customerId,yunTuConfigProperties.apiSecret);

        RequestModel tokenModelBuilder = RequestModel.builder()
                .baseUrl(yunTuConfigProperties.getBaseUrl())
                .url(yunTuConfigProperties.getCreateOrder())
                .authorization(token)
                .build();

        JSONObject result = orderService.createOrder(tokenModelBuilder);
        log.info("【云途接口】-运单申请接口返回结果：",result);
        return result.toString();
    }


    /**
     * 查询运单
     * @return
     */
    @GetMapping("/getOrder")
    @PermitAll
    @Operation(summary = "云途物流-查询运单")
    public String getOrder() {
        String token = buildToken(yunTuConfigProperties.customerId,yunTuConfigProperties.apiSecret);
        HashMap<String, Object> param = new HashMap<>();
        param.put("OrderNumber","YT1908821203000021");
        RequestModel tokenModelBuilder = RequestModel.builder()
                .baseUrl(yunTuConfigProperties.getBaseUrl())
                .url(yunTuConfigProperties.getOrder)
                .authorization(token)
                .params(param).build();
        JSONObject result = orderService.getOrder(tokenModelBuilder);
        log.info("【云途接口】-查询运单接口返回结果：",result);
        return result.toString();
    }

    /**
     * 查询发件人信息
     * @return
     */
    @GetMapping("/getSender")
    @PermitAll
    @Operation(summary = "云途物流-查询发件人信息")
    public String getSender() {
        String token = buildToken(yunTuConfigProperties.customerId,yunTuConfigProperties.apiSecret);
        HashMap<String, Object> param = new HashMap<>();
        param.put("OrderNumber","YT1908821203000021");
        RequestModel tokenModelBuilder = RequestModel.builder()
                .baseUrl(yunTuConfigProperties.getBaseUrl())
                .url(yunTuConfigProperties.getSender)
                .authorization(token)
                .params(param).build();
        JSONObject result = orderService.getSender(tokenModelBuilder);
        log.info("【云途接口】-查询发件人信息接口返回结果：",result);
        return result.toString();
    }

    /**
     * 查询物流运费明细
     * @return
     */
    @GetMapping("/getShippingFeeDetail")
    @PermitAll
    @Operation(summary = "云途物流-查询物流运费明细")
    public String getShippingFeeDetail() {
        String token = buildToken(yunTuConfigProperties.customerId,yunTuConfigProperties.apiSecret);
        HashMap<String, Object> param = new HashMap<>();
        param.put("WayBillNumber","YT1908421201000005");
        RequestModel tokenModelBuilder = RequestModel.builder()
                .baseUrl(yunTuConfigProperties.getBaseUrl())
                .url(yunTuConfigProperties.getShippingFeeDetail)
                .authorization(token)
                .params(param).build();
        JSONObject result = shippingFeeService.getShippingFeeDetail(tokenModelBuilder);
        log.info("【云途接口】-查询物流运费明细接口返回结果：",result);
        return result.toString();
    }

    /**
     * 查询物流轨迹信息
     * @return
     */
    @GetMapping("/getTrackInfo")
    @PermitAll
    @Operation(summary = "云途物流-查询物流轨迹信息")
    public String getTrackInfo() {
        String token = buildToken(yunTuConfigProperties.customerId,yunTuConfigProperties.apiSecret);
        HashMap<String, Object> param = new HashMap<>();
        param.put("OrderNumber","YT1908321215012659");
        RequestModel tokenModelBuilder = RequestModel.builder()
                .baseUrl(yunTuConfigProperties.getBaseUrl())
                .url(yunTuConfigProperties.getTrackInfo)
                .authorization(token)
                .params(param).build();
        JSONObject result = shippingFeeService.getTrackInfo(tokenModelBuilder);
        log.info("【云途接口】-查询物流轨迹信息接口返回结果：",result);
        return result.toString();
    }


    /**
     * 按单号订阅轨迹
     * @return
     */
    @PostMapping("/createdOrderSubscribe")
    @PermitAll
    @Operation(summary = "云途物流-按单号订阅轨迹")
    public String createdOrderSubscribe() {
        String token = buildToken(yunTuConfigProperties.customerId,yunTuConfigProperties.apiSecret);

        RequestModel tokenModelBuilder = RequestModel.builder()
                .baseUrl(yunTuConfigProperties.getBaseUrl())
                .url(yunTuConfigProperties.getCreatedOrderSubscribe())
                .authorization(token)
                .build();

        JSONObject result = orderService.createdOrderSubscribe(tokenModelBuilder);
        log.info("【云途接口】-按单号订阅轨迹接口返回结果：",result);
        return result.toString();
    }

    /**
     * 按单号取消轨迹订阅
     * @return
     */
    @PostMapping("/cancelOrderSubscribe")
    @PermitAll
    @Operation(summary = "云途物流-按单号取消轨迹订阅")
    public String cancelOrderSubscribe() {
        String token = buildToken(yunTuConfigProperties.customerId,yunTuConfigProperties.apiSecret);

        RequestModel tokenModelBuilder = RequestModel.builder()
                .baseUrl(yunTuConfigProperties.getBaseUrl())
                .url(yunTuConfigProperties.getCreatedOrderSubscribe())
                .authorization(token)
                .build();

        JSONObject result = orderService.cancelOrderSubscribe(tokenModelBuilder);
        log.info("【云途接口】-按单号取消轨迹订阅接口返回结果：",result);
        return result.toString();
    }


    /**
     * 修改订单预报重量
     * @return
     */
    @PostMapping("/updateWeight")
    @PermitAll
    @Operation(summary = "云途物流-修改订单预报重量")
    public String updateWeight() {
        String token = buildToken(yunTuConfigProperties.customerId,yunTuConfigProperties.apiSecret);

        RequestModel tokenModelBuilder = RequestModel.builder()
                .baseUrl(yunTuConfigProperties.getBaseUrl())
                .url(yunTuConfigProperties.updateWeight)
                .authorization(token)
                .build();

        JSONObject result = orderService.updateWeight(tokenModelBuilder);
        log.info("【云途接口】-修改订单预报重量接口返回结果：",result);
        return result.toString();
    }


    /**
     * 删除订单
     * @return
     */
    @PostMapping("/deleteOrder")
    @PermitAll
    @Operation(summary = "云途物流-删除订单")
    public String deleteOrder() {
        String token = buildToken(yunTuConfigProperties.customerId,yunTuConfigProperties.apiSecret);

        RequestModel tokenModelBuilder = RequestModel.builder()
                .baseUrl(yunTuConfigProperties.getBaseUrl())
                .url(yunTuConfigProperties.deleteOrder)
                .authorization(token)
                .build();

        JSONObject result = orderService.deleteOrder(tokenModelBuilder);
        log.info("【云途接口】-删除订单接口返回结果：",result);
        return result.toString();
    }


    public static String buildToken(String customerId,String apiSecret) {
        String token = customerId + "&" + apiSecret;
        return "Basic " + Base64.getEncoder().encodeToString(token.getBytes());
    }

}
