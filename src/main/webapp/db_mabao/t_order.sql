/*
Source Database       : mabao
Date: 2016-07-06 15:15:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS t_order;
CREATE TABLE t_order (
  id int(11) NOT NULL COMMENT '编号',
  buyer_id int(11) NOT NULL COMMENT '买家编号',
  seller_id int(11) NOT NULL COMMENT '卖家编号',
  create_time datetime DEFAULT NULL COMMENT '订单创建时间',
  port_time datetime DEFAULT NULL COMMENT '订单发货时间',
  pay_time datetime DEFAULT NULL COMMENT '订单支付时间',
  deal_time datetime DEFAULT NULL COMMENT '订单完成时间',
  port_number varchar(20) DEFAULT NULL COMMENT '运单号',
  transcation_num varchar(30) DEFAULT NULL COMMENT '支付单号',
  address_id int(11) DEFAULT NULL COMMENT '地址默认地址编号',
  message varchar(100) DEFAULT NULL COMMENT '买家留言',
  state int(1) NOT NULL COMMENT '订单状态，0待支付（买家），1待发货（卖家），2待收货（买家），3已完成（卖家），4已取消（买家）',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of t_order
-- ----------------------------
