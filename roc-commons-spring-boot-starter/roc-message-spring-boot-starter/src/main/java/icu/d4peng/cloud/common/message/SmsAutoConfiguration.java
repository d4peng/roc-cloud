package icu.d4peng.cloud.common.message;


import icu.d4peng.cloud.common.message.properties.SmsProperties;
import icu.d4peng.cloud.common.message.service.SmsService;
import icu.d4peng.cloud.common.message.service.impl.SmsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p> SmsAutoConfiguration:短信自动配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@Configuration
@EnableConfigurationProperties({SmsProperties.class})
@ConditionalOnProperty(prefix = SmsProperties.PREFIX, value = "enabled", havingValue = "true", matchIfMissing = true)
public class SmsAutoConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsAutoConfiguration.class);

    @Bean
    public SmsService smsService(SmsProperties smsProperties) {
        return new SmsServiceImpl(smsProperties);
    }
}
