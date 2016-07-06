/*
Source Database       : mabao
Date: 2016-07-06 15:15:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_shopping
-- ----------------------------
--DROP TABLE IF EXISTS t_shopping;
CREATE TABLE t_shopping (
  id int(11) NOT NULL COMMENT '编号',
  goods_and_num_list varchar(100) DEFAULT NULL COMMENT '商品和数量列表，以goodsId,num;形式存储',
  total_number int(11) DEFAULT NULL COMMENT '商品总数量',
  total_pay int(11) DEFAULT NULL COMMENT '购物车商品总价',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车';

-- ----------------------------
-- Records of t_shopping
-- ----------------------------
