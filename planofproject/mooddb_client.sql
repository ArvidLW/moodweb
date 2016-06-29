/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : mooddb

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2016-06-28 21:33:05

clientmood 对应相应的用户ID，用户ID由向服务器注册后获得。

这样的话就只有注册了才能用

如果不注册就用的话，那么表名可以任意取一个，当用户注册登录后，再更新表名为ID名。
其中clientmood id属性可以不要(一个手机用户在本地对应一个数据表)。

心情推荐不用本地数据表
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for clientmood
-- ----------------------------
DROP TABLE IF EXISTS `clientmood`;
CREATE TABLE `clientmood` (
  `id` char(12) DEFAULT NULL,
  `mood` char(20) DEFAULT NULL,
  `reasontag` char(30) DEFAULT NULL,
  `reasondesc` char(255) DEFAULT NULL,
  `moodimage` char(60) DEFAULT NULL,
  `dateandtime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for clientuser
-- ----------------------------
DROP TABLE IF EXISTS `clientuser`;
CREATE TABLE `clientuser` (
  `id` char(12) DEFAULT NULL,
  `email` char(30) DEFAULT NULL,
  `phone` decimal(11,0) DEFAULT NULL,
  `name` char(20) DEFAULT NULL,
  `sex` enum('女','男') DEFAULT NULL,
  `location` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


