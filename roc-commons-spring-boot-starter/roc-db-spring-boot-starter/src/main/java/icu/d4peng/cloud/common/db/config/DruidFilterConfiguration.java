package icu.d4peng.cloud.common.db.config;

import com.alibaba.druid.filter.config.ConfigFilter;
import com.alibaba.druid.filter.encoding.EncodingConvertFilter;
import com.alibaba.druid.filter.logging.CommonsLogFilter;
import com.alibaba.druid.filter.logging.Log4j2Filter;
import com.alibaba.druid.filter.logging.Log4jFilter;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * <p> DruidFilterConfiguration:Filter配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class DruidFilterConfiguration {
    private static final String FILTER_STAT_PREFIX = "roc.db.druid.filter.stat";
    private static final String FILTER_CONFIG_PREFIX = "roc.db.druid.filter.config";
    private static final String FILTER_ENCODING_PREFIX = "roc.db.druid.filter.encoding";
    private static final String FILTER_SLF4J_PREFIX = "roc.db.druid.filter.slf4j";
    private static final String FILTER_LOG4J_PREFIX = "roc.db.druid.filter.log4j";
    private static final String FILTER_LOG4J2_PREFIX = "roc.db.druid.filter.log4j2";
    private static final String FILTER_COMMONS_LOG_PREFIX = "roc.db.druid.filter.commons-log";
    private static final String FILTER_WALL_PREFIX = "roc.db.druid.filter.wall";
    private static final String FILTER_WALL_CONFIG_PREFIX = FILTER_WALL_PREFIX + ".config";

    @Bean
    @ConfigurationProperties(FILTER_STAT_PREFIX)
    @ConditionalOnProperty(prefix = FILTER_STAT_PREFIX, name = "enabled")
    @ConditionalOnMissingBean
    public StatFilter statFilter() {
        return new StatFilter();
    }

    @Bean
    @ConfigurationProperties(FILTER_CONFIG_PREFIX)
    @ConditionalOnProperty(prefix = FILTER_CONFIG_PREFIX, name = "enabled")
    @ConditionalOnMissingBean
    public ConfigFilter configFilter() {
        return new ConfigFilter();
    }

    @Bean
    @ConfigurationProperties(FILTER_ENCODING_PREFIX)
    @ConditionalOnProperty(prefix = FILTER_ENCODING_PREFIX, name = "enabled")
    @ConditionalOnMissingBean
    public EncodingConvertFilter encodingConvertFilter() {
        return new EncodingConvertFilter();
    }

    @Bean
    @ConfigurationProperties(FILTER_SLF4J_PREFIX)
    @ConditionalOnProperty(prefix = FILTER_SLF4J_PREFIX, name = "enabled")
    @ConditionalOnMissingBean
    public Slf4jLogFilter slf4jLogFilter() {
        return new Slf4jLogFilter();
    }

    @Bean
    @ConfigurationProperties(FILTER_LOG4J_PREFIX)
    @ConditionalOnProperty(prefix = FILTER_LOG4J_PREFIX, name = "enabled")
    @ConditionalOnMissingBean
    public Log4jFilter log4jFilter() {
        return new Log4jFilter();
    }

    @Bean
    @ConfigurationProperties(FILTER_LOG4J2_PREFIX)
    @ConditionalOnProperty(prefix = FILTER_LOG4J2_PREFIX, name = "enabled")
    @ConditionalOnMissingBean
    public Log4j2Filter log4j2Filter() {
        return new Log4j2Filter();
    }

    @Bean
    @ConfigurationProperties(FILTER_COMMONS_LOG_PREFIX)
    @ConditionalOnProperty(prefix = FILTER_COMMONS_LOG_PREFIX, name = "enabled")
    @ConditionalOnMissingBean
    public CommonsLogFilter commonsLogFilter() {
        return new CommonsLogFilter();
    }

    @Bean
    @ConfigurationProperties(FILTER_WALL_CONFIG_PREFIX)
    @ConditionalOnProperty(prefix = FILTER_WALL_PREFIX, name = "enabled")
    @ConditionalOnMissingBean
    public WallConfig wallConfig() {
        return new WallConfig();
    }

    @Bean
    @ConfigurationProperties(FILTER_WALL_PREFIX)
    @ConditionalOnProperty(prefix = FILTER_WALL_PREFIX, name = "enabled")
    @ConditionalOnMissingBean
    public WallFilter wallFilter(WallConfig wallConfig) {
        WallFilter filter = new WallFilter();
        filter.setConfig(wallConfig);
        return filter;
    }
}
