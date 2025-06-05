package cn.iocoder.yudao.module.products.service.label;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.products.controller.admin.label.vo.*;
import cn.iocoder.yudao.module.products.dal.dataobject.label.LabelDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.products.dal.mysql.label.LabelMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 商品标签表，用于存储商品相关的标签信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class LabelServiceImpl implements LabelService {

    @Resource
    private LabelMapper labelMapper;

    @Override
    public Long createLabel(LabelSaveReqVO createReqVO) {
        // 插入
        LabelDO label = BeanUtils.toBean(createReqVO, LabelDO.class);
        labelMapper.insert(label);
        // 返回
        return label.getId();
    }

    @Override
    public void updateLabel(LabelSaveReqVO updateReqVO) {
        // 校验存在
        validateLabelExists(updateReqVO.getId());
        // 更新
        LabelDO updateObj = BeanUtils.toBean(updateReqVO, LabelDO.class);
        labelMapper.updateById(updateObj);
    }

    @Override
    public void deleteLabel(Long id) {
        // 校验存在
        validateLabelExists(id);
        // 删除
        labelMapper.deleteById(id);
    }

    private void validateLabelExists(Long id) {
        if (labelMapper.selectById(id) == null) {
            throw exception(new ErrorCode(122, "商品标签表临时记录不存在"));
        }
    }

    @Override
    public LabelDO getLabel(Long id) {
        return labelMapper.selectById(id);
    }

    @Override
    public PageResult<LabelDO> getLabelPage(LabelPageReqVO pageReqVO) {
        return labelMapper.selectPage(pageReqVO);
    }

}