package cn.iocoder.yudao.module.system.service.yunExpress.impl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.iocoder.yudao.module.system.controller.yunExpress.model.RequestModel;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.GoodsTypeSaveReqVO;
import cn.iocoder.yudao.module.system.service.yunExpress.GoodsService;
import cn.iocoder.yudao.module.system.service.yunExpress.GoodsTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsTypeService goodsTypeService;


    /**
     * 获取货品类型
     * @param tokenModelBuilder
     * @return
     */
    public JSONObject getGoodsType(RequestModel tokenModelBuilder) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println(tokenModelBuilder.getAuthorization());
        headers.set("Authorization", tokenModelBuilder.getAuthorization());

        // 创建 HttpEntity
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        // 发送 POST 请求
        ResponseEntity<String> response = restTemplate.exchange(
                tokenModelBuilder.getBaseUrl()+tokenModelBuilder.getUrl(),
                HttpMethod.GET,
                requestEntity,
                String.class);

        JSONObject responseBody = JSONUtil.parseObj(response.getBody());
        JSONArray itemsArray = responseBody.getJSONArray("Items");
        List<JSONObject> itemsList = itemsArray.toList(JSONObject.class);
        itemsList.forEach(item -> {
            GoodsTypeSaveReqVO goodsTypeSaveReqVO = new GoodsTypeSaveReqVO();
            goodsTypeSaveReqVO.setId(Long.valueOf(String.valueOf(item.get("Id"))));
            goodsTypeSaveReqVO.setCName(String.valueOf(item.get("CName")));
            goodsTypeSaveReqVO.setEName(String.valueOf(item.get("EName")));
            goodsTypeSaveReqVO.setAuthorization(tokenModelBuilder.getAuthorization());
            goodsTypeService.createGoodsType(goodsTypeSaveReqVO);
        });

        return JSONUtil.parseObj(response.getBody());
    }
}
