package cn.iocoder.yudao.module.system.service.yunExpress;

import java.util.*;

import cn.iocoder.yudao.module.system.controller.yunExpress.vo.PriceTrialPageReqVO;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.PriceTrialSaveReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.module.system.dal.dataobject.yunExpress.PriceTrialDO;

import javax.validation.Valid;

/**
 * 物流价格 Service 接口
 *
 * @author 芋道源码
 */
public interface PriceTrialService {


    List<Map<String, Object>> getGetPriceTrial(String customerId, String apiSecret, HashMap<String, Object> param);

    /**
     * 创建物流价格
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPriceTrial(@Valid PriceTrialSaveReqVO createReqVO);

    /**
     * 更新物流价格
     *
     * @param updateReqVO 更新信息
     */
    void updatePriceTrial(@Valid PriceTrialSaveReqVO updateReqVO);

    /**
     * 删除物流价格
     *
     * @param id 编号
     */
    void deletePriceTrial(Long id);

    /**
     * 获得物流价格
     *
     * @param id 编号
     * @return 物流价格
     */
    PriceTrialDO getPriceTrial(Long id);

    /**
     * 获得物流价格分页
     *
     * @param pageReqVO 分页查询
     * @return 物流价格分页
     */
    PageResult<PriceTrialDO> getPriceTrialPage(PriceTrialPageReqVO pageReqVO);

}