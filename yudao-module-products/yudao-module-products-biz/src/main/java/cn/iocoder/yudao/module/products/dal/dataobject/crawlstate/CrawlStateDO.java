package cn.iocoder.yudao.module.products.dal.dataobject.crawlstate;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 商品爬取状态临时记录 DO
 *
 * @author 芋道源码
 */
@TableName("products_crawl_state")
@KeySequence("products_crawl_state_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrawlStateDO extends BaseDO {

    /**
     * 主键 ID，自增或唯一标识
     */
    @TableId
    private Long id;
    /**
     * 爬取状态（0-未爬取，1-成功，2-失败等）
     */
    private Long crawlState;
    /**
     * 爬取结果的文本描述或备注信息
     */
    private String crawlText;
    /**
     * 爬取地址
     */
    private String crawlUrl;

}