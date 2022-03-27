package icu.d4peng.cloud.common.db.customizer;

import com.baomidou.mybatisplus.core.MybatisConfiguration;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-29 15:18
 * @description ConfigurationCustomizer:Mybatis原生配置定制化
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