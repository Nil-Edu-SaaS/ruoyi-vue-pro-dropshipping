package cn.iocoder.yudao.module.products.dal.dataobject.label;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 商品标签表，用于存储商品相关的标签信息 DO
 *
 * @author 芋道源码
 */
@TableName("products_label")
@KeySequence("products_label_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LabelDO extends BaseDO {

    /**
     * 主键 ID，自增或唯一标识
     */
    @TableId
    private Long id;
    /**
     * 标签名称
     */
    private String labelName;


}