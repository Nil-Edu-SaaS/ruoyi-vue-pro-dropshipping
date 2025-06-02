package cn.iocoder.yudao.module.products.dal.mysql.crawlstate;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.products.dal.dataobject.crawlstate.CrawlStateDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.products.controller.admin.crawlstate.vo.*;

/**
 * 商品爬取状态临时记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface CrawlStateMapper extends BaseMapperX<CrawlStateDO> {

    default PageResult<CrawlStateDO> selectPage(CrawlStatePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CrawlStateDO>()
                .eqIfPresent(CrawlStateDO::getCrawlState, reqVO.getCrawlState())
                .eqIfPresent(CrawlStateDO::getCrawlText, reqVO.getCrawlText())
                .betweenIfPresent(CrawlStateDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CrawlStateDO::getId));
    }

}