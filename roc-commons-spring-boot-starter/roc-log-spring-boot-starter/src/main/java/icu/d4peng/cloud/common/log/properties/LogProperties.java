package icu.d4peng.cloud.common.log.properties;

import icu.d4peng.cloud.common.log.generator.LogGenerator;
import icu.d4peng.cloud.common.log.generator.spanid.SpanIdGenerator;
import icu.d4peng.cloud.common.log.generator.traceid.TraceIdGenerator;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 13:47
 * @description LogProperties:日志配置
 */
@Data
@Accessors(chain = true)
@ConfigurationProperties(prefix = LogProperties.PREFIX)
public class LogProperties implements InitializingBean {
    /**
     * 前缀:roc.log
     */
    public static final String PREFIX = "roc.log";
    /**
     * 是否开启:默认开启
     */
    private boolean enabled = true;
    /**
     * MDC模式串:默认为<traceId:$traceId><spanId:$spanId><currentIp:$currentIp><preApp:$preApp><preHost:$preHost><preIp:$preIp>
     */
    private String mdcPattern = "<traceId:$traceId><spanId:$spanId><currentIp:$currentIp><preAppName:$preAppName><preHost:$preHost><preIp:$preIp>";
    /**
     * traceId生成器:为空就使用默认的生成器
     */
    private String traceIdGenerator = "icu.d4peng.cloud.common.log.generator.traceid.DefaultTraceIdGenerator";
    /**
     * spanId生成器:为空就使用默认的生成器
     */
    private String spanIdGenerator = "icu.d4peng.cloud.common.log.generator.spanid.DefaultSpanIdGenerator";
    /**
     * 是否开启aop记录:默认不开启
     */
    private boolean enableAopLog = false;
    /**
     * 日志路径
     */
    private String path = "/opt/logs/";

    @Override
    public void afterPropertiesSet() throws Exception {
        LogGenerator.setLabelPattern(this.mdcPattern);

        Class<?> traceIdGeneratorClass = Class.forName(this.traceIdGenerator);
        TraceIdGenerator traceIdGenerator = ((TraceIdGenerator) traceIdGeneratorClass.newInstance());
        LogGenerator.setTraceIdGenerator(traceIdGenerator);

        Class<?> spanIdGeneratorClass = Class.forName(this.spanIdGenerator);
        SpanIdGenerator spanIdGenerator = ((SpanIdGenerator) spanIdGeneratorClass.newInstance());
        LogGenerator.setSpanIdGenerator(spanIdGenerator);
    }
}
