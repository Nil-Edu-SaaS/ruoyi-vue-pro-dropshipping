package cn.iocoder.yudao.module.products.controller.admin.crawlstate.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 商品爬取状态临时记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CrawlStatePageReqVO extends PageParam {

    @Schema(description = "爬取状态（0-未爬取，1-成功，2-失败等）")
    private Long crawlState;

    @Schema(description = "爬取结果的文本描述或备注信息")
    private String crawlText;

    @Schema(description = "记录创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}