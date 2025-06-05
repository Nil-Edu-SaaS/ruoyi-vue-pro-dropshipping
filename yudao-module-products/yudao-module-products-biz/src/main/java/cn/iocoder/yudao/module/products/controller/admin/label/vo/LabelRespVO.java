package cn.iocoder.yudao.module.products.controller.admin.label.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 商品标签表，用于存储商品相关的标签信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class LabelRespVO {

    @Schema(description = "主键 ID，自增或唯一标识", requiredMode = Schema.RequiredMode.REQUIRED, example = "18887")
    @ExcelProperty("主键 ID，自增或唯一标识")
    private Long id;

    @Schema(description = "标签名称", example = "李四")
    @ExcelProperty("标签名称")
    private String labelName;

    @Schema(description = "记录创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("记录创建时间")
    private LocalDateTime createTime;



}