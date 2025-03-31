package cn.iocoder.yudao.module.top.product.vo;

import cn.iocoder.yudao.module.top.product.po.ProductImgPO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
@Schema(description = "管理后台 - 商品详情 response VO")
@Data
public class ProductInfoVo extends ProductRespVO{

    /**
     * 商品图片
     * */
    private List<ProductImgPO> imagList;
}
