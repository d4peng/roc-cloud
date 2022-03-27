package icu.d4peng.cloud.common.auth;

import icu.d4peng.cloud.common.auth.properties.JustAuthProperties;
import icu.d4peng.cloud.common.auth.service.JustAuthService;
import icu.d4peng.cloud.common.auth.service.impl.JustAuthServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p> JustAuthAutoConfiguration:三方登录自动配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@Configuration
@EnableConfigurationProperties({JustAuthProperties.class})
@ConditionalOnProperty(prefix = JustAuthProperties.PREFIX, name = {"enabled"}, havingValue = "true")
public class JustAuthAutoConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(JustAuthAutoConfiguration.class);

    @Bean
    @ConditionalOnMissingBean({JustAuthService.class})
    public JustAuthService justAuthService(JustAuthProperties justAuthProperties) {
        return new JustAuthServiceImpl(justAuthProperties);
    }
}
