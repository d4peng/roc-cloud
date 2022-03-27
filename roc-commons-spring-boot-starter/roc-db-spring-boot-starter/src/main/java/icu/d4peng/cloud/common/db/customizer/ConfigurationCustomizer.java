package icu.d4peng.cloud.common.db.customizer;

import com.baomidou.mybatisplus.core.MybatisConfiguration;

/**
 * <p> ConfigurationCustomizer:Mybatis原生配置定制化
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@FunctionalInterface
public interface ConfigurationCustomizer {

    /**
     * Mybatis原生配置定制化
     *
     * @param configuration 配置
     */
    void customize(MybatisConfiguration configuration);
}