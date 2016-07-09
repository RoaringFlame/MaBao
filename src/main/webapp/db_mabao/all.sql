/*
Navicat MySQL Data Transfer

Source Server         : localhost5.6
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : mabao

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-07-09 16:40:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_address
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `id` int(11) NOT NULL COMMENT '地址编号',
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `recipients` varchar(25) NOT NULL COMMENT '收件人',
  `tel` varchar(25) NOT NULL COMMENT '手机号',
  `location` varchar(100) NOT NULL COMMENT '地址详情',
  `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '地址状态，是否为默认收货地址，0为否、1为是。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='地址信息表';

-- ----------------------------
-- Records of t_address
-- ----------------------------

-- ----------------------------
-- Table structure for t_baby
-- ----------------------------
DROP TABLE IF EXISTS `t_baby`;
CREATE TABLE `t_baby` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `name` varchar(255) DEFAULT NULL COMMENT '宝宝姓名',
  `birthday` date NOT NULL COMMENT '出生日期',
  `gender` int(11) NOT NULL COMMENT '宝宝性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='宝宝信息';

-- ----------------------------
-- Records of t_baby
-- ----------------------------

-- ----------------------------
-- Table structure for t_banner
-- ----------------------------
DROP TABLE IF EXISTS `t_banner`;
CREATE TABLE `t_banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NOT NULL COMMENT '商品ID',
  `alt` varchar(255) DEFAULT NULL COMMENT '提示',
  `picture` varchar(255) DEFAULT NULL COMMENT '图片',
  `sort` varchar(255) NOT NULL COMMENT '排序',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '禁用or启用',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='首页广告';

-- ----------------------------
-- Records of t_banner
-- ----------------------------
INSERT INTO `t_banner` VALUES ('1', '2', null, '30.jpg', '1', '', null);
INSERT INTO `t_banner` VALUES ('2', '3', null, '31.jpg', '2', '', null);
INSERT INTO `t_banner` VALUES ('3', '4', null, '32.jpg', '3', '', null);
INSERT INTO `t_banner` VALUES ('4', '5', null, '33.jpg', '4', '', null);

-- ----------------------------
-- Table structure for t_brand
-- ----------------------------
DROP TABLE IF EXISTS `t_brand`;
CREATE TABLE `t_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(255) NOT NULL COMMENT '品牌名称',
  `picture` varchar(255) DEFAULT NULL COMMENT '图标',
  `sort` int(11) NOT NULL COMMENT '排序',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='品牌';

-- ----------------------------
-- Records of t_brand
-- ----------------------------
INSERT INTO `t_brand` VALUES ('1', 'T&R', null, '1', '', null);
INSERT INTO `t_brand` VALUES ('2', 'BOBO', null, '2', '', null);
INSERT INTO `t_brand` VALUES ('3', 'M&D', null, '3', '', null);
INSERT INTO `t_brand` VALUES ('4', 'Enfamil', null, '4', '', null);
INSERT INTO `t_brand` VALUES ('5', '花王', null, '5', '', null);
INSERT INTO `t_brand` VALUES ('6', '屈臣氏', null, '6', '', null);
INSERT INTO `t_brand` VALUES ('7', '帮宝适', null, '9', '', null);
INSERT INTO `t_brand` VALUES ('8', '竹纤维', null, '7', '', null);
INSERT INTO `t_brand` VALUES ('9', '七波辉', null, '8', '', null);
INSERT INTO `t_brand` VALUES ('10', '轨迹', null, '22', '', null);
INSERT INTO `t_brand` VALUES ('11', '好娃娃', null, '12', '', null);
INSERT INTO `t_brand` VALUES ('12', 'BinBe', null, '0', '', null);

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` int(11) NOT NULL COMMENT '商品编号，自增',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '商品归属者编号，后台用户编号为0',
  `article_number` varchar(45) DEFAULT NULL COMMENT '货号',
  `picture` varchar(45) DEFAULT NULL COMMENT '图片标签',
  `title` varchar(45) NOT NULL COMMENT '标题',
  `old_price` int(11) NOT NULL COMMENT '原价，用整型存储避免计算出错，存取时记得变位。',
  `price` int(11) NOT NULL COMMENT '现价，用法同原价。',
  `type_name` varchar(25) DEFAULT NULL COMMENT '二级类型名称',
  `type_id` int(11) DEFAULT NULL COMMENT '一级类型编号',
  `brand` varchar(45) DEFAULT NULL COMMENT '商品品牌',
  `up_time` datetime NOT NULL COMMENT '上架时间',
  `new_degree` int(2) NOT NULL COMMENT '新旧程度，0表示全新，95，80分别表示95成8成新',
  `size` varchar(5) DEFAULT NULL COMMENT '尺寸',
  `pack` tinyint(1) DEFAULT NULL COMMENT '是否有包装，1有0无',
  `receipt` tinyint(1) DEFAULT NULL COMMENT '是否有小票，1有0无',
  `message` varchar(500) DEFAULT NULL COMMENT '卖家分享',
  `picture_list` varchar(200) DEFAULT NULL COMMENT '附加图片，list元素用分号隔开存入数据库',
  `stock_number` int(11) DEFAULT NULL COMMENT '库存数量',
  `state` bit(1) NOT NULL DEFAULT b'1' COMMENT '商品状态，1为存在，0为下架或不存在。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('1', '0', 'AX9008', '12.jpg', '适合两岁宝宝的婴儿车', '8000', '6630', '婴儿车', '1', 'H&M', '2016-06-02 11:31:31', '0', 'L', '1', '1', '这是一款带有未来设计感的婴儿车', null, '100', '');
INSERT INTO `t_goods` VALUES ('2', '0', null, '1.jpg', '适合三岁宝宝的玩具', '11000', '12485', '玩具', '2', 'LV', '2016-06-04 00:00:00', '0', 'XL', '1', '1', '结实，耐折腾', null, '150', '');
INSERT INTO `t_goods` VALUES ('3', '0', null, '2.jpg', '遥控车', '20000', '30000', '玩具', '2', 'T&R', '2016-06-03 00:00:00', '0', 'L', '1', '1', '玩具遥控车', null, '20', '');
INSERT INTO `t_goods` VALUES ('4', '0', null, 'main-new1.png', 'H&M', '6690', '10000', '服饰鞋帽', '3', 'M&D', '2016-06-05 00:00:00', '0', 'S', '1', '1', '简约，奢华', null, '10', '');
INSERT INTO `t_goods` VALUES ('5', '0', null, 'main-new2.png', 'CARDING', '28000', '35000', '服饰鞋帽', '3', 'T&R', '2016-06-06 23:08:18', '0', 'L', '1', '1', '结实，耐折腾', null, '200', '');
INSERT INTO `t_goods` VALUES ('6', '0', null, '13.jpg', '板凳', '27000', '28000', '安全座椅', '1', 'T&R', '2016-06-20 23:08:21', '0', 'L', '1', '1', '结实，耐折腾', null, '25', '');
INSERT INTO `t_goods` VALUES ('7', '0', null, '13.jpg', '沙发', '13000', '15000', '安全座椅', '4', 'T&R', '2016-06-21 23:08:23', '0', 'S', '1', '1', '结实，耐折腾', null, '30', '\0');
INSERT INTO `t_goods` VALUES ('8', '0', null, '13.jpg', '轮椅', '20000', '24000', '安全座椅', '4', 'T&R', '2016-06-20 23:08:26', '0', 'L', '1', '1', '结实，耐折腾', null, '35', '');
INSERT INTO `t_goods` VALUES ('9', '0', null, '14.jpg', '笔记本', '42000', '46000', '图片绘本', '1', 'T&R', '2016-06-14 23:08:29', '0', 'L', '1', '1', '结实，耐折腾', null, '50', '');
INSERT INTO `t_goods` VALUES ('10', '0', null, '14.jpg', '画板', '25000', '28000', '图片绘本', '5', 'T&R', '2016-06-06 23:08:33', '0', 'S', '1', '1', '结实，耐折腾', null, '80', '');
INSERT INTO `t_goods` VALUES ('12', '0', null, '16.jpg', '奶瓶', '3500', '3500', '生活用品', '9', 'BOBO', '2016-06-30 16:03:47', '0', 'M', '1', '1', '结实好用', '', '30', '');
INSERT INTO `t_goods` VALUES ('13', '0', null, '17.jpg', '奶粉', '28000', '28000', '玩具', '2', 'Enfamil', '2016-06-30 16:05:22', '3', 'L', '1', '1', '安全有营养', null, '35', '');
INSERT INTO `t_goods` VALUES ('14', '0', null, '18.jpg', '抽纸', '950', '950', '日常用品', '6', '花王', '2016-06-30 16:06:30', '3', 'L', '1', '1', '卫生', null, '15', '');
INSERT INTO `t_goods` VALUES ('15', '0', null, '19.jpg', '洗浴套', '13000', '13000', '玩具', '2', '屈臣氏', '2016-06-30 16:07:31', '3', 'L', '1', '1', '家庭套', null, '10', '');
INSERT INTO `t_goods` VALUES ('16', '0', null, '20.jps', '尿不湿', '2300', '2300', '日常用品', '6', '帮宝适', '2016-06-30 16:08:44', '5', 'M', '1', '1', '方便好用', null, '15', '');
INSERT INTO `t_goods` VALUES ('17', '0', null, '21.jpg', '奶嘴', '1300', '1300', '日常用品', '6', '花王', '2016-06-30 16:09:33', '4', 'S', '1', '1', '材质好', null, '8', '');
INSERT INTO `t_goods` VALUES ('18', '0', null, '22.jpg', '浴巾', '4900', '4900', '日常用品', '6', '竹纤维', '2016-06-30 16:10:42', '4', 'M', '1', '1', '安全优质', null, '35', '');
INSERT INTO `t_goods` VALUES ('19', '0', null, '23.jpg', '背带裤', '8900', '8900', '玩具', '2', '七波辉', '2016-06-30 16:11:38', '4', 'M', '1', '1', '好看舒适', null, '80', '');
INSERT INTO `t_goods` VALUES ('20', '0', null, '24.jpg', '玩具', '1300', '1300', '日常用品', '6', '轨迹', '2016-06-30 16:12:33', '1', 'S', '1', '1', '耐久', null, '15', '');
INSERT INTO `t_goods` VALUES ('21', '0', null, '25.jpg', '洗手液', '2800', '2800', '洗浴用品', '8', '好娃娃', '2016-06-30 16:13:32', '1', 'L', '1', '1', '经用且环保', null, '18', '');
INSERT INTO `t_goods` VALUES ('22', '0', null, '26.jpg', '被子', '28000', '28000', '玩具', '2', 'BinBe', '2016-06-30 16:14:40', '5', 'M', '1', '1', '质地好', null, '200', '');
INSERT INTO `t_goods` VALUES ('30', '0', null, '30.jpg', '童装', '36000', '25000', '服饰鞋帽', '3', 'T&R', '2015-06-16 23:07:33', '0', 'S', '1', '1', '简约', null, null, '');
INSERT INTO `t_goods` VALUES ('31', '0', null, '31.jpg', '童装', '25000', '20000', '服饰鞋帽', '3', 'T&R', '2015-06-15 23:07:33', '0', 'S', '1', '1', '简约', null, null, '');
INSERT INTO `t_goods` VALUES ('32', '0', null, '32.jpg', '童装', '48000', '36000', '服饰鞋帽', '3', 'T&R', '2015-06-14 23:07:33', '0', 'S', '1', '1', '简约', null, null, '');
INSERT INTO `t_goods` VALUES ('33', '0', null, '33.jpg', '童装', '36000', '27000', '服饰鞋帽', '3', 'T&R', '2015-06-13 23:07:33', '0', 'S', '1', '1', '简约', null, null, '');

-- ----------------------------
-- Table structure for t_goods_type
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_type`;
CREATE TABLE `t_goods_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '一级分类Id',
  `type_name` varchar(45) NOT NULL COMMENT '一级分类名称',
  `type_list` varchar(1000) DEFAULT NULL COMMENT '二级分类列表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='商品类别表';

-- ----------------------------
-- Records of t_goods_type
-- ----------------------------
INSERT INTO `t_goods_type` VALUES ('1', '婴儿车', null);
INSERT INTO `t_goods_type` VALUES ('2', '玩具', null);
INSERT INTO `t_goods_type` VALUES ('3', '服饰鞋帽', null);
INSERT INTO `t_goods_type` VALUES ('4', '安全座椅', null);
INSERT INTO `t_goods_type` VALUES ('5', '图片绘本', null);
INSERT INTO `t_goods_type` VALUES ('6', '日常用品', null);
INSERT INTO `t_goods_type` VALUES ('7', '婴儿食品', null);
INSERT INTO `t_goods_type` VALUES ('8', '洗浴用品', null);
INSERT INTO `t_goods_type` VALUES ('9', '生活用品', null);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL COMMENT '编号',
  `buyer_id` int(11) NOT NULL COMMENT '买家编号',
  `create_time` datetime DEFAULT NULL COMMENT '订单创建时间',
  `port_time` datetime DEFAULT NULL COMMENT '订单发货时间',
  `pay_time` datetime DEFAULT NULL COMMENT '订单支付时间',
  `deal_time` datetime DEFAULT NULL COMMENT '订单完成时间',
  `port_number` varchar(20) DEFAULT NULL COMMENT '运单号',
  `transcation_num` varchar(30) DEFAULT NULL COMMENT '支付单号',
  `address_id` int(11) DEFAULT NULL COMMENT '地址默认地址编号',
  `message` varchar(100) DEFAULT NULL COMMENT '买家留言',
  `state` int(1) NOT NULL COMMENT '订单状态，0待支付（买家），1待发货（卖家），2待收货（买家），3已完成（卖家），4已取消（买家）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_details
-- ----------------------------
DROP TABLE IF EXISTS `t_order_details`;
CREATE TABLE `t_order_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_id` int(11) NOT NULL COMMENT '订单ID',
  `goods_id` int(11) NOT NULL COMMENT '商品ID',
  `quantity` int(11) NOT NULL COMMENT '商品数量',
  `unit_cost` double DEFAULT NULL COMMENT '单价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情';

-- ----------------------------
-- Records of t_order_details
-- ----------------------------

-- ----------------------------
-- Table structure for t_shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_shopping_cart`;
CREATE TABLE `t_shopping_cart` (
  `id` int(11) NOT NULL COMMENT '编号',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `goods_id` int(11) NOT NULL COMMENT '商品ID',
  `quantity` int(11) NOT NULL COMMENT '商品数量',
  `create_time` int(11) DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车';

-- ----------------------------
-- Records of t_shopping_cart
-- ----------------------------

-- ----------------------------
-- Table structure for t_goods_size_table
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_size_table`;
CREATE TABLE `t_goods_size_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_type_id` int(11) NOT NULL COMMENT '商品类别',
  `name` varchar(255) NOT NULL COMMENT '尺码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='商品尺码表';

-- ----------------------------
-- Records of t_goods_size_table
-- ----------------------------
INSERT INTO `t_goods_size_table` VALUES ('1', '1', '0-3m');
INSERT INTO `t_goods_size_table` VALUES ('2', '1', '3-6m');
INSERT INTO `t_goods_size_table` VALUES ('3', '1', '6-9m');
INSERT INTO `t_goods_size_table` VALUES ('4', '1', '9-12m');
INSERT INTO `t_goods_size_table` VALUES ('5', '1', '12-18m');
INSERT INTO `t_goods_size_table` VALUES ('6', '1', '18-24m');
INSERT INTO `t_goods_size_table` VALUES ('7', '2', '2m');
INSERT INTO `t_goods_size_table` VALUES ('8', '2', '1.5m');
INSERT INTO `t_goods_size_table` VALUES ('9', '2', '0.5m');
INSERT INTO `t_goods_size_table` VALUES ('10', '4', '1m');
INSERT INTO `t_goods_size_table` VALUES ('11', '4', '30公分');
INSERT INTO `t_goods_size_table` VALUES ('12', '4', '50公分');
INSERT INTO `t_goods_size_table` VALUES ('13', '4', '70公分');
INSERT INTO `t_goods_size_table` VALUES ('14', '3', '常规尺寸');
INSERT INTO `t_goods_size_table` VALUES ('15', '5', '平装');
INSERT INTO `t_goods_size_table` VALUES ('16', '5', '精装');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) NOT NULL COMMENT '呢称',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机',
  `email` varchar(255) NOT NULL COMMENT '邮箱',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `picture` varchar(255) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'test', 'test', '12347654', 'qq@qq.com', '2016-07-08 18:03:22', 'test');
