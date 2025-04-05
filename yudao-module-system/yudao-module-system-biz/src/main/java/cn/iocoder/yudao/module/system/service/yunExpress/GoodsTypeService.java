package cn.iocoder.yudao.module.system.service.yunExpress;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.GoodsTypePageReqVO;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.GoodsTypeSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.yunExpress.GoodsTypeDO;

import java.util.*;
import javax.validation.*;

/**
 * 货品类型 Service 接口
 *
 * @author 芋道源码
 */
public interface GoodsTypeService {

    /**
     * 创建货品类型
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createGoodsType(@Valid GoodsTypeSaveReqVO createReqVO);

    /**
     * 更新货品类型
     *
     * @param updateReqVO 更新信息
     */
    void updateGoodsType(@Valid GoodsTypeSaveReqVO updateReqVO);

    /**
     * 删除货品类型
     *
     * @param id 编号
     */
    void deleteGoodsType(Long id);

    /**
     * 获得货品类型
     *
     * @param id 编号
     * @return 货品类型
     */
    GoodsTypeDO getGoodsType(Long id);

    /**
     * 获得货品类型分页
     *
     * @param pageReqVO 分页查询
     * @return 货品类型分页
     */
    PageResult<GoodsTypeDO> getGoodsTypePage(GoodsTypePageReqVO pageReqVO);

}