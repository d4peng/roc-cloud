package icu.d4peng.cloud.common.db.config;//package icu.d4peng.cloud.common.db.config;
//
//import org.apache.commons.dbcp2.BasicDataSource;
//import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
//import org.apache.shardingsphere.infra.config.algorithm.ShardingSphereAlgorithmConfiguration;
//import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
//import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
//import org.apache.shardingsphere.sharding.api.config.strategy.sharding.StandardShardingStrategyConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
///**
// * @author d4peng
// * @version 1.0.0
// * @date 2022-02-28 21:35
// * @description ShardingConfig:
// */
//@Configuration
//public class ShardingConfig {
//
//    @Primary
//    @Bean
//    public DataSource dataSource() {
//        // 配置真实数据源
//        Map<String, DataSource> dataSourceMap = new HashMap<>();
//
//        // 配置第 1 个数据源
//        BasicDataSource dataSource1 = new BasicDataSource();
//        dataSource1.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource1.setUrl("jdbc:mysql://192.168.0.201:3306/roc0?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=UTC");
//        dataSource1.setUsername("root");
//        dataSource1.setPassword("Roc@2022");
//        dataSourceMap.put("roc0", dataSource1);
//
//        // 配置第 2 个数据源
//        BasicDataSource dataSource2 = new BasicDataSource();
//        dataSource2.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource2.setUrl("jdbc:mysql://192.168.0.201:3306/roc1?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=UTC");
//        dataSource2.setUsername("root");
//        dataSource2.setPassword("Roc@2022");
//        dataSourceMap.put("roc1", dataSource2);
//
//        // 配置 t_order 表规则
//        ShardingTableRuleConfiguration orderTableRuleConfig = new ShardingTableRuleConfiguration("t_roc", "roc${0..1}.t_roc_${[0,1]}");
//
//        // 配置分库策略
//        orderTableRuleConfig.setDatabaseShardingStrategy(new StandardShardingStrategyConfiguration("id", "dbShardingAlgorithm"));
//
//        // 配置分表策略
//        orderTableRuleConfig.setTableShardingStrategy(new StandardShardingStrategyConfiguration("table_id", "tableShardingAlgorithm"));
//
//        // 省略配置 t_order_item 表规则...
//        // ...
//
//        // 配置分片规则
//        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
//        shardingRuleConfig.getTables().add(orderTableRuleConfig);
//
//        // 配置分库算法
//        Properties dbShardingAlgorithmrProps = new Properties();
//        dbShardingAlgorithmrProps.setProperty("algorithm-expression", "roc${id % 2}");
//        shardingRuleConfig.getShardingAlgorithms().put("dbShardingAlgorithm", new ShardingSphereAlgorithmConfiguration("INLINE", dbShardingAlgorithmrProps));
//
//        // 配置分表算法
//        Properties tableShardingAlgorithmrProps = new Properties();
//        tableShardingAlgorithmrProps.setProperty("algorithm-expression", "t_roc_${table_id % 2}");
//        shardingRuleConfig.getShardingAlgorithms().put("tableShardingAlgorithm", new ShardingSphereAlgorithmConfiguration("INLINE", tableShardingAlgorithmrProps));
//
//        DataSource dataSource = null;
//        try {
//            dataSource = ShardingSphereDataSourceFactory.createDataSource(dataSourceMap, Collections.singleton(shardingRuleConfig), new Properties());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return dataSource;
//    }
//}
