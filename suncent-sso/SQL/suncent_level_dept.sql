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

 Date: 30/10/2020 18:03:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for suncent_level_dept
-- ----------------------------
DROP TABLE IF EXISTS `suncent_level_dept`;
CREATE TABLE `suncent_level_dept`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dept_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '部门名称',
  `ctime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建时间',
  `mtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改时间',
  `cuser_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `muser_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of suncent_level_dept
-- ----------------------------
INSERT INTO `suncent_level_dept` VALUES ('2b633c5f-dea2-4528-8a9f-bbe5720e49be', '推广部', '2020-10-30 12:12:54', NULL, NULL, NULL);
INSERT INTO `suncent_level_dept` VALUES ('36b598ca-11e4-4d59-8d11-e091050663b6', '仓储部', '2020-10-30 12:12:54', NULL, NULL, NULL);
INSERT INTO `suncent_level_dept` VALUES ('3ad6fd59-da0b-49c2-8345-4de4913e404f', '采购部', '2020-10-30 12:12:54', NULL, NULL, NULL);
INSERT INTO `suncent_level_dept` VALUES ('3adda1fa-6183-4545-be2c-9da692cc6265', 'Amazon运营部', '2020-10-30 12:12:54', NULL, NULL, NULL);
INSERT INTO `suncent_level_dept` VALUES ('526fb8c9-1e11-41c2-b443-057d54e0a485', '品质部', '2020-10-30 12:12:54', NULL, NULL, NULL);
INSERT INTO `suncent_level_dept` VALUES ('5db05092-a6e8-451e-83ce-aec107badbab', '产品部', '2020-10-30 12:12:54', NULL, NULL, NULL);
INSERT INTO `suncent_level_dept` VALUES ('6a07d45f-f138-4f76-8c36-c2624b16853d', '物流部', '2020-10-30 12:12:54', NULL, NULL, NULL);
INSERT INTO `suncent_level_dept` VALUES ('7409ad88-95f1-4053-a488-99cc48ea4f70', 'eBay运营部', '2020-10-30 12:12:54', NULL, NULL, NULL);
INSERT INTO `suncent_level_dept` VALUES ('8e44965f-b09c-4787-bb33-3b3e023f7e9a', '研发部', '2020-10-30 12:12:54', NULL, NULL, NULL);
INSERT INTO `suncent_level_dept` VALUES ('954a4c87-138d-4d32-a6dc-3f7eee7aadb8', '信息技术部', '2020-10-30 12:12:54', NULL, NULL, NULL);
INSERT INTO `suncent_level_dept` VALUES ('b25ce417-1e5b-4bff-a710-eb0538d339ae', 'Amazon客服部', '2020-10-30 12:12:54', NULL, NULL, NULL);
INSERT INTO `suncent_level_dept` VALUES ('c4664f03-8cca-4106-b7bd-19edfef6c639', '品牌部', '2020-10-30 12:12:54', NULL, NULL, NULL);
INSERT INTO `suncent_level_dept` VALUES ('c6b60ae1-41c5-46b4-8adf-76e0fd66482a', '设计部', '2020-10-30 12:12:54', NULL, NULL, NULL);
INSERT INTO `suncent_level_dept` VALUES ('d37e8dfe-cacf-4469-b9cb-4c8d3466f278', '总经办', '2020-10-30 12:12:54', NULL, NULL, NULL);
INSERT INTO `suncent_level_dept` VALUES ('e7f394b1-b00e-4e81-85be-a1968e798dd1', '计划部', '2020-10-30 12:12:54', NULL, NULL, NULL);
INSERT INTO `suncent_level_dept` VALUES ('f7a755d4-003e-4718-abba-b2ac684c10c2', '财务部', '2020-10-30 12:12:54', NULL, NULL, NULL);
INSERT INTO `suncent_level_dept` VALUES ('fa7550d8-5efa-4ce2-87e8-cbcadf0946a3', '人事行政部', '2020-10-30 12:12:54', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
