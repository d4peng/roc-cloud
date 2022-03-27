package icu.d4peng.cloud.common.cache.service;

import icu.d4peng.cloud.common.cache.CacheApplication;
import icu.d4peng.cloud.common.core.vo.ResultVO;
import net.oschina.j2cache.CacheChannel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CacheApplication.class)
public class CacheServiceTest {
    private static final String REGION = "test";
    private static final String KEY = "key";
    private final CacheService cacheService;

    @Autowired
    public CacheServiceTest(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Test
    public void getCacheChannel() throws Exception {
        CacheChannel cacheChannel = this.cacheService.getCacheChannel();

        // 普通值
        System.out.println("-----普通值------");
        cacheChannel.set(REGION, KEY, "d4peng", false);
        System.out.println(cacheChannel.get(REGION, KEY).getValue());
        System.out.println("-----普通值------\n");

        // JSON值
        System.out.println("-----JSON------");
        cacheChannel.set(REGION, KEY, ResultVO.build(200, "test", "test").toString(), false);
        System.out.println(cacheChannel.get(REGION, KEY).getValue());
        System.out.println("-----JSON------\n");

        // 过期
        System.out.println("-----过期------");
        // 这里设置的时间要和yml中配置一致,不然会报错
        cacheChannel.set(REGION, KEY, "d4peng", 1, false);
        Thread.sleep(900);
        System.out.println(cacheChannel.get(REGION, KEY, false).getValue());
        Thread.sleep(100);
        System.out.println(cacheChannel.get(REGION, KEY, false).getValue());
        System.out.println("-----过期------\n");
    }

    @Test
    public void close() {
        this.cacheService.close();
        Assertions.assertNotNull(this.cacheService);
    }

}