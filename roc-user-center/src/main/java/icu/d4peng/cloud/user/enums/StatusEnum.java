package icu.d4peng.cloud.user.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

/**
 * <p> StatusEnum
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
public enum StatusEnum implements IEnum<Integer> {
    /**
     * 正常
     */
    NORMAL(1, "正常"),
    /**
     * 禁用
     */
    DISABLE(2, "禁用"),
    ;

    private final Integer value;
    private final String desc;

    StatusEnum(final Integer value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
