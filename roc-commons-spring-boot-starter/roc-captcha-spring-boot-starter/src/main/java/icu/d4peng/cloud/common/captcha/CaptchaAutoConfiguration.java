package icu.d4peng.cloud.common.captcha;

import icu.d4peng.cloud.common.captcha.properties.CaptchaProperties;
import icu.d4peng.cloud.common.captcha.service.CaptchaService;
import icu.d4peng.cloud.common.captcha.service.impl.CaptchaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p> CaptchaAutoConfiguration: 验证码自动配置类
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@Configuration
@EnableConfigurationProperties({CaptchaProperties.class})
@ConditionalOnProperty(prefix = CaptchaProperties.PREFIX, name = {"enabled"}, havingValue = "true")
public class CaptchaAutoConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(CaptchaAutoConfiguration.class);

    @Bean
    @ConditionalOnMissingBean({CaptchaService.class})
    public CaptchaService captchaService(@Autowired CaptchaProperties captchaProperties) {
        return new CaptchaServiceImpl(captchaProperties);
    }
}
