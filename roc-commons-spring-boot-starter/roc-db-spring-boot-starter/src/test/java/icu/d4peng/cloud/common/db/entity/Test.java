package icu.d4peng.cloud.common.db.entity;

import com.alibaba.fastjson.JSON;
import icu.d4peng.cloud.common.db.domain.AbstractSuperEntity;

/**
 * <p> Test:测试
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class Test extends AbstractSuperEntity {
    private String test;

    public String getTest() {
        return test;
    }

    public Test setTest(String test) {
        this.test = test;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
