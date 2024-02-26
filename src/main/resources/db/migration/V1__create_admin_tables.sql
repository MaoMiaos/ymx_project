-- 管理员表
CREATE TABLE `admin` (
                         `id` VARCHAR(50) NOT NULL PRIMARY KEY,
                         `user_name` VARCHAR(20),
                         `password` VARCHAR(20)
) COMMENT '管理员表';