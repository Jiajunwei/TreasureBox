/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : db2

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2016-07-04 10:49:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `booktypes`
-- ----------------------------
DROP TABLE IF EXISTS `booktypes`;
CREATE TABLE `booktypes` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型编号',
  `typeName` varchar(100) NOT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of booktypes
-- ----------------------------
INSERT INTO `booktypes` VALUES ('1', '计算机软件开发');
INSERT INTO `booktypes` VALUES ('2', '计算机网络工程');
INSERT INTO `booktypes` VALUES ('3', '神话小说');
INSERT INTO `booktypes` VALUES ('4', '科幻小说');
INSERT INTO `booktypes` VALUES ('5', '外语');
INSERT INTO `booktypes` VALUES ('6', '测试类型');
INSERT INTO `booktypes` VALUES ('7', '91');
INSERT INTO `booktypes` VALUES ('8', '92');
INSERT INTO `booktypes` VALUES ('9', '93');
INSERT INTO `booktypes` VALUES ('91', '建筑设计');
INSERT INTO `booktypes` VALUES ('92', '工业设计');
INSERT INTO `booktypes` VALUES ('93', '船舶制造');