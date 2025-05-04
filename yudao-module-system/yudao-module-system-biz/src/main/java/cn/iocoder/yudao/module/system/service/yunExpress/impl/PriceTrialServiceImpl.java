package cn.iocoder.yudao.module.system.service.yunExpress.impl;


import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.PriceTrialPageReqVO;
import cn.iocoder.yudao.module.system.controller.yunExpress.vo.PriceTrialSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.yunExpress.GoodsTypeDO;
import cn.iocoder.yudao.module.system.dal.dataobject.yunExpress.PriceTrialDO;
import cn.iocoder.yudao.module.system.dal.mysql.yunExpress.PriceTrialMapper;
import cn.iocoder.yudao.module.system.service.yunExpress.PriceTrialService;
import cn.iocoder.yudao.module.system.service.yunExpress.impl.base.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.taolord.yunexpress.application.YunExpressClient;
import top.taolord.yunexpress.domain.model.PriceTrial;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.yunExpress.ErrorCodeConstants.PRICE_TRIAL_NOT_EXISTS;

@Service
@Slf4j
public class PriceTrialServiceImpl extends BaseServiceImpl implements PriceTrialService {

    @Resource
    private YunExpressClient client;

    @Resource
    private PriceTrialMapper priceTrialMapper;

    /**
     * 获取价格
     *
     * @param param
     * @return
     */

    public List<Map<String, Object>> getGetPriceTrial(String customerId,String apiSecret,HashMap<String, Object> param) {

        String countryCode =  String.valueOf(param.get("countryCode"));
        Double weight = parseDouble(param.get("weight"));
        Integer length = Integer.valueOf(String.valueOf(param.get("length")));
        Integer width = Integer.valueOf(String.valueOf(param.get("width")));
        Integer height = Integer.valueOf(String.valueOf(param.get("height")));
        Integer packageType = Integer.valueOf(String.valueOf(param.get("packageType")));
        String origin = String.valueOf(param.get("origin"));

        PriceTrial priceTrial = client.getPriceTrial(countryCode, weight, length, width, height, packageType, origin);


        List<Map<String, Object>> items = priceTrial.priceDetails();

        String token = buildToken(customerId, apiSecret);
        items.forEach(map -> {
            PriceTrialDO priceTrialDO = new PriceTrialDO();
            priceTrialDO.setCode(String.valueOf(map.get("Code")));
            priceTrialDO.setCName(String.valueOf(map.get("CName")));
            priceTrialDO.setEName(String.valueOf(map.get("EName")));
            priceTrialDO.setShippingFee(new BigDecimal(String.valueOf(map.get("ShippingFee"))));
            priceTrialDO.setRegistrationFee(new BigDecimal((String.valueOf(map.get("RegistrationFee")))));
            priceTrialDO.setFuelFee(new BigDecimal((String.valueOf(map.get("FuelFee")))));
            priceTrialDO.setSundryFee(new BigDecimal((String.valueOf(map.get("SundryFee")))));

            if (!"null".equals(String.valueOf(map.get("TariffPrepayFee")))) {
                priceTrialDO.setTariffPrepayFee(new BigDecimal((String.valueOf(map.get("TariffPrepayFee")))));
            }
            priceTrialDO.setTotalFee(new BigDecimal((String.valueOf(map.get("TotalFee")))));
            priceTrialDO.setDeliveryDays(String.valueOf(map.get("DeliveryDays")));
            priceTrialDO.setRemark(String.valueOf(map.get("Remark")));
            priceTrialDO.setAuthorization(token);
            priceTrialMapper.insert(priceTrialDO);
        });
        return priceTrial.priceDetails();
    }


    @Override
    public Long createPriceTrial(PriceTrialSaveReqVO createReqVO) {
        // 插入
        PriceTrialDO priceTrial = BeanUtils.toBean(createReqVO, PriceTrialDO.class);
        priceTrialMapper.insert(priceTrial);
        // 返回
        return priceTrial.getId();
    }

    @Override
    public void updatePriceTrial(PriceTrialSaveReqVO updateReqVO) {
        // 校验存在
        validatePriceTrialExists(updateReqVO.getId());
        // 更新
        PriceTrialDO updateObj = BeanUtils.toBean(updateReqVO, PriceTrialDO.class);
        priceTrialMapper.updateById(updateObj);
    }

    @Override
    public void deletePriceTrial(Long id) {
        // 校验存在
        validatePriceTrialExists(id);
        // 删除
        priceTrialMapper.deleteById(id);
    }

    private void validatePriceTrialExists(Long id) {
        if (priceTrialMapper.selectById(id) == null) {
            throw exception(PRICE_TRIAL_NOT_EXISTS);
        }
    }

    @Override
    public PriceTrialDO getPriceTrial(Long id) {
        return priceTrialMapper.selectById(id);
    }

    @Override
    public PageResult<PriceTrialDO> getPriceTrialPage(PriceTrialPageReqVO pageReqVO) {
        return priceTrialMapper.selectPage(pageReqVO);
    }





}
