package cn.iocoder.yudao.module.products.controller.admin.crawlstate.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 商品爬取状态临时记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class CrawlStateRespVO {

    @Schema(description = "主键 ID，自增或唯一标识", requiredMode = Schema.RequiredMode.REQUIRED, example = "7346")
    @ExcelProperty("主键 ID，自增或唯一标识")
    private Long id;

    @Schema(description = "爬取状态（0-未爬取，1-成功，2-失败等）")
    @ExcelProperty("爬取状态（0-未爬取，1-成功，2-失败等）")
    private Long crawlState;

    @Schema(description = "爬取结果的文本描述或备注信息")
    @ExcelProperty("爬取结果的文本描述或备注信息")
    private String crawlText;

    @Schema(description = "记录创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("记录创建时间")
    private LocalDateTime createTime;

}