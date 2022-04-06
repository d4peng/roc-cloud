package icu.d4peng.cloud.common.http.properties;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <p> HttpConvertProperties:Http转换属性配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class HttpConvertProperties {
    private HttpConverterItemProperties text;
    private HttpConverterItemProperties json;
    private HttpConverterItemProperties xml;
    private HttpConverterItemProperties binary;
    private HttpConverterItemProperties protobuf;

    public HttpConverterItemProperties getText() {
        return text;
    }

    public HttpConvertProperties setText(HttpConverterItemProperties text) {
        this.text = text;
        return this;
    }

    public HttpConverterItemProperties getJson() {
        return json;
    }

    public HttpConvertProperties setJson(HttpConverterItemProperties json) {
        this.json = json;
        return this;
    }

    public HttpConverterItemProperties getXml() {
        return xml;
    }

    public HttpConvertProperties setXml(HttpConverterItemProperties xml) {
        this.xml = xml;
        return this;
    }

    public HttpConverterItemProperties getBinary() {
        return binary;
    }

    public HttpConvertProperties setBinary(HttpConverterItemProperties binary) {
        this.binary = binary;
        return this;
    }

    public HttpConverterItemProperties getProtobuf() {
        return protobuf;
    }

    public HttpConvertProperties setProtobuf(HttpConverterItemProperties protobuf) {
        this.protobuf = protobuf;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("text", text)
                .append("json", json)
                .append("xml", xml)
                .append("binary", binary)
                .append("protobuf", protobuf)
                .toString();
    }
}
