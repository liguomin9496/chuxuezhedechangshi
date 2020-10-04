/*
Navicat MySQL Data Transfer

Source Server         : test_connection
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : mysqlforonlinemall

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2020-06-19 10:29:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `oid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` double(5,0) NOT NULL,
  `flag` varchar(100) NOT NULL,
  `count` int NOT NULL,
  `orderDate` datetime NOT NULL,
  `orderCustomer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id` varchar(10) NOT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('O2', '黑人亮白牙膏', '25', '1', '2', '2020-06-18 10:49:03', '李国民', '6');
INSERT INTO `cart` VALUES ('O3', '医用外科口罩', '50', '2', '2', '2020-06-17 10:49:59', '李国民', '7');

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `id` varchar(5) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` float(5,2) NOT NULL,
  `count` double(5,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES ('1', 'NYX 16色眼影 | WARM NEUTRALS', '200.00', '5');
INSERT INTO `commodity` VALUES ('2', '再长 3 英寸护发素 250ML', '167.20', '12');
INSERT INTO `commodity` VALUES ('3', '再长 3 英寸保健大梳', '154.00', '33');
INSERT INTO `commodity` VALUES ('4', '天师大纪念品', '10.00', '100');
INSERT INTO `commodity` VALUES ('6', '黑人亮白牙膏', '25.00', '50');
INSERT INTO `commodity` VALUES ('7', '医用外科口罩', '50.00', '50');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `username` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `passward` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('123', '321', '5758@qq.com', '22', '1999-01-14 00:00:00', '四川省巴中市');
INSERT INTO `userinfo` VALUES ('125', '125', null, null, null, null);
INSERT INTO `userinfo` VALUES ('root1', '1toor', '848980832@qq.com', '20', '1999-01-14 00:00:00', '巴中市');
INSERT INTO `userinfo` VALUES ('zhy', '211985', null, null, null, null);
INSERT INTO `userinfo` VALUES ('李国民', '211985', '848980834@qq.com', '10', '1999-01-14 00:00:00', '四川省巴中市恩阳区');
