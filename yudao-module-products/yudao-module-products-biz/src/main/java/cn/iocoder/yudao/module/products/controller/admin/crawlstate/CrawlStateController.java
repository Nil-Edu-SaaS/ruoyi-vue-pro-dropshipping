package cn.iocoder.yudao.module.products.controller.admin.crawlstate;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;


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

import cn.iocoder.yudao.module.products.controller.admin.crawlstate.vo.*;
import cn.iocoder.yudao.module.products.dal.dataobject.crawlstate.CrawlStateDO;
import cn.iocoder.yudao.module.products.service.crawlstate.CrawlStateService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Tag(name = "管理后台 - 商品爬取状态临时记录")
@RestController
@RequestMapping("/products/crawl-state")
@Validated
public class CrawlStateController {

    @Resource
    private CrawlStateService crawlStateService;

    @PostMapping("/create")
    @Operation(summary = "创建商品爬取状态临时记录")
    @PreAuthorize("@ss.hasPermission('products:crawl-state:create')")
    public CommonResult<Long> createCrawlState(@Valid @RequestBody CrawlStateSaveReqVO createReqVO) {
        // 1. 发起 GET 请求到 Flask 服务
        String targetUrl = "http://127.0.0.1:5001/extract_product";
        String productUrl = createReqVO.getCrawlUrl();  // 假设这个字段就是 URL

        // 构造带参数的 URL
        String requestUrl = UriComponentsBuilder
                .fromHttpUrl(targetUrl)
                .queryParam("url", productUrl)
                .build()
                .encode() // 解决中文或特殊字符问题
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        String crawlResult;

        try {
            crawlResult = restTemplate.getForObject(requestUrl, String.class);
            System.out.println(crawlResult);
        } catch (Exception e) {
            return CommonResult.error(500, "调用爬虫接口失败：" + e.getMessage());
        }
        // 2. 保存爬取结果到数据库
        createReqVO.setCrawlText(crawlResult);
        createReqVO.setCrawlUrl(productUrl);
        return success(crawlStateService.createCrawlState(createReqVO));
    }

    @DeleteMapping("/put")
    @Operation(summary = "同步")
    @PreAuthorize("@ss.hasPermission('products:crawl-state:create')")
    public CommonResult<Boolean> putCrawlState(@RequestParam("id") Long id) {
        CrawlStateDO crawlState = crawlStateService.getCrawlState(id);
        if (crawlState == null) {
            throw new RuntimeException("找不到对应记录");
        }

        // 2. 构造请求
        String url = "http://127.0.0.1:5000/api/Products/push";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJIdWFuZ0NoZW5YdWUiLCJleHAiOjE3NDg5NDc1NTl9.SdID_e9dJr82C5IMFuGL58mTKLrRHvOUeuEl_RzPhUk");

        HttpEntity<CrawlStateDO> entity = new HttpEntity<>(crawlState, headers);

        // 3. 发送 PUT 请求
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    url,
                    HttpMethod.PUT,
                    entity,
                    String.class
            );
            System.out.println("响应状态码：" + response.getStatusCode());
            System.out.println("响应内容：" + response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("请求外部接口失败：" + e.getMessage());
        }
        return success(true);
    }

    @PutMapping("/update")
    @Operation(summary = "更新商品爬取状态临时记录")
    @PreAuthorize("@ss.hasPermission('products:crawl-state:update')")
    public CommonResult<Boolean> updateCrawlState(@Valid @RequestBody CrawlStateSaveReqVO updateReqVO) {
        crawlStateService.updateCrawlState(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除商品爬取状态临时记录")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('products:crawl-state:delete')")
    public CommonResult<Boolean> deleteCrawlState(@RequestParam("id") Long id) {
        crawlStateService.deleteCrawlState(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得商品爬取状态临时记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('products:crawl-state:query')")
    public CommonResult<CrawlStateRespVO> getCrawlState(@RequestParam("id") Long id) {
        CrawlStateDO crawlState = crawlStateService.getCrawlState(id);
        return success(BeanUtils.toBean(crawlState, CrawlStateRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得商品爬取状态临时记录分页")
    @PreAuthorize("@ss.hasPermission('products:crawl-state:query')")
    public CommonResult<PageResult<CrawlStateRespVO>> getCrawlStatePage(@Valid CrawlStatePageReqVO pageReqVO) {
        PageResult<CrawlStateDO> pageResult = crawlStateService.getCrawlStatePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, CrawlStateRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出商品爬取状态临时记录 Excel")
    @PreAuthorize("@ss.hasPermission('products:crawl-state:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportCrawlStateExcel(@Valid CrawlStatePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<CrawlStateDO> list = crawlStateService.getCrawlStatePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "商品爬取状态临时记录.xls", "数据", CrawlStateRespVO.class,
                        BeanUtils.toBean(list, CrawlStateRespVO.class));
    }

}