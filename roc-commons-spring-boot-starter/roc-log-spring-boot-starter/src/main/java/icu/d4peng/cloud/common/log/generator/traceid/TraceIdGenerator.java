package icu.d4peng.cloud.common.log.generator.traceid;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 14:03
 * @description TraceIdGenerator:TraceId生成器
 */
public interface TraceIdGenerator {
    /**
     * ID生成
     *
     * @return ID返回
     */
    String generateTraceId();
}