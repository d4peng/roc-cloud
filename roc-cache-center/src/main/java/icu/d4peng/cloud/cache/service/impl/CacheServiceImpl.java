package icu.d4peng.cloud.cache.service.impl;

import com.alibaba.fastjson.JSON;
import icu.d4peng.cloud.cache.dto.CacheDTO;
import icu.d4peng.cloud.cache.service.CacheService;
import icu.d4peng.cloud.common.core.vo.ListVO;
import icu.d4peng.cloud.common.core.vo.ResultVO;
import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

/**
 * <p> CacheServiceImpl: 缓存服务实现
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-04-09
 */
@Service
public class CacheServiceImpl implements CacheService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheServiceImpl.class);
    private final CacheChannel cacheChannel;

    @Autowired
    public CacheServiceImpl(icu.d4peng.cloud.common.cache.service.CacheService cacheService) {
        this.cacheChannel = cacheService.getCacheChannel();
    }

    @Override
    public ResultVO<String> add(CacheDTO cacheDTO) {
        try {
            this.cacheChannel.set(cacheDTO.getRegion(), cacheDTO.getKey(), JSON.toJSONString(cacheDTO.getValue()), cacheDTO.getTtl(), false);
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
            return ResultVO.build(0, exception.getMessage());
        }
        return ResultVO.build(1, "OK");
    }

    @Override
    public ListVO<CacheObject> list(CacheDTO cacheDTO) {
        Map<String, CacheObject> result = null;
        try {
            result = this.cacheChannel.get(cacheDTO.getRegion(), cacheDTO.getKeys());
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return ListVO.build(0, new ArrayList<CacheObject>());
        }
        return ListVO.build(1, result.values());
    }

    @Override
    public ResultVO<CacheObject> detail(String region, String key) {
        CacheObject cacheObject = null;
        try {
            cacheObject = this.cacheChannel.get(region, key);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return ResultVO.build(0, null);
        }
        return ResultVO.build(1, cacheObject);
    }

    @Override
    public ResultVO<String> delete(String region, String key) {
        try {
            this.cacheChannel.evict(region, key);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return ResultVO.build(0, e.getMessage());
        }
        return ResultVO.build(1, "OK");
    }

    @Override
    public ResultVO<String> update(CacheDTO cacheDTO) {
        try {
            if (this.cacheChannel.exists(cacheDTO.getRegion(), cacheDTO.getKey())) {
                this.cacheChannel.set(cacheDTO.getRegion(), cacheDTO.getKey(), cacheDTO.getValue(), cacheDTO.getTtl(), false);
            } else {
                LOGGER.error("no this cache ->region:{},key:{}", cacheDTO.getRegion(), cacheDTO.getKey());
                return ResultVO.build(0, "no this cache");
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return ResultVO.build(0, e.getMessage());
        }
        return ResultVO.build(1, "OK");
    }
}
