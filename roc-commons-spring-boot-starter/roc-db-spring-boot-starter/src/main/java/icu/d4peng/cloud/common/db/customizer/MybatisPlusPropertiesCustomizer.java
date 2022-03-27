package icu.d4peng.cloud.common.db.customizer;

import icu.d4peng.cloud.common.db.properties.MybatisPlusProperties;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-29 15:22
 * @description MybatisPlusPropertiesCustomizer:MybatisPlus属性定制化
 */
@FunctionalInterface
public interface MybatisPlusPropertiesCustomizer {

    /**
     * MybatisPlus属性定制化
     *
     * @param mybatisPlusProperties 属性
     */
    void customize(MybatisPlusProperties mybatisPlusProperties);
}