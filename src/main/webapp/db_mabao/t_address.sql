/*
Source Database       : mabao
Date: 2016-07-06 15:14:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_address
-- ----------------------------
-- DROP TABLE IF EXISTS t_address;
CREATE TABLE t_address (
  id int(11) NOT NULL COMMENT '地址编号',
  user_id int(11) NOT NULL COMMENT '用户编号',
  recipients varchar(25) NOT NULL COMMENT '收件人',
  tel varchar(25) NOT NULL COMMENT '手机号',
  location varchar(100) NOT NULL COMMENT '地址详情',
  state tinyint(1) NOT NULL DEFAULT '0' COMMENT '地址状态，是否为默认收货地址，0为否、1为是。',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='地址信息表';

-- ----------------------------
-- Records of t_address
-- ----------------------------
