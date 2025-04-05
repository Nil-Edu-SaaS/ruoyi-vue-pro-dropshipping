package cn.iocoder.yudao.module.system.service.yunExpress;

import cn.hutool.json.JSONObject;
import cn.iocoder.yudao.module.system.controller.yunExpress.model.RequestModel;

public interface GoodsService{
    JSONObject getGoodsType(RequestModel tokenModelBuilder);
}
