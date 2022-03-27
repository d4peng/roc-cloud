CREATE
DATABASE IF NOT EXISTS roc_cloud;
USE
roc_cloud;

#
t_roc_message表
DROP TABLE IF EXISTS t_roc_message;
CREATE TABLE t_roc_message
(
    id           bigint primary key NOT NULL COMMENT 'ID',
    created_time timestamp          NOT NULL COMMENT '创建时间',
    updated_time timestamp          NOT NULL COMMENT '更新时间',
    deleted_time timestamp COMMENT '删除时间',
    status       tinyint            NOT NULL COMMENT '状态',
    type         tinyint            NOT NULL COMMENT '类型',
    content      text COMMENT '内容'
) COMMENT '信息表';

#
t_roc_user表
DROP TABLE IF EXISTS t_roc_user;
CREATE TABLE t_roc_user
(
    id           bigint primary key NOT NULL COMMENT 'ID',
    created_time timestamp          NOT NULL COMMENT '创建时间',
    updated_time timestamp          NOT NULL COMMENT '更新时间',
    deleted_time timestamp COMMENT '删除时间',
    nick_name    varchar(128) COMMENT '昵称',
    username     varchar(128) COMMENT '用户名',
    password     varchar(255) COMMENT '密码',
    phone        varchar(128) COMMENT '手机号',
    email        varchar(128) COMMENT '邮箱',
    avatar       varchar(256) COMMENT '头像地址',
    login_ip     varchar(128) COMMENT '登录IP',
    status       tinyint(1) COMMENT '用户状态',
    remark       text COMMENT '备注'
) COMMENT '用户表';