package cn.iocoder.yudao.module.system.controller.yunExpress.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 货品类型 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GoodsTypeRespVO {

    @Schema(description = "货品类型id", requiredMode = Schema.RequiredMode.REQUIRED, example = "25082")
    @ExcelProperty("货品类型id")
    private Long id;

    @Schema(description = "货品类型中文名称", example = "王五")
    @ExcelProperty("货品类型中文名称")
    private String cName;

    @Schema(description = "货品类型英文名称", example = "李四")
    @ExcelProperty("货品类型英文名称")
    private String eName;

    @Schema(description = "用户token")
    @ExcelProperty("用户token")
    private String authorization;

}