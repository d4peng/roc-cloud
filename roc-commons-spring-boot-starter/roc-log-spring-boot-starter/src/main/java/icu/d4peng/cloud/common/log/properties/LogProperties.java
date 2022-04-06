package icu.d4peng.cloud.common.log.properties;

import icu.d4peng.cloud.common.log.generator.LogGenerator;
import icu.d4peng.cloud.common.log.generator.spanid.SpanIdGenerator;
import icu.d4peng.cloud.common.log.generator.traceid.TraceIdGenerator;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p> LogProperties:日志配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
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

    public boolean isEnabled() {
        return enabled;
    }

    public LogProperties setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String getMdcPattern() {
        return mdcPattern;
    }

    public LogProperties setMdcPattern(String mdcPattern) {
        this.mdcPattern = mdcPattern;
        return this;
    }

    public String getTraceIdGenerator() {
        return traceIdGenerator;
    }

    public LogProperties setTraceIdGenerator(String traceIdGenerator) {
        this.traceIdGenerator = traceIdGenerator;
        return this;
    }

    public String getSpanIdGenerator() {
        return spanIdGenerator;
    }

    public LogProperties setSpanIdGenerator(String spanIdGenerator) {
        this.spanIdGenerator = spanIdGenerator;
        return this;
    }

    public boolean isEnableAopLog() {
        return enableAopLog;
    }

    public LogProperties setEnableAopLog(boolean enableAopLog) {
        this.enableAopLog = enableAopLog;
        return this;
    }

    public String getPath() {
        return path;
    }

    public LogProperties setPath(String path) {
        this.path = path;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("enabled", enabled)
                .append("mdcPattern", mdcPattern)
                .append("traceIdGenerator", traceIdGenerator)
                .append("spanIdGenerator", spanIdGenerator)
                .append("enableAopLog", enableAopLog)
                .append("path", path)
                .toString();
    }
}
