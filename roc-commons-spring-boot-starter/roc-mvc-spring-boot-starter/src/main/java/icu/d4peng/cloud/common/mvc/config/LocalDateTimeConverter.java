package icu.d4peng.cloud.common.mvc.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p> LocalDateTimeConverter:GET请求中时间转换
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class LocalDateTimeConverter implements Converter<String, LocalDateTime> {
    private final DateTimeFormatter YYYY_MM = DateTimeFormatter.ofPattern("yyyy-MM");
    private final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final DateTimeFormatter YYYY_MM_DD_HH_MM = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final DateTimeFormatter YYYY_MM_DD_HH_MM_SS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public LocalDateTime convert(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }
        source = source.trim();
        if (source.matches("^\\d{4}-\\d{1,2}$")) {
            return LocalDateTime.parse(source, YYYY_MM);
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
            return LocalDateTime.parse(source, YYYY_MM_DD);
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
            return LocalDateTime.parse(source, YYYY_MM_DD_HH_MM);
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
            return LocalDateTime.parse(source, YYYY_MM_DD_HH_MM_SS);
        } else {
            throw new IllegalArgumentException("Invalid false value '" + source + "'");
        }
    }

}
