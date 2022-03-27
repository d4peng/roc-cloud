package icu.d4peng.cloud.common.cache.properties;

import icu.d4peng.cloud.common.cache.serializer.FastJsonSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import net.oschina.j2cache.J2CacheConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p> CacheProperties:缓存配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@Data
@Accessors(chain = true)
@ConfigurationProperties(prefix = CacheProperties.PREFIX)
@EqualsAndHashCode(callSuper = true)
public class CacheProperties extends J2CacheConfig implements InitializingBean {
    /**
     * 前缀
     */
    public static final String PREFIX = "roc.cache";
    /**
     * 是否开启:默认开启
     */
    private boolean enabled = true;

    /**
     * 解决fastjson版本冲突
     */
    @Override
    public void afterPropertiesSet() {
        if (this.getSerialization() == null || "fastjson".equals(this.getSerialization())) {
            this.setSerialization(FastJsonSerializer.class.getName());
        }
    }
}
