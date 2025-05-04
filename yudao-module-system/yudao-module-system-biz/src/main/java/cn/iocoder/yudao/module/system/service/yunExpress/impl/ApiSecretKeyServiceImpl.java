package cn.iocoder.yudao.module.system.service.yunExpress.impl;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.ApiSecretKeyPageReqVO;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.ApiSecretKeySaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.dept.DeptDO;
import cn.iocoder.yudao.module.system.dal.dataobject.yunExpress.ApiSecretKeyDO;
import cn.iocoder.yudao.module.system.dal.mysql.yunExpress.ApiSecretKeyMapper;
import cn.iocoder.yudao.module.system.service.yunExpress.ApiSecretKeyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.API_SECRET_KEY_NOT_EXISTS;

/**
 * api秘钥 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ApiSecretKeyServiceImpl implements ApiSecretKeyService {

    @Resource
    private ApiSecretKeyMapper apiSecretKeyMapper;

    @Override
    public Long createApiSecretKey(ApiSecretKeySaveReqVO createReqVO) {
        // 插入
        ApiSecretKeyDO apiSecretKey = BeanUtils.toBean(createReqVO, ApiSecretKeyDO.class);
        apiSecretKeyMapper.insert(apiSecretKey);
        // 返回
        return apiSecretKey.getId();
    }

    @Override
    public void updateApiSecretKey(ApiSecretKeySaveReqVO updateReqVO) {
        // 校验存在
        validateApiSecretKeyExists(updateReqVO.getId());
        // 更新
        ApiSecretKeyDO updateObj = BeanUtils.toBean(updateReqVO, ApiSecretKeyDO.class);
        apiSecretKeyMapper.updateById(updateObj);
    }

    @Override
    public void deleteApiSecretKey(Long id) {
        // 校验存在
        validateApiSecretKeyExists(id);
        // 删除
        apiSecretKeyMapper.deleteById(id);
    }

    private void validateApiSecretKeyExists(Long id) {
        if (apiSecretKeyMapper.selectById(id) == null) {
            throw exception(API_SECRET_KEY_NOT_EXISTS);
        }
    }

    @Override
    public ApiSecretKeyDO getApiSecretKey(Long id) {
        return apiSecretKeyMapper.selectById(id);
    }

    @Override
    public ApiSecretKeyDO getApiSecretKeyByUserId(Long id) {

        ApiSecretKeyDO apiSecretKeyDO = apiSecretKeyMapper.selectOne(ApiSecretKeyDO::getUserId, id,ApiSecretKeyDO::getEnv,"dev");
        if (apiSecretKeyDO != null){
            return apiSecretKeyDO;
        }
        return null;
    }


    @Override
    public PageResult<ApiSecretKeyDO> getApiSecretKeyPage(ApiSecretKeyPageReqVO pageReqVO) {
        return apiSecretKeyMapper.selectPage(pageReqVO);
    }

}