package cn.iocoder.yudao.module.top.product.service;

import java.util.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.module.top.product.po.ProductPO;
import cn.iocoder.yudao.module.top.product.vo.*;

import javax.validation.Valid;

/**
 * 商品信息 Service 接口
 *
 * @author 芋道源码
 */
public interface ProductService {

    /**
     * 创建商品信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createProduct(@Valid ProductSaveReqVO createReqVO);

    /**
     * 更新商品信息
     *
     * @param updateReqVO 更新信息
     */
    void updateProduct(@Valid ProductSaveReqVO updateReqVO);

    /**
     * 删除商品信息
     *
     * @param id 编号
     */
    void deleteProduct(Long id);

    /**
     * 获得商品信息
     *
     * @param id 编号
     * @return 商品信息
     */
    ProductInfoVo getProduct(Long id);

    /**
     * 获得商品信息分页
     *
     * @param pageReqVO 分页查询
     * @return 商品信息分页
     */
    PageResult<ProductPO> getProductPage(ProductPageReqVO pageReqVO);

    /**
     * 导入商品信息
     *
     * @param importUsers 商品信息
     * @param isUpdateSupport 是否支持更新
     * @return 商品信息
     */
    ProductImportRespVO importUserList(List<ProductImportExcelVO> importUsers, boolean isUpdateSupport);

}