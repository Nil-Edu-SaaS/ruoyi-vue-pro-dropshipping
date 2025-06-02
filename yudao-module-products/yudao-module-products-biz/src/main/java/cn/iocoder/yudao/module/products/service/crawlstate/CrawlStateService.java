package cn.iocoder.yudao.module.products.service.crawlstate;

import java.util.*;
import cn.iocoder.yudao.module.products.controller.admin.crawlstate.vo.*;
import cn.iocoder.yudao.module.products.dal.dataobject.crawlstate.CrawlStateDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 商品爬取状态临时记录 Service 接口
 *
 * @author 芋道源码
 */
public interface CrawlStateService {

    /**
     * 创建商品爬取状态临时记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createCrawlState(@Valid CrawlStateSaveReqVO createReqVO);

    /**
     * 更新商品爬取状态临时记录
     *
     * @param updateReqVO 更新信息
     */
    void updateCrawlState(@Valid CrawlStateSaveReqVO updateReqVO);

    /**
     * 删除商品爬取状态临时记录
     *
     * @param id 编号
     */
    void deleteCrawlState(Long id);

    /**
     * 获得商品爬取状态临时记录
     *
     * @param id 编号
     * @return 商品爬取状态临时记录
     */
    CrawlStateDO getCrawlState(Long id);

    /**
     * 获得商品爬取状态临时记录分页
     *
     * @param pageReqVO 分页查询
     * @return 商品爬取状态临时记录分页
     */
    PageResult<CrawlStateDO> getCrawlStatePage(CrawlStatePageReqVO pageReqVO);

}