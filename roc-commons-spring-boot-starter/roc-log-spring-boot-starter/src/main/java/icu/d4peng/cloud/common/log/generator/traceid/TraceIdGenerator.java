package icu.d4peng.cloud.common.log.generator.traceid;

/**
 * <p> TraceIdGenerator:TraceId生成器
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public interface TraceIdGenerator {
    /**
     * ID生成
     *
     * @return ID返回
     */
    String generateTraceId();
}