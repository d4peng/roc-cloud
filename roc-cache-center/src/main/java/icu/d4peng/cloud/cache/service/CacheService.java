package icu.d4peng.cloud.cache.service;

import icu.d4peng.cloud.cache.dto.CacheDTO;
import icu.d4peng.cloud.common.core.vo.ListVO;
import icu.d4peng.cloud.common.core.vo.ResultVO;
import net.oschina.j2cache.CacheObject;

/**
 * <p> CacheService: 缓存服务
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-04-09
 */
public interface CacheService {
    /**
     * 添加
     *
     * @param cacheDTO DTO参数
     * @return 列表返回
     */
    ResultVO<String> add(CacheDTO cacheDTO);

    /**
     * 列表
     *
     * @param cacheDTO DTO参数
     * @return 列表返回
     */
    ListVO<CacheObject> list(CacheDTO cacheDTO);

    /**
     * 详情
     *
     * @param region 区域
     * @param key    主键
     * @return 详情
     */
    ResultVO<CacheObject> detail(String region, String key);

    /**
     * 删除
     *
     * @param region 区域
     * @param key    主键
     * @return 结果
     */
    ResultVO<String> delete(String region, String key);

    /**
     * 更新
     *
     * @param cacheDTO DTO参数
     * @return 结果
     */
    ResultVO<String> update(CacheDTO cacheDTO);
}
