package icu.d4peng.cloud.common.log.generator.traceid;

import java.util.UUID;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 14:04
 * @description DefaultTraceIdGenerator:默认TraceId生成器
 */
public class DefaultTraceIdGenerator implements TraceIdGenerator {
    @Override
    public String generateTraceId() {
        return UUID.randomUUID().toString();
    }
}
