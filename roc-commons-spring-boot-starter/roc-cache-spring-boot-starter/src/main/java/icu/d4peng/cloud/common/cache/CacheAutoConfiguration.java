package icu.d4peng.cloud.common.cache;

import icu.d4peng.cloud.common.cache.properties.CacheProperties;
import icu.d4peng.cloud.common.cache.service.CacheService;
import icu.d4peng.cloud.common.cache.service.impl.CacheServiceImpl;
import net.oschina.j2cache.J2CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 16:48
 * @description CacheAutoConfiguration:缓存自动配置
 */
@Configuration
@EnableConfigurationProperties({CacheProperties.class})
@ConditionalOnProperty(prefix = CacheProperties.PREFIX, name = {"enabled"}, havingValue = "true")
public class CacheAutoConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheAutoConfiguration.class);

    @Bean
    @ConditionalOnMissingBean({CacheService.class})
    public CacheService cacheService(CacheProperties cacheProperties) {
        return new CacheServiceImpl(J2CacheBuilder.init(cacheProperties).getChannel());
    }

}
