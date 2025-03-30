package cn.iocoder.yudao.module.top.product.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 商品信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ProductRespVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "10586")
    @ExcelProperty("主键")
    private Long id;

    @Schema(description = "商品名称", example = "芋艿")
    @ExcelProperty("商品名称")
    private String productName;

    @Schema(description = "商品描述")
    @ExcelProperty("商品描述")
    private String productDepict;

    @Schema(description = "商品来源(供货商地址)")
    @ExcelProperty("商品来源(供货商地址)")
    private String productSrc;

    @Schema(description = "成本价", example = "3830")
    @ExcelProperty("成本价")
    private BigDecimal costPrice;

    @Schema(description = "零售价", example = "4031")
    @ExcelProperty("零售价")
    private BigDecimal retailPrice;

    @Schema(description = "商品状态")
    @ExcelProperty("商品状态")
    private Boolean state;

    @Schema(description = "创建人")
    @ExcelProperty("创建人")
    private String createOperate;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime cretaeDate;

    @Schema(description = "修改人")
    @ExcelProperty("修改人")
    private String updateOperate;

    @Schema(description = "修改时间")
    @ExcelProperty("修改时间")
    private LocalDateTime udpateDate;

}