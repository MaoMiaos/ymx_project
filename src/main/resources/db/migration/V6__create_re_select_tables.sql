-- 重查表
CREATE TABLE `re_select` (
                             `ASIN` VARCHAR(50) NOT NULL PRIMARY KEY COMMENT 'ASIN',
                             `brand` VARCHAR(100) NOT NULL COMMENT '品牌',
                             `ASIN_link` VARCHAR(100) COMMENT 'ASIN超链接',
                             `create_data` DATE COMMENT '创建日期'
) COMMENT '重查表';

