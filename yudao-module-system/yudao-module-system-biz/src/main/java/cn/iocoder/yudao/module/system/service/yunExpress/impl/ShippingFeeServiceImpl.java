package cn.iocoder.yudao.module.system.service.yunExpress.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.iocoder.yudao.module.system.controller.yunExpress.model.RequestModel;
import cn.iocoder.yudao.module.system.service.yunExpress.ShippingFeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ShippingFeeServiceImpl implements ShippingFeeService {
    @Override
    public JSONObject getShippingFeeDetail(RequestModel tokenModelBuilder) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println(tokenModelBuilder.getAuthorization());
        headers.set("Authorization", tokenModelBuilder.getAuthorization());
        // 创建 HttpEntity
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        String paramStr = "?WayBillNumber=" + tokenModelBuilder.getParams().get("WayBillNumber");

        // 发送 GET 请求
        ResponseEntity<String> response = restTemplate.exchange(
                tokenModelBuilder.getBaseUrl() + tokenModelBuilder.getUrl() + paramStr,
                HttpMethod.GET,
                requestEntity,
                String.class);
        return JSONUtil.parseObj(response.getBody());
    }

    @Override
    public JSONObject getTrackInfo(RequestModel tokenModelBuilder) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println(tokenModelBuilder.getAuthorization());
        headers.set("Authorization", tokenModelBuilder.getAuthorization());
        // 创建 HttpEntity
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        String paramStr = "?OrderNumber=" + tokenModelBuilder.getParams().get("OrderNumber");

        // 发送 GET 请求
        ResponseEntity<String> response = restTemplate.exchange(
                tokenModelBuilder.getBaseUrl() + tokenModelBuilder.getUrl() + paramStr,
                HttpMethod.GET,
                requestEntity,
                String.class);
        return JSONUtil.parseObj(response.getBody());
    }
}
