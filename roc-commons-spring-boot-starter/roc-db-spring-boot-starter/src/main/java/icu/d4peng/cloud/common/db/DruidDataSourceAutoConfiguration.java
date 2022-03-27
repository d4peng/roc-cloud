package icu.d4peng.cloud.common.db;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import icu.d4peng.cloud.common.db.config.DruidFilterConfiguration;
import icu.d4peng.cloud.common.db.config.DruidStatViewServletConfiguration;
import icu.d4peng.cloud.common.db.config.DruidWebStatFilterConfiguration;
import icu.d4peng.cloud.common.db.properties.DruidProperties;
import icu.d4peng.cloud.common.db.properties.DruidStatProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.List;

/**
 * <p> DruidDataSourceAutoConfiguration:Druid数据源自动配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@Configuration
@ConditionalOnClass(DruidDataSource.class)
@AutoConfigureBefore({DataSourceAutoConfiguration.class, MybatisPlusAutoConfiguration.class})
@EnableConfigurationProperties({DruidStatProperties.class, DataSourceProperties.class, DruidProperties.class})
@ConditionalOnProperty(prefix = DruidProperties.PREFIX, name = {"enabled"}, havingValue = "true")
@Import({DruidFilterConfiguration.class, DruidStatViewServletConfiguration.class, DruidWebStatFilterConfiguration.class})
public class DruidDataSourceAutoConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(DruidDataSourceAutoConfiguration.class);

    /**
     * 数据库配置
     *
     * @param druidProperties 数据库属性
     * @param filters         拦截器
     */
    @ConditionalOnMissingBean({DruidDataSource.class})
    @Autowired
    public void dataSource(DruidProperties druidProperties, @Autowired(required = false) List<Filter> filters) {
        druidProperties.setProxyFilters(filters);
    }
}