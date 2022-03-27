package icu.d4peng.cloud.common.core.constants;

/**
 * <p> BaseConstant:基础常量
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public enum BaseConstant {
    /**
     * 0
     */
    ZERO(0, "ZERO"),
    /**
     * 1
     */
    ONE(1, "ONE"),
    /**
     * 2
     */
    TWO(2, "TWO"),
    /**
     * 3
     */
    THREE(3, "THREE"),
    /**
     * 4
     */
    FOUR(4, "FOUR"),
    /**
     * 5
     */
    FIVE(5, "FIVE"),
    /**
     * 6
     */
    SIX(6, "SIX"),
    /**
     * 7
     */
    SEVEN(7, "SEVEN"),
    /**
     * 8
     */
    EIGHT(8, "EIGHT"),
    /**
     * 9
     */
    NINE(9, "NINE"),
    /**
     * 10
     */
    TEN(10, "TEN"),
    /**
     * 成功
     */
    SUCCESS(0, "SUCCESS"),
    /**
     * 失败
     */
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
