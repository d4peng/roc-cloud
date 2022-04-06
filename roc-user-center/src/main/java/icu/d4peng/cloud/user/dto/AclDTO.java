package icu.d4peng.cloud.user.dto;

import icu.d4peng.cloud.common.db.request.SuperDTO;
import icu.d4peng.cloud.user.entity.User;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <p> AclDTO
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
public class AclDTO extends SuperDTO<User> {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 验证码
     */
    private String code;


    public String getUsername() {
        return username;
    }

    public AclDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AclDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getCode() {
        return code;
    }

    public AclDTO setCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("username", username)
                .append("password", password)
                .append("code", code)
                .toString();
    }
}
