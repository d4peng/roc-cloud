package icu.d4peng.cloud.common.core;

import icu.d4peng.cloud.common.core.util.SpringAware;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * <p> CoreAutoConfiguration:核心包自动配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@Configuration
public class CoreAutoConfiguration {

    @ConditionalOnMissingBean({SpringAware.class})
    @Bean
    public SpringAware springAware() {
        return new SpringAware();
    }

}
