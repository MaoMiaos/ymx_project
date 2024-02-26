-- 总表
CREATE TABLE `all_table` (
                             `ASIN` VARCHAR(50) NOT NULL PRIMARY KEY UNIQUE COMMENT 'ASIN',
                             `brand` VARCHAR(100) COMMENT '品牌',
                             `ASIN_link` VARCHAR(100) COMMENT 'ASIN超链接',
                             `create_data` DATE COMMENT '创建日期'
) COMMENT '总表';