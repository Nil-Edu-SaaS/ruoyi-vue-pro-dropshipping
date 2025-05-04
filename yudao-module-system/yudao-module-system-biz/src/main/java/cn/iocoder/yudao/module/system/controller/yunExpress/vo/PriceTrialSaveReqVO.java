package cn.iocoder.yudao.module.system.controller.yunExpress.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 物流价格新增/修改 Request VO")
@Data
public class PriceTrialSaveReqVO {

    @Schema(description = "价格id", requiredMode = Schema.RequiredMode.REQUIRED, example = "11570")
    private Long id;

    @Schema(description = "可服务的运输方式代码")
    private String code;

    @Schema(description = "可服务的运输方式中文名称", example = "王五")
    private String cName;

    @Schema(description = "可服务的运输方式英文名称", example = "张三")
    private String eName;

    @Schema(description = "基础运费")
    private BigDecimal shippingFee;

    @Schema(description = "挂号费")
    private BigDecimal registrationFee;

    @Schema(description = "燃油费")
    private BigDecimal fuelFee;

    @Schema(description = "杂费")
    private BigDecimal sundryFee;

    @Schema(description = "关税预付服务费")
    private BigDecimal tariffPrepayFee;

    @Schema(description = "总费用")
    private BigDecimal totalFee;

    @Schema(description = "预计时效")
    private String deliveryDays;

    @Schema(description = "说明(当 Remark 为空时不显示）", example = "你猜")
    private String remark;

    @Schema(description = "用户token")
    private String authorization;

}