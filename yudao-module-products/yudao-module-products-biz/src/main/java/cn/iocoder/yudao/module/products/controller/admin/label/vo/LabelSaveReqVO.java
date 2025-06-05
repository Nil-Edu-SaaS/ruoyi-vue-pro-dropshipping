package cn.iocoder.yudao.module.products.controller.admin.label.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 商品标签表，用于存储商品相关的标签信息新增/修改 Request VO")
@Data
public class LabelSaveReqVO {

    @Schema(description = "主键 ID，自增或唯一标识", requiredMode = Schema.RequiredMode.REQUIRED, example = "18887")
    private Long id;

    @Schema(description = "标签名称", example = "李四")
    private String labelName;



}