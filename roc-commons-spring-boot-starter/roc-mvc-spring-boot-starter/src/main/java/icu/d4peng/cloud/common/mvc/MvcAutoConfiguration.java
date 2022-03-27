package icu.d4peng.cloud.common.mvc;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import icu.d4peng.cloud.common.mvc.config.LocalDateTimeConverter;
import icu.d4peng.cloud.common.mvc.test.DefaultErrorController;
import icu.d4peng.cloud.common.mvc.properties.MvcProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-30 11:26
 * @description MvcAutoConfiguration:默认MVC处理机制
 */
@Configuration
@ConditionalOnProperty(prefix = MvcProperties.PREFIX, name = {"enabled"}, havingValue = "true")
@EnableConfigurationProperties({MvcProperties.class})
@AutoConfigureBefore({WebMvcAutoConfiguration.class, ErrorMvcAutoConfiguration.class})
public class MvcAutoConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(MvcAutoConfiguration.class);

    /**
     * 默认错误处理机制
     *
     * @return 默认错误处理
     */
    @ConditionalOnProperty(prefix = MvcProperties.PREFIX, name = {"enable-default-errors-handler"}, havingValue = "true")
    @ConditionalOnMissingBean({DefaultErrorController.class})
    @Bean
    public DefaultErrorController defaultErrorController() {
        return new DefaultErrorController(new DefaultErrorAttributes());
    }

    /**
     * JSON数据序列化和反序列化
     *
     * @param mvcProperties 配置属性
     * @return ObjectMapperBuilder
     */
    @Bean
    @ConditionalOnMissingBean({Jackson2ObjectMapperBuilderCustomizer.class})
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer(MvcProperties mvcProperties) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(mvcProperties.getGlobalTimeFormatRegex());
        return builder -> {
            builder.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(dateTimeFormatter));
            builder.deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(dateTimeFormatter));
        };
    }

    /**
     * GET请求中字符串转LocalDateTime
     *
     * @return 时间转换Convert
     */
    @Bean
    @ConditionalOnMissingBean({LocalDateTimeConverter.class})
    public LocalDateTimeConverter localDateTimeConverter() {
        return new LocalDateTimeConverter();
    }
}