package icu.d4peng.cloud.common.auth.properties;

import lombok.Data;
import lombok.experimental.Accessors;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.config.AuthDefaultSource;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-24 18:30
 * @description JustAuthProperties:三方认证配置
 */
@Data
@Accessors(chain = true)
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

}
