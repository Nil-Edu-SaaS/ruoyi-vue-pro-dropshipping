package cn.iocoder.yudao.module.system.dal.mysql.yunExpress;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.PriceTrialPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.yunExpress.PriceTrialDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 物流价格 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PriceTrialMapper extends BaseMapperX<PriceTrialDO> {

    default PageResult<PriceTrialDO> selectPage(PriceTrialPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PriceTrialDO>()
                .eqIfPresent(PriceTrialDO::getCode, reqVO.getCode())
                .likeIfPresent(PriceTrialDO::getCName, reqVO.getCName())
                .likeIfPresent(PriceTrialDO::getEName, reqVO.getEName())
                .eqIfPresent(PriceTrialDO::getShippingFee, reqVO.getShippingFee())
                .eqIfPresent(PriceTrialDO::getRegistrationFee, reqVO.getRegistrationFee())
                .eqIfPresent(PriceTrialDO::getFuelFee, reqVO.getFuelFee())
                .eqIfPresent(PriceTrialDO::getSundryFee, reqVO.getSundryFee())
                .eqIfPresent(PriceTrialDO::getTariffPrepayFee, reqVO.getTariffPrepayFee())
                .eqIfPresent(PriceTrialDO::getTotalFee, reqVO.getTotalFee())
                .eqIfPresent(PriceTrialDO::getDeliveryDays, reqVO.getDeliveryDays())
                .eqIfPresent(PriceTrialDO::getRemark, reqVO.getRemark())
                .eqIfPresent(PriceTrialDO::getAuthorization, reqVO.getAuthorization())
                .betweenIfPresent(PriceTrialDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PriceTrialDO::getId));
    }

}