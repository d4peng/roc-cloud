package icu.d4peng.cloud.common.log.generator.spanid;

/**
 * <p> SpanIdGenerator:SpanId生成
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public interface SpanIdGenerator {

    /**
     * 这里防止同时获取一个spanId出现并发问题
     *
     * @param spanId 当前spanId
     * @return 下一个snapId
     */
    String generateNextSpanId(String spanId);


}
