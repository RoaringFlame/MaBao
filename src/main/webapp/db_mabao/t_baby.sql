/*
Source Database       : mabao
Date: 2016-07-07 16:05:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_baby
-- ----------------------------
-- DROP TABLE IF EXISTS t_baby;
CREATE TABLE t_baby (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) NOT NULL COMMENT '用户ID',
  name varchar(255) DEFAULT NULL COMMENT '宝宝姓名',
  birthday date NOT NULL COMMENT '出生日期',
  gender int(11) NOT NULL COMMENT '宝宝性别',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='宝宝信息';

-- ----------------------------
-- Records of t_baby
-- ----------------------------
