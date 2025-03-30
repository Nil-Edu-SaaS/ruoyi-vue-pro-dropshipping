package cn.iocoder.yudao.module.top.product.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 商品图片新增/修改 Request VO")
@Data
public class ProductImgSaveReqVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "9619")
    private Long id;

    @Schema(description = "商品id", example = "19930")
    private Long pId;

    @Schema(description = "商品图片")
    private String productImgAddr;

    @Schema(description = "是否主图  0:否 1:是")
    private Boolean isMaster;

    @Schema(description = "创建人")
    private String createOperate;

    @Schema(description = "创建时间")
    private LocalDateTime cretaeDate;

    @Schema(description = "修改人")
    private String updateOperate;

    @Schema(description = "修改时间")
    private LocalDateTime udpateDate;

}