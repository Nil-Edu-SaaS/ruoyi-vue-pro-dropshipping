package cn.iocoder.yudao.module.system.controller.yunExpress.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - api秘钥新增/修改 Request VO")
@Data
public class ApiSecretKeySaveReqVO {

    @Schema(description = "秘钥id", requiredMode = Schema.RequiredMode.REQUIRED, example = "23677")
    private Long id;

    @Schema(description = "用户账号", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @NotEmpty(message = "用户账号不能为空")
    private String username;

    @Schema(description = "客户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "7696")
    @NotEmpty(message = "客户编号不能为空")
    private String customerId;

    @Schema(description = "api秘钥", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "api秘钥不能为空")
    private String apiSecret;

    @Schema(description = "令牌")
    private String authorization;

    @Schema(description = "环境  dev：开发环境  pro：生产")
    private String env;

}