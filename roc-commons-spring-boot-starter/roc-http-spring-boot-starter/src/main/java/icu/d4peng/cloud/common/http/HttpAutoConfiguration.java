package icu.d4peng.cloud.common.http;

import com.dtflys.forest.config.ForestConfiguration;
import com.dtflys.forest.config.SpringForestProperties;
import com.dtflys.forest.converter.ForestConverter;
import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.interceptor.SpringInterceptorFactory;
import com.dtflys.forest.logging.ForestLogHandler;
import com.dtflys.forest.reflection.SpringForestObjectFactory;
import com.dtflys.forest.scanner.ClassPathClientScanner;
import com.dtflys.forest.schema.ForestConfigurationBeanDefinitionParser;
import com.dtflys.forest.spring.ForestBeanProcessor;
import com.dtflys.forest.utils.ForestDataType;
import icu.d4peng.cloud.common.core.exception.InstanceException;
import icu.d4peng.cloud.common.http.properties.HttpConvertProperties;
import icu.d4peng.cloud.common.http.properties.HttpConverterItemProperties;
import icu.d4peng.cloud.common.http.properties.HttpProperties;
import icu.d4peng.cloud.common.http.properties.HttpSslKeyStoreProperties;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cglib.core.ReflectUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Map;

/**
 * <p> HttpAutoConfiguration:Http自动配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@Configuration
@EnableConfigurationProperties({HttpProperties.class})
@ConditionalOnProperty(prefix = HttpProperties.PREFIX, name = {"enabled"}, havingValue = "true")
public class HttpAutoConfiguration {

    /**
     * 变量
     *
     * @return 变量注册
     */
    @Bean
    @ConditionalOnMissingBean
    public ForestBeanProcessor forestBeanProcessor() {
        return new ForestBeanProcessor();
    }


    /**
     * bean注册
     *
     * @param configurableApplicationContext 上下文
     * @param httpProperties                 属性
     * @return bean注册
     */
    @Bean
    @ConditionalOnMissingBean
    @SuppressWarnings("AlibabaMethodTooLong")
    public ClassPathClientScanner classPathClientScanner(ConfigurableApplicationContext configurableApplicationContext,
                                                         HttpProperties httpProperties) {
        // 注册ForestConfigurationBean
        BeanDefinitionBuilder forestConfigurationBuilder = BeanDefinitionBuilder.genericBeanDefinition(ForestConfiguration.class);

        Class<? extends ForestLogHandler> logHandlerClass = httpProperties.getLogHandler();
        ForestLogHandler logHandler = null;
        if (logHandlerClass != null) {
            try {
                logHandler = logHandlerClass.newInstance();
            } catch (Exception e) {
                throw new InstanceException(e);
            }
        }

        forestConfigurationBuilder
                .addPropertyValue("maxAsyncThreadSize", httpProperties.getMaxAsyncThreadSize())
                .addPropertyValue("maxConnections", httpProperties.getMaxConnections())
                .addPropertyValue("maxRouteConnections", httpProperties.getMaxRouteConnections())
                .addPropertyValue("timeout", httpProperties.getTimeout())
                .addPropertyValue("connectTimeout", httpProperties.getConnectTimeout())
                .addPropertyValue("readTimeout", httpProperties.getReadTimeout())
                .addPropertyValue("charset", httpProperties.getCharset())
                .addPropertyValue("retryer", httpProperties.getRetryer())
                .addPropertyValue("maxRetryCount", httpProperties.getMaxRetryCount())
                .addPropertyValue("maxRetryInterval", httpProperties.getMaxRetryInterval())
                .addPropertyValue("autoRedirection", httpProperties.isAutoRedirection())
                .addPropertyValue("logEnabled", httpProperties.isLogEnabled())
                .addPropertyValue("logRequest", httpProperties.isLogRequest())
                .addPropertyValue("logResponseStatus", httpProperties.isLogResponseStatus())
                .addPropertyValue("logResponseContent", httpProperties.isLogResponseContent())
                .addPropertyValue("logHandler", logHandler)
                .addPropertyValue("backendName", httpProperties.getBackend())
                .addPropertyValue("baseAddressScheme", httpProperties.getBaseAddressScheme())
                .addPropertyValue("baseAddressHost", httpProperties.getBaseAddressHost())
                .addPropertyValue("baseAddressPort", httpProperties.getBaseAddressPort())
                .addPropertyValue("baseAddressSourceClass", httpProperties.getBaseAddressSource())
                .addPropertyValue("successWhenClass", httpProperties.getSuccessWhen())
                .addPropertyValue("retryWhenClass", httpProperties.getRetryWhen())
                .addPropertyValue("interceptors", httpProperties.getInterceptors())
                .addPropertyValue("sslProtocol", httpProperties.getSslProtocol())
                .addPropertyValue("variables", httpProperties.getVariables())
                .setLazyInit(false)
                .setFactoryMethod("configuration");

        BeanDefinition forestPropertiesBean = registerForestPropertiesBean(configurableApplicationContext);
        forestConfigurationBuilder.addPropertyValue("properties", forestPropertiesBean);

        BeanDefinition forestObjectFactoryBeanDefinition = registerForestObjectFactoryBean(configurableApplicationContext);
        forestConfigurationBuilder.addPropertyValue("forestObjectFactory", forestObjectFactoryBeanDefinition);

        BeanDefinition interceptorFactoryBeanDefinition = registerInterceptorFactoryBean(configurableApplicationContext);
        forestConfigurationBuilder.addPropertyValue("interceptorFactory", interceptorFactoryBeanDefinition);

        ManagedMap<String, BeanDefinition> sslKeystoreMap = generateSslKeyStoreMapBean(httpProperties.getSslKeyStores());
        forestConfigurationBuilder.addPropertyValue("sslKeyStores", sslKeystoreMap);

        // 注册Bean
        BeanDefinition beanDefinition = forestConfigurationBuilder.getRawBeanDefinition();
        beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
        BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) configurableApplicationContext.getBeanFactory();
        beanFactory.registerBeanDefinition(httpProperties.getBeanId(), beanDefinition);

        ForestConfiguration forestConfiguration = configurableApplicationContext.getBean(httpProperties.getBeanId(), ForestConfiguration.class);

        // 注册过滤器
        Map<String, Class<?>> filters = httpProperties.getFilters();
        for (Map.Entry<String, Class<?>> entry : filters.entrySet()) {
            forestConfiguration.registerFilter(entry.getKey(), entry.getValue());
        }

        // 注册转换器
        HttpConvertProperties httpConvertProperties = httpProperties.getConverters();
        if (httpConvertProperties != null) {
            registerConverter(forestConfiguration, ForestDataType.TEXT, httpConvertProperties.getText());
            registerConverter(forestConfiguration, ForestDataType.JSON, httpConvertProperties.getJson());
            registerConverter(forestConfiguration, ForestDataType.XML, httpConvertProperties.getXml());
            registerConverter(forestConfiguration, ForestDataType.BINARY, httpConvertProperties.getBinary());
            registerConverter(forestConfiguration, ForestDataType.PROTOBUF, httpConvertProperties.getProtobuf());
        }

        // 配置扫描
        ClassPathClientScanner classPathClientScanner = new ClassPathClientScanner(httpProperties.getBeanId(), (BeanDefinitionRegistry) configurableApplicationContext.getBeanFactory());
        classPathClientScanner.doScan(AutoConfigurationPackages.get(configurableApplicationContext.getBeanFactory()).toArray(new String[]{}));
        return classPathClientScanner;
    }

    private BeanDefinition registerForestPropertiesBean(ConfigurableApplicationContext configurableApplicationContext) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(SpringForestProperties.class);
        BeanDefinition beanDefinition = beanDefinitionBuilder.getRawBeanDefinition();
        beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
        BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) configurableApplicationContext.getBeanFactory();
        beanFactory.registerBeanDefinition("forestProperties", beanDefinition);
        return beanDefinition;
    }

    private BeanDefinition registerForestObjectFactoryBean(ConfigurableApplicationContext configurableApplicationContext) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(SpringForestObjectFactory.class);
        BeanDefinition beanDefinition = beanDefinitionBuilder.getRawBeanDefinition();
        beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
        BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) configurableApplicationContext.getBeanFactory();
        beanFactory.registerBeanDefinition("forestObjectFactory", beanDefinition);
        return beanDefinition;
    }

    private BeanDefinition registerInterceptorFactoryBean(ConfigurableApplicationContext configurableApplicationContext) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(SpringInterceptorFactory.class);
        BeanDefinition beanDefinition = beanDefinitionBuilder.getRawBeanDefinition();
        beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
        BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) configurableApplicationContext.getBeanFactory();
        beanFactory.registerBeanDefinition("forestInterceptorFactory", beanDefinition);
        return beanDefinition;
    }

    private ManagedMap<String, BeanDefinition> generateSslKeyStoreMapBean(List<HttpSslKeyStoreProperties> httpSslKeyStorePropertiesList) {
        ManagedMap<String, BeanDefinition> sslKeystoreMap = new ManagedMap<>();
        for (HttpSslKeyStoreProperties httpSslKeyStoreProperties : httpSslKeyStorePropertiesList) {
            BeanDefinition beanDefinition = ForestConfigurationBeanDefinitionParser.createSSLKeyStoreBean(
                    httpSslKeyStoreProperties.getId(),
                    httpSslKeyStoreProperties.getType(),
                    httpSslKeyStoreProperties.getFile(),
                    httpSslKeyStoreProperties.getKeystorePass(),
                    httpSslKeyStoreProperties.getCertPass(),
                    httpSslKeyStoreProperties.getProtocols(),
                    httpSslKeyStoreProperties.getCipherSuites(),
                    httpSslKeyStoreProperties.getHostnameVerifier(),
                    httpSslKeyStoreProperties.getSslSocketFactoryBuilder()
            );
            beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
            sslKeystoreMap.put(httpSslKeyStoreProperties.getId(), beanDefinition);
        }
        return sslKeystoreMap;
    }

    private void registerConverter(ForestConfiguration configuration, ForestDataType dataType, HttpConverterItemProperties httpConverterItemProperties) {
        if (httpConverterItemProperties == null) {
            return;
        }
        Class<?> type = httpConverterItemProperties.getType();
        if (type != null) {
            ForestConverter<?> converter = null;
            try {
                Constructor<?>[] constructors = type.getConstructors();
                for (Constructor<?> constructor : constructors) {
                    Parameter[] params = constructor.getParameters();
                    if (params.length == 0) {
                        converter = (ForestConverter<?>) constructor.newInstance(new Object[0]);
                        break;
                    } else if (params.length == 1 &&
                            ForestConfiguration.class.isAssignableFrom(constructor.getParameterTypes()[0])) {
                        converter = (ForestConverter<?>) constructor.newInstance(new Object[]{constructor});
                        break;
                    }
                }

                Map<String, Object> parameters = httpConverterItemProperties.getParameters();
                PropertyDescriptor[] descriptors = ReflectUtils.getBeanSetters(type);
                for (PropertyDescriptor descriptor : descriptors) {
                    String name = descriptor.getName();
                    Object value = parameters.get(name);
                    Method method = descriptor.getWriteMethod();
                    if (method != null) {
                        try {
                            method.invoke(converter, value);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new ForestRuntimeException("An error occurred during setting the property " + type.getName() + "." + name, e);
                        }
                    }
                }
                configuration.getConverterMap().put(dataType, converter);
            } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
                throw new ForestRuntimeException("[Forest] Convert type '" + type.getName() + "' cannot be initialized!", e);
            }
        }
    }

}
