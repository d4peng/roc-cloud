package icu.d4peng.cloud.common.core.constants;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-24 18:23
 * @description BaseConstant:基础常量
 */
public enum BaseConstant {
    ZERO(0, "ZERO"),
    ONE(1, "ONE"),
    TWO(2, "TWO"),
    THREE(3, "THREE"),
    FOUR(4, "FOUR"),
    FIVE(5, "FIVE"),
    SIX(6, "SIX"),
    SEVEN(7, "SEVEN"),
    EIGHT(8, "EIGHT"),
    NINE(9, "NINE"),
    TEN(10, "TEN"),

    SUCCESS(0, "SUCCESS"),
    FAILED(-1, "FAILED"),

    ;

    /**
     * 值
     */
    private final int value;
    /**
     * 描述
     */
    private final String desc;

    BaseConstant(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
