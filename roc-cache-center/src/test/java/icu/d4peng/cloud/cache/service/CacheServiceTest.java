package icu.d4peng.cloud.cache.service;

import icu.d4peng.cloud.cache.CacheApplication;
import io.lettuce.core.RedisURI;
import io.lettuce.core.cluster.ClusterClientOptions;
import io.lettuce.core.cluster.ClusterTopologyRefreshOptions;
import io.lettuce.core.cluster.RedisClusterClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@SpringBootTest(classes = CacheApplication.class)
public class CacheServiceTest {

    @Test
    public void test() {
    }
}