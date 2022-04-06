package icu.d4peng.cloud.common.db.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import icu.d4peng.cloud.common.db.MybatisPlusApplication;
import icu.d4peng.cloud.common.db.mapper.TestMapper;
import icu.d4peng.cloud.common.db.request.SuperDTO;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p> MybatisPlusTests:测试Mapper
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@SpringBootTest(classes = {MybatisPlusApplication.class})
@ActiveProfiles({"mybatis-plus"})
public class MybatisPlusTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisPlusTests.class);
    private final TestMapper testMapper;

    @Autowired
    public MybatisPlusTests(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    @Test
    public void selectList1() {
        this.testMapper.selectList(null).forEach(System.out::println);
        //this.testMapper.selectList(new QueryWrapper<>()).forEach(System.out::println);
    }

    @Test
    public void selectList2() {
        QueryWrapper<icu.d4peng.cloud.common.db.entity.Test> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "test");
        this.testMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    @Test
    public void selectList3() {
        QueryWrapper<icu.d4peng.cloud.common.db.entity.Test> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("test", "test1");
        this.testMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    @Test
    public void selectList4() {
        QueryWrapper<icu.d4peng.cloud.common.db.entity.Test> queryWrapper = new QueryWrapper<>();
        queryWrapper.groupBy("id");
        this.testMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    @Test
    public void selectById() {
        System.out.println(this.testMapper.selectById(1L));
    }

    @Test
    public void selectBatchIds() {
        ArrayList<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(4L);
        this.testMapper.selectBatchIds(ids).forEach(System.out::println);
    }

    @Test
    public void selectCount() {
        System.out.println(this.testMapper.selectCount(null));
    }

    @Test
    // 1 2 3 4 5 6 7 8 9 10 11 12 13 14
    public void selectPage() {
        SuperDTO<icu.d4peng.cloud.common.db.entity.Test> superDTO = new SuperDTO<>();
        superDTO.setCurrent(4);
        superDTO.setSize(3);
        this.testMapper.selectPage(superDTO, null);
        superDTO.getRecords().forEach(System.out::println);
    }

    @Test
    public void selectMapper() {
        this.testMapper.selectList(new QueryWrapper<>()).forEach(System.out::println);
    }

    @Test
    public void insert() {
        icu.d4peng.cloud.common.db.entity.Test entity = new icu.d4peng.cloud.common.db.entity.Test();
        entity.setTest("insert");
        this.testMapper.insert(entity);
        selectMapper();
    }

    @Test
    public void deleteById() {
        this.testMapper.deleteById(1L);
        selectMapper();
    }

    @Test
    public void deleteByWrapper() {
        QueryWrapper<icu.d4peng.cloud.common.db.entity.Test> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(new icu.d4peng.cloud.common.db.entity.Test().setTest("test2"));
        this.testMapper.delete(queryWrapper);
        selectMapper();
    }

    @Test
    public void deleteBatchIds() {
        List<Long> batchIds = new ArrayList<>(4);
        batchIds.add(1L);
        batchIds.add(4L);
        this.testMapper.deleteBatchIds(batchIds);
        selectMapper();
    }

    @Test
    public void deleteByMap() {
        Map<String, Object> maps = new HashMap<>();
        maps.put("id", 1);
        maps.put("test", "test1");
        this.testMapper.deleteByMap(maps);
        selectMapper();
    }

    @Test
    public void updateById() {
        icu.d4peng.cloud.common.db.entity.Test entity = new icu.d4peng.cloud.common.db.entity.Test();
        entity.setId(1L);
        entity.setTest("update");
        this.testMapper.updateById(entity);
        selectMapper();
    }

    @Test
    public void tenant() {
        // 需要关闭null
        selectMapper();
    }

}
