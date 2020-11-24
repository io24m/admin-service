/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : admin_service

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2020-11-24 14:04:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_test
-- ----------------------------
DROP TABLE IF EXISTS `sys_test`;
CREATE TABLE `sys_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_test
-- ----------------------------
INSERT INTO `sys_test` VALUES ('1', 'a', 'e');
INSERT INTO `sys_test` VALUES ('2', 'b', 'c');
INSERT INTO `sys_test` VALUES ('3', 'qq', 'ww');
INSERT INTO `sys_test` VALUES ('4', 'qwqw', 'wqwqw');
INSERT INTO `sys_test` VALUES ('5', 'ewqe', 'ewq');
INSERT INTO `sys_test` VALUES ('6', 'ewq', null);
INSERT INTO `sys_test` VALUES ('7', 'wq', null);
INSERT INTO `sys_test` VALUES ('8', 'ewq', null);
INSERT INTO `sys_test` VALUES ('9', 'wqewq', null);
INSERT INTO `sys_test` VALUES ('10', 'ewqewq', null);
INSERT INTO `sys_test` VALUES ('11', 'ewqeqw', null);
INSERT INTO `sys_test` VALUES ('12', '1', null);
INSERT INTO `sys_test` VALUES ('13', '2', null);
INSERT INTO `sys_test` VALUES ('14', '3', null);
INSERT INTO `sys_test` VALUES ('15', '4', null);
INSERT INTO `sys_test` VALUES ('16', '5', null);
INSERT INTO `sys_test` VALUES ('17', '6', null);
INSERT INTO `sys_test` VALUES ('18', '7', null);
INSERT INTO `sys_test` VALUES ('19', '8', null);
INSERT INTO `sys_test` VALUES ('20', '9', null);
INSERT INTO `sys_test` VALUES ('21', '10', null);
