package cn.iocoder.yudao.module.top.product.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - 商品信息新增/修改 Request VO")
@Data
public class ProductSaveReqVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "10586")
    private Long id;

    @Schema(description = "商品名称", example = "芋艿")
    private String productName;

    @Schema(description = "商品描述")
    private String productDepict;

    @Schema(description = "商品来源(供货商地址)")
    private String productSrc;

    @Schema(description = "成本价", example = "3830")
    private BigDecimal costPrice;

    @Schema(description = "零售价", example = "4031")
    private BigDecimal retailPrice;

    @Schema(description = "商品状态")
    private Boolean state;

    @Schema(description = "商品图片")
    private List<ProductImgSaveReqVO> imagList;

    @Schema(description = "创建人")
    private String creator;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "修改人")
    private String updater;

    @Schema(description = "修改时间")
    private LocalDateTime updateTime;

}