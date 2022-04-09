DROP TABLE IF EXISTS t_roc_message;
CREATE TABLE t_roc_message
(
    id           BIGINT PRIMARY KEY NOT NULL COMMENT 'ID',
    created_time TIMESTAMP          NOT NULL COMMENT '创建时间',
    updated_time TIMESTAMP          NOT NULL COMMENT '更新时间',
    deleted_time TIMESTAMP COMMENT '删除时间',
    status       TINYINT            NOT NULL COMMENT '状态',
    type         TINYINT            NOT NULL COMMENT '类型',
    content      TEXT COMMENT '内容'
) COMMENT '信息表';