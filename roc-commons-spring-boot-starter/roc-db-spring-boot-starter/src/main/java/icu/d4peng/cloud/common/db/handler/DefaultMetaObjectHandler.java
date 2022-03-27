package icu.d4peng.cloud.common.db.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * <p> DefaultMetaObjectHandler:默认父类填充器
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class DefaultMetaObjectHandler implements MetaObjectHandler {
    /**
     * 更新时间实体类字段名称
     */
    public static final String UPDATE_TIME_FIELD_NAME = "updatedTime";

    /**
     * 插入时间实体类字段名称
     */
    public static final String INSERT_TIME_FIELD_NAME = "createdTime";


    /**
     * 插入时需要更新两个字段
     * createdTime,updatedTime
     *
     * @param metaObject 元信息
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, INSERT_TIME_FIELD_NAME, LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, UPDATE_TIME_FIELD_NAME, LocalDateTime.class, LocalDateTime.now());
    }

    /**
     * 更新时需要更新这个字段
     * updatedTime
     *
     * @param metaObject 元信息
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, UPDATE_TIME_FIELD_NAME, LocalDateTime.class, LocalDateTime.now());
    }
}
