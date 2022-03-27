package icu.d4peng.cloud.common.cache.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import net.oschina.j2cache.util.Serializer;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2022-03-20 14:55
 * @description FastJSONSerializer:FastJSON序列化
 */
public class FastJSONSerializer implements Serializer {

    @Override
    public String name() {
        return "fastjson";
    }

    @Override
    public byte[] serialize(Object obj) {
        return JSON.toJSONString(obj, SerializerFeature.WriteClassName).getBytes();
    }

    @Override
    public Object deserialize(byte[] bytes) {
        return JSON.parse(new String(bytes));
    }

}
