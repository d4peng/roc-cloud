package icu.d4peng.cloud.common.db.entity;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.TableName;
import icu.d4peng.cloud.common.db.domain.AbstractSuperEntity;

/**
 * <p> Shard:分片
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@TableName("t_roc")
public class Shard extends AbstractSuperEntity {
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
