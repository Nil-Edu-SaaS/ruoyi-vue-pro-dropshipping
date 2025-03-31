package cn.iocoder.yudao.module.top.product.po;

import cn.iocoder.yudao.module.top.product.vo.ProductImgSaveReqVO;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 商品信息 DO
 *
 * @author 芋道源码
 */
@TableName("t_product")
@KeySequence("t_product_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品描述
     */
    private String productDepict;
    /**
     * 商品来源(供货商地址)
     */
    private String productSrc;
    /**
     * 成本价
     */
    private BigDecimal costPrice;
    /**
     * 零售价
     */
    private BigDecimal retailPrice;
    /**
     * 商品状态
     */
    private Boolean state;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;
    /**
     * 修改人
     */
    private String updater;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

}