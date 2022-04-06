package icu.d4peng.cloud.user.entity;

import icu.d4peng.cloud.common.db.domain.AbstractSuperEntity;
import icu.d4peng.cloud.user.enums.StatusEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <p> User
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
public class User extends AbstractSuperEntity {
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 登录IP
     */
    private String loginIp;
    /**
     * 用户状态
     */
    private StatusEnum status;
    /**
     * 备注
     */
    private String remark;

    public String getNickName() {
        return nickName;
    }

    public User setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public User setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public User setLoginIp(String loginIp) {
        this.loginIp = loginIp;
        return this;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public User setStatus(StatusEnum status) {
        this.status = status;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public User setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("nickName", nickName)
                .append("username", username)
                .append("password", password)
                .append("phone", phone)
                .append("email", email)
                .append("avatar", avatar)
                .append("loginIp", loginIp)
                .append("status", status)
                .append("remark", remark)
                .toString();
    }
}