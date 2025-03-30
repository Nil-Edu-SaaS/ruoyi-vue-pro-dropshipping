package cn.iocoder.yudao.module.top.product.mapper;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.top.product.po.ProductPO;
import cn.iocoder.yudao.module.top.product.vo.ProductPageReqVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ProductMapper extends BaseMapperX<ProductPO> {

    default PageResult<ProductPO> selectPage(ProductPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProductPO>()
                .likeIfPresent(ProductPO::getProductName, reqVO.getProductName())
                .eqIfPresent(ProductPO::getProductDepict, reqVO.getProductDepict())
                .eqIfPresent(ProductPO::getProductSrc, reqVO.getProductSrc())
                .eqIfPresent(ProductPO::getCostPrice, reqVO.getCostPrice())
                .eqIfPresent(ProductPO::getRetailPrice, reqVO.getRetailPrice())
                .eqIfPresent(ProductPO::getState, reqVO.getState())
                .eqIfPresent(ProductPO::getCreator, reqVO.getCreator())
                .betweenIfPresent(ProductPO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ProductPO::getUpdater, reqVO.getUpdater())
                .betweenIfPresent(ProductPO::getUpdateTime, reqVO.getUpdateTime())
                .orderByDesc(ProductPO::getId));
    }

}