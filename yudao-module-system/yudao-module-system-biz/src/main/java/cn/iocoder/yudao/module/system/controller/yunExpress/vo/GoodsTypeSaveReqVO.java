package cn.iocoder.yudao.module.system.controller.yunExpress.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 货品类型新增/修改 Request VO")
@Data
public class GoodsTypeSaveReqVO {

    @Schema(description = "货品类型id", requiredMode = Schema.RequiredMode.REQUIRED, example = "25082")
    private Long id;

    @Schema(description = "货品类型中文名称", example = "王五")
    private String cName;

    @Schema(description = "货品类型英文名称", example = "李四")
    private String eName;

    @Schema(description = "用户token")
    private String authorization;

}