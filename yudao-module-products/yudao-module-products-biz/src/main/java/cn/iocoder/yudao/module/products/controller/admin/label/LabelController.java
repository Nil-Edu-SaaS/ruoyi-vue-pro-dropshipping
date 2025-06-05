package cn.iocoder.yudao.module.products.controller.admin.label;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.products.controller.admin.label.vo.*;
import cn.iocoder.yudao.module.products.dal.dataobject.label.LabelDO;
import cn.iocoder.yudao.module.products.service.label.LabelService;

@Tag(name = "管理后台 - 商品标签表，用于存储商品相关的标签信息")
@RestController
@RequestMapping("/products/label")
@Validated
public class LabelController {

    @Resource
    private LabelService labelService;

    @PostMapping("/create")
    @Operation(summary = "创建商品标签表，用于存储商品相关的标签信息")
    @PreAuthorize("@ss.hasPermission('products:label:create')")
    public CommonResult<Long> createLabel(@Valid @RequestBody LabelSaveReqVO createReqVO) {
        return success(labelService.createLabel(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新商品标签表，用于存储商品相关的标签信息")
    @PreAuthorize("@ss.hasPermission('products:label:update')")
    public CommonResult<Boolean> updateLabel(@Valid @RequestBody LabelSaveReqVO updateReqVO) {
        labelService.updateLabel(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除商品标签表，用于存储商品相关的标签信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('products:label:delete')")
    public CommonResult<Boolean> deleteLabel(@RequestParam("id") Long id) {
        labelService.deleteLabel(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得商品标签表，用于存储商品相关的标签信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('products:label:query')")
    public CommonResult<LabelRespVO> getLabel(@RequestParam("id") Long id) {
        LabelDO label = labelService.getLabel(id);
        return success(BeanUtils.toBean(label, LabelRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得商品标签表，用于存储商品相关的标签信息分页")
    @PreAuthorize("@ss.hasPermission('products:label:query')")
    public CommonResult<PageResult<LabelRespVO>> getLabelPage(@Valid LabelPageReqVO pageReqVO) {
        PageResult<LabelDO> pageResult = labelService.getLabelPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, LabelRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出商品标签表，用于存储商品相关的标签信息 Excel")
    @PreAuthorize("@ss.hasPermission('products:label:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportLabelExcel(@Valid LabelPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<LabelDO> list = labelService.getLabelPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "商品标签表，用于存储商品相关的标签信息.xls", "数据", LabelRespVO.class,
                        BeanUtils.toBean(list, LabelRespVO.class));
    }

}