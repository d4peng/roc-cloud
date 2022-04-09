package icu.d4peng.cloud.cache.controller;

import icu.d4peng.cloud.cache.dto.CacheDTO;
import icu.d4peng.cloud.cache.service.CacheService;
import icu.d4peng.cloud.common.core.vo.ListVO;
import icu.d4peng.cloud.common.core.vo.ResultVO;
import net.oschina.j2cache.CacheObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p> CacheController: 缓存控制器
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-04-09
 */
@RestController
@RequestMapping("cache")
public class CacheController {
    private final CacheService cacheService;

    @Autowired
    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @PostMapping()
    public ResultVO<String> add(@RequestBody CacheDTO cacheDTO) {
        return this.cacheService.add(cacheDTO);
    }

    @GetMapping
    public ListVO<CacheObject> list(CacheDTO cacheDTO) {
        return this.cacheService.list(cacheDTO);
    }

    @GetMapping("/{region}/{key}")
    public ResultVO<CacheObject> detail(@PathVariable String region, @PathVariable String key) {
        return this.cacheService.detail(region, key);
    }

    @DeleteMapping("/{region}/{key}")
    public ResultVO<String> delete(@PathVariable String region, @PathVariable String key) {
        return this.cacheService.delete(region, key);
    }

    @PatchMapping()
    public ResultVO<String> update(@RequestBody CacheDTO cacheDTO) {
        return this.cacheService.update(cacheDTO);
    }
}
