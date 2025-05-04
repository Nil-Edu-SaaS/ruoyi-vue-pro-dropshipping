package cn.iocoder.yudao.module.system.service.yunExpress.impl;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.GoodsTypePageReqVO;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.GoodsTypeSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.yunExpress.GoodsTypeDO;
import cn.iocoder.yudao.module.system.dal.mysql.yunExpress.GoodsTypeMapper;
import cn.iocoder.yudao.module.system.service.yunExpress.GoodsTypeService;
import cn.iocoder.yudao.module.system.service.yunExpress.impl.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import java.time.LocalDateTime;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.yunExpress.ErrorCodeConstants.GOODS_TYPE_NOT_EXISTS;

/**
 * 货品类型 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GoodsTypeServiceImpl extends BaseServiceImpl implements GoodsTypeService {

    @Resource
    private GoodsTypeMapper goodsTypeMapper;

    @Override
    public Long createGoodsType(GoodsTypeSaveReqVO createReqVO) {
        // 插入
        GoodsTypeDO goodsType = BeanUtils.toBean(createReqVO, GoodsTypeDO.class);
        goodsTypeMapper.insert(goodsType);
        // 返回
        return goodsType.getId();
    }

    @Override
    public void updateGoodsType(GoodsTypeSaveReqVO updateReqVO) {
        // 校验存在
        validateGoodsTypeExists(updateReqVO.getId());
        // 更新
        GoodsTypeDO updateObj = BeanUtils.toBean(updateReqVO, GoodsTypeDO.class);

        updateObj.setUpdateTime(LocalDateTime.now());
        updateObj.setUpdater(String.valueOf(SecurityFrameworkUtils.getLoginUser().getId()));
        goodsTypeMapper.updateById(updateObj);
    }

    @Override
    public void deleteGoodsType(Long id) {
        // 校验存在
        validateGoodsTypeExists(id);
        // 删除
        goodsTypeMapper.deleteById(id);
    }

    private void validateGoodsTypeExists(Long id) {
        if (goodsTypeMapper.selectById(id) == null) {
            throw exception(GOODS_TYPE_NOT_EXISTS);
        }
    }

    @Override
    public GoodsTypeDO getGoodsType(Long id) {
        return goodsTypeMapper.selectById(id);
    }

    @Override
    public PageResult<GoodsTypeDO> getGoodsTypePage(GoodsTypePageReqVO pageReqVO) {
        return goodsTypeMapper.selectPage(pageReqVO);
    }

}