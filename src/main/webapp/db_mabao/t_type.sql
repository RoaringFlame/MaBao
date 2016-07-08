/*
Source Database       : mabao
Date: 2016-07-06 15:15:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS t_type;
CREATE TABLE t_type (
  id int(11) NOT NULL COMMENT '一级分类Id',
  type_name varchar(45) NOT NULL COMMENT '一级分类名称',
  type_list varchar(1000) DEFAULT NULL COMMENT '二级分类列表',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品类别表';

-- ----------------------------
-- Records of t_type
-- ----------------------------
