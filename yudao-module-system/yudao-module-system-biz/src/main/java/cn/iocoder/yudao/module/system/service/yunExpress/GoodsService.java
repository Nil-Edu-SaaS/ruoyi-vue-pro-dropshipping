package cn.iocoder.yudao.module.system.service.yunExpress;

import cn.iocoder.yudao.module.system.controller.yunExpress.model.RequestModel;
import top.taolord.yunexpress.domain.model.GoodsType;

import java.util.List;

public interface GoodsService {
    List<GoodsType> getGoodsType(String customerId,String apiSecret);
}
