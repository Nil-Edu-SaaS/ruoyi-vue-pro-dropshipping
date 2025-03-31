package cn.iocoder.yudao.module.top.product.po;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 商品图片 DO
 *
 * @author 芋道源码
 */
@TableName("t_product_img")
@KeySequence("t_product_img_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductImgPO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 商品id
     */
    private Long pId;
    /**
     * 商品图片
     */
    private String productImgAddr;
    /**
     * 是否主图  0:否 1:是
     */
    private Boolean isMaster;
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