/*
Navicat MySQL Data Transfer

Source Server         : 个人外网服务器
Source Server Version : 50642
Source Host           : shihu19860215.6655.la:3306
Source Database       : db_city1

Target Server Type    : MYSQL
Target Server Version : 50642
File Encoding         : 65001

Date: 2019-02-15 10:28:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_city0`
-- ----------------------------
DROP TABLE IF EXISTS `t_city0`;
CREATE TABLE `t_city0` (
  `id` bigint(20) NOT NULL,
  `city_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_city0
-- ----------------------------

-- ----------------------------
-- Table structure for `t_city1`
-- ----------------------------
DROP TABLE IF EXISTS `t_city1`;
CREATE TABLE `t_city1` (
  `id` bigint(20) NOT NULL,
  `city_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_city1
-- ----------------------------
