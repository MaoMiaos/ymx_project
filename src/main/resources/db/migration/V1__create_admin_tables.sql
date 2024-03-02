-- 管理员表
CREATE TABLE `admin` (
                         `id` VARCHAR(50) NOT NULL PRIMARY KEY,
                         `user_name` VARCHAR(20),
                         `password` VARCHAR(64)
) COMMENT '管理员表';
INSERT INTO `admin`(id,user_name,password) value ('2d5gPiGATJN7RDtopU3HK1dFe2u', '123456', '$2a$10$2jswaEB68TGBZfLj3hGux.tZ7vAlFZeFBE78bX0pGIIusQj0RRP6O');