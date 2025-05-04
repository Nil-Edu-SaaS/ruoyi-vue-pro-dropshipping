package cn.iocoder.yudao.module.system.service.yunExpress;

import cn.hutool.json.JSONObject;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.DeleteOrderRequest;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.OrderSubscribeRequest;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.UpdateWeightRequest;
import top.taolord.yunexpress.domain.model.OrderRequest;

import java.util.List;

public interface OrderService {

    List<JSONObject> createOrder(OrderRequest orderRequest);

    JSONObject getOrder(String orderNumber);

    JSONObject getSender(String orderNumber);

    JSONObject createdOrderSubscribe(OrderSubscribeRequest orderSubscribeRequest);

    JSONObject cancelOrderSubscribe(OrderSubscribeRequest orderSubscribeRequest);

    JSONObject updateWeight(UpdateWeightRequest updateWeightRequest);

    JSONObject deleteOrder(DeleteOrderRequest deleteOrderRequest);


}
