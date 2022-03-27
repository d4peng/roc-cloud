package icu.d4peng.cloud.common.cache.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import net.oschina.j2cache.util.Serializer;

/**
 * <p> FastJSONSerializer:FastJSON序列化
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class FastJsonSerializer implements Serializer {

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
