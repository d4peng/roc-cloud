package icu.d4peng.cloud.common.mvc.properties;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-30 11:25
 * @description MvcProperties:
 */
@Data
@Accessors(chain = true)
@ConfigurationProperties(prefix = MvcProperties.PREFIX)
public class MvcProperties {
    /**
     * 前缀
     */
    public static final String PREFIX = "roc.mvc";
    /**
     * 是否开启:默认开启
     */
    private boolean enabled = true;
    /**
     * 是否开启默认的错误处理
     */
    private boolean enableDefaultErrorsHandler = true;
    /**
     * 是否开启默认的校验策略 TODO
     */
    // private boolean enableDefaultValidRule = true;
    /**
     * 全局时间格式化正则表达式
     */
    private String globalTimeFormatRegex = "yyyy-MM-dd HH:mm:ss";

}