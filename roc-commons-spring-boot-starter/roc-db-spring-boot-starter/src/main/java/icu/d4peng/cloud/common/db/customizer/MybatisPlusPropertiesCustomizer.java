package icu.d4peng.cloud.common.db.customizer;

import icu.d4peng.cloud.common.db.properties.MybatisPlusProperties;

/**
 * <p> MybatisPlusPropertiesCustomizer:MybatisPlus属性定制化
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
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