package icu.d4peng.cloud.common.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;

/**
 * <p> SpringAware:Spring操作
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class SpringAware implements ApplicationContextAware {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringAware.class);
    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return SpringAware.applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringAware.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clz) {
        return SpringAware.applicationContext.getBean(clz);
    }

    public static <T> void registerBean(String name, T bean) {
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) SpringAware.applicationContext.getAutowireCapableBeanFactory();
        beanFactory.autowireBean(bean);
        beanFactory.registerSingleton(bean.getClass().getName(), bean);
    }

    public static <T> void registerBean(T bean) {
        registerBean(bean.getClass().getSimpleName(), bean);
    }

    public static <T> void unregisterBean(String name) {
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) SpringAware.applicationContext.getAutowireCapableBeanFactory();
        beanFactory.destroyBean(name);
    }

    public static <T> void unregisterBean(T bean) {
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) SpringAware.applicationContext.getAutowireCapableBeanFactory();
        beanFactory.destroyBean(bean);
    }

    public static Environment getEnvironment() {
        return SpringAware.applicationContext.getEnvironment();
    }

    public static String getEnvironmentProperty(String key) {
        return getEnvironment().getProperty(key);
    }

}