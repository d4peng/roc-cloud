package icu.d4peng.cloud.common.auth.properties;

import cn.dev33.satoken.config.SaTokenConfig;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p> SaTokenProperties: sa-token配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@ConfigurationProperties(prefix = SaTokenProperties.PREFIX)
public class SaTokenProperties extends SaTokenConfig implements InitializingBean {
    /**
     * 前缀
     */
    public static final String PREFIX = "roc.token";
    /**
     * 是否开启:默认开启
     */
    private boolean enabled = true;

    @Override
    public void afterPropertiesSet() {
        this.setIsPrint(false);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public SaTokenProperties setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("enabled", enabled)
                .toString();
    }
}
