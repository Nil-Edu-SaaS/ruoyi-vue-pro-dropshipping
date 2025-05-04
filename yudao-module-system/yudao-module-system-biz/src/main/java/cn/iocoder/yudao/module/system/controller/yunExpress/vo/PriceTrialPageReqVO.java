package cn.iocoder.yudao.module.system.controller.yunExpress.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 物流价格分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PriceTrialPageReqVO extends PageParam {

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

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}