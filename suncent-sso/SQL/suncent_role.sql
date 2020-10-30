/*
 Navicat Premium Data Transfer

 Source Server         : Localhost
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : suncent_ms

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 30/10/2020 18:03:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for suncent_role
-- ----------------------------
DROP TABLE IF EXISTS `suncent_role`;
CREATE TABLE `suncent_role`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of suncent_role
-- ----------------------------
INSERT INTO `suncent_role` VALUES ('0', '普通员工');
INSERT INTO `suncent_role` VALUES ('1', '管理员');
INSERT INTO `suncent_role` VALUES ('2', '超级管理员');

SET FOREIGN_KEY_CHECKS = 1;
