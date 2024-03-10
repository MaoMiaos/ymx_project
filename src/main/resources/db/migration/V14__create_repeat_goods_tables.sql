CREATE TABLE repeat_goods (
                              ASIN VARCHAR(50) NOT NULL COMMENT 'ASIN',
                              pic_link VARCHAR(100) COMMENT '商品图片链接',
                              brand VARCHAR(100) NOT NULL COMMENT '品牌',
                              ASIN_link VARCHAR(100) COMMENT 'ASIN超链接',
                              goods_count VARCHAR(12) COMMENT '商品销量',
                              price VARCHAR(20) COMMENT '商品价格',
                              height VARCHAR(15) COMMENT '商品重量',
                              FBA_value VARCHAR(15) COMMENT 'FBA值',
                              create_data DATE COMMENT '创建日期',
                              PRIMARY KEY (ASIN) -- 将ASIN设置为主键
) COMMENT '存储重复商品信息的表';