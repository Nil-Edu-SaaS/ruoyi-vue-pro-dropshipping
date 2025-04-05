package cn.iocoder.yudao.module.system.service.yunExpress.impl;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.iocoder.yudao.module.system.controller.yunExpress.model.RequestModel;
import cn.iocoder.yudao.module.system.service.yunExpress.PriceTrialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class PriceTrialServiceImpl implements PriceTrialService {

    /**
     * 获取价格
     * @param tokenModelBuilder
     * @return
     */

    public JSONObject getGetPriceTrial(RequestModel tokenModelBuilder) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println(tokenModelBuilder.getAuthorization());
        headers.set("Authorization", tokenModelBuilder.getAuthorization());
        // 创建 HttpEntity
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        String paramStr = "?CountryCode="+tokenModelBuilder.getParams().get("CountryCode")+"&Weight="+tokenModelBuilder.getParams().get("Weight");

        // 发送 GET 请求
        ResponseEntity<String> response = restTemplate.exchange(
                tokenModelBuilder.getBaseUrl()+tokenModelBuilder.getUrl()+paramStr,
                HttpMethod.GET,
                requestEntity,
                String.class);
        return JSONUtil.parseObj(response.getBody());
    }
}
