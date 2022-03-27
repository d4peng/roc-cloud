package icu.d4peng.cloud.common.log.generator.traceid;

import java.util.UUID;

/**
 * <p> DefaultTraceIdGenerator:默认TraceId生成器
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class DefaultTraceIdGenerator implements TraceIdGenerator {
    @Override
    public String generateTraceId() {
        return UUID.randomUUID().toString();
    }
}
