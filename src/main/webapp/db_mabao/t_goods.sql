/*
Navicat MySQL Data Transfer

Source Server         : localhost5.6
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : mabao

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-07-13 11:56:51
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `old_price` decimal(11,2) NOT NULL COMMENT '原价，用整型存储避免计算出错，存取时记得变位。',
  `price` decimal(11,2) NOT NULL COMMENT '现价，用法同原价。',
  `baby_type` int(11) NOT NULL COMMENT '适合宝宝类型',
  `type_name` varchar(25) DEFAULT NULL COMMENT '二级类型名称',
  `type_id` int(11) DEFAULT NULL COMMENT '一级类型编号',
  `brand_id` int(11) NOT NULL,
  `brand_name` varchar(45) NOT NULL COMMENT '商品品牌',
  `up_time` datetime NOT NULL COMMENT '上架时间',
  `new_degree` int(2) NOT NULL COMMENT '新旧程度，0表示全新，95，80分别表示95成8成新',
  `size` int(5) DEFAULT NULL COMMENT '尺寸',
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
INSERT INTO `t_goods` VALUES ('1', '0', 'AX9008', '12.jpg', '适合两岁宝宝的婴儿车', '80.00', '66.30', '0', '婴儿车', '1', '0', 'H&M', '2016-06-02 11:31:31', '0', '1', '1', '1', '这是一款带有未来设计感的婴儿车', null, '100', '');
INSERT INTO `t_goods` VALUES ('2', '0', null, '1.jpg', '适合三岁宝宝的玩具', '110.00', '124.85', '0', '玩具', '2', '0', 'LV', '2016-06-04 00:00:00', '0', '1', '1', '1', '结实，耐折腾', null, '150', '');
INSERT INTO `t_goods` VALUES ('3', '0', null, '2.jpg', '遥控车', '200.00', '300.00', '0', '玩具', '2', '1', 'T&R', '2016-06-03 00:00:00', '0', '1', '1', '1', '玩具遥控车', null, '20', '');
INSERT INTO `t_goods` VALUES ('4', '0', null, 'main-new1.png', 'H&M', '66.90', '100.00', '0', '服饰鞋帽', '3', '3', 'M&D', '2016-06-05 00:00:00', '0', '1', '1', '1', '简约，奢华', null, '10', '');
INSERT INTO `t_goods` VALUES ('5', '0', null, 'main-new2.png', 'CARDING', '280.00', '350.00', '0', '服饰鞋帽', '3', '1', 'T&R', '2016-06-06 23:08:18', '0', '1', '1', '1', '结实，耐折腾', null, '200', '');
INSERT INTO `t_goods` VALUES ('6', '0', null, '13.jpg', '板凳', '270.00', '280.00', '0', '安全座椅', '1', '1', 'T&R', '2016-06-20 23:08:21', '0', '1', '1', '1', '结实，耐折腾', null, '25', '');
INSERT INTO `t_goods` VALUES ('7', '0', null, '13.jpg', '沙发', '130.00', '150.00', '0', '安全座椅', '4', '1', 'T&R', '2016-06-21 23:08:23', '0', '1', '1', '1', '结实，耐折腾', null, '30', '\0');
INSERT INTO `t_goods` VALUES ('8', '0', null, '13.jpg', '轮椅', '200.00', '240.00', '0', '安全座椅', '4', '1', 'T&R', '2016-06-20 23:08:26', '0', '1', '1', '1', '结实，耐折腾', null, '35', '');
INSERT INTO `t_goods` VALUES ('9', '0', null, '14.jpg', '笔记本', '420.00', '460.00', '0', '图片绘本', '1', '1', 'T&R', '2016-06-14 23:08:29', '0', '1', '1', '1', '结实，耐折腾', null, '50', '');
INSERT INTO `t_goods` VALUES ('10', '0', null, '14.jpg', '画板', '250.00', '280.00', '0', '图片绘本', '5', '1', 'T&R', '2016-06-06 23:08:33', '0', '1', '1', '1', '结实，耐折腾', null, '80', '');
INSERT INTO `t_goods` VALUES ('12', '0', null, '16.jpg', '奶瓶', '35.00', '35.00', '0', '生活用品', '9', '2', 'BOBO', '2016-06-30 16:03:47', '0', '1', '1', '1', '结实好用', '', '30', '');
INSERT INTO `t_goods` VALUES ('13', '0', null, '17.jpg', '奶粉', '280.00', '280.00', '0', '玩具', '2', '4', 'Enfamil', '2016-06-30 16:05:22', '3', '1', '1', '1', '安全有营养', null, '35', '');
INSERT INTO `t_goods` VALUES ('14', '0', null, '18.jpg', '抽纸', '9.50', '9.50', '0', '日常用品', '6', '5', '花王', '2016-06-30 16:06:30', '3', '1', '1', '1', '卫生', null, '15', '');
INSERT INTO `t_goods` VALUES ('15', '0', null, '19.jpg', '洗浴套', '130.00', '130.00', '0', '玩具', '2', '6', '屈臣氏', '2016-06-30 16:07:31', '3', '1', '1', '1', '家庭套', null, '10', '');
INSERT INTO `t_goods` VALUES ('16', '0', null, '20.jpg', '尿不湿', '23.00', '23.00', '0', '日常用品', '6', '7', '帮宝适', '2016-06-30 16:08:44', '5', '1', '1', '1', '方便好用', null, '15', '');
INSERT INTO `t_goods` VALUES ('17', '0', null, '21.jpg', '奶嘴', '13.00', '13.00', '0', '日常用品', '6', '5', '花王', '2016-06-30 16:09:33', '4', '1', '1', '1', '材质好', null, '8', '');
INSERT INTO `t_goods` VALUES ('18', '0', null, '22.jpg', '浴巾', '49.00', '49.00', '0', '日常用品', '6', '8', '竹纤维', '2016-06-30 16:10:42', '4', '1', '1', '1', '安全优质', null, '35', '');
INSERT INTO `t_goods` VALUES ('19', '0', null, '23.jpg', '背带裤', '89.00', '89.00', '0', '玩具', '2', '9', '七波辉', '2016-06-30 16:11:38', '4', '1', '1', '1', '好看舒适', null, '80', '');
INSERT INTO `t_goods` VALUES ('20', '0', null, '24.jpg', '玩具', '13.00', '13.00', '0', '日常用品', '6', '10', '轨迹', '2016-06-30 16:12:33', '1', '1', '1', '1', '耐久', null, '15', '');
INSERT INTO `t_goods` VALUES ('21', '0', null, '25.jpg', '洗手液', '28.00', '28.00', '0', '洗浴用品', '8', '11', '好娃娃', '2016-06-30 16:13:32', '1', '1', '1', '1', '经用且环保', null, '18', '');
INSERT INTO `t_goods` VALUES ('22', '0', null, '26.jpg', '被子', '280.00', '280.00', '0', '玩具', '2', '12', 'BinBe', '2016-06-30 16:14:40', '5', '1', '1', '1', '质地好', null, '200', '');
INSERT INTO `t_goods` VALUES ('30', '0', null, '30.jpg', '童装', '360.00', '250.00', '0', '服饰鞋帽', '3', '1', 'T&R', '2015-06-16 23:07:33', '0', '1', '1', '1', '简约', null, null, '');
INSERT INTO `t_goods` VALUES ('31', '0', null, '31.jpg', '童装', '250.00', '200.00', '0', '服饰鞋帽', '3', '1', 'T&R', '2015-06-15 23:07:33', '0', '1', '1', '1', '简约', null, null, '');
INSERT INTO `t_goods` VALUES ('32', '0', null, '32.jpg', '童装', '480.00', '360.00', '0', '服饰鞋帽', '3', '1', 'T&R', '2015-06-14 23:07:33', '0', '1', '1', '1', '简约', null, null, '');
INSERT INTO `t_goods` VALUES ('33', '0', null, '33.jpg', '童装', '360.00', '270.00', '0', '服饰鞋帽', '3', '1', 'T&R', '2015-06-13 23:07:33', '0', '1', '1', '1', '简约', null, null, '');
