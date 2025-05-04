package cn.iocoder.yudao.module.system.dal.dataobject.yunExpress;

import lombok.*;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 物流价格 DO
 *
 * @author 芋道源码
 */
@TableName("saas_price_trial")
@KeySequence("saas_price_trial_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceTrialDO extends BaseDO {

    /**
     * 价格id
     */
    @TableId
    private Long id;
    /**
     * 可服务的运输方式代码
     */
    private String code;
    /**
     * 可服务的运输方式中文名称
     */
    @TableField(value = "CName")
    private String cName;
    /**
     * 可服务的运输方式英文名称
     */
    @TableField(value = "EName")
    private String eName;
    /**
     * 基础运费
     */
    @TableField(value = "ShippingFee")
    private BigDecimal shippingFee;
    /**
     * 挂号费
     */
    @TableField(value = "RegistrationFee")
    private BigDecimal registrationFee;
    /**
     * 燃油费
     */
    @TableField(value = "FuelFee")
    private BigDecimal fuelFee;
    /**
     * 杂费
     */
    @TableField(value = "SundryFee")
    private BigDecimal sundryFee;
    /**
     * 关税预付服务费
     */
    @TableField(value = "TariffPrepayFee")
    private BigDecimal tariffPrepayFee;
    /**
     * 总费用
     */
    @TableField(value = "TotalFee")
    private BigDecimal totalFee;
    /**
     * 预计时效
     */
    @TableField(value = "DeliveryDays")
    private String deliveryDays;
    /**
     * 说明(当 Remark 为空时不显示）
     */
    @TableField(value = "Remark")
    private String remark;
    /**
     * 用户token
     */
    private String authorization;

}