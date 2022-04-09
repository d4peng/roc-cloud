package icu.d4peng.cloud.cache.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * <p> CacheDTO: 缓存DTO
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-04-09
 */
public class CacheDTO {
    /**
     * 区域(这个不能为空)
     */
    private String region;
    /**
     * Key
     */
    private String key;
    /**
     * 多缓存
     */
    private List<String> keys;
    /**
     * value
     */
    private String value;
    /**
     * ttl时间
     */
    private Long ttl;

    public String getRegion() {
        return region;
    }

    public CacheDTO setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getKey() {
        return key;
    }

    public CacheDTO setKey(String key) {
        this.key = key;
        return this;
    }

    public String getValue() {
        return value;
    }

    public CacheDTO setValue(String value) {
        this.value = value;
        return this;
    }

    public Long getTtl() {
        return ttl;
    }

    public CacheDTO setTtl(Long ttl) {
        this.ttl = ttl;
        return this;
    }

    public List<String> getKeys() {
        return keys;
    }

    public CacheDTO setKeys(List<String> keys) {
        this.keys = keys;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("region", region)
                .append("key", key)
                .append("keys", keys)
                .append("value", value)
                .append("ttl", ttl)
                .toString();
    }
}
