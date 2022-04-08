package icu.d4peng.cloud.user.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <p> CaptchaDTO: 验证码DTO
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-04-08
 */
public class CaptchaDTO {
    private String username;

    public String getUsername() {
        return username;
    }

    public CaptchaDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("username", username)
                .toString();
    }
}
