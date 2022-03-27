package icu.d4peng.cloud.common.log.generator;

import icu.d4peng.cloud.common.log.generator.spanid.DefaultSpanIdGenerator;
import icu.d4peng.cloud.common.log.generator.spanid.SpanIdGenerator;
import icu.d4peng.cloud.common.log.generator.traceid.DefaultTraceIdGenerator;
import icu.d4peng.cloud.common.log.generator.traceid.TraceIdGenerator;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2022-03-21 21:11
 * @description LogGenerator:Log标签生成
 */
public class LogGenerator {
    /**
     * MDC标签生成
     */
    public static String labelPattern = "<$spanId><$traceId>";
    /**
     * traceId生成器
     */
    public static TraceIdGenerator traceIdGenerator = new DefaultTraceIdGenerator();
    /**
     * spanId生成器
     */
    public static SpanIdGenerator spanIdGenerator = new DefaultSpanIdGenerator();

    public static String generateLogLabel(String traceId, String spanId, String currentIp, String preAppName, String preHost, String preIp) {
        return labelPattern
                .replace("$traceId", traceId)
                .replace("$spanId", spanId)
                .replace("$currentIp", currentIp)
                .replace("$preAppName", preAppName)
                .replace("$preHost", preHost)
                .replace("$preIp", preIp);
    }

    public static void setLabelPattern(String labelPattern) {
        LogGenerator.labelPattern = labelPattern;
    }

    public static String generatorTraceId() {
        return LogGenerator.traceIdGenerator.generateTraceId();
    }

    public static void setTraceIdGenerator(TraceIdGenerator traceIdGenerator) {
        LogGenerator.traceIdGenerator = traceIdGenerator;
    }

    public static String generatorSpanId(String spanId) {
        return LogGenerator.spanIdGenerator.generateNextSpanId(spanId);
    }

    public static void setSpanIdGenerator(SpanIdGenerator spanIdGenerator) {
        LogGenerator.spanIdGenerator = spanIdGenerator;
    }

    public static SpanIdGenerator getSpanIdGenerator() {
        return LogGenerator.spanIdGenerator;
    }

}