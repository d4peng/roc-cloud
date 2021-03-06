package icu.d4peng.cloud.common.log;

import icu.d4peng.cloud.common.log.aspect.LogAspect;
import icu.d4peng.cloud.common.log.config.WebLogMvcConfigurer;
import icu.d4peng.cloud.common.log.properties.LogProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p> LogAutoConfiguration:日志自动配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@Configuration
@EnableConfigurationProperties(LogProperties.class)
@ConditionalOnProperty(prefix = LogProperties.PREFIX, value = {"enabled"}, matchIfMissing = true, havingValue = "true")
public class LogAutoConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAutoConfiguration.class);

    @ConditionalOnProperty(prefix = LogProperties.PREFIX, value = {"enable-aop-log"}, matchIfMissing = true, havingValue = "true")
    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }

    @Bean
    public WebLogMvcConfigurer webLogMvcConfigurer() {
        return new WebLogMvcConfigurer();
    }
}
