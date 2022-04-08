package icu.d4peng.cloud.user.entity;

import icu.d4peng.cloud.common.db.domain.AbstractSuperEntity;

/**
 * <p> Permission:权限
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
public class Permission extends AbstractSuperEntity {
    private String name;

    public String getName() {
        return name;
    }

    public Permission setName(String name) {
        this.name = name;
        return this;
    }

}
