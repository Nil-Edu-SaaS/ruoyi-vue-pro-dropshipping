package cn.iocoder.yudao.module.products.service.label;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.products.controller.admin.label.vo.*;
import cn.iocoder.yudao.module.products.dal.dataobject.label.LabelDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 商品标签表，用于存储商品相关的标签信息 Service 接口
 *
 * @author 芋道源码
 */
public interface LabelService {

    /**
     * 创建商品标签表，用于存储商品相关的标签信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createLabel(@Valid LabelSaveReqVO createReqVO);

    /**
     * 更新商品标签表，用于存储商品相关的标签信息
     *
     * @param updateReqVO 更新信息
     */
    void updateLabel(@Valid LabelSaveReqVO updateReqVO);

    /**
     * 删除商品标签表，用于存储商品相关的标签信息
     *
     * @param id 编号
     */
    void deleteLabel(Long id);

    /**
     * 获得商品标签表，用于存储商品相关的标签信息
     *
     * @param id 编号
     * @return 商品标签表，用于存储商品相关的标签信息
     */
    LabelDO getLabel(Long id);

    /**
     * 获得商品标签表，用于存储商品相关的标签信息分页
     *
     * @param pageReqVO 分页查询
     * @return 商品标签表，用于存储商品相关的标签信息分页
     */
    PageResult<LabelDO> getLabelPage(LabelPageReqVO pageReqVO);

}