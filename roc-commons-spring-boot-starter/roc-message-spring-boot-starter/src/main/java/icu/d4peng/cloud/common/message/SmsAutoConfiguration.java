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
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 15:39
 * @description SmsAutoConfiguration:短信自动配置
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
