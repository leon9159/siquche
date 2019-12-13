/*
 Navicat Premium Data Transfer

 Source Server         : liang
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : weathertest

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 13/12/2019 19:10:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_data
-- ----------------------------
DROP TABLE IF EXISTS `t_data`;
CREATE TABLE `t_data`  (
  `No` int(255) NULL DEFAULT NULL,
  `year` int(255) NULL DEFAULT NULL,
  `month` int(255) NULL DEFAULT NULL,
  `day` int(255) NULL DEFAULT NULL,
  `hour` int(255) NULL DEFAULT NULL,
  `PM25` double(255, 0) NULL DEFAULT NULL,
  `PM10` double(255, 0) NULL DEFAULT NULL,
  `SO2` double(255, 0) NULL DEFAULT NULL,
  `NO2` double(255, 0) NULL DEFAULT NULL,
  `CO` double(255, 0) NULL DEFAULT NULL,
  `O3` double(255, 0) NULL DEFAULT NULL,
  `TEMP` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PRES` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DEWP` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `RAIN` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `WSPM` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `station` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_data
-- ----------------------------
INSERT INTO `t_data` VALUES (1, 2013, 3, 1, 0, 4, 4, 4, 7, 300, 77, '-0.7', '1023', '-18.8', '0', 'NNW', '4.4', 'Aotizhongxin');
INSERT INTO `t_data` VALUES (2, 2013, 3, 1, 1, 8, 8, 4, 7, 300, 77, '-1.1', '1023.2', '-18.2', '0', 'N', '4.7', 'Aotizhongxin');
INSERT INTO `t_data` VALUES (3, 2013, 3, 1, 2, 7, 7, 5, 10, 300, 73, '-1', '1023', '-18', '0', 'NNW', '6', 'Aotizhongxin');
INSERT INTO `t_data` VALUES (4, 2013, 3, 1, 3, 6, 6, 11, 11, 300, 72, '-1', '1024', '-19', '0', 'NW', '3', 'Aotizhongxin');
INSERT INTO `t_data` VALUES (5, 2013, 3, 1, 4, 3, 3, 12, 12, 300, 72, '-2', '1025', '-20', '0', 'N', '2', 'Aotizhongxin');
INSERT INTO `t_data` VALUES (6, 2013, 3, 1, 5, 5, 5, 18, 18, 400, 66, '-2', '1026', '-20', '0', 'N', '4', 'Aotizhongxin');
INSERT INTO `t_data` VALUES (7, 2013, 3, 1, 6, 3, 3, 18, 32, 500, 50, '-3', '1026', '-19', '0', 'NNE', '2', 'Aotizhongxin');
INSERT INTO `t_data` VALUES (8, 2013, 3, 1, 7, 3, 6, 19, 41, 500, 43, '-2', '1027', '-19', '0', 'NNW', '4', 'Aotizhongxin');
INSERT INTO `t_data` VALUES (9, 2013, 3, 1, 8, 3, 6, 16, 43, 500, 45, '0', '1028', '-19', '0', 'NNW', '4', 'Aotizhongxin');
INSERT INTO `t_data` VALUES (11, 2013, 3, 1, 10, 3, 6, 9, 12, 400, 72, '2', '1028', '-19', '0', 'NNW', '4', 'Aotizhongxin');

SET FOREIGN_KEY_CHECKS = 1;
