/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 80035
Source Host           : localhost:3306
Source Database       : movie

Target Server Type    : MYSQL
Target Server Version : 80035
File Encoding         : 65001

Date: 2024-02-02 19:50:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `movies`
-- ----------------------------
DROP TABLE IF EXISTS `movies`;
CREATE TABLE `movies` (
  `name` varchar(10) NOT NULL,
  `introduction` varchar(30) DEFAULT NULL,
  `actor` varchar(20) DEFAULT NULL,
  `score` float(20,0) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of movies
-- ----------------------------
INSERT INTO `movies` VALUES ('海王', '不错', '杰森·莫玛:海王/亚瑟·库瑞,艾梅柏', '7');

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `username` varchar(10) NOT NULL,
  `introduction` varchar(20) DEFAULT NULL,
  `watch` int DEFAULT NULL,
  `commont` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('aaaaaa', 'vsdvsdvsd', '1', 'vsdvsvss');
INSERT INTO `person` VALUES ('bbbbbb', '开朗', '1', '不错');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `nickname` varchar(10) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `user_pic` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'dsfdcsc', '3f571ab24d54baf70b44bb4ce6c88214', null, null, null, '2024-01-23 17:29:59', '2024-01-23 17:29:59');
INSERT INTO `user` VALUES ('2', 'yang', '3f571ab24d54baf70b44bb4ce6c88214', null, null, null, '2024-01-23 17:37:25', '2024-01-23 17:37:25');
INSERT INTO `user` VALUES ('3', 'dfgds', '5ba57e3720f9bf6bcc9c5f987916b050', null, null, null, '2024-01-23 20:04:50', '2024-01-23 20:04:50');
INSERT INTO `user` VALUES ('4', 'aaaaaa', '96e79218965eb72c92a549dd5a330112', null, null, 'https://img2.baidu.com/it/u=3818990727,912341063&fm=253&fmt=auto&app=120&f=JPEG?w=1422&h=800', '2024-01-24 00:04:56', '2024-02-01 23:38:36');
INSERT INTO `user` VALUES ('5', 'sddcsv', 'edf0edf194a0ceaf25be5da9de3424cc', null, null, null, '2024-01-24 00:27:46', '2024-01-24 00:27:46');
INSERT INTO `user` VALUES ('6', 'leichao', '96e79218965eb72c92a549dd5a330112', null, null, null, '2024-01-24 00:30:56', '2024-01-24 00:30:56');
INSERT INTO `user` VALUES ('7', 'qqqqqq', '96e79218965eb72c92a549dd5a330112', 'sdfgsd', null, 'https://t7.baidu.com/it/u=1595072465,3644073269&fm=193&f=GIF', '2024-01-24 11:45:36', '2024-01-24 17:05:33');
INSERT INTO `user` VALUES ('8', 'sdcsdc', '9fa54bcd8f674b54ef45a73f0427492d', null, null, 'https://t7.baidu.com/it/u=1595072465,3644073269&fm=193&f=GIF', '2024-01-30 23:05:32', '2024-01-31 19:28:03');
INSERT INTO `user` VALUES ('9', 'sdcssdcc', '9fa54bcd8f674b54ef45a73f0427492d', null, null, null, '2024-01-31 23:52:43', '2024-01-31 23:52:43');
INSERT INTO `user` VALUES ('10', 'sdcdfvffd', '9fa54bcd8f674b54ef45a73f0427492d', null, null, null, '2024-02-01 00:28:01', '2024-02-01 00:28:01');
INSERT INTO `user` VALUES ('11', 'sghcghv', '9fa54bcd8f674b54ef45a73f0427492d', null, null, null, '2024-02-01 23:27:46', '2024-02-01 23:27:46');
INSERT INTO `user` VALUES ('12', 'bbbbbb', '96e79218965eb72c92a549dd5a330112', null, null, 'https://img2.baidu.com/it/u=3818990727,912341063&fm=253&fmt=auto&app=120&f=JPEG?w=1422&h=800', '2024-02-01 23:41:55', '2024-02-01 23:45:58');
INSERT INTO `user` VALUES ('13', 'hgcgghc', '96e79218965eb72c92a549dd5a330112', null, null, null, '2024-02-01 23:45:19', '2024-02-01 23:45:19');
