package cn.iocoder.yudao.module.system.controller.yunExpress.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - api秘钥 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ApiSecretKeyRespVO {

    @Schema(description = "秘钥id", requiredMode = Schema.RequiredMode.REQUIRED, example = "23677")
    @ExcelProperty("秘钥id")
    private Long id;

    @Schema(description = "用户账号", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @ExcelProperty("用户账号")
    private String username;

    @Schema(description = "客户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "7696")
    @ExcelProperty("客户编号")
    private String customerId;

    @Schema(description = "api秘钥", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("api秘钥")
    private String apiSecret;

    @Schema(description = "令牌")
    @ExcelProperty("令牌")
    private String authorization;

    @Schema(description = "环境  dev：开发环境  pro：生产")
    @ExcelProperty("环境  dev：开发环境  pro：生产")
    private String env;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}