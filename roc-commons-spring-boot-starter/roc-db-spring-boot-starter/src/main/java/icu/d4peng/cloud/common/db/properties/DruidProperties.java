package icu.d4peng.cloud.common.db.properties;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p> DruidProperties:Druid配置 TODO:可以自定义端点
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@Data
@Accessors(chain = true)
@ConfigurationProperties(prefix = DruidProperties.PREFIX)
@EqualsAndHashCode(callSuper = true)
public class DruidProperties extends DruidDataSource implements InitializingBean {
    /**
     * 前缀
     */
    public static final String PREFIX = "roc.db.druid";
    /**
     * 是否开启:默认开启
     */
    private boolean enabled = true;
    @Autowired(required = false)
    private DataSourceProperties basicProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (super.getUsername() == null) {
            super.setUsername(this.basicProperties.determineUsername());
        }

        if (super.getPassword() == null) {
            super.setPassword(this.basicProperties.determinePassword());
        }

        if (super.getUrl() == null) {
            super.setUrl(this.basicProperties.determineUrl());
        }

        if (super.getDriverClassName() == null) {
            super.setDriverClassName(this.basicProperties.getDriverClassName());
        }
    }
}