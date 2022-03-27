package icu.d4peng.cloud.common.http.properties;

import com.dtflys.forest.converter.json.ForestJsonConverter;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> HttpConverterItemProperties:Http转换单个属性配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@Data
public class HttpConverterItemProperties {
    private Class<? extends ForestJsonConverter> type;
    private Map<String, Object> parameters = new HashMap<>();
}
