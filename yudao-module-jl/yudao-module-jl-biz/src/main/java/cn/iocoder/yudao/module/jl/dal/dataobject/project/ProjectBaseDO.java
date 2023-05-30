package cn.iocoder.yudao.module.jl.dal.dataobject.project;

import cn.iocoder.yudao.module.jl.dal.dataobject.BaseEntity;
import lombok.*;

import java.time.LocalDate;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;

/**
 * 项目管理 DO
 *
 * @author 惟象科技
 */

//@KeySequence("jl_project_base_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jl_project_base")
public class ProjectBaseDO extends BaseEntity {

    /**
     * 岗位ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 销售线索 id
     */
    private Long salesleadId;
    /**
     * 项目名字
     */
    private String name;
    /**
     * 项目开展阶段
     */
    private String stage;
    /**
     * 项目状态
     */
    private String status;
    /**
     * 项目类型
     */
    private String type;
    /**
     * 启动时间
     */
    private LocalDate startDate;
    /**
     * 截止时间
     */
    private LocalDate endDate;
    /**
     * 项目负责人
     */
    private Long managerId;
    /**
     * 参与者 ids，数组
     */
    private String participants;
    /**
     * 销售 id
     */
    private Long salesId;

    /**
     * 客户 ID
     */
    private Long customerId;
}
