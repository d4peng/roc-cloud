package icu.d4peng.cloud.common.log.generator.spanid;

import org.apache.commons.lang3.StringUtils;

/**
 * <p> DefaultSpanIdGenerator:默认spanId生成器
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class DefaultSpanIdGenerator implements SpanIdGenerator {
    private static final char SPLIT = '.';
    private static final char MIN = 'A';
    private static final char MAX = 'Z';

    @Override
    public String generateNextSpanId(String spanId) {
        if (StringUtils.isBlank(spanId)) {
            return String.valueOf(MIN);
        } else {
            char target = (char) (spanId.charAt(spanId.length() - 1) + 1);
            if (target != SPLIT && target <= MAX) {
                return spanId + SPLIT + String.valueOf(target);
            } else {
                throw new RuntimeException();
            }
        }
    }
}
