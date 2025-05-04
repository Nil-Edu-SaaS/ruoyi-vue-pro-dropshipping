package cn.iocoder.yudao.module.system.service.yunExpress.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.iocoder.yudao.module.system.controller.yunExpress.model.RequestModel;
import cn.iocoder.yudao.module.system.service.yunExpress.ShippingFeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import top.taolord.yunexpress.application.YunExpressClient;
import top.taolord.yunexpress.domain.model.ShippingFee;
import top.taolord.yunexpress.domain.model.TrackInfo;

import javax.annotation.Resource;

@Service
@Slf4j
public class ShippingFeeServiceImpl implements ShippingFeeService {

    @Resource
    private YunExpressClient client;

    @Override
    public JSONObject getShippingFeeDetail(String wayBillNumber) {

        // 发送 GET 请求
        ShippingFee shippingFee = client.getShippingFeeDetail(wayBillNumber);

        JSONObject jsonObject = new JSONObject();
        jsonObject.set("wayBillNumber", shippingFee.wayBillNumber());
        jsonObject.set("details", shippingFee.feeDetails());

        return jsonObject;
    }

    @Override
    public JSONObject getTrackInfo(String orderNumber) {

        TrackInfo trackInfo = client.getTrackInfo(orderNumber);

        JSONObject jsonObject = new JSONObject();
        jsonObject.set("orderNumber", trackInfo.orderNumber());
        jsonObject.set("details", trackInfo.trackDetails());

        return jsonObject;
    }
}
