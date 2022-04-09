DROP TABLE IF EXISTS t_roc_user;
CREATE TABLE t_roc_user
(
    id           BIGINT PRIMARY KEY NOT NULL COMMENT 'ID',
    created_time TIMESTAMP          NOT NULL COMMENT '创建时间',
    updated_time TIMESTAMP          NOT NULL COMMENT '更新时间',
    deleted_time TIMESTAMP COMMENT '删除时间',
    nick_name    VARCHAR(128) COMMENT '昵称',
    username     VARCHAR(128)       NOT NULL COMMENT '用户名',
    password     VARCHAR(255)       NOT NULL COMMENT '密码',
    phone        VARCHAR(128) COMMENT '手机号',
    email        VARCHAR(128) COMMENT '邮箱',
    avatar       VARCHAR(256) COMMENT '头像地址',
    login_ip     VARCHAR(128) COMMENT '登录IP',
    status       TINYINT(1)         NOT NULL COMMENT '用户状态',
    remark       TEXT COMMENT '备注'
) COMMENT '用户表';

DROP TABLE IF EXISTS t_roc_user_role;
CREATE TABLE t_roc_user_role
(
    id           BIGINT PRIMARY KEY NOT NULL COMMENT 'ID',
    created_time TIMESTAMP          NOT NULL COMMENT '创建时间',
    updated_time TIMESTAMP          NOT NULL COMMENT '更新时间',
    deleted_time TIMESTAMP COMMENT '删除时间',
    user_id      BIGINT             NOT NULL COMMENT '用户ID',
    role_id      BIGINT             NOT NULL COMMENT '角色ID'
) COMMENT '用户角色表';

DROP TABLE IF EXISTS t_roc_role;
CREATE TABLE t_roc_role
(
    id           BIGINT PRIMARY KEY NOT NULL COMMENT 'ID',
    created_time TIMESTAMP          NOT NULL COMMENT '创建时间',
    updated_time TIMESTAMP          NOT NULL COMMENT '更新时间',
    deleted_time TIMESTAMP COMMENT '删除时间',
    name         VARCHAR(128)       NOT NULL COMMENT '角色名称'
) COMMENT '角色表';

DROP TABLE IF EXISTS t_roc_role_permission;
CREATE TABLE t_roc_role_permission
(
    id            BIGINT PRIMARY KEY NOT NULL COMMENT 'ID',
    created_time  TIMESTAMP          NOT NULL COMMENT '创建时间',
    updated_time  TIMESTAMP          NOT NULL COMMENT '更新时间',
    deleted_time  TIMESTAMP COMMENT '删除时间',
    role_id       BIGINT             NOT NULL COMMENT '角色ID',
    permission_id BIGINT             NOT NULL COMMENT '权限ID'
) COMMENT '角色权限表';

DROP TABLE IF EXISTS t_roc_permission;
CREATE TABLE t_roc_permission
(
    id           BIGINT PRIMARY KEY NOT NULL COMMENT 'ID',
    created_time TIMESTAMP          NOT NULL COMMENT '创建时间',
    updated_time TIMESTAMP          NOT NULL COMMENT '更新时间',
    deleted_time TIMESTAMP COMMENT '删除时间',
    name         VARCHAR(128)       NOT NULL COMMENT '权限名称'
) COMMENT '权限表';