package icu.d4peng.cloud.common.auth.properties;

import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.config.AuthDefaultSource;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> JustAuthProperties:三方认证配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@ConfigurationProperties(prefix = JustAuthProperties.PREFIX)
public class JustAuthProperties {
    /**
     * 前缀
     */
    public static final String PREFIX = "roc.auth";
    /**
     * 是否开启:默认关闭
     */
    private boolean enabled = false;
    /**
     * 类型配置:自定义第三方Oauth配置
     */
    private Map<AuthDefaultSource, AuthConfig> types = new HashMap<>();

    public boolean isEnabled() {
        return enabled;
    }

    public JustAuthProperties setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Map<AuthDefaultSource, AuthConfig> getTypes() {
        return types;
    }

    public JustAuthProperties setTypes(Map<AuthDefaultSource, AuthConfig> types) {
        this.types = types;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("enabled", enabled)
                .append("types", types)
                .toString();
    }
}
