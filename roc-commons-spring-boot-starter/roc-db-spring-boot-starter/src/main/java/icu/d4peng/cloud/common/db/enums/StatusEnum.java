package icu.d4peng.cloud.common.db.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

/**
 * <p> StatusEnum:状态枚举
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@Getter
public enum StatusEnum implements IEnum<Integer> {
    /**
     * 未知
     */
    UNKNOWN(-1, "UNKNOWN"),
    /**
     * 成功
     */
    SUCCESS(0, "SUCCESS"),
    /**
     * 失败
     */
    FAILED(1, "FAILED"),
    ;
    /**
     * 类型
     */
    private final Integer value;
    /**
     * 描述
     */
    private final String description;

    StatusEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }
}
