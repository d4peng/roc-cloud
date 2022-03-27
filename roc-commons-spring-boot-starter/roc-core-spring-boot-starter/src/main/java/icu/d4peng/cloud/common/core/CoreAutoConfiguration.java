package icu.d4peng.cloud.common.core;

import icu.d4peng.cloud.common.core.util.SpringAware;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-23 20:49
 * @description CoreAutoConfiguration:核心包自动配置
 */
@Configuration
public class CoreAutoConfiguration {

    @ConditionalOnMissingBean({SpringAware.class})
    @Bean
    public SpringAware springAware() {
        return new SpringAware();
    }

}
