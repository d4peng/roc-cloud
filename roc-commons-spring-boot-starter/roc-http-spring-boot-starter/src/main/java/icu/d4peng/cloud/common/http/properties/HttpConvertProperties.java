package icu.d4peng.cloud.common.http.properties;

import lombok.Data;

/**
 * <p> HttpConvertProperties:Http转换属性配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@Data
public class HttpConvertProperties {
    private HttpConverterItemProperties text;
    private HttpConverterItemProperties json;
    private HttpConverterItemProperties xml;
    private HttpConverterItemProperties binary;
    private HttpConverterItemProperties protobuf;
}
