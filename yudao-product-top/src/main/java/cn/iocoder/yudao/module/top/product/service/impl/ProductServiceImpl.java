package cn.iocoder.yudao.module.top.product.service.impl;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.top.product.enums.ErrorCodeConstants;
import cn.iocoder.yudao.module.top.product.mapper.ProductMapper;
import cn.iocoder.yudao.module.top.product.po.ProductPO;
import cn.iocoder.yudao.module.top.product.service.ProductImgService;
import cn.iocoder.yudao.module.top.product.service.ProductService;
import cn.iocoder.yudao.module.top.product.vo.ProductImgSaveReqVO;
import cn.iocoder.yudao.module.top.product.vo.ProductPageReqVO;
import cn.iocoder.yudao.module.top.product.vo.ProductSaveReqVO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 商品信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductImgService productImgService;


    @Override
    public Long createProduct(ProductSaveReqVO createReqVO) {
        // 插入
        ProductPO product = BeanUtils.toBean(createReqVO, ProductPO.class);
        productMapper.insert(product);

        System.out.println("新增商品id:=====>"+product.getId());

        createReqVO.getImagList().forEach(item->{
            productImgService.createProductImg(new ProductImgSaveReqVO().setPId(product.getId())
                    .setProductImgAddr(item.getProductImgAddr())
                    .setIsMaster(item.getIsMaster())
            );
        });

        // 返回
        return product.getId();
    }

    @Override
    public void updateProduct(ProductSaveReqVO updateReqVO) {
        // 校验存在
        validateProductExists(updateReqVO.getId());
        // 更新
        ProductPO updateObj = BeanUtils.toBean(updateReqVO, ProductPO.class);

        productImgService.deleteProductImgByProductId(updateReqVO.getId());

        updateReqVO.getImagList().forEach(item->{
            productImgService.createProductImg(new ProductImgSaveReqVO().setPId(updateReqVO.getId())
                    .setProductImgAddr(item.getProductImgAddr())
                    .setIsMaster(item.getIsMaster())
            );
        });

        productMapper.updateById(updateObj);
    }

    @Override
    public void deleteProduct(Long id) {
        // 校验存在
        validateProductExists(id);
        // 删除
        productMapper.deleteById(id);
        productImgService.deleteProductImgByProductId(id);
    }

    private void validateProductExists(Long id) {
        if (productMapper.selectById(id) == null) {
            throw exception(ErrorCodeConstants.PRODUCT_NOT_EXISTS);
        }
    }

    @Override
    public ProductPO getProduct(Long id) {
        return productMapper.selectById(id);
    }

    @Override
    public PageResult<ProductPO> getProductPage(ProductPageReqVO pageReqVO) {
        return productMapper.selectPage(pageReqVO);
    }

}