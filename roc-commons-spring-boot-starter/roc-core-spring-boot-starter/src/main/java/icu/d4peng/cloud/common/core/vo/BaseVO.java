package icu.d4peng.cloud.common.core.vo;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-24 09:26
 * @description BaseVO:基础抽象视图
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