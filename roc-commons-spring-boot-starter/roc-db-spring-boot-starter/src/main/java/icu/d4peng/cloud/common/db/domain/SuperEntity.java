package icu.d4peng.cloud.common.db.domain;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-29 16:21
 * @description SuperEntity:数据库domain超级父类
 */
@Data
@Accessors(chain = true)
public abstract class SuperEntity implements Serializable {
    /**
     * 这个ID是使用雪花算法来生成的ID,使用的是容器中的Bean
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 当发生插入操作时,会自动填充
     */
    @TableField(fill = FieldFill.INSERT, insertStrategy = FieldStrategy.NOT_EMPTY)
    private LocalDateTime createdTime;
    /**
     * 当发生更新和插入操作时,会自动填充
     */
    @TableField(fill = FieldFill.INSERT_UPDATE, insertStrategy = FieldStrategy.NOT_EMPTY, updateStrategy = FieldStrategy.NOT_EMPTY)
    private LocalDateTime updatedTime;
    /**
     * 软删除:删除时使用now()函数,未删除时使用null
     */
    @TableLogic(delval = "now()", value = "null")
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private LocalDateTime deletedTime;
    /**
     * 多租户ID
     */
    @TableField(exist = false)
    private String tenantId;
}