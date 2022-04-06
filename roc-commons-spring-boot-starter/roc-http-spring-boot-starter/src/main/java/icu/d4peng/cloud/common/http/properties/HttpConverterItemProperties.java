package icu.d4peng.cloud.common.http.properties;

import com.dtflys.forest.converter.json.ForestJsonConverter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> HttpConverterItemProperties:Http转换单个属性配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class HttpConverterItemProperties {
    private Class<? extends ForestJsonConverter> type;
    private Map<String, Object> parameters = new HashMap<>();

    public Class<? extends ForestJsonConverter> getType() {
        return type;
    }

    public HttpConverterItemProperties setType(Class<? extends ForestJsonConverter> type) {
        this.type = type;
        return this;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public HttpConverterItemProperties setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .append("parameters", parameters)
                .toString();
    }
}
