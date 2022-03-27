package icu.d4peng.cloud.common.http.properties;

import com.dtflys.forest.converter.json.ForestJsonConverter;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class HttpConverterItemProperties {
    private Class<? extends ForestJsonConverter> type;
    private Map<String, Object> parameters = new HashMap<>();
}
