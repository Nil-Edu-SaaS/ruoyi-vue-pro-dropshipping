package cn.iocoder.yudao.module.products.dal.mysql.label;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.products.dal.dataobject.label.LabelDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.products.controller.admin.label.vo.*;

/**
 * 商品标签表，用于存储商品相关的标签信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface LabelMapper extends BaseMapperX<LabelDO> {

    default PageResult<LabelDO> selectPage(LabelPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<LabelDO>()
                .likeIfPresent(LabelDO::getLabelName, reqVO.getLabelName())
                .betweenIfPresent(LabelDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(LabelDO::getId));
    }

}