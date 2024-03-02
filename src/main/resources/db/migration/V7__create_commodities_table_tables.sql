-- 选品表
CREATE TABLE `commodities_table` (
                                     `ASIN` VARCHAR(50) NOT NULL PRIMARY KEY COMMENT 'ASIN',
                                     `brand` VARCHAR(100) NOT NULL COMMENT '品牌',
                                     `ASIN_link` VARCHAR(100) COMMENT 'ASIN超链接',
                                     `goods_type` VARCHAR(12) COMMENT '商品类别',
                                     `price` VARCHAR(20) COMMENT '商品价格',
                                     `height` VARCHAR(15) COMMENT '商品重量',
                                     `FBA_value` VARCHAR(15) COMMENT 'FBA值',
                                     `create_data` DATE COMMENT '创建日期',
                                     `picture_link` varchar(100) COMMENT '图片链接',
                                     `user_id` varchar(50) comment '用户id'

) COMMENT '选品表';