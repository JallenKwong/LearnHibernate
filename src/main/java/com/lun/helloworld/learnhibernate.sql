/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50558
Source Host           : localhost:3306
Source Database       : learnhibernate

Target Server Type    : MYSQL
Target Server Version : 50558
File Encoding         : 65001

Date: 2018-09-01 22:25:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(32) NOT NULL DEFAULT '',
  `lastName` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('101', 'Max', 'Su');
INSERT INTO `employee` VALUES ('102', 'Max', 'Su');
INSERT INTO `employee` VALUES ('103', 'Max', 'Su');
INSERT INTO `employee` VALUES ('104', 'Max', 'Su');
INSERT INTO `employee` VALUES ('105', 'Max', 'Su');
INSERT INTO `employee` VALUES ('107', 'Max', 'Su');

-- ----------------------------
-- Table structure for `job`
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES ('1', 'Programmer');
