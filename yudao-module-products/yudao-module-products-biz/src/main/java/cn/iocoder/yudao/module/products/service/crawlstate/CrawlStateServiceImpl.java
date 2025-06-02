package cn.iocoder.yudao.module.products.service.crawlstate;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.products.controller.admin.crawlstate.vo.*;
import cn.iocoder.yudao.module.products.dal.dataobject.crawlstate.CrawlStateDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.products.dal.mysql.crawlstate.CrawlStateMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 商品爬取状态临时记录 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class CrawlStateServiceImpl implements CrawlStateService {

    @Resource
    private CrawlStateMapper crawlStateMapper;

    @Override
    public Long createCrawlState(CrawlStateSaveReqVO createReqVO) {
        // 插入
        CrawlStateDO crawlState = BeanUtils.toBean(createReqVO, CrawlStateDO.class);
        crawlStateMapper.insert(crawlState);
        // 返回
        return crawlState.getId();
    }

    @Override
    public void updateCrawlState(CrawlStateSaveReqVO updateReqVO) {
        // 校验存在
        validateCrawlStateExists(updateReqVO.getId());
        // 更新
        CrawlStateDO updateObj = BeanUtils.toBean(updateReqVO, CrawlStateDO.class);
        crawlStateMapper.updateById(updateObj);
    }

    @Override
    public void deleteCrawlState(Long id) {
        // 校验存在
        validateCrawlStateExists(id);
        // 删除
        crawlStateMapper.deleteById(id);
    }

    private void validateCrawlStateExists(Long id) {
        if (crawlStateMapper.selectById(id) == null) {
            throw exception(new ErrorCode(122, "商品爬取状态临时记录不存在"));
        }
    }

    @Override
    public CrawlStateDO getCrawlState(Long id) {
        return crawlStateMapper.selectById(id);
    }

    @Override
    public PageResult<CrawlStateDO> getCrawlStatePage(CrawlStatePageReqVO pageReqVO) {
        return crawlStateMapper.selectPage(pageReqVO);
    }

}