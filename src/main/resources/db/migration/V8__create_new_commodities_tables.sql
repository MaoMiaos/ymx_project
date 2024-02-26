-- 新品表
CREATE TABLE `new_commodities` (
                                   `ASIN` VARCHAR(50) NOT NULL PRIMARY KEY COMMENT 'ASIN',
                                   `brand` VARCHAR(100) NOT NULL COMMENT '品牌',
                                   `ASIN_link` VARCHAR(100) COMMENT 'ASIN超链接',
                                   `goods_type` VARCHAR(12) COMMENT '商品类别',
                                   `price` VARCHAR(20) COMMENT '商品价格',
                                   `height` VARCHAR(15) COMMENT '商品重量',
                                   `FBA_value` VARCHAR(15) COMMENT 'FBA值',
                                   `create_data` DATE COMMENT '创建日期'
) COMMENT '新品表';
