package icu.d4peng.cloud.common.core.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * <p> BaseVO:基础抽象视图
 * @since 2022-03-27 15:43
 */
@Data
@Accessors(chain = true)
public abstract class BaseVO implements Serializable {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 信息
     */
    private String message;
}