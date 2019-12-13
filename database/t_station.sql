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

 Date: 13/12/2019 19:12:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_station
-- ----------------------------
DROP TABLE IF EXISTS `t_station`;
CREATE TABLE `t_station`  (
  `station_id` int(11) NOT NULL AUTO_INCREMENT,
  `station_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lng` double(255, 6) NULL DEFAULT NULL,
  `lat` double(255, 6) NULL DEFAULT NULL,
  PRIMARY KEY (`station_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_station
-- ----------------------------
INSERT INTO `t_station` VALUES (1, '奥体中心', 116.400865, 39.983894);
INSERT INTO `t_station` VALUES (2, '昌平', 116.135233, 40.220661);
INSERT INTO `t_station` VALUES (3, '东四', 116.425171, 39.929562);
INSERT INTO `t_station` VALUES (4, '官园', 116.356819, 39.932774);
INSERT INTO `t_station` VALUES (5, '古城', 116.185036, 39.915345);
INSERT INTO `t_station` VALUES (6, '怀柔', 116.642349, 40.315704);
INSERT INTO `t_station` VALUES (7, '农展馆', 116.465138, 39.940522);
INSERT INTO `t_station` VALUES (8, '顺义', 116.654561, 40.130347);
INSERT INTO `t_station` VALUES (9, '天坛', 116.410829, 39.881913);
INSERT INTO `t_station` VALUES (10, '万柳', 116.298073, 39.967155);
INSERT INTO `t_station` VALUES (11, '万寿西宫', 116.368245, 39.879812);
INSERT INTO `t_station` VALUES (12, '定陵', 116.225759, 40.294843);

SET FOREIGN_KEY_CHECKS = 1;
