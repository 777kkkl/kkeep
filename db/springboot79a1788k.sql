-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: springboot79a1788k
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `springboot79a1788k`
--

/*!40000 DROP DATABASE IF EXISTS `springboot79a1788k`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `springboot79a1788k` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `springboot79a1788k`;

--
-- Table structure for table `baojingxinxi`
--

DROP TABLE IF EXISTS `baojingxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baojingxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `baojingbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '报警编号',
  `guanlizhanghao` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '管理账号',
  `guanlixingming` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '管理姓名',
  `xiaoqumingcheng` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '小区名称',
  `xiaoqudizhi` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '小区地址',
  `baojingneirong` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '报警内容',
  `baojingshijian` datetime DEFAULT NULL COMMENT '报警时间',
  PRIMARY KEY (`id`),
  KEY `guanlizhanghao` (`guanlizhanghao`,`guanlixingming`,`xiaoqumingcheng`,`xiaoqudizhi`),
  CONSTRAINT `baojingxinxi_ibfk_1` FOREIGN KEY (`guanlizhanghao`, `guanlixingming`, `xiaoqumingcheng`, `xiaoqudizhi`) REFERENCES `xiaoquguanliyuan` (`guanlizhanghao`, `guanlixingming`, `xiaoqumingcheng`, `xiaoqudizhi`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='报警信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baojingxinxi`
--

LOCK TABLES `baojingxinxi` WRITE;
/*!40000 ALTER TABLE `baojingxinxi` DISABLE KEYS */;
INSERT INTO `baojingxinxi` VALUES (1,'2024-12-11 12:51:16','报警编号1','管理账号1','管理姓名1','小区名称1','小区地址1','非法闯入','2024-12-11 20:51:16'),(2,'2024-12-11 12:51:16','报警编号2','管理账号2','管理姓名2','小区名称2','小区地址2','非法闯入','2024-12-11 20:51:16'),(3,'2024-12-11 12:51:16','报警编号3','管理账号3','管理姓名3','小区名称3','小区地址3','非法闯入','2024-12-11 20:51:16'),(4,'2024-12-11 12:51:16','报警编号4','管理账号4','管理姓名4','小区名称4','小区地址4','非法闯入','2024-12-11 20:51:16'),(5,'2024-12-11 12:51:16','报警编号5','管理账号5','管理姓名5','小区名称5','小区地址5','非法闯入','2024-12-11 20:51:16'),(6,'2024-12-11 12:51:16','报警编号6','管理账号6','管理姓名6','小区名称6','小区地址6','非法闯入','2024-12-11 20:51:16'),(7,'2024-12-11 12:51:16','报警编号7','管理账号7','管理姓名7','小区名称7','小区地址7','非法闯入','2024-12-11 20:51:16'),(8,'2024-12-11 12:51:16','报警编号8','管理账号8','管理姓名8','小区名称8','小区地址8','非法闯入','2024-12-11 20:51:16');
/*!40000 ALTER TABLE `baojingxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `churujilu`
--

DROP TABLE IF EXISTS `churujilu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `churujilu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `guanlizhanghao` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '管理账号',
  `guanlixingming` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '管理姓名',
  `xiaoqumingcheng` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '小区名称',
  `waimaizhanghao` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '外卖账号',
  `waimaixingming` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '外卖姓名',
  `lianxidianhua` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `peisongpingtai` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '配送平台',
  `jinrushijian` datetime NOT NULL COMMENT '进入时间',
  `likaishijian` datetime DEFAULT NULL COMMENT '离开时间',
  `churuzhuangtai` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '出入状态',
  `dengjiriqi` date DEFAULT NULL COMMENT '登记日期',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  PRIMARY KEY (`id`),
  KEY `guanlizhanghao` (`guanlizhanghao`,`guanlixingming`,`xiaoqumingcheng`),
  KEY `waimaizhanghao` (`waimaizhanghao`,`waimaixingming`,`lianxidianhua`,`peisongpingtai`),
  CONSTRAINT `churujilu_ibfk_1` FOREIGN KEY (`guanlizhanghao`, `guanlixingming`, `xiaoqumingcheng`) REFERENCES `xiaoquguanliyuan` (`guanlizhanghao`, `guanlixingming`, `xiaoqumingcheng`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `churujilu_ibfk_2` FOREIGN KEY (`waimaizhanghao`, `waimaixingming`, `lianxidianhua`, `peisongpingtai`) REFERENCES `waimaiyuan` (`waimaizhanghao`, `waimaixingming`, `lianxidianhua`, `peisongpingtai`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='出入记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `churujilu`
--

LOCK TABLES `churujilu` WRITE;
/*!40000 ALTER TABLE `churujilu` DISABLE KEYS */;
INSERT INTO `churujilu` VALUES (1,'2024-12-11 12:51:16','管理账号1','管理姓名1','小区名称1','外卖账号1','外卖姓名1','13823888881','配送平台1','2024-12-11 20:51:16','2024-12-11 20:51:16','进入','2024-12-11',1,1),(2,'2024-12-11 12:51:16','管理账号2','管理姓名2','小区名称2','外卖账号2','外卖姓名2','13823888882','配送平台2','2024-12-11 20:51:16','2024-12-11 20:51:16','进入','2024-12-11',2,2),(3,'2024-12-11 12:51:16','管理账号3','管理姓名3','小区名称3','外卖账号3','外卖姓名3','13823888883','配送平台3','2024-12-11 20:51:16','2024-12-11 20:51:16','进入','2024-12-11',3,3),(4,'2024-12-11 12:51:16','管理账号4','管理姓名4','小区名称4','外卖账号4','外卖姓名4','13823888884','配送平台4','2024-12-11 20:51:16','2024-12-11 20:51:16','进入','2024-12-11',4,4),(5,'2024-12-11 12:51:16','管理账号5','管理姓名5','小区名称5','外卖账号5','外卖姓名5','13823888885','配送平台5','2024-12-11 20:51:16','2024-12-11 20:51:16','进入','2024-12-11',5,5),(6,'2024-12-11 12:51:16','管理账号6','管理姓名6','小区名称6','外卖账号6','外卖姓名6','13823888886','配送平台6','2024-12-11 20:51:16','2024-12-11 20:51:16','进入','2024-12-11',6,6),(7,'2024-12-11 12:51:16','管理账号7','管理姓名7','小区名称7','外卖账号7','外卖姓名7','13823888887','配送平台7','2024-12-11 20:51:16','2024-12-11 20:51:16','进入','2024-12-11',7,7),(8,'2024-12-11 12:51:16','管理账号8','管理姓名8','小区名称8','外卖账号8','外卖姓名8','13823888888','配送平台8','2024-12-11 20:51:16','2024-12-11 20:51:16','进入','2024-12-11',8,8);
/*!40000 ALTER TABLE `churujilu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  `url` varchar(500) DEFAULT NULL COMMENT 'url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','upload/picture1.jpg',NULL),(2,'picture2','upload/picture2.jpg',NULL),(3,'picture3','upload/picture3.jpg',NULL);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shenqingjilu`
--

DROP TABLE IF EXISTS `shenqingjilu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shenqingjilu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `guanlizhanghao` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '管理账号',
  `guanlixingming` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '管理姓名',
  `xiaoqumingcheng` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '小区名称',
  `xiaoqudizhi` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '小区地址',
  `waimaizhanghao` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '外卖账号',
  `waimaixingming` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '外卖姓名',
  `lianxidianhua` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `peisongpingtai` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '配送平台',
  `xinyuqingkuang` int(11) DEFAULT NULL COMMENT '信誉情况',
  `peisongjietu` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '配送截图',
  `sfsh` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT '审核回复',
  PRIMARY KEY (`id`),
  KEY `waimaizhanghao` (`waimaizhanghao`,`waimaixingming`,`lianxidianhua`,`peisongpingtai`,`xinyuqingkuang`),
  KEY `guanlizhanghao` (`guanlizhanghao`,`guanlixingming`,`xiaoqumingcheng`,`xiaoqudizhi`),
  CONSTRAINT `shenqingjilu_ibfk_1` FOREIGN KEY (`waimaizhanghao`, `waimaixingming`, `lianxidianhua`, `peisongpingtai`, `xinyuqingkuang`) REFERENCES `waimaiyuan` (`waimaizhanghao`, `waimaixingming`, `lianxidianhua`, `peisongpingtai`, `xinyuqingkuang`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `shenqingjilu_ibfk_2` FOREIGN KEY (`guanlizhanghao`, `guanlixingming`, `xiaoqumingcheng`, `xiaoqudizhi`) REFERENCES `xiaoquguanliyuan` (`guanlizhanghao`, `guanlixingming`, `xiaoqumingcheng`, `xiaoqudizhi`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='申请记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shenqingjilu`
--

LOCK TABLES `shenqingjilu` WRITE;
/*!40000 ALTER TABLE `shenqingjilu` DISABLE KEYS */;
INSERT INTO `shenqingjilu` VALUES (1,'2024-12-11 12:51:16','管理账号1','管理姓名1','小区名称1','小区地址1','外卖账号1','外卖姓名1','13823888881','配送平台1',1,'upload/shenqingjilu_peisongjietu1.jpg,upload/shenqingjilu_peisongjietu2.jpg,upload/shenqingjilu_peisongjietu3.jpg','是',''),(2,'2024-12-11 12:51:16','管理账号2','管理姓名2','小区名称2','小区地址2','外卖账号2','外卖姓名2','13823888882','配送平台2',2,'upload/shenqingjilu_peisongjietu2.jpg,upload/shenqingjilu_peisongjietu3.jpg,upload/shenqingjilu_peisongjietu4.jpg','是',''),(3,'2024-12-11 12:51:16','管理账号3','管理姓名3','小区名称3','小区地址3','外卖账号3','外卖姓名3','13823888883','配送平台3',3,'upload/shenqingjilu_peisongjietu3.jpg,upload/shenqingjilu_peisongjietu4.jpg,upload/shenqingjilu_peisongjietu5.jpg','是',''),(4,'2024-12-11 12:51:16','管理账号4','管理姓名4','小区名称4','小区地址4','外卖账号4','外卖姓名4','13823888884','配送平台4',4,'upload/shenqingjilu_peisongjietu4.jpg,upload/shenqingjilu_peisongjietu5.jpg,upload/shenqingjilu_peisongjietu6.jpg','是',''),(5,'2024-12-11 12:51:16','管理账号5','管理姓名5','小区名称5','小区地址5','外卖账号5','外卖姓名5','13823888885','配送平台5',5,'upload/shenqingjilu_peisongjietu5.jpg,upload/shenqingjilu_peisongjietu6.jpg,upload/shenqingjilu_peisongjietu7.jpg','是',''),(6,'2024-12-11 12:51:16','管理账号6','管理姓名6','小区名称6','小区地址6','外卖账号6','外卖姓名6','13823888886','配送平台6',6,'upload/shenqingjilu_peisongjietu6.jpg,upload/shenqingjilu_peisongjietu7.jpg,upload/shenqingjilu_peisongjietu8.jpg','是',''),(7,'2024-12-11 12:51:16','管理账号7','管理姓名7','小区名称7','小区地址7','外卖账号7','外卖姓名7','13823888887','配送平台7',7,'upload/shenqingjilu_peisongjietu7.jpg,upload/shenqingjilu_peisongjietu8.jpg,upload/shenqingjilu_peisongjietu1.jpg','是',''),(8,'2024-12-11 12:51:16','管理账号8','管理姓名8','小区名称8','小区地址8','外卖账号8','外卖姓名8','13823888888','配送平台8',8,'upload/shenqingjilu_peisongjietu8.jpg,upload/shenqingjilu_peisongjietu1.jpg,upload/shenqingjilu_peisongjietu2.jpg','是','');
/*!40000 ALTER TABLE `shenqingjilu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipinjiankong`
--

DROP TABLE IF EXISTS `shipinjiankong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipinjiankong` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jiankongbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '监控编号',
  `shipin` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '视频',
  `guanlizhanghao` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '管理账号',
  `guanlixingming` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '管理姓名',
  `xiaoqumingcheng` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '小区名称',
  `xiaoqudizhi` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '小区地址',
  `shangchuanshijian` date DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `jiankongbianhao` (`jiankongbianhao`),
  KEY `guanlizhanghao` (`guanlizhanghao`,`guanlixingming`,`xiaoqumingcheng`,`xiaoqudizhi`),
  CONSTRAINT `shipinjiankong_ibfk_1` FOREIGN KEY (`guanlizhanghao`, `guanlixingming`, `xiaoqumingcheng`, `xiaoqudizhi`) REFERENCES `xiaoquguanliyuan` (`guanlizhanghao`, `guanlixingming`, `xiaoqumingcheng`, `xiaoqudizhi`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='视频监控';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipinjiankong`
--

LOCK TABLES `shipinjiankong` WRITE;
/*!40000 ALTER TABLE `shipinjiankong` DISABLE KEYS */;
INSERT INTO `shipinjiankong` VALUES (1,'2024-12-11 12:51:16','1111111111','','管理账号1','管理姓名1','小区名称1','小区地址1','2024-12-11'),(2,'2024-12-11 12:51:16','2222222222','','管理账号2','管理姓名2','小区名称2','小区地址2','2024-12-11'),(3,'2024-12-11 12:51:16','3333333333','','管理账号3','管理姓名3','小区名称3','小区地址3','2024-12-11'),(4,'2024-12-11 12:51:16','4444444444','','管理账号4','管理姓名4','小区名称4','小区地址4','2024-12-11'),(5,'2024-12-11 12:51:16','5555555555','','管理账号5','管理姓名5','小区名称5','小区地址5','2024-12-11'),(6,'2024-12-11 12:51:16','6666666666','','管理账号6','管理姓名6','小区名称6','小区地址6','2024-12-11'),(7,'2024-12-11 12:51:16','7777777777','','管理账号7','管理姓名7','小区名称7','小区地址7','2024-12-11'),(8,'2024-12-11 12:51:16','8888888888','','管理账号8','管理姓名8','小区名称8','小区地址8','2024-12-11');
/*!40000 ALTER TABLE `shipinjiankong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `syslog`
--

DROP TABLE IF EXISTS `syslog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `syslog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `operation` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户操作',
  `method` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '请求方法',
  `params` longtext COLLATE utf8mb4_unicode_ci COMMENT '请求参数',
  `time` bigint(20) DEFAULT NULL COMMENT '请求时长(毫秒)',
  `ip` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'IP地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syslog`
--

LOCK TABLES `syslog` WRITE;
/*!40000 ALTER TABLE `syslog` DISABLE KEYS */;
/*!40000 ALTER TABLE `syslog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `image` varchar(200) DEFAULT NULL COMMENT '头像',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin','upload/image1.jpg','管理员','2024-12-11 12:51:16');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waimaiyuan`
--

DROP TABLE IF EXISTS `waimaiyuan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `waimaiyuan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `waimaizhanghao` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '外卖账号',
  `mima` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `waimaixingming` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '外卖姓名',
  `nianling` int(11) DEFAULT NULL COMMENT '年龄',
  `xingbie` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `lianxidianhua` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '联系电话',
  `touxiang` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '头像',
  `peisongpingtai` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '配送平台',
  `xinyuqingkuang` int(11) DEFAULT NULL COMMENT '信誉情况',
  PRIMARY KEY (`id`),
  UNIQUE KEY `waimaizhanghao` (`waimaizhanghao`),
  KEY `waimaiyuan_of0g` (`waimaizhanghao`,`waimaixingming`,`lianxidianhua`,`peisongpingtai`,`xinyuqingkuang`),
  KEY `waimaiyuan_yuy5` (`waimaizhanghao`,`waimaixingming`,`lianxidianhua`,`peisongpingtai`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='外卖员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waimaiyuan`
--

LOCK TABLES `waimaiyuan` WRITE;
/*!40000 ALTER TABLE `waimaiyuan` DISABLE KEYS */;
INSERT INTO `waimaiyuan` VALUES (11,'2024-12-11 12:51:16','外卖账号1','123456','外卖姓名1',1,'男','13823888881','upload/waimaiyuan_touxiang1.jpg','配送平台1',1),(12,'2024-12-11 12:51:16','外卖账号2','123456','外卖姓名2',2,'男','13823888882','upload/waimaiyuan_touxiang2.jpg','配送平台2',2),(13,'2024-12-11 12:51:16','外卖账号3','123456','外卖姓名3',3,'男','13823888883','upload/waimaiyuan_touxiang3.jpg','配送平台3',3),(14,'2024-12-11 12:51:16','外卖账号4','123456','外卖姓名4',4,'男','13823888884','upload/waimaiyuan_touxiang4.jpg','配送平台4',4),(15,'2024-12-11 12:51:16','外卖账号5','123456','外卖姓名5',5,'男','13823888885','upload/waimaiyuan_touxiang5.jpg','配送平台5',5),(16,'2024-12-11 12:51:16','外卖账号6','123456','外卖姓名6',6,'男','13823888886','upload/waimaiyuan_touxiang6.jpg','配送平台6',6),(17,'2024-12-11 12:51:16','外卖账号7','123456','外卖姓名7',7,'男','13823888887','upload/waimaiyuan_touxiang7.jpg','配送平台7',7),(18,'2024-12-11 12:51:16','外卖账号8','123456','外卖姓名8',8,'男','13823888888','upload/waimaiyuan_touxiang8.jpg','配送平台8',8);
/*!40000 ALTER TABLE `waimaiyuan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xiaoquguanliyuan`
--

DROP TABLE IF EXISTS `xiaoquguanliyuan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xiaoquguanliyuan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `guanlizhanghao` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '管理账号',
  `mima` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `guanlixingming` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '管理姓名',
  `touxiang` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `lianxidianhua` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `xiaoqumingcheng` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '小区名称',
  `xiaoqudizhi` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '小区地址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `guanlizhanghao` (`guanlizhanghao`),
  KEY `xiaoquguanliyuan_8s6x` (`guanlizhanghao`,`guanlixingming`,`xiaoqumingcheng`,`xiaoqudizhi`),
  KEY `xiaoquguanliyuan_3l31` (`guanlizhanghao`,`guanlixingming`,`xiaoqumingcheng`),
  KEY `xiaoquguanliyuan_6n8q` (`guanlizhanghao`,`guanlixingming`,`xiaoqumingcheng`,`xiaoqudizhi`,`lianxidianhua`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='小区管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xiaoquguanliyuan`
--

LOCK TABLES `xiaoquguanliyuan` WRITE;
/*!40000 ALTER TABLE `xiaoquguanliyuan` DISABLE KEYS */;
INSERT INTO `xiaoquguanliyuan` VALUES (21,'2024-12-11 12:51:16','管理账号1','123456','管理姓名1','upload/xiaoquguanliyuan_touxiang1.jpg','13823888881','小区名称1','小区地址1'),(22,'2024-12-11 12:51:16','管理账号2','123456','管理姓名2','upload/xiaoquguanliyuan_touxiang2.jpg','13823888882','小区名称2','小区地址2'),(23,'2024-12-11 12:51:16','管理账号3','123456','管理姓名3','upload/xiaoquguanliyuan_touxiang3.jpg','13823888883','小区名称3','小区地址3'),(24,'2024-12-11 12:51:16','管理账号4','123456','管理姓名4','upload/xiaoquguanliyuan_touxiang4.jpg','13823888884','小区名称4','小区地址4'),(25,'2024-12-11 12:51:16','管理账号5','123456','管理姓名5','upload/xiaoquguanliyuan_touxiang5.jpg','13823888885','小区名称5','小区地址5'),(26,'2024-12-11 12:51:16','管理账号6','123456','管理姓名6','upload/xiaoquguanliyuan_touxiang6.jpg','13823888886','小区名称6','小区地址6'),(27,'2024-12-11 12:51:16','管理账号7','123456','管理姓名7','upload/xiaoquguanliyuan_touxiang7.jpg','13823888887','小区名称7','小区地址7'),(28,'2024-12-11 12:51:16','管理账号8','123456','管理姓名8','upload/xiaoquguanliyuan_touxiang8.jpg','13823888888','小区名称8','小区地址8');
/*!40000 ALTER TABLE `xiaoquguanliyuan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xiaoqumenjin`
--

DROP TABLE IF EXISTS `xiaoqumenjin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xiaoqumenjin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `guanlizhanghao` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '管理账号',
  `guanlixingming` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '管理姓名',
  `xiaoqumingcheng` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '小区名称',
  `xiaoqudizhi` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '小区地址',
  `lianxidianhua` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `xiaoqutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '小区图片',
  `kaifangshijian` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '开放时间',
  PRIMARY KEY (`id`),
  KEY `guanlizhanghao` (`guanlizhanghao`,`guanlixingming`,`xiaoqumingcheng`,`xiaoqudizhi`,`lianxidianhua`),
  CONSTRAINT `xiaoqumenjin_ibfk_1` FOREIGN KEY (`guanlizhanghao`, `guanlixingming`, `xiaoqumingcheng`, `xiaoqudizhi`, `lianxidianhua`) REFERENCES `xiaoquguanliyuan` (`guanlizhanghao`, `guanlixingming`, `xiaoqumingcheng`, `xiaoqudizhi`, `lianxidianhua`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='小区门禁';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xiaoqumenjin`
--

LOCK TABLES `xiaoqumenjin` WRITE;
/*!40000 ALTER TABLE `xiaoqumenjin` DISABLE KEYS */;
INSERT INTO `xiaoqumenjin` VALUES (1,'2024-12-11 12:51:16','管理账号1','管理姓名1','小区名称1','小区地址1','13823888881','upload/xiaoqumenjin_xiaoqutupian1.jpg,upload/xiaoqumenjin_xiaoqutupian2.jpg,upload/xiaoqumenjin_xiaoqutupian3.jpg','开放时间1'),(2,'2024-12-11 12:51:16','管理账号2','管理姓名2','小区名称2','小区地址2','13823888882','upload/xiaoqumenjin_xiaoqutupian2.jpg,upload/xiaoqumenjin_xiaoqutupian3.jpg,upload/xiaoqumenjin_xiaoqutupian4.jpg','开放时间2'),(3,'2024-12-11 12:51:16','管理账号3','管理姓名3','小区名称3','小区地址3','13823888883','upload/xiaoqumenjin_xiaoqutupian3.jpg,upload/xiaoqumenjin_xiaoqutupian4.jpg,upload/xiaoqumenjin_xiaoqutupian5.jpg','开放时间3'),(4,'2024-12-11 12:51:16','管理账号4','管理姓名4','小区名称4','小区地址4','13823888884','upload/xiaoqumenjin_xiaoqutupian4.jpg,upload/xiaoqumenjin_xiaoqutupian5.jpg,upload/xiaoqumenjin_xiaoqutupian6.jpg','开放时间4'),(5,'2024-12-11 12:51:16','管理账号5','管理姓名5','小区名称5','小区地址5','13823888885','upload/xiaoqumenjin_xiaoqutupian5.jpg,upload/xiaoqumenjin_xiaoqutupian6.jpg,upload/xiaoqumenjin_xiaoqutupian7.jpg','开放时间5'),(6,'2024-12-11 12:51:16','管理账号6','管理姓名6','小区名称6','小区地址6','13823888886','upload/xiaoqumenjin_xiaoqutupian6.jpg,upload/xiaoqumenjin_xiaoqutupian7.jpg,upload/xiaoqumenjin_xiaoqutupian8.jpg','开放时间6'),(7,'2024-12-11 12:51:16','管理账号7','管理姓名7','小区名称7','小区地址7','13823888887','upload/xiaoqumenjin_xiaoqutupian7.jpg,upload/xiaoqumenjin_xiaoqutupian8.jpg,upload/xiaoqumenjin_xiaoqutupian1.jpg','开放时间7'),(8,'2024-12-11 12:51:16','管理账号8','管理姓名8','小区名称8','小区地址8','13823888888','upload/xiaoqumenjin_xiaoqutupian8.jpg,upload/xiaoqumenjin_xiaoqutupian1.jpg,upload/xiaoqumenjin_xiaoqutupian2.jpg','开放时间8');
/*!40000 ALTER TABLE `xiaoqumenjin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-11 21:24:19
