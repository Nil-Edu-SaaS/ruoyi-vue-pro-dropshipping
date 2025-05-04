package cn.iocoder.yudao.module.system.controller.yunExpress.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - api秘钥分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ApiSecretKeyPageReqVO extends PageParam {

    @Schema(description = "用户账号", example = "芋艿")
    private String username;

    @Schema(description = "客户编号", example = "7696")
    private String customerId;

    @Schema(description = "api秘钥")
    private String apiSecret;

    @Schema(description = "令牌")
    private String authorization;

    @Schema(description = "环境  dev：开发环境  pro：生产")
    private String env;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}