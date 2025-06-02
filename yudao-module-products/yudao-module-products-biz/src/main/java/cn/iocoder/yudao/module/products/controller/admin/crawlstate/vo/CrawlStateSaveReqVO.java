package cn.iocoder.yudao.module.products.controller.admin.crawlstate.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "管理后台 - 商品爬取状态临时记录新增/修改 Request VO")
@Data
public class CrawlStateSaveReqVO {

    @Schema(description = "主键 ID，自增或唯一标识", requiredMode = Schema.RequiredMode.REQUIRED, example = "7346")
    private Long id;

    @Schema(description = "爬取状态（0-未爬取，1-成功，2-失败等）")
    private Long crawlState;

    @Schema(description = "爬取结果的文本描述或备注信息")
    private String crawlText;

    @Schema(description = "爬取地址")
    private String crawlUrl;

}