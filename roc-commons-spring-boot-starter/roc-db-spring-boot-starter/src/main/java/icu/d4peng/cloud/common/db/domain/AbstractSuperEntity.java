package icu.d4peng.cloud.common.db.domain;

import com.baomidou.mybatisplus.annotation.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p> AbstractSuperEntity:数据库domain超级父类
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public abstract class AbstractSuperEntity implements Serializable {
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

    public Long getId() {
        return id;
    }

    public AbstractSuperEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public AbstractSuperEntity setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public AbstractSuperEntity setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
        return this;
    }

    public LocalDateTime getDeletedTime() {
        return deletedTime;
    }

    public AbstractSuperEntity setDeletedTime(LocalDateTime deletedTime) {
        this.deletedTime = deletedTime;
        return this;
    }

    public String getTenantId() {
        return tenantId;
    }

    public AbstractSuperEntity setTenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("createdTime", createdTime).append("updatedTime", updatedTime).append("deletedTime", deletedTime).append("tenantId", tenantId).toString();
    }
}