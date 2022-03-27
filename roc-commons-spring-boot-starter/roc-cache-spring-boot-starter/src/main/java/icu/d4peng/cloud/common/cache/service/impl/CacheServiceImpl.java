package icu.d4peng.cloud.common.cache.service.impl;

import icu.d4peng.cloud.common.cache.service.CacheService;
import net.oschina.j2cache.CacheChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * <p> CacheServiceImpl:缓存服务实现
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
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


@Override
    public CacheChannel getCacheChannel() {
        return this.cacheChannel;
    }

    @Override
    public void close() {
        this.cacheChannel.close();
    }
}
