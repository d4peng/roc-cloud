package icu.d4peng.cloud.user.dto;

import icu.d4peng.cloud.common.db.request.SuperDTO;
import icu.d4peng.cloud.user.entity.User;
import icu.d4peng.cloud.user.enums.StatusEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <p> UserDTO: 用户DTO
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
public class UserDTO extends SuperDTO<User> {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 用户状态
     */
    private StatusEnum status;

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public UserDTO setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public UserDTO setStatus(StatusEnum status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("username", username)
                .append("password", password)
                .append("nickName", nickName)
                .append("phone", phone)
                .append("status", status)
                .toString();
    }
}
