CREATE TABLE cheap_goods (
                             ASIN VARCHAR(50) NOT NULL COMMENT '商品的唯一标识符',
                             picture_link VARCHAR(100) COMMENT '商品图片的链接地址',
                             brand VARCHAR(100) NOT NULL COMMENT '商品品牌的名称',
                             ASIN_link VARCHAR(100) COMMENT '指向ASIN的超链接',
                             goods_count VARCHAR(12) COMMENT '商品的销量计数',
                             price VARCHAR(20) COMMENT '商品的销售价格',
                             height VARCHAR(15) COMMENT '商品的重量',
                             FBA_value VARCHAR(15) COMMENT 'FBA（Fulfillment by Amazon）的费用',
                             create_data DATE COMMENT '记录创建的日期'
) COMMENT '存储低利润商品信息的表';