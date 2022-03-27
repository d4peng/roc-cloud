package icu.d4peng.cloud.common.log.config;

import icu.d4peng.cloud.common.log.web.LogWebInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 14:51
 * @description WebLogMvcConfigurer:WebLogMvc配置器
 */
public class WebLogMvcConfigurer implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogWebInterceptor());
    }
}
