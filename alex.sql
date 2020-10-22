/*
Navicat MySQL Data Transfer

Source Server         : 哈哈
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : alex

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-23 00:21:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_person
-- ----------------------------
DROP TABLE IF EXISTS `t_person`;
CREATE TABLE `t_person` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `person_name` varchar(100) DEFAULT NULL,
  `person_age` int(11) DEFAULT NULL,
  `person_sex` int(11) DEFAULT NULL,
  `person_mobile` varchar(30) DEFAULT NULL,
  `person_birthday` datetime DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_person
-- ----------------------------
INSERT INTO `t_person` VALUES ('53', 'ulllll', '12', '1', '2121212', '2020-10-22 00:35:25');
INSERT INTO `t_person` VALUES ('54', 'zhi', '12', '1', '2121212', '2020-10-22 00:35:29');
INSERT INTO `t_person` VALUES ('55', '丫丫', '12', '1', '2121212', '2020-10-22 00:35:34');
INSERT INTO `t_person` VALUES ('56', '丫丫', '12', '1', '2121212', '2020-10-22 00:35:36');
INSERT INTO `t_person` VALUES ('58', '丫丫', '12', '1', '2121212', '2020-10-22 00:35:41');
INSERT INTO `t_person` VALUES ('59', '丫丫', '12', '1', '2121212', '2020-10-22 11:49:32');
INSERT INTO `t_person` VALUES ('61', 'admin', '13', '0', '13221321', '2020-02-27 00:00:00');
