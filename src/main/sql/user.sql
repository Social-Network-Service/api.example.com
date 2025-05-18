DROP TABLE IF EXISTS user;

create table user(
    user_id bigint AUTO_INCREMENT primary key,
    user_name varchar(64) not null,
    password varchar(128) not null,
    email varchar(128),
    phone varchar(20),
    status tinyint default 1 comment '用户状态：1-正常，0-禁用',
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp,
    unique key idx_user_name (user_name),index idx_email (email),index idx_phone (phone)
);

-- 添加测试数据
INSERT INTO user (user_name, password, email, phone, status) VALUES
('admin', '123456', 'admin@example.com', '13800138000', 1),
('user1', 'user123', 'user1@example.com', '13800138001', 1),
('user2', 'user123', 'user2@example.com', '13800138002', 1),
('testuser', 'test123', 'test@example.com', '13800138003', 1);