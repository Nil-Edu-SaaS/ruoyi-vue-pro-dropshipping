package cn.iocoder.yudao.module.system.service.yunExpress.impl;

import cn.iocoder.yudao.module.system.controller.yunExpress.model.RequestModel;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.GoodsTypeSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.yunExpress.GoodsTypeDO;
import cn.iocoder.yudao.module.system.service.yunExpress.GoodsService;
import cn.iocoder.yudao.module.system.service.yunExpress.impl.base.BaseServiceImpl;
import top.taolord.yunexpress.application.YunExpressClient;
import cn.iocoder.yudao.module.system.service.yunExpress.GoodsTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.taolord.yunexpress.domain.model.GoodsType;
import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class GoodsServiceImpl extends BaseServiceImpl implements GoodsService {


    @Resource
    private YunExpressClient client;

    @Resource
    private GoodsTypeService goodsTypeService;


    /**
     * 获取货品类型
     * @param customerId,apiSecret
     * @return
     */
    public List<GoodsType> getGoodsType(String customerId,String apiSecret) {

        List<GoodsType> goodsTypes = client.getGoodsTypes();
        goodsTypes.forEach(goodsType -> {
            GoodsTypeDO goodsTypeDO = goodsTypeService.getGoodsType(goodsType.id());
            GoodsTypeSaveReqVO goodsTypeSaveReqVO = new GoodsTypeSaveReqVO();
            goodsTypeSaveReqVO.setId(Long.valueOf(String.valueOf(goodsType.id())));
            goodsTypeSaveReqVO.setCName(String.valueOf(goodsType.cName()));
            goodsTypeSaveReqVO.setEName(String.valueOf(goodsType.eName()));
            goodsTypeSaveReqVO.setAuthorization(buildToken(customerId,apiSecret));

            if(goodsTypeDO!=null){
                goodsTypeService.updateGoodsType(goodsTypeSaveReqVO);
            }else{
                goodsTypeService.createGoodsType(goodsTypeSaveReqVO);
            }
        });
        return goodsTypes;
    }
}
