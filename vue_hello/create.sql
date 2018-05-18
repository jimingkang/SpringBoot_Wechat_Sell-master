create table `event_category` (
    `category_id` int not null auto_increment,
    `category_name` varchar(64) not null comment '类目名字',
    `category_type` int not null comment '类目编号',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`category_id`),
    unique key `uqe_category_type` (`category_type`)
);

-- 活动  `team_id` varchar(32) `captain_id` varchar(32),
create table `event_info` (
    `event_id` varchar(32) not null,
    `team_id` varchar(32) default null,
    `captain_id` varchar(32) default null,
    `event_name` varchar(64) not null comment '活动名称',
    `event_price` decimal(8,2) not null comment '单价',
    `event_stock` int not null comment '库存',
    `event_description` varchar(1000) comment '描述',
    `event_icon` varchar(512) comment '小图',
    `event_status` tinyint(3) DEFAULT '0' COMMENT '活动状态,0正常1下架',
    `category_type` int not null comment '类目编号',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`event_id`)
);

-- 订单   `user_id`  `event_id`
create table `order_master` (
    `order_id` varchar(32) not null,
    `user_id` varchar(32) ,
    `event_id` varchar(32),
    `buyer_name` varchar(32) not null comment '买家名字',
    `buyer_phone` varchar(32) not null comment '买家电话',
    `buyer_address` varchar(128) not null comment '买家地址',
    `buyer_openid` varchar(64) not null comment '买家微信openid',
    `order_amount` decimal(8,2) not null comment '订单总金额',
    `order_status` tinyint(3) not null default '0' comment '订单状态, 默认为新下单',
    `pay_status` tinyint(3) not null default '0' comment '支付状态, 默认未支付',
    `create_time` timestamp not null default current_timestamp comment '活动开始时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '结束时间',
    primary key (`order_id`)

);

-- 订单活动
create table `order_detail` (
    `detail_id` varchar(32) not null,
    `order_id` varchar(32) not null,
    `event_id` varchar(32) ,
    `event_name` varchar(64) not null comment '活动名称',
    `event_price` decimal(8,2) not null comment '当前价格,单位分',
    `event_quantity` int not null comment '数量',
    `event_icon` varchar(512) comment '小图',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`detail_id`)

);

-- 卖家(登录后台使用, 卖家登录之后可能直接采用微信扫码登录，不使用账号密码)
create table `team_info` (
    `id` varchar(32) not null,
    `teamname` varchar(50) ,
     `teamlogo` varchar(500),
    `username` varchar(32) not null,
    `password` varchar(32) not null,
    `openid` varchar(64) not null comment '微信openid',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`)
) comment '战队信息表';

create table `user_info` (
    `id` varchar(32) not null,
     `team_id` varchar(32) ,
    `username` varchar(32),
    `password` varchar(32) ,

    `openid` varchar(64) not null comment '微信openid',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`)
) comment 'user信息表';
