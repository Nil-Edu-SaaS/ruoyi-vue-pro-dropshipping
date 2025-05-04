package cn.iocoder.yudao.module.system.service.yunExpress.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.iocoder.yudao.module.system.controller.yunExpress.model.RequestModel;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.DeleteOrderRequest;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.OrderSubscribeRequest;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.UpdateWeightRequest;
import cn.iocoder.yudao.module.system.service.yunExpress.OrderService;
import cn.iocoder.yudao.module.system.service.yunExpress.impl.base.BaseServiceImpl;
import cn.iocoder.yudao.module.system.service.yunExpress.impl.body.BuildBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import top.taolord.yunexpress.application.YunExpressClient;
import top.taolord.yunexpress.domain.model.Order;
import top.taolord.yunexpress.domain.model.OrderRequest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {

    @Resource
    private YunExpressClient client;
    @Override
    public List<JSONObject> createOrder(OrderRequest orderRequest) {
        return client.createOrder(orderRequest);
    }

    @Override
    public JSONObject getOrder(String orderNumber) {
        // 发送 GET 请求
        Order order = client.getOrder(orderNumber);
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("orderNumber", order.orderNumber());
        jsonObject.set("details", order.details());
        return jsonObject;
    }

    @Override
    public JSONObject getSender(String orderNumber) {
        // 发送 GET 请求
        Order order = client.getSender(orderNumber);
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("orderNumber", order.orderNumber());
        jsonObject.set("details", order.details());
        return jsonObject;
    }

    @Override
    public JSONObject createdOrderSubscribe(OrderSubscribeRequest orderSubscribeRequest) {

        Order order = client.cancelOrderSubscription(orderSubscribeRequest.getWayBillNumber(), orderSubscribeRequest.getDisplayMode(), orderSubscribeRequest.getQueryMode());
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("orderNumber", order.orderNumber());
        jsonObject.set("details", order.details());
        return jsonObject;
    }

    @Override
    public JSONObject cancelOrderSubscribe(OrderSubscribeRequest orderSubscribeRequest) {
        Order order = client.cancelOrderSubscription(orderSubscribeRequest.getWayBillNumber(),orderSubscribeRequest.getDisplayMode(), orderSubscribeRequest.getQueryMode());
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("orderNumber", order.orderNumber());
        jsonObject.set("details", order.details());
        return jsonObject;
    }

    @Override
    public JSONObject updateWeight(UpdateWeightRequest updateWeightRequest) {
        Order order = client.updateWeight(updateWeightRequest.getOrderNumber(), parseDouble(updateWeightRequest.getWeight()));
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("orderNumber", order.orderNumber());
        jsonObject.set("details", order.details());
        return jsonObject;
    }

    @Override
    public JSONObject deleteOrder(DeleteOrderRequest deleteOrderRequest) {
        Order order = client.deleteOrder(deleteOrderRequest.getOrderNumber(), deleteOrderRequest.getOrderType());
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("orderNumber", order.orderNumber());
        jsonObject.set("details", order.details());
        return jsonObject;
    }
}
