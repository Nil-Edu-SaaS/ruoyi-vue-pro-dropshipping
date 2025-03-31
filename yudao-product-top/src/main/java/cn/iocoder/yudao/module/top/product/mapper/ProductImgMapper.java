package cn.iocoder.yudao.module.top.product.mapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.top.product.po.ProductImgPO;
import cn.iocoder.yudao.module.top.product.vo.ProductImgPageReqVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品图片 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ProductImgMapper extends BaseMapperX<ProductImgPO> {

    default PageResult<ProductImgPO> selectPage(ProductImgPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProductImgPO>()
                .eqIfPresent(ProductImgPO::getPId, reqVO.getPId())
                .eqIfPresent(ProductImgPO::getProductImgAddr, reqVO.getProductImgAddr())
                .eqIfPresent(ProductImgPO::getIsMaster, reqVO.getIsMaster())
                .eqIfPresent(ProductImgPO::getCreator, reqVO.getCreateOperate())
                .betweenIfPresent(ProductImgPO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ProductImgPO::getCreator, reqVO.getUpdateOperate())
                .betweenIfPresent(ProductImgPO::getUpdateTime, reqVO.getUpdateTime())
                .orderByDesc(ProductImgPO::getId));
    }

}