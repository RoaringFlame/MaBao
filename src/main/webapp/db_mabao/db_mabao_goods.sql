-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_mabao
-- ------------------------------------------------------
-- Server version	5.6.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL COMMENT '商品编号，自增',
  `userId` int(11) NOT NULL DEFAULT '0' COMMENT '商品归属者编号，后台用户编号为0',
  `articleNumber` varchar(45) DEFAULT NULL COMMENT '货号',
  `picture` varchar(45) DEFAULT NULL COMMENT '图片标签',
  `title` varchar(45) NOT NULL COMMENT '标题',
  `oldPrice` int(11) NOT NULL COMMENT '原价，用整型存储避免计算出错，存取时记得变位。',
  `price` int(11) NOT NULL COMMENT '现价，用法同原价。',
  `typeName` varchar(25) DEFAULT NULL COMMENT '二级类型名称',
  `typeId` int(11) DEFAULT NULL COMMENT '一级类型编号',
  `brand` varchar(45) DEFAULT NULL COMMENT '商品品牌',
  `upTime` datetime NOT NULL COMMENT '上架时间',
  `newDegree` int(2) DEFAULT NULL COMMENT '新旧程度，0表示全新，95，80分别表示95成8成新',
  `size` varchar(5) DEFAULT NULL COMMENT '尺寸',
  `pack` tinyint(1) DEFAULT NULL COMMENT '是否有包装，1有0无',
  `receipt` tinyint(1) DEFAULT NULL COMMENT '是否有小票，1有0无',
  `message` varchar(500) DEFAULT NULL COMMENT '卖家分享',
  `pictureList` varchar(200) DEFAULT NULL COMMENT '附加图片，list元素用分号隔开存入数据库',
  `stockNumber` int(11) DEFAULT NULL COMMENT '库存数量',
  `state` tinyint(1) NOT NULL DEFAULT '1' COMMENT '商品状态，1为存在，0为下架或不存在。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,0,'AX9008','12.jpg','适合两岁宝宝的婴儿车',8000,6630,'婴儿车',NULL,'H&M','2016-06-02 11:31:31',0,'L',1,1,'这是一款带有未来设计感的婴儿车',NULL,100,1),(2,0,NULL,'1.jpg','适合三岁宝宝的玩具',11000,12485,'玩具',NULL,'LV','2016-06-04 00:00:00',0,'XL',1,1,'结实，耐折腾',NULL,150,1),(3,0,NULL,'2.jpg','遥控车',20000,30000,'玩具',NULL,'T&R','2016-06-03 00:00:00',0,'L',1,1,'玩具遥控车',NULL,20,1),(4,0,NULL,'main-new1.png','H&M',6690,10000,'服饰鞋帽',NULL,'M&D','2016-06-05 00:00:00',0,'S',1,1,'简约，奢华',NULL,10,1),(5,0,NULL,'main-new2.png','CARDING',28000,35000,'服饰鞋帽',NULL,'T&R','2016-06-06 23:08:18',0,'L',1,1,'结实，耐折腾',NULL,200,1),(6,0,NULL,'13.jpg','板凳',27000,28000,'安全座椅',NULL,'T&R','2016-06-20 23:08:21',0,'L',1,1,'结实，耐折腾',NULL,25,1),(7,0,NULL,'13.jpg','沙发',13000,15000,'安全座椅',NULL,'T&R','2016-06-21 23:08:23',0,'S',1,1,'结实，耐折腾',NULL,30,0),(8,0,NULL,'13.jpg','轮椅',20000,24000,'安全座椅',NULL,'T&R','2016-06-20 23:08:26',0,'L',1,1,'结实，耐折腾',NULL,35,1),(9,0,NULL,'14.jpg','笔记本',42000,46000,'图片绘本',NULL,'T&R','2016-06-14 23:08:29',0,'L',1,1,'结实，耐折腾',NULL,50,1),(10,0,NULL,'14.jpg','画板',25000,28000,'图片绘本',NULL,'T&R','2016-06-06 23:08:33',0,'S',1,1,'结实，耐折腾',NULL,80,1),(12,0,NULL,'16.jpg','奶瓶',3500,3500,'生活',NULL,'BOBO','2016-06-30 16:03:47',0,'M',1,1,'结实好用','',30,1),(13,0,NULL,'17.jpg','奶粉',28000,28000,'婴儿食用',NULL,'Enfamil','2016-06-30 16:05:22',NULL,'L',1,1,'安全有营养',NULL,35,1),(14,0,NULL,'18.jpg','抽纸',950,950,'日常',NULL,'花王','2016-06-30 16:06:30',NULL,'L',1,1,'卫生',NULL,15,1),(15,0,NULL,'19.jpg','洗浴套',13000,13000,'洗浴',NULL,'屈臣氏','2016-06-30 16:07:31',NULL,'L',1,1,'家庭套',NULL,10,1),(16,0,NULL,'20.jps','尿不湿',2300,2300,'日常',NULL,'帮宝适','2016-06-30 16:08:44',NULL,'M',1,1,'方便好用',NULL,15,1),(17,0,NULL,'21.jpg','奶嘴',1300,1300,'日常',NULL,'花王','2016-06-30 16:09:33',NULL,'S',1,1,'材质好',NULL,8,1),(18,0,NULL,'22.jpg','浴巾',4900,4900,'日常',NULL,'竹纤维','2016-06-30 16:10:42',NULL,'M',1,1,'安全优质',NULL,35,1),(19,0,NULL,'23.jpg','背带裤',8900,8900,'衣物',NULL,'七波辉','2016-06-30 16:11:38',NULL,'M',1,1,'好看舒适',NULL,80,1),(20,0,NULL,'24.jpg','玩具',1300,1300,'日常',NULL,'轨迹','2016-06-30 16:12:33',NULL,'S',1,1,'耐久',NULL,15,1),(21,0,NULL,'25.jpg','洗手液',2800,2800,'洗浴',NULL,'好娃娃','2016-06-30 16:13:32',NULL,'L',1,1,'经用且环保',NULL,18,1),(22,0,NULL,'26.jpg','被子',28000,28000,'衣物被子',NULL,'BinBe','2016-06-30 16:14:40',NULL,'M',1,1,'质地好',NULL,200,1),(30,0,NULL,'30.jpg','童装',36000,25000,'服饰鞋帽',NULL,'T&R','2015-06-16 23:07:33',0,'S',1,1,'简约',NULL,NULL,1),(31,0,NULL,'31.jpg','童装',25000,20000,'服饰鞋帽',NULL,'T&R','2015-06-15 23:07:33',0,'S',1,1,'简约',NULL,NULL,1),(32,0,NULL,'32.jpg','童装',48000,36000,'服饰鞋帽',NULL,'T&R','2015-06-14 23:07:33',0,'S',1,1,'简约',NULL,NULL,1),(33,0,NULL,'33.jpg','童装',36000,27000,'服饰鞋帽',NULL,'T&R','2015-06-13 23:07:33',0,'S',1,1,'简约',NULL,NULL,1);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-04 19:09:05
