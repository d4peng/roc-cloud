package icu.d4peng.cloud.common.cache.service.impl;

import icu.d4peng.cloud.common.cache.service.CacheService;
import net.oschina.j2cache.CacheChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 16:46
 * @description CacheServiceImpl:缓存服务实现
 */
public class CacheServiceImpl implements CacheService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheServiceImpl.class);
    /**
     * 缓存通道
     */
    private final CacheChannel cacheChannel;

    public CacheServiceImpl(CacheChannel cacheChannel) {
        this.cacheChannel = cacheChannel;
        Assert.notNull(cacheChannel, "cache channel can't be null");
    }

    public CacheChannel getCacheChannel() {
        return this.cacheChannel;
    }

    public void close() {
        this.cacheChannel.close();
    }
}
