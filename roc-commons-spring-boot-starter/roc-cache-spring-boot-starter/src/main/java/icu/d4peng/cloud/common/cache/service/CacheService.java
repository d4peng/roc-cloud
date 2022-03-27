package icu.d4peng.cloud.common.cache.service;

import net.oschina.j2cache.CacheChannel;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 16:47
 * @description CacheService:缓存服务
 */
public interface CacheService {
    /**
     * 获得缓存服务
     *
     * @return 缓存服务接口
     */
    CacheChannel getCacheChannel();

    /**
     * 关闭缓存
     */
    void close();
}
