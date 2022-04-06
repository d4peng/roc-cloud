package icu.d4peng.cloud.common.db.properties;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.toolkit.GlobalConfigUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
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
 * <p> MybatisPlusProperties:MybatisPlus属性配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@ConfigurationProperties(prefix = MybatisPlusProperties.PREFIX)
public class MybatisPlusProperties implements InitializingBean {
    /**
     * 前缀
     */
    public static final String PREFIX = "roc.db.mybatis";
    /**
     * 资源解决器
     */
    private static final ResourcePatternResolver RESOURCE_RESOLVER = new PathMatchingResourcePatternResolver();
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
            return RESOURCE_RESOLVER.getResources(location);
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
        //this.setTypeEnumsPackage(this.getTypeEnumsPackage() + ";icu.d4peng.cloud.common.db.enums");
    }

    public boolean isEnabled() {
        return enabled;
    }

    public MybatisPlusProperties setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String getConfigLocation() {
        return configLocation;
    }

    public MybatisPlusProperties setConfigLocation(String configLocation) {
        this.configLocation = configLocation;
        return this;
    }

    public String[] getMapperLocations() {
        return mapperLocations;
    }

    public MybatisPlusProperties setMapperLocations(String[] mapperLocations) {
        this.mapperLocations = mapperLocations;
        return this;
    }

    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }

    public MybatisPlusProperties setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
        return this;
    }

    public Class<?> getTypeAliasesSuperType() {
        return typeAliasesSuperType;
    }

    public MybatisPlusProperties setTypeAliasesSuperType(Class<?> typeAliasesSuperType) {
        this.typeAliasesSuperType = typeAliasesSuperType;
        return this;
    }

    public String getTypeHandlersPackage() {
        return typeHandlersPackage;
    }

    public MybatisPlusProperties setTypeHandlersPackage(String typeHandlersPackage) {
        this.typeHandlersPackage = typeHandlersPackage;
        return this;
    }

    public boolean isCheckConfigLocation() {
        return checkConfigLocation;
    }

    public MybatisPlusProperties setCheckConfigLocation(boolean checkConfigLocation) {
        this.checkConfigLocation = checkConfigLocation;
        return this;
    }

    public ExecutorType getExecutorType() {
        return executorType;
    }

    public MybatisPlusProperties setExecutorType(ExecutorType executorType) {
        this.executorType = executorType;
        return this;
    }

    public Properties getConfigurationProperties() {
        return configurationProperties;
    }

    public MybatisPlusProperties setConfigurationProperties(Properties configurationProperties) {
        this.configurationProperties = configurationProperties;
        return this;
    }

    public MybatisConfiguration getConfiguration() {
        return configuration;
    }

    public MybatisPlusProperties setConfiguration(MybatisConfiguration configuration) {
        this.configuration = configuration;
        return this;
    }

    public String getTypeEnumsPackage() {
        return typeEnumsPackage;
    }

    public MybatisPlusProperties setTypeEnumsPackage(String typeEnumsPackage) {
        this.typeEnumsPackage = typeEnumsPackage;
        return this;
    }

    public GlobalConfig getGlobalConfig() {
        return globalConfig;
    }

    public MybatisPlusProperties setGlobalConfig(GlobalConfig globalConfig) {
        this.globalConfig = globalConfig;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("enabled", enabled)
                .append("configLocation", configLocation)
                .append("mapperLocations", mapperLocations)
                .append("typeAliasesPackage", typeAliasesPackage)
                .append("typeAliasesSuperType", typeAliasesSuperType)
                .append("typeHandlersPackage", typeHandlersPackage)
                .append("checkConfigLocation", checkConfigLocation)
                .append("executorType", executorType)
                .append("configurationProperties", configurationProperties)
                .append("configuration", configuration)
                .append("typeEnumsPackage", typeEnumsPackage)
                .append("globalConfig", globalConfig)
                .toString();
    }
}
