package icu.d4peng.cloud.common.auth.properties;

import cn.dev33.satoken.config.SaTokenConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 09:16
 * @description SaTokenProperties: sa-token配置
 */
@Data
@Accessors(chain = true)
@ConfigurationProperties(prefix = SaTokenProperties.PREFIX)
@EqualsAndHashCode(callSuper = true)
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
}
