package cn.iocoder.yudao.module.system.service.yunExpress.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.iocoder.yudao.module.system.controller.yunExpress.model.RequestModel;
import cn.iocoder.yudao.module.system.service.yunExpress.OrderService;
import cn.iocoder.yudao.module.system.service.yunExpress.impl.body.BuildBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Override
    public JSONObject createOrder(RequestModel tokenModelBuilder) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.set("Authorization", tokenModelBuilder.getAuthorization());

        List<JSONObject> orderBody = Arrays.asList(BuildBody.createOrderBody());
        System.out.println(orderBody);
        // 创建 HttpEntity
        HttpEntity<List<JSONObject>> requestEntity = new HttpEntity<>(orderBody, headers);

        ResponseEntity<JSONObject> response = restTemplate.exchange(
                tokenModelBuilder.getBaseUrl()+tokenModelBuilder.getUrl(),
                HttpMethod.POST,
                requestEntity,
                JSONObject.class);
        // 处理响应
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            log.error("Failed to create order: {}", response.getStatusCode());
            return null;
        }
    }

    @Override
    public JSONObject getOrder(RequestModel tokenModelBuilder) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println(tokenModelBuilder.getAuthorization());
        headers.set("Authorization", tokenModelBuilder.getAuthorization());
        // 创建 HttpEntity
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        String paramStr = "?OrderNumber="+tokenModelBuilder.getParams().get("OrderNumber");

        // 发送 GET 请求
        ResponseEntity<String> response = restTemplate.exchange(
                tokenModelBuilder.getBaseUrl()+tokenModelBuilder.getUrl()+paramStr,
                HttpMethod.GET,
                requestEntity,
                String.class);
        return JSONUtil.parseObj(response.getBody());
    }

    @Override
    public JSONObject getSender(RequestModel tokenModelBuilder) {
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

    @Override
    public JSONObject createdOrderSubscribe(RequestModel tokenModelBuilder) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.set("Authorization", tokenModelBuilder.getAuthorization());

        JSONObject orderSubscribeBody = BuildBody.getOrderSubscribeBody();
        System.out.println(orderSubscribeBody);
        // 创建 HttpEntity
        HttpEntity<JSONObject> requestEntity = new HttpEntity<>(orderSubscribeBody, headers);

        ResponseEntity<JSONObject> response = restTemplate.exchange(
                tokenModelBuilder.getBaseUrl()+tokenModelBuilder.getUrl(),
                HttpMethod.POST,
                requestEntity,
                JSONObject.class);
        // 处理响应
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            log.error("Failed to create order: {}", response.getStatusCode());
            return null;
        }
    }

    @Override
    public JSONObject cancelOrderSubscribe(RequestModel tokenModelBuilder) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.set("Authorization", tokenModelBuilder.getAuthorization());

        JSONObject orderSubscribeBody = BuildBody.getOrderSubscribeBody();
        System.out.println(orderSubscribeBody);
        // 创建 HttpEntity
        HttpEntity<JSONObject> requestEntity = new HttpEntity<>(orderSubscribeBody, headers);

        ResponseEntity<JSONObject> response = restTemplate.exchange(
                tokenModelBuilder.getBaseUrl()+tokenModelBuilder.getUrl(),
                HttpMethod.POST,
                requestEntity,
                JSONObject.class);
        // 处理响应
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            log.error("Failed to create order: {}", response.getStatusCode());
            return null;
        }
    }

    @Override
    public JSONObject updateWeight(RequestModel tokenModelBuilder) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.set("Authorization", tokenModelBuilder.getAuthorization());

        JSONObject updateWeightBody = BuildBody.updateWeightBody();
        System.out.println(updateWeightBody);
        // 创建 HttpEntity
        HttpEntity<JSONObject> requestEntity = new HttpEntity<>(updateWeightBody, headers);

        ResponseEntity<JSONObject> response = restTemplate.exchange(
                tokenModelBuilder.getBaseUrl()+tokenModelBuilder.getUrl(),
                HttpMethod.POST,
                requestEntity,
                JSONObject.class);
        // 处理响应
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            log.error("Failed to create order: {}", response.getStatusCode());
            return null;
        }
    }

    @Override
    public JSONObject deleteOrder(RequestModel tokenModelBuilder) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.set("Authorization", tokenModelBuilder.getAuthorization());

        JSONObject deleteOrderBody = BuildBody.deleteOrderBody();
        // 创建 HttpEntity
        HttpEntity<JSONObject> requestEntity = new HttpEntity<>(deleteOrderBody, headers);

        ResponseEntity<JSONObject> response = restTemplate.exchange(
                tokenModelBuilder.getBaseUrl()+tokenModelBuilder.getUrl(),
                HttpMethod.POST,
                requestEntity,
                JSONObject.class);
        // 处理响应
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            log.error("Failed to create order: {}", response.getStatusCode());
            return null;
        }
    }
}
