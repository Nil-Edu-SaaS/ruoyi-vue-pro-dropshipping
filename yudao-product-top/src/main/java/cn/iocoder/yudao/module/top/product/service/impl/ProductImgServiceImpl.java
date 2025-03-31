package cn.iocoder.yudao.module.top.product.service.impl;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.top.product.enums.ErrorCodeConstants;
import cn.iocoder.yudao.module.top.product.mapper.ProductImgMapper;
import cn.iocoder.yudao.module.top.product.po.ProductImgPO;
import cn.iocoder.yudao.module.top.product.service.ProductImgService;
import cn.iocoder.yudao.module.top.product.vo.ProductImgPageReqVO;
import cn.iocoder.yudao.module.top.product.vo.ProductImgSaveReqVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import javax.annotation.Resource;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 商品图片 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ProductImgServiceImpl implements ProductImgService {

    @Resource
    private ProductImgMapper productImgMapper;

    @Override
    public Long createProductImg(ProductImgSaveReqVO createReqVO) {
        // 插入
        ProductImgPO productImg = BeanUtils.toBean(createReqVO, ProductImgPO.class);
        productImgMapper.insert(productImg);
        // 返回
        return productImg.getId();
    }

    @Override
    public void updateProductImg(ProductImgSaveReqVO updateReqVO) {
        // 校验存在
        validateProductImgExists(updateReqVO.getId());
        // 更新
        ProductImgPO updateObj = BeanUtils.toBean(updateReqVO, ProductImgPO.class);
        productImgMapper.updateById(updateObj);
    }

    @Override
    public void deleteProductImg(Long id) {
        // 校验存在
        validateProductImgExists(id);
        // 删除
        productImgMapper.deleteById(id);
    }

    @Override
    public void deleteProductImgByProductId(Long pId) {
        QueryWrapper<ProductImgPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p_id",pId);
        // 删除
        productImgMapper.delete(queryWrapper);
    }

    private void validateProductImgExists(Long id) {
        if (productImgMapper.selectById(id) == null) {
            throw exception(ErrorCodeConstants.PRODUCT_IMG_NOT_EXISTS);
        }
    }

    @Override
    public ProductImgPO getProductImg(Long id) {
        return productImgMapper.selectById(id);
    }

    @Override
    public PageResult<ProductImgPO> getProductImgPage(ProductImgPageReqVO pageReqVO) {
        return productImgMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ProductImgPO> getProductImgByProductId(Long pId) {

        QueryWrapper<ProductImgPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p_id",pId);
        queryWrapper.eq("deleted",0);

        List<ProductImgPO> productImgPOS = productImgMapper.selectList(queryWrapper);
        if (!productImgPOS.isEmpty()) {
            return productImgPOS;
        }
        return null;
    }

}