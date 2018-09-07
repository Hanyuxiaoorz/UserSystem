/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.21-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `user_mess` (
	`userName` varchar (150),
	`password` varchar (18),
	`id` double ,
	`e_mail` varchar (150),
	`sex` varchar (3),
	`phone_number` varchar (36),
	`major` varchar (150),
	`class_number` varchar (24),
	`study_direction` varchar (150),
	`age` double ,
	`birth` date ,
	`state` double ,
	`labelinfo` varchar (150)
); 
