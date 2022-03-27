package icu.d4peng.cloud.common.db.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2022-03-19 14:23
 * @description StatusEnum:
 */
@Getter
public enum StatusEnum implements IEnum<Integer> {
    UNKNOWN(-1, "UNKNOWN"),
    SUCCESS(0, "SUCCESS"),
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
