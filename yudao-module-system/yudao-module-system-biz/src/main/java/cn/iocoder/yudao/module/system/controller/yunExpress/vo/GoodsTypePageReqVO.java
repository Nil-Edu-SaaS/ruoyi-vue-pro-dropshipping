package cn.iocoder.yudao.module.system.controller.yunExpress.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 货品类型分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GoodsTypePageReqVO extends PageParam {

    @Schema(description = "货品类型中文名称", example = "王五")
    private String cName;

    @Schema(description = "货品类型英文名称", example = "李四")
    private String eName;

    @Schema(description = "用户token")
    private String authorization;

}