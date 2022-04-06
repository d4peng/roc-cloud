package icu.d4peng.cloud.common.core.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * <p> BaseVO:基础抽象视图
 * @since 2022-03-27 15:43
 */
public abstract class BaseVO implements Serializable {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 信息
     */
    private String message;

    public Integer getCode() {
        return code;
    }

    public BaseVO setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BaseVO setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("code", code)
                .append("message", message)
                .toString();
    }
}