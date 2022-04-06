package icu.d4peng.cloud.user.entity;

import icu.d4peng.cloud.common.db.domain.AbstractSuperEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <p> UserRole
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
public class UserRole extends AbstractSuperEntity {
    private Long userId;
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public UserRole setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getRoleId() {
        return roleId;
    }

    public UserRole setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userId", userId)
                .append("roleId", roleId)
                .toString();
    }
}
