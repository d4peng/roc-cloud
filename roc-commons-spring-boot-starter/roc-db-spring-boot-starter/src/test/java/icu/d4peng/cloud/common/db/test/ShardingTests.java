//package icu.d4peng.cloud.common.db.test;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import icu.d4peng.cloud.common.db.MybatisPlusApplication;
//import icu.d4peng.cloud.common.db.entity.Shard;
//import icu.d4peng.cloud.common.db.mapper.ShardMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//
///**
// * @author d4peng
// * @version 1.0.0
// * @date 2022-02-28 21:53
// * @description ShardingTests:分库分表测试
// */
//@SpringBootTest(classes = {MybatisPlusApplication.class})
//@ActiveProfiles({"mybatis-shard"})
//public class ShardingTests {
//    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisPlusTests.class);
//    private ShardMapper shardMapper;
//
//    @BeforeEach
//    public void before(@Autowired ShardMapper shardMapper) {
//        this.shardMapper = shardMapper;
//    }
//
//    @Test
//    public void insert() throws InterruptedException {
//        Shard shard = new Shard();
//        shard.setTableId(1L);
//        this.shardMapper.insert(shard);
//        Thread.sleep(10000);
//
//        shard = new Shard();
//        shard.setTableId(2L);
//        this.shardMapper.insert(shard);
//        Thread.sleep(10000);
//
//        shard = new Shard();
//        shard.setTableId(3L);
//        this.shardMapper.insert(shard);
//        Thread.sleep(10000);
//
//        shard = new Shard();
//        shard.setTableId(4L);
//        this.shardMapper.insert(shard);
//    }
//
//    @Test
//    public void selectList() {
//        this.shardMapper.selectList(new QueryWrapper<Shard>()).forEach(System.out::println);
//    }
//}
