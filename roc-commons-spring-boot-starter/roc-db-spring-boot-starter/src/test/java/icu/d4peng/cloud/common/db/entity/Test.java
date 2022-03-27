package icu.d4peng.cloud.common.db.entity;

import com.alibaba.fastjson.JSON;
import icu.d4peng.cloud.common.db.domain.SuperEntity;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2022-01-24 21:44
 * @description Test:
 */
public class Test extends SuperEntity {
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
