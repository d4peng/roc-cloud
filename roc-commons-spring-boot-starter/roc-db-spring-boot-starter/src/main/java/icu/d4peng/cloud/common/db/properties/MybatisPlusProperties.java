package icu.d4peng.cloud.common.db.properties;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.toolkit.GlobalConfigUtils;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.ibatis.session.ExecutorType;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-29 15:23
 * @description MybatisPlusProperties:MybatisPlus属性配置
 */
@Data
@Accessors(chain = true)
@ConfigurationProperties(prefix = MybatisPlusProperties.PREFIX)
public class MybatisPlusProperties implements InitializingBean {
    /**
     * 前缀
     */
    public static final String PREFIX = "roc.db.mybatis";
    /**
     * 资源解决器
     */
    private static final ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
    /**
     * 是否开启:默认开启
     */
    private boolean enabled = true;
    /**
     * MyBatis xml配置文件位置
     */
    private String configLocation;
    /**
     * MyBatisMapper文件位置
     */
    private String[] mapperLocations = new String[]{"classpath*:/mapper/**/*.xml"};
    /**
     * typeAliases包
     */
    private String typeAliasesPackage;
    /**
     * typeAliases父类
     */
    private Class<?> typeAliasesSuperType;
    /**
     * type handlers包
     */
    private String typeHandlersPackage;
    /**
     * 是否检查MyBatis xml配置文件
     */
    private boolean checkConfigLocation = false;
    /**
     * SqlSessionTemplate执行模式
     */
    private ExecutorType executorType;
    /**
     * MyBatis 额外配置
     */
    private Properties configurationProperties;
    /**
     * Mybatis原生配置
     */
    @NestedConfigurationProperty
    private MybatisConfiguration configuration;
    /**
     * 枚举包扫描
     */
    private String typeEnumsPackage;
    /**
     * 全局配置
     */
    @NestedConfigurationProperty
    private GlobalConfig globalConfig = GlobalConfigUtils.defaults();

    public Resource[] resolveMapperLocations() {
        return Stream.of(Optional.ofNullable(this.mapperLocations).orElse(new String[0]))
                .flatMap(location -> Stream.of(getResources(location))).toArray(Resource[]::new);
    }

    private Resource[] getResources(String location) {
        try {
            return resourceResolver.getResources(location);
        } catch (IOException e) {
            return new Resource[0];
        }
    }

    /**
     * 设置Banner打印和默认枚举包
     *
     * @throws Exception 异常
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        this.getGlobalConfig().setBanner(false);
        this.setTypeEnumsPackage(this.getTypeEnumsPackage() + ";icu.d4peng.cloud.common.db.enums");
    }
}
