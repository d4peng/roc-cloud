package icu.d4peng.cloud.user.entity;

import icu.d4peng.cloud.common.db.domain.AbstractSuperEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <p> RolePermission
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
public class RolePermission extends AbstractSuperEntity {
    private Long roleId;
    private Long permissionId;

    public Long getRoleId() {
        return roleId;
    }

    public RolePermission setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public RolePermission setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("roleId", roleId)
                .append("permissionId", permissionId)
                .toString();
    }
}
