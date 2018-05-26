/*
SQLyog 企业版 - MySQL GUI v8.14
MySQL - 5.7.21-log : Database - user_message
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 如果存在这个数据库那么就删除这个数据库
drop database if exists user_message;


CREATE DATABASE `user_message` default character set utf8 collate utf8_general_ci;

USE `user_message`;

/*Table structure for table `user_mess` */

DROP TABLE IF EXISTS `user_mess`;

CREATE TABLE `user_mess` (
  `username` varchar(50) NOT NULL COMMENT '用户姓名',
  `password` varchar(6) NOT NULL COMMENT '用户密码',
  `id` int(10) NOT NULL COMMENT '用户学号',
  `e-mail` varchar(50) NOT NULL COMMENT '邮箱地址',
  `sex` char(1) DEFAULT NULL COMMENT '用户性别',
  `phone_number` int(11) NOT NULL COMMENT '用户手机号',
  `major` varchar(50) NOT NULL COMMENT '用户专业',
  `class_number` int(8) DEFAULT NULL COMMENT '用户班级代号',
  `study_direction` varchar(50) DEFAULT NULL COMMENT '用户学习方向',
  `age` int(3) DEFAULT NULL COMMENT '用户年龄',
  `birth` date DEFAULT NULL COMMENT '用户出生日期',
  `habit` varchar(50) DEFAULT NULL COMMENT '用户爱好',
  `state` int(1) NOT NULL DEFAULT '0' COMMENT '用户目前功能状态',
  PRIMARY KEY (`username`,`id`,`e-mail`,`phone_number`),
  index(username),
  index(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_mess` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
