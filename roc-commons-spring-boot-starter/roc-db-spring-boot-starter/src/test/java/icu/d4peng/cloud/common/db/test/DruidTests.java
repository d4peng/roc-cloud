package icu.d4peng.cloud.common.db.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.stat.DruidStatManagerFacade;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import icu.d4peng.cloud.common.db.DruidApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.SQLException;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2022-03-26 20:49
 * @description DruidTests:测试
 */
@SpringBootTest(classes = {DruidApplication.class})
@ActiveProfiles({"druid"})
public class DruidTests {
    private final DruidDataSource druidDataSource;

    @Autowired
    public DruidTests(DruidDataSource druidDataSource) {
        this.druidDataSource = druidDataSource;
    }

    @Test
    public void testConnection() {
        try {
            Assertions.assertNotNull(this.druidDataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFilters() {
        System.out.println(this.druidDataSource.getProxyFilters().size());
    }

    @Test
    public void testDruidStat() {
        System.out.println(JSON.toJSONString(DruidStatManagerFacade.getInstance().getDataSourceStatDataList(), SerializerFeature.PrettyFormat));
    }
}
