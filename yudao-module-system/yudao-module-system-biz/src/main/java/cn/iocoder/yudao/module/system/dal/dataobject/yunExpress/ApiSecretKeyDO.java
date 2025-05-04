package cn.iocoder.yudao.module.system.dal.dataobject.yunExpress;

import lombok.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * api秘钥 DO
 *
 * @author 芋道源码
 */
@TableName("saas_api_secret_key")
@KeySequence("saas_api_secret_key_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiSecretKeyDO extends BaseDO {

    /**
     * 秘钥id
     */
    @TableId
    private Long id;
    /**
     * 用户账号
     */
    @TableField(value = "user_id")
    private String userId;
    /**
     * 客户编号
     */
    @TableField(value = "customer_id")
    private String customerId;
    /**
     * api秘钥
     */
    @TableField(value = "api_secret")
    private String apiSecret;
    /**
     * 令牌
     */
    private String authorization;
    /**
     * 环境  dev：开发环境  pro：生产
     */
    private String env;

}