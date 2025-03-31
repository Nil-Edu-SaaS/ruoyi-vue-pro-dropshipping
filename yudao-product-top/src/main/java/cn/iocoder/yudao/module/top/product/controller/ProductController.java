package cn.iocoder.yudao.module.top.product.controller;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.module.system.enums.common.SexEnum;
import cn.iocoder.yudao.module.top.product.po.ProductPO;
import cn.iocoder.yudao.module.top.product.service.ProductService;
import cn.iocoder.yudao.module.top.product.vo.*;
import io.swagger.v3.oas.annotations.Parameters;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import java.math.BigDecimal;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import org.springframework.web.multipart.MultipartFile;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Tag(name = "管理后台 - 商品信息")
@RestController
@RequestMapping("/top/product")
@Validated
public class ProductController {

    @Resource
    private ProductService productService;



    @PostMapping("/create")
    @Operation(summary = "创建商品信息")
    @PreAuthorize("@ss.hasPermission('t:product:create')")
    public CommonResult<Long> createProduct(@Valid @RequestBody ProductSaveReqVO createReqVO) {
        return success(productService.createProduct(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新商品信息")
    @PreAuthorize("@ss.hasPermission('t:product:update')")
    public CommonResult<Boolean> updateProduct(@Valid @RequestBody ProductSaveReqVO updateReqVO) {
        productService.updateProduct(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除商品信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('t:product:delete')")
    public CommonResult<Boolean> deleteProduct(@RequestParam("id") Long id) {
        productService.deleteProduct(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得商品信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('t:product:query')")
    public CommonResult<ProductRespVO> getProduct(@RequestParam("id") Long id) {
        ProductInfoVo product = productService.getProduct(id);
        return success(BeanUtils.toBean(product, ProductInfoVo.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得商品信息分页")
    //@PreAuthorize("@ss.hasPermission('t:product:query')")
    public CommonResult<PageResult<ProductRespVO>> getProductPage(@Valid ProductPageReqVO pageReqVO) {
        PageResult<ProductPO> pageResult = productService.getProductPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ProductRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出商品信息 Excel")
    @PreAuthorize("@ss.hasPermission('t:product:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportProductExcel(@Valid ProductPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ProductPO> list = productService.getProductPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "商品信息.xls", "数据", ProductRespVO.class,
                        BeanUtils.toBean(list, ProductRespVO.class));
    }


    @GetMapping("/get-import-template")
    @Operation(summary = "获得导入商品模板")
    public void importTemplate(HttpServletResponse response) throws IOException {
        // 手动创建导出 demo
        List<ProductImportExcelVO> list = Arrays.asList(

                ProductImportExcelVO.builder().productName("衬衫").productDepict("http://img.alicdn.com/img/i1/7507168693/O1CN01jQdmqH2E5S2j9GLFj_!!4611686018427383221-0-saturn_solar.jpg")
                        .productSrc("中国")
                        .costPrice(BigDecimal.valueOf(10.00)).retailPrice(BigDecimal.valueOf(20.00)).build(),
                ProductImportExcelVO.builder().productName("裤子").productDepict("http://img.alicdn.com/img/i2/23330073/O1CN01drngyi1CPTt1bI0qs_!!0-saturn_solar.jpg")
                        .productSrc("中国")
                        .costPrice(BigDecimal.valueOf(25.00)).retailPrice(BigDecimal.valueOf(50.00)).build()
                /*ProductImportExcelVO.builder().username("yuanma").deptId(2L).email("yuanma@iocoder.cn").mobile("15601701300")
                        .nickname("源码").status(CommonStatusEnum.DISABLE.getStatus()).sex(SexEnum.FEMALE.getSex()).build()*/
        );
        // 输出
        ExcelUtils.write(response, "用户导入模板.xls", "用户列表", ProductImportExcelVO.class, list);
    }



    @PostMapping("/import-excel")
    @Operation(summary = "导入用户")
    @Parameters({
            @Parameter(name = "file", description = "Excel 文件", required = true),
            @Parameter(name = "updateSupport", description = "是否支持更新，默认为 false", example = "true")
    })
    @PreAuthorize("@ss.hasPermission('system:user:import')")
    public CommonResult<ProductImportRespVO> importExcel(@RequestParam("file") MultipartFile file,
                                                         @RequestParam(value = "updateSupport", required = false, defaultValue = "false") Boolean updateSupport) throws Exception {
        List<ProductImportExcelVO> list = ExcelUtils.read(file, ProductImportExcelVO.class);
        return success(productService.importUserList(list, updateSupport));
    }


}