package cn.iocoder.yudao.module.top.product.service;

import cn.iocoder.yudao.module.top.product.po.ProductImgPO;
import cn.iocoder.yudao.module.top.product.vo.ProductImgPageReqVO;
import cn.iocoder.yudao.module.top.product.vo.ProductImgSaveReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;
import java.util.List;

/**
 * 商品图片 Service 接口
 *
 * @author 芋道源码
 */
public interface ProductImgService {

    /**
     * 创建商品图片
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createProductImg(@Valid ProductImgSaveReqVO createReqVO);

    /**
     * 更新商品图片
     *
     * @param updateReqVO 更新信息
     */
    void updateProductImg(@Valid ProductImgSaveReqVO updateReqVO);

    /**
     * 删除商品图片
     *
     * @param id 编号
     */
    void deleteProductImg(Long id);

    /**
     * 删除商品图片
     *
     * @param pId 商品id
     */
    void deleteProductImgByProductId(Long pId);

    /**
     * 获得商品图片
     *
     * @param id 编号
     * @return 商品图片
     */
    ProductImgPO getProductImg(Long id);

    /**
     * 获得商品图片分页
     *
     * @param pageReqVO 分页查询
     * @return 商品图片分页
     */
    PageResult<ProductImgPO> getProductImgPage(ProductImgPageReqVO pageReqVO);


    /**
     * 删除商品图片
     *
     * @param pId 商品id
     */
    List<ProductImgPO> getProductImgByProductId(Long pId);

}