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
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-29 18:36
 * @description DruidProperties:Druid配置 TODO:可以自定义端点
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