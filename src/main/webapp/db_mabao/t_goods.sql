/*
Date: 2016-07-06 15:15:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS t_goods;
CREATE TABLE t_goods (
  id int(11) NOT NULL COMMENT '商品编号，自增',
  user_id int(11) NOT NULL DEFAULT '0' COMMENT '商品归属者编号，后台用户编号为0',
  article_number varchar(45) DEFAULT NULL COMMENT '货号',
  picture varchar(45) DEFAULT NULL COMMENT '图片标签',
  title varchar(45) NOT NULL COMMENT '标题',
  old_price int(11) NOT NULL COMMENT '原价，用整型存储避免计算出错，存取时记得变位。',
  price int(11) NOT NULL COMMENT '现价，用法同原价。',
  type_name varchar(25) DEFAULT NULL COMMENT '二级类型名称',
  type_id int(11) DEFAULT NULL COMMENT '一级类型编号',
  brand varchar(45) DEFAULT NULL COMMENT '商品品牌',
  up_time datetime NOT NULL COMMENT '上架时间',
  new_degree int(2) DEFAULT NULL COMMENT '新旧程度，0表示全新，95，80分别表示95成8成新',
  size varchar(5) DEFAULT NULL COMMENT '尺寸',
  pack tinyint(1) DEFAULT NULL COMMENT '是否有包装，1有0无',
  receipt tinyint(1) DEFAULT NULL COMMENT '是否有小票，1有0无',
  message varchar(500) DEFAULT NULL COMMENT '卖家分享',
  picture_list varchar(200) DEFAULT NULL COMMENT '附加图片，list元素用分号隔开存入数据库',
  stock_number int(11) DEFAULT NULL COMMENT '库存数量',
  state tinyint(1) NOT NULL DEFAULT '1' COMMENT '商品状态，1为存在，0为下架或不存在。',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO t_goods VALUES ('1', '0', 'AX9008', '12.jpg', '适合两岁宝宝的婴儿车', '8000', '6630', '婴儿车', null, 'H&M', '2016-06-02 11:31:31', '0', 'L', '1', '1', '这是一款带有未来设计感的婴儿车', null, '100', '1');
INSERT INTO t_goods VALUES ('2', '0', null, '1.jpg', '适合三岁宝宝的玩具', '11000', '12485', '玩具', null, 'LV', '2016-06-04 00:00:00', '0', 'XL', '1', '1', '结实，耐折腾', null, '150', '1');
INSERT INTO t_goods VALUES ('3', '0', null, '2.jpg', '遥控车', '20000', '30000', '玩具', null, 'T&R', '2016-06-03 00:00:00', '0', 'L', '1', '1', '玩具遥控车', null, '20', '1');
INSERT INTO t_goods VALUES ('4', '0', null, 'main-new1.png', 'H&M', '6690', '10000', '服饰鞋帽', null, 'M&D', '2016-06-05 00:00:00', '0', 'S', '1', '1', '简约，奢华', null, '10', '1');
INSERT INTO t_goods VALUES ('5', '0', null, 'main-new2.png', 'CARDING', '28000', '35000', '服饰鞋帽', null, 'T&R', '2016-06-06 23:08:18', '0', 'L', '1', '1', '结实，耐折腾', null, '200', '1');
INSERT INTO t_goods VALUES ('6', '0', null, '13.jpg', '板凳', '27000', '28000', '安全座椅', null, 'T&R', '2016-06-20 23:08:21', '0', 'L', '1', '1', '结实，耐折腾', null, '25', '1');
INSERT INTO t_goods VALUES ('7', '0', null, '13.jpg', '沙发', '13000', '15000', '安全座椅', null, 'T&R', '2016-06-21 23:08:23', '0', 'S', '1', '1', '结实，耐折腾', null, '30', '0');
INSERT INTO t_goods VALUES ('8', '0', null, '13.jpg', '轮椅', '20000', '24000', '安全座椅', null, 'T&R', '2016-06-20 23:08:26', '0', 'L', '1', '1', '结实，耐折腾', null, '35', '1');
INSERT INTO t_goods VALUES ('9', '0', null, '14.jpg', '笔记本', '42000', '46000', '图片绘本', null, 'T&R', '2016-06-14 23:08:29', '0', 'L', '1', '1', '结实，耐折腾', null, '50', '1');
INSERT INTO t_goods VALUES ('10', '0', null, '14.jpg', '画板', '25000', '28000', '图片绘本', null, 'T&R', '2016-06-06 23:08:33', '0', 'S', '1', '1', '结实，耐折腾', null, '80', '1');
