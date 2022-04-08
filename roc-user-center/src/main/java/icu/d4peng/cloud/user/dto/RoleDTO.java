package icu.d4peng.cloud.user.dto;

import icu.d4peng.cloud.common.db.request.SuperDTO;
import icu.d4peng.cloud.user.entity.Role;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <p> RoleDTO: 权限DTO
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-04-08
 */
public class RoleDTO extends SuperDTO<Role> {
    private String name;

    public String getName() {
        return name;
    }

    public RoleDTO setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .toString();
    }
}
