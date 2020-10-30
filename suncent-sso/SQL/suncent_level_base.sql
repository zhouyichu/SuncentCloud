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

 Date: 30/10/2020 18:03:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for suncent_level_base
-- ----------------------------
DROP TABLE IF EXISTS `suncent_level_base`;
CREATE TABLE `suncent_level_base`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `core_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `dept_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of suncent_level_base
-- ----------------------------
INSERT INTO `suncent_level_base` VALUES ('00e6d8cf-8a0a-4d44-81fb-8856946f6ff3', '321b2e45-fcc6-4a1f-b8b8-3ca616d653f', 'e7f394b1-b00e-4e81-85be-a1968e798dd1');
INSERT INTO `suncent_level_base` VALUES ('2e2fe379-8ad4-45c2-b4e8-a449b1504a08', '9121ef01-8c3f-4e20-984b-eedf52644313', '954a4c87-138d-4d32-a6dc-3f7eee7aadb8');
INSERT INTO `suncent_level_base` VALUES ('2ef8d3d8-8a0d-40e7-a35a-2d912746f0a9', '321b2e45-fcc6-4a1f-b8b8-3ca616d653f', '6a07d45f-f138-4f76-8c36-c2624b16853d');
INSERT INTO `suncent_level_base` VALUES ('4a6e5037-c673-4434-9416-bd3e50f9b9d7', '1bf4db91-3716-40e2-b80b-4934fccd1725', 'c4664f03-8cca-4106-b7bd-19edfef6c639');
INSERT INTO `suncent_level_base` VALUES ('5970cb73-ee0e-4e24-a47d-b465ce164fd6', 'a0a1f6d2-50a1-4fbd-9c53-ddde3be47211', '2b633c5f-dea2-4528-8a9f-bbe5720e49be');
INSERT INTO `suncent_level_base` VALUES ('5aa7c5ba-e75a-4aa4-bc37-46457d38807e', 'a0a1f6d2-50a1-4fbd-9c53-ddde3be47211', 'c6b60ae1-41c5-46b4-8adf-76e0fd66482a');
INSERT INTO `suncent_level_base` VALUES ('69bb1ace-7136-4872-a94c-ae2bc1e36b7e', '321b2e45-fcc6-4a1f-b8b8-3ca616d653f', '526fb8c9-1e11-41c2-b443-057d54e0a485');
INSERT INTO `suncent_level_base` VALUES ('7894421f-b328-4274-832f-f50220a2fbb1', '321b2e45-fcc6-4a1f-b8b8-3ca616d653f', '36b598ca-11e4-4d59-8d11-e091050663b6');
INSERT INTO `suncent_level_base` VALUES ('88c8ffb9-8f20-4d71-8413-8bf8287101c2', '1bf4db91-3716-40e2-b80b-4934fccd1725', '8e44965f-b09c-4787-bb33-3b3e023f7e9a');
INSERT INTO `suncent_level_base` VALUES ('8b65554f-887d-4dfb-9be5-c57c4badf889', '9121ef01-8c3f-4e20-984b-eedf52644313', 'f7a755d4-003e-4718-abba-b2ac684c10c2');
INSERT INTO `suncent_level_base` VALUES ('8f670a5f-0826-4e67-8d84-4ec7185d5c30', '94439302-c6b9-482f-a21f-1e6a9d0aba56', '3adda1fa-6183-4545-be2c-9da692cc6265');
INSERT INTO `suncent_level_base` VALUES ('9015eb5e-4c0d-457b-a24c-a7a52802ca18', '94439302-c6b9-482f-a21f-1e6a9d0aba56', 'b25ce417-1e5b-4bff-a710-eb0538d339ae');
INSERT INTO `suncent_level_base` VALUES ('941e4d18-74e8-4b52-9eaa-ffc2ebf27ba6', '1bf4db91-3716-40e2-b80b-4934fccd1725', 'fa7550d8-5efa-4ce2-87e8-cbcadf0946a3');
INSERT INTO `suncent_level_base` VALUES ('96611aad-22ec-4d31-aa08-3f917fd54faa', '321b2e45-fcc6-4a1f-b8b8-3ca616d653f', '3ad6fd59-da0b-49c2-8345-4de4913e404f');
INSERT INTO `suncent_level_base` VALUES ('b1ead16b-4727-4bd6-ad25-aa902da7543c', '5d49821f-4fb8-4c9f-9aa1-2d7d2921ac40', 'd37e8dfe-cacf-4469-b9cb-4c8d3466f278');
INSERT INTO `suncent_level_base` VALUES ('b3072fc7-2817-4f73-8835-450292372095', '1bf4db91-3716-40e2-b80b-4934fccd1725', '5db05092-a6e8-451e-83ce-aec107badbab');
INSERT INTO `suncent_level_base` VALUES ('cb4d5463-90ea-4bb7-a5e3-da030b1337c3', 'a0a1f6d2-50a1-4fbd-9c53-ddde3be47211', '7409ad88-95f1-4053-a488-99cc48ea4f70');

SET FOREIGN_KEY_CHECKS = 1;
