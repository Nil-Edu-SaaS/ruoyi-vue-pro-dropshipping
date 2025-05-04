package cn.iocoder.yudao.module.system.controller.yunExpress;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.PriceTrialPageReqVO;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.PriceTrialRespVO;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.PriceTrialSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.yunExpress.PriceTrialDO;
import cn.iocoder.yudao.module.system.service.yunExpress.PriceTrialService;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import java.io.IOException;
import java.util.List;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

@Tag(name = "管理后台 - 物流价格")
@RestController
@RequestMapping("/saas/priceTrial")
@Validated
public class PriceTrialController {

    @Resource
    private PriceTrialService priceTrialService;

    @PostMapping("/create")
    @Operation(summary = "创建物流价格")
    @PreAuthorize("@ss.hasPermission('saas:price-trial:create')")
    public CommonResult<Long> createPriceTrial(@Valid @RequestBody PriceTrialSaveReqVO createReqVO) {
        return success(priceTrialService.createPriceTrial(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新物流价格")
    @PreAuthorize("@ss.hasPermission('saas:price-trial:update')")
    public CommonResult<Boolean> updatePriceTrial(@Valid @RequestBody PriceTrialSaveReqVO updateReqVO) {
        priceTrialService.updatePriceTrial(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除物流价格")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('saas:price-trial:delete')")
    public CommonResult<Boolean> deletePriceTrial(@RequestParam("id") Long id) {
        priceTrialService.deletePriceTrial(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得物流价格")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('saas:price-trial:query')")
    public CommonResult<PriceTrialRespVO> getPriceTrial(@RequestParam("id") Long id) {
        PriceTrialDO priceTrial = priceTrialService.getPriceTrial(id);
        return success(BeanUtils.toBean(priceTrial, PriceTrialRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得物流价格分页")
    @PreAuthorize("@ss.hasPermission('saas:price-trial:query')")
    public CommonResult<PageResult<PriceTrialRespVO>> getPriceTrialPage(@Valid PriceTrialPageReqVO pageReqVO) {
        PageResult<PriceTrialDO> pageResult = priceTrialService.getPriceTrialPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, PriceTrialRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出物流价格 Excel")
    @PreAuthorize("@ss.hasPermission('saas:price-trial:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportPriceTrialExcel(@Valid PriceTrialPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<PriceTrialDO> list = priceTrialService.getPriceTrialPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "物流价格.xls", "数据", PriceTrialRespVO.class,
                        BeanUtils.toBean(list, PriceTrialRespVO.class));
    }

}