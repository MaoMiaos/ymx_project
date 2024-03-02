create table staff_goods(
                            ASIN varchar(50) primary key not null comment 'ASIN',
                            pic_link varchar(100) comment '商品图片链接',
                            brand varchar(100)  not null comment '品牌',
                            ASIN_link varchar(100) comment 'ASIN超链接',
                            goods_count varchar(12) comment '商品销量',
                            price varchar(20) comment '商品价格',
                            height varchar(15) comment '商品重量',
                            FBA_value varchar(15) comment 'FBA值',
                            caigou_link varchar(100) comment '采购链接',
                            caigou_price varchar(20) comment '采购价',
                            caigou_count varchar(20) comment '采购数量',
                            huilv varchar(10) comment '汇率',
                            user_id varchar(50) comment '用户id',
                            create_data date comment '创建日期'
) comment '员工选品表';
