-- B列淘汰表
CREATE TABLE `remove_B` (
                            `brand` VARCHAR(100) NOT NULL PRIMARY KEY UNIQUE COMMENT '品牌',
                            `ASIN` VARCHAR(50) COMMENT 'ASIN',
                            `ASIN_link` VARCHAR(100) COMMENT 'ASIN超链接',
                            `create_data` DATE COMMENT '创建日期'
) COMMENT 'B列淘汰表';