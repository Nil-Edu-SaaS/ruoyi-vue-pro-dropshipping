package cn.iocoder.yudao.module.system.service.yunExpress;

import cn.hutool.json.JSONObject;
import cn.iocoder.yudao.module.system.controller.yunExpress.model.RequestModel;

public interface OrderService {

    JSONObject createOrder(RequestModel tokenModelBuilder);

    JSONObject getOrder(RequestModel tokenModelBuilder);

    JSONObject getSender(RequestModel tokenModelBuilder);

    JSONObject createdOrderSubscribe(RequestModel tokenModelBuilder);

    JSONObject cancelOrderSubscribe(RequestModel tokenModelBuilder);

    JSONObject updateWeight(RequestModel tokenModelBuilder);

    JSONObject deleteOrder(RequestModel tokenModelBuilder);


}
