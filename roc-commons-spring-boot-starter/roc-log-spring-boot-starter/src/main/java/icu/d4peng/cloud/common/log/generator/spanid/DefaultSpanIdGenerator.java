package icu.d4peng.cloud.common.log.generator.spanid;

import org.apache.commons.lang3.StringUtils;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 14:02
 * @description DefaultSpanIdGenerator:默认spanId生成器
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
