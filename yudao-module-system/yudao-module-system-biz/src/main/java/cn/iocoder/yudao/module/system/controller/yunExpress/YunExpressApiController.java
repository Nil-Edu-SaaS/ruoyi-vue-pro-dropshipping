package cn.iocoder.yudao.module.system.controller.yunExpress;

import cn.hutool.json.JSONObject;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.security.core.LoginUser;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import cn.iocoder.yudao.module.system.controller.yunExpress.config.YunExpressConfigProperties;
import cn.iocoder.yudao.module.system.controller.yunExpress.model.RequestModel;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.DeleteOrderRequest;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.OrderSubscribeRequest;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.UpdateWeightRequest;
import cn.iocoder.yudao.module.system.dal.dataobject.yunExpress.ApiSecretKeyDO;
import cn.iocoder.yudao.module.system.service.yunExpress.*;
import cn.iocoder.yudao.module.system.service.yunExpress.impl.body.BuildBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.taolord.yunexpress.domain.model.GoodsType;
import top.taolord.yunexpress.domain.model.Order;
import top.taolord.yunexpress.domain.model.OrderRequest;
import top.taolord.yunexpress.domain.model.PriceTrial;


import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 云途")
@RestController
@RequestMapping("/system/yunExpress")
@Validated
@Slf4j
public class YunExpressApiController {

    @Resource
    private YunExpressConfigProperties yunExpressConfigProperties;
    @Resource
    private GoodsService goodsService;

    @Resource
    private PriceTrialService priceTrialService;

    @Resource
    private OrderService orderService;


    @Resource
    private ShippingFeeService shippingFeeService;

    @Resource
    private ApiSecretKeyService apiSecretKeyService;

    /**
     * 查询货品类型
     * @return
     */
    @GetMapping("/getGoodsType")
    @PermitAll
    @Operation(summary = "云途物流-查询货品类型")
    public CommonResult<List<GoodsType>> getGoodsType() {
        JSONObject result = new JSONObject();
        List<GoodsType> list = new ArrayList<>();
        LoginUser loginUser = SecurityFrameworkUtils.getLoginUser();
        Long userId = loginUser.getId();
        ApiSecretKeyDO apiSecretKeyDO = apiSecretKeyService.getApiSecretKeyByUserId(userId);
        if(apiSecretKeyDO!=null){
            list = goodsService.getGoodsType(yunExpressConfigProperties.customerId,yunExpressConfigProperties.apiSecret);
            log.info("【云途接口】-查询货品类型接口返回结果：",list);
        }else{
            result.set("msg","当前用户没有绑定云途账号,请先绑定云途账号");
            log.info("没有绑定云途账号");
        }
        return success(list);
    }

    /**
     * 查询价格
     * @return
     */
    @GetMapping("/getPriceTrial")
    @PermitAll
    @Operation(summary = "云途物流-查询价格")
    public String getPriceTrial(@RequestParam(value = "countryCode") String countryCode,
                                @RequestParam(value = "weight") String weight,
                                @RequestParam(value = "length",required = false) String length,
                                @RequestParam(value = "width",required = false) String width,
                                @RequestParam(value = "height",required = false) String height,
                                @RequestParam(value = "packageType") String packageType,
                                @RequestParam(value = "origin",required = false) String origin) {
        JSONObject result = new JSONObject();
        HashMap<String, Object> param = new HashMap<>();
        param.put("countryCode",countryCode);
        param.put("weight",weight);
        param.put("length",length);
        param.put("width",width);
        param.put("height",height);
        param.put("packageType",packageType);
        if(origin!=null){
            param.put("origin",origin);
        }else{
            param.put("origin","YT-SZ");
        }

        LoginUser loginUser = SecurityFrameworkUtils.getLoginUser();
        Long userId = loginUser.getId();
        ApiSecretKeyDO apiSecretKeyDO = apiSecretKeyService.getApiSecretKeyByUserId(userId);
        if(apiSecretKeyDO!=null){
            List<Map<String, Object>> list = priceTrialService.getGetPriceTrial(yunExpressConfigProperties.customerId,yunExpressConfigProperties.apiSecret,param);
            result.set("priceTrial",list);
            log.info("【云途接口】-查询价格接口返回结果：",list);
        } else{
            result.set("msg","当前用户没有绑定云途账号,请先绑定云途账号");
            log.info("没有绑定云途账号");
        }
        return result.toString();
    }

    /**
     * 运单申请
     * @return
     */
    @PostMapping("/createOrder")
    @PermitAll
    @Operation(summary = "云途物流-运单申请")
    public String createOrder(@RequestBody @Valid OrderRequest orderRequest) {
        List<JSONObject> order = orderService.createOrder(orderRequest);
        log.info("【云途接口】-运单申请接口返回结果：",order);
        return order.toString();
    }


    /**
     * 查询运单
     * @return
     */
    @GetMapping("/getOrder")
    @PermitAll
    @Operation(summary = "云途物流-查询运单")
    public String getOrder(@RequestParam(value = "orderNumber") String orderNumber) {
        JSONObject result = orderService.getOrder(orderNumber);
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
    public String getSender(@RequestParam(value = "orderNumber") String orderNumber) {
        JSONObject result = orderService.getSender(orderNumber);
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
    public String getShippingFeeDetail(@RequestParam(value = "wayBillNumber") String wayBillNumber) {
        JSONObject result = shippingFeeService.getShippingFeeDetail(wayBillNumber);
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
    public String getTrackInfo(@RequestParam(value = "orderNumber") String orderNumber) {
        JSONObject result = shippingFeeService.getTrackInfo(orderNumber);
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
    public String createdOrderSubscribe(@RequestBody OrderSubscribeRequest orderSubscribeRequest) {
        JSONObject result = orderService.createdOrderSubscribe(orderSubscribeRequest);
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
    public String cancelOrderSubscribe(@RequestBody OrderSubscribeRequest orderSubscribeRequest) {
        JSONObject result = orderService.cancelOrderSubscribe(orderSubscribeRequest);
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
    public String updateWeight(@RequestBody UpdateWeightRequest updateWeightRequest) {
        JSONObject result = orderService.updateWeight(updateWeightRequest);
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
    public String deleteOrder(@RequestBody DeleteOrderRequest deleteOrderRequest) {
        JSONObject result = orderService.deleteOrder(deleteOrderRequest);
        log.info("【云途接口】-删除订单接口返回结果：",result);
        return result.toString();
    }


}
