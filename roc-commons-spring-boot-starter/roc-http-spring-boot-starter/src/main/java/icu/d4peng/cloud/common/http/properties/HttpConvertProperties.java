package icu.d4peng.cloud.common.http.properties;

import lombok.Data;

@Data
public class HttpConvertProperties {
    private HttpConverterItemProperties text;
    private HttpConverterItemProperties json;
    private HttpConverterItemProperties xml;
    private HttpConverterItemProperties binary;
    private HttpConverterItemProperties protobuf;
}
