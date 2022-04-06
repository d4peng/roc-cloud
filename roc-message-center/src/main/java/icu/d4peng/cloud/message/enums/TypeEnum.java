package icu.d4peng.cloud.message.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

/**
 * <p> TypeEnum:类型枚举
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
public enum TypeEnum implements IEnum<Integer> {
    /**
     * SMS
     */
    SMS(1, "SMS"),
    /**
     * 邮件
     */
    EMAIL(2, "EMAIL");

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 描述
     */
    private final String description;

    TypeEnum(Integer type, String description) {
        this.type = type;
        this.description = description;
    }

    @Override
    public Integer getValue() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
