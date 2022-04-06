package icu.d4peng.cloud.user.entity;

import icu.d4peng.cloud.common.db.domain.AbstractSuperEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <p> Role
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
public class Role extends AbstractSuperEntity {
    private String name;

    public String getName() {
        return name;
    }

    public Role setName(String name) {
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
