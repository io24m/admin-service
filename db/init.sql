/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.12 : Database - admin_service
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(128) NOT NULL,
  `enable` tinyint(1) DEFAULT '1',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `sys_role` */

/*Table structure for table `sys_test` */

DROP TABLE IF EXISTS `sys_test`;

CREATE TABLE `sys_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `sys_test` */

insert  into `sys_test`(`id`,`name`,`remark`) values (1,'a','e'),(2,'b','c'),(3,'qq','ww'),(4,'qwqw','wqwqw'),(5,'ewqe','ewq'),(6,'ewq',NULL),(7,'wq',NULL),(8,'ewq',NULL),(9,'wqewq',NULL),(10,'ewqewq',NULL),(11,'ewqeqw',NULL),(12,'1',NULL),(13,'2',NULL),(14,'3',NULL),(15,'4',NULL),(16,'5',NULL),(17,'6',NULL),(18,'7',NULL),(19,'8',NULL),(20,'9',NULL),(21,'10',NULL);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(32) NOT NULL,
  `password` varchar(512) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  `sys_user` tinyint(1) DEFAULT '0',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`account`,`password`,`name`,`enable`,`sys_user`,`create_time`) values (1,'test','5f329d3ac22671f7b214c461e58c27f3','testname',1,0,'2020-12-10 14:51:30'),(2,'test1','12345','testname1',0,1,'2020-12-11 14:17:44');

/*Table structure for table `validate_class` */

DROP TABLE IF EXISTS `validate_class`;

CREATE TABLE `validate_class` (
  `class_type` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `class_name` varchar(128) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '1',
  `remark` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`class_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `validate_class` */

insert  into `validate_class`(`class_type`,`class_name`,`status`,`remark`) values ('com.github.io24m.adminservice.module.validate.Person','个人信息',1,NULL),('com.github.io24m.adminservice.module.validate.Person1','个人信息1',1,NULL);

/*Table structure for table `validate_file_config` */

DROP TABLE IF EXISTS `validate_file_config`;

CREATE TABLE `validate_file_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_type` varchar(512) DEFAULT NULL,
  `file_key` varchar(128) DEFAULT NULL,
  `validate_type` varchar(128) DEFAULT NULL,
  `check` tinyint(1) DEFAULT '1',
  `pass` tinyint(1) DEFAULT '0',
  `error_message` varchar(2014) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `validate_file_config` */

insert  into `validate_file_config`(`id`,`class_type`,`file_key`,`validate_type`,`check`,`pass`,`error_message`) values (1,'com.github.io24m.adminservice.module.validate.Person','name','empty',0,0,'error:name empty'),(2,'com.github.io24m.adminservice.module.validate.Person','age','empty',1,1,'error:age empty'),(3,'com.github.io24m.adminservice.module.validate.Person1','name','dict',1,0,'error:name dict');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
