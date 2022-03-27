package icu.d4peng.cloud.common.cache.service;

import net.oschina.j2cache.CacheChannel;

/**
 * <p> CacheService:缓存服务
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
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
