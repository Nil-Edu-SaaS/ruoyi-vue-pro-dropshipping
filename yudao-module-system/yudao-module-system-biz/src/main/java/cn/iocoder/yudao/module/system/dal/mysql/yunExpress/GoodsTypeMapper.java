package cn.iocoder.yudao.module.system.dal.mysql.yunExpress;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.GoodsTypePageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.yunExpress.GoodsTypeDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 货品类型 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GoodsTypeMapper extends BaseMapperX<GoodsTypeDO> {

    default PageResult<GoodsTypeDO> selectPage(GoodsTypePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GoodsTypeDO>()
                .likeIfPresent(GoodsTypeDO::getCName, reqVO.getCName())
                .likeIfPresent(GoodsTypeDO::getEName, reqVO.getEName())
                .eqIfPresent(GoodsTypeDO::getAuthorization, reqVO.getAuthorization())
                .orderByDesc(GoodsTypeDO::getId));
    }

}