package cn.iocoder.yudao.module.system.controller.yunExpress.model;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;

@Data
@Builder
public class RequestModel {


    String baseUrl;
    //请求路径
    String url;
    //请求参数
    String grantType;
    String appId;
    String appSecret;
    String sourceKey;
    String authorization;

    HashMap<String,Object> params;
}
