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

 Date: 30/10/2020 18:03:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for suncent_level_core
-- ----------------------------
DROP TABLE IF EXISTS `suncent_level_core`;
CREATE TABLE `suncent_level_core`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `core_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '隶属中心名称',
  `ctime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建时间',
  `mtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改时间',
  `cuser_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `muser_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of suncent_level_core
-- ----------------------------
INSERT INTO `suncent_level_core` VALUES ('1bf4db91-3716-40e2-b80b-4934fccd1725', '综合中心', '2020-10-30 11:58:29', NULL, NULL, NULL);
INSERT INTO `suncent_level_core` VALUES ('321b2e45-fcc6-4a1f-b8b8-3ca616d653f', '供应链中心', '2020-10-30 11:58:29', NULL, NULL, NULL);
INSERT INTO `suncent_level_core` VALUES ('5d49821f-4fb8-4c9f-9aa1-2d7d2921ac40', '总经办', '2020-10-30 11:58:29', NULL, NULL, NULL);
INSERT INTO `suncent_level_core` VALUES ('9121ef01-8c3f-4e20-984b-eedf52644313', '业务支持中心', '2020-10-30 11:58:29', NULL, NULL, NULL);
INSERT INTO `suncent_level_core` VALUES ('94439302-c6b9-482f-a21f-1e6a9d0aba56', '运营一中心', '2020-10-30 11:58:29', NULL, NULL, NULL);
INSERT INTO `suncent_level_core` VALUES ('a0a1f6d2-50a1-4fbd-9c53-ddde3be47211', '运营二中心', '2020-10-30 11:58:29', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
