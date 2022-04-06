package icu.d4peng.cloud.common.mvc.properties;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p> MvcProperties:Mvc属性配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
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

    public boolean isEnabled() {
        return enabled;
    }

    public MvcProperties setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public boolean isEnableDefaultErrorsHandler() {
        return enableDefaultErrorsHandler;
    }

    public MvcProperties setEnableDefaultErrorsHandler(boolean enableDefaultErrorsHandler) {
        this.enableDefaultErrorsHandler = enableDefaultErrorsHandler;
        return this;
    }

    public String getGlobalTimeFormatRegex() {
        return globalTimeFormatRegex;
    }

    public MvcProperties setGlobalTimeFormatRegex(String globalTimeFormatRegex) {
        this.globalTimeFormatRegex = globalTimeFormatRegex;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("enabled", enabled)
                .append("enableDefaultErrorsHandler", enableDefaultErrorsHandler)
                .append("globalTimeFormatRegex", globalTimeFormatRegex)
                .toString();
    }
}