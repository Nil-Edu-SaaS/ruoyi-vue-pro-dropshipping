package cn.iocoder.yudao.module.system.dal.dataobject.yunExpress;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 货品类型 DO
 *
 * @author 芋道源码
 */
@TableName("saas_goods_type")
@KeySequence("saas_goods_type_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsTypeDO extends TenantBaseDO {

    /**
     * 货品类型id
     */
    @TableId
    private Long id;
    /**
     * 货品类型中文名称
     */
    @TableField(value = "CName")
    private String cName;
    /**
     * 货品类型英文名称
     */
    @TableField(value = "EName")
    private String eName;
    /**
     * 用户token
     */
    private String authorization;

}