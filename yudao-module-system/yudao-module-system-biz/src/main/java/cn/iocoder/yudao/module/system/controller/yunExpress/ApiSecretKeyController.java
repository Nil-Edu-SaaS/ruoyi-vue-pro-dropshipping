package cn.iocoder.yudao.module.system.controller.yunExpress;

import cn.iocoder.yudao.module.system.controller.yunExpress.vo.ApiSecretKeyPageReqVO;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.ApiSecretKeyRespVO;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.ApiSecretKeySaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.yunExpress.ApiSecretKeyDO;
import cn.iocoder.yudao.module.system.service.yunExpress.ApiSecretKeyService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
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

@Tag(name = "管理后台 - api秘钥")
@RestController
@RequestMapping("/admin-api/yunExpress/apiSecretKey")
@Validated
public class ApiSecretKeyController {

    @Resource
    private ApiSecretKeyService apiSecretKeyService;

    @PostMapping("/create")
    @Operation(summary = "创建api秘钥")
    @PreAuthorize("@ss.hasPermission('yunExpress:api-secret-key:create')")
    public CommonResult<Long> createApiSecretKey(@Valid @RequestBody ApiSecretKeySaveReqVO createReqVO) {
        return success(apiSecretKeyService.createApiSecretKey(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新api秘钥")
    @PreAuthorize("@ss.hasPermission('yunExpress:api-secret-key:update')")
    public CommonResult<Boolean> updateApiSecretKey(@Valid @RequestBody ApiSecretKeySaveReqVO updateReqVO) {
        apiSecretKeyService.updateApiSecretKey(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除api秘钥")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('yunExpress:api-secret-key:delete')")
    public CommonResult<Boolean> deleteApiSecretKey(@RequestParam("id") Long id) {
        apiSecretKeyService.deleteApiSecretKey(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得api秘钥")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('yunExpress:api-secret-key:query')")
    public CommonResult<ApiSecretKeyRespVO> getApiSecretKey(@RequestParam("id") Long id) {
        ApiSecretKeyDO apiSecretKey = apiSecretKeyService.getApiSecretKey(id);
        return success(BeanUtils.toBean(apiSecretKey, ApiSecretKeyRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得api秘钥分页")
    @PreAuthorize("@ss.hasPermission('yunExpress:api-secret-key:query')")
    public CommonResult<PageResult<ApiSecretKeyRespVO>> getApiSecretKeyPage(@Valid ApiSecretKeyPageReqVO pageReqVO) {
        PageResult<ApiSecretKeyDO> pageResult = apiSecretKeyService.getApiSecretKeyPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ApiSecretKeyRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出api秘钥 Excel")
    @PreAuthorize("@ss.hasPermission('yunExpress:api-secret-key:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportApiSecretKeyExcel(@Valid ApiSecretKeyPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ApiSecretKeyDO> list = apiSecretKeyService.getApiSecretKeyPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "api秘钥.xls", "数据", ApiSecretKeyRespVO.class,
                        BeanUtils.toBean(list, ApiSecretKeyRespVO.class));
    }

}