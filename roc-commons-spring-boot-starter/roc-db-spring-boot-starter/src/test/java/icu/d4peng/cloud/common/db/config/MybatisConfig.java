package icu.d4peng.cloud.common.db.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.dialects.MySqlDialect;
import icu.d4peng.cloud.common.db.handler.DefaultMetaObjectHandler;
import icu.d4peng.cloud.common.db.handler.DefaultTenantHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-29 16:24
 * @description MybatisConfig:Mybatis配置
 */
@Configuration
public class MybatisConfig {

    /**
     * 默认字段填充器
     *
     * @return 字段填充器
     */
    @Bean
    public MetaObjectHandler defaultMetaObjectHandler() {
        return new DefaultMetaObjectHandler();
    }

    /**
     * 默认ID生成器
     *
     * @return ID生成器
     */
    @Bean
    public IdentifierGenerator defaultIdentifierGenerator() {
        return new DefaultIdentifierGenerator();
    }

    /**
     * 多租户插件
     *
     * @return 多租户生成器
     */
    @Bean
    public DefaultTenantHandler defaultTenantHandler() {
        return null;
//        return new DefaultTenantHandler("roc", "tenant", new ArrayList<String>());
    }


    /**
     * 插件汇总
     *
     * @return 插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        // 多租户插件
        TenantLineInnerInterceptor tenantLineInnerInterceptor = new TenantLineInnerInterceptor();
        tenantLineInnerInterceptor.setTenantLineHandler(defaultTenantHandler());

        // 分页插件
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        paginationInnerInterceptor.setOverflow(true);
        paginationInnerInterceptor.setMaxLimit(100L);
        paginationInnerInterceptor.setDbType(DbType.MYSQL);
        paginationInnerInterceptor.setDialect(new MySqlDialect());
        paginationInnerInterceptor.setOptimizeJoin(true);

        // 针对 update 和 delete 语句 作用: 阻止恶意的全表更新删除
        BlockAttackInnerInterceptor blockAttackInnerInterceptor = new BlockAttackInnerInterceptor();

        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        interceptor.addInnerInterceptor(blockAttackInnerInterceptor);
        if (tenantLineInnerInterceptor.getTenantLineHandler() != null) {
            interceptor.addInnerInterceptor(tenantLineInnerInterceptor);
        }
        return interceptor;
    }

}