package icu.d4peng.cloud.user.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <p> RegisterDTO: 注册DTO
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-04-08
 */
public class RegisterDTO {
    private String username;
    private String password;
    private String code;

    public String getUsername() {
        return username;
    }

    public RegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getCode() {
        return code;
    }

    public RegisterDTO setCode(String code) {
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
