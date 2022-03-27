DROP TABLE IF EXISTS test;

CREATE TABLE test
(
    id           BIGINT(20)  NOT NULL COMMENT '主键ID',
    test         VARCHAR(30) NULL DEFAULT NULL COMMENT '测试字段',
    created_time TIME        NOT NULL COMMENT '创建时间',
    updated_time TIME        NOT NULL COMMENT '更新时间',
    deleted_time TIME COMMENT '删除时间',
    PRIMARY KEY (id)
);
