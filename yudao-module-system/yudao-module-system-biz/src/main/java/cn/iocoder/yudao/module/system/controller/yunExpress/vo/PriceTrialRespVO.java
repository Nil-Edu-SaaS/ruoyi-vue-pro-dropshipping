package cn.iocoder.yudao.module.system.controller.yunExpress.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 物流价格 Response VO")
@Data
@ExcelIgnoreUnannotated
public class PriceTrialRespVO {

    @Schema(description = "价格id", requiredMode = Schema.RequiredMode.REQUIRED, example = "11570")
    @ExcelProperty("价格id")
    private Long id;

    @Schema(description = "可服务的运输方式代码")
    @ExcelProperty("可服务的运输方式代码")
    private String code;

    @Schema(description = "可服务的运输方式中文名称", example = "王五")
    @ExcelProperty("可服务的运输方式中文名称")
    private String cName;

    @Schema(description = "可服务的运输方式英文名称", example = "张三")
    @ExcelProperty("可服务的运输方式英文名称")
    private String eName;

    @Schema(description = "基础运费")
    @ExcelProperty("基础运费")
    private BigDecimal shippingFee;

    @Schema(description = "挂号费")
    @ExcelProperty("挂号费")
    private BigDecimal registrationFee;

    @Schema(description = "燃油费")
    @ExcelProperty("燃油费")
    private BigDecimal fuelFee;

    @Schema(description = "杂费")
    @ExcelProperty("杂费")
    private BigDecimal sundryFee;

    @Schema(description = "关税预付服务费")
    @ExcelProperty("关税预付服务费")
    private BigDecimal tariffPrepayFee;

    @Schema(description = "总费用")
    @ExcelProperty("总费用")
    private BigDecimal totalFee;

    @Schema(description = "预计时效")
    @ExcelProperty("预计时效")
    private String deliveryDays;

    @Schema(description = "说明(当 Remark 为空时不显示）", example = "你猜")
    @ExcelProperty("说明(当 Remark 为空时不显示）")
    private String remark;

    @Schema(description = "用户token")
    @ExcelProperty("用户token")
    private String authorization;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}