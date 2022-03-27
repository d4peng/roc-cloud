package icu.d4peng.cloud.common.db.filter;

import com.alibaba.druid.filter.FilterAdapter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.proxy.jdbc.DataSourceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomFilter extends FilterAdapter {
    private static Logger LOGGER = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public void init(DataSourceProxy dataSourceProxy) {
        if (!(dataSourceProxy instanceof DruidDataSource)) {
            LOGGER.error("ConfigLoader only support DruidDataSource");
        }
        DruidDataSource dataSource = (DruidDataSource) dataSourceProxy;
        LOGGER.info("db configuration: url=" + dataSource.getUrl());
    }
}