package icu.d4peng.cloud.common.db.entity;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.TableName;
import icu.d4peng.cloud.common.db.domain.SuperEntity;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2022-01-24 21:44
 * @description Shard:
 */
@TableName("t_roc")
public class Shard extends SuperEntity {
    private Long tableId;

    public Long getTableId() {
        return tableId;
    }

    public Shard setTableId(Long tableId) {
        this.tableId = tableId;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
