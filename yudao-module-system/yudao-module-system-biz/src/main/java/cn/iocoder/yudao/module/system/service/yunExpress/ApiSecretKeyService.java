package cn.iocoder.yudao.module.system.service.yunExpress;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.ApiSecretKeyPageReqVO;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.ApiSecretKeySaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.yunExpress.ApiSecretKeyDO;

import java.util.*;
import javax.validation.*;

/**
 * api秘钥 Service 接口
 *
 * @author 芋道源码
 */
public interface ApiSecretKeyService {

    /**
     * 创建api秘钥
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createApiSecretKey(@Valid ApiSecretKeySaveReqVO createReqVO);

    /**
     * 更新api秘钥
     *
     * @param updateReqVO 更新信息
     */
    void updateApiSecretKey(@Valid ApiSecretKeySaveReqVO updateReqVO);

    /**
     * 删除api秘钥
     *
     * @param id 编号
     */
    void deleteApiSecretKey(Long id);

    /**
     * 获得api秘钥
     *
     * @param id 编号
     * @return api秘钥
     */
    ApiSecretKeyDO getApiSecretKey(Long id);


    /**
     * 获得api秘钥
     *
     * @param userId 用户id
     * @return api秘钥
     */
    ApiSecretKeyDO getApiSecretKeyByUserId(Long userId);


    /**
     * 获得api秘钥分页
     *
     * @param pageReqVO 分页查询
     * @return api秘钥分页
     */
    PageResult<ApiSecretKeyDO> getApiSecretKeyPage(ApiSecretKeyPageReqVO pageReqVO);

}