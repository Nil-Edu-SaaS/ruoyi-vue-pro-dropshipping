package cn.iocoder.yudao.module.top.product.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 商品图片 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ProductImgRespVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "9619")
    @ExcelProperty("主键")
    private Long id;

    @Schema(description = "商品id", example = "19930")
    @ExcelProperty("商品id")
    private Long pId;

    @Schema(description = "商品图片")
    @ExcelProperty("商品图片")
    private String productImgAddr;

    @Schema(description = "是否主图  0:否 1:是")
    @ExcelProperty("是否主图  0:否 1:是")
    private Boolean isMaster;

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