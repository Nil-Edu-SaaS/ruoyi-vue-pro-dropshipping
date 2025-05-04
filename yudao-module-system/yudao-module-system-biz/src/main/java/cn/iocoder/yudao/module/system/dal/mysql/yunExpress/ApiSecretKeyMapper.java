package cn.iocoder.yudao.module.system.dal.mysql.yunExpress;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.ApiSecretKeyPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.yunExpress.ApiSecretKeyDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * api秘钥 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ApiSecretKeyMapper extends BaseMapperX<ApiSecretKeyDO> {

    default PageResult<ApiSecretKeyDO> selectPage(ApiSecretKeyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ApiSecretKeyDO>()
                .likeIfPresent(ApiSecretKeyDO::getUserId, reqVO.getUsername())
                .eqIfPresent(ApiSecretKeyDO::getCustomerId, reqVO.getCustomerId())
                .eqIfPresent(ApiSecretKeyDO::getApiSecret, reqVO.getApiSecret())
                .eqIfPresent(ApiSecretKeyDO::getAuthorization, reqVO.getAuthorization())
                .eqIfPresent(ApiSecretKeyDO::getEnv, reqVO.getEnv())
                .betweenIfPresent(ApiSecretKeyDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ApiSecretKeyDO::getId));
    }

}