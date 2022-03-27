package icu.d4peng.cloud.common.log.generator.spanid;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 14:03
 * @description SpanIdGenerator:SpanId生成
 */
public interface SpanIdGenerator {

    /**
     * 这里防止同时获取一个spanId出现并发问题:这里用于微服务远程调用分离spanId
     *
     * @return 下一个spanId
     */
    String generateNextSpanId(String spanId);


}
