package cn.iocoder.yudao.module.top.product.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 商品信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductPageReqVO extends PageParam {

    @Schema(description = "商品名称", example = "芋艿")
    private String productName;

    @Schema(description = "商品描述")
    private String productDepict;

    @Schema(description = "商品来源(供货商地址)")
    private String productSrc;

    @Schema(description = "成本价", example = "3830")
    private BigDecimal costPrice;

    @Schema(description = "零售价", example = "4031")
    private BigDecimal retailPrice;

    @Schema(description = "商品状态")
    private Boolean state;

    @Schema(description = "创建人")
    private String creator;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "修改人")
    private String updater;

    @Schema(description = "修改时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] updateTime;

}