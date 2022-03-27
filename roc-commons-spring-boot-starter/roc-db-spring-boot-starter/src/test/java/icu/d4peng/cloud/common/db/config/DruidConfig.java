package icu.d4peng.cloud.common.db.config;

import icu.d4peng.cloud.common.db.filter.CustomFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidConfig {

    @Bean
    public CustomFilter customFilter() {
        return new CustomFilter();
    }
}