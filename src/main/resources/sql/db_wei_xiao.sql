/*
 Navicat Premium Data Transfer

 Source Server         : huaisun
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : db_wei_xiao

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 19/03/2019 12:59:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_employ
-- ----------------------------
DROP TABLE IF EXISTS `t_employ`;
CREATE TABLE `t_employ`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序列',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '手机',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '邮箱',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '登陆密码',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '居住地址',
  `head` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '头像地址',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `valid` int(1) NULL DEFAULT NULL COMMENT '是否禁用该员工',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_employ
-- ----------------------------
INSERT INTO `t_employ` VALUES (1, 'admin', '18855036835', 'admin@gmail.com', 'admin', 'admin', '../static/images/icon/admin.jpg', '2019-03-13 18:34:28', 0);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` int(11) NOT NULL COMMENT '标识符',
  `uId` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `mode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付方式',
  `valid` int(11) NULL DEFAULT NULL COMMENT '是否有效',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单个价格',
  `count` int(11) NULL DEFAULT NULL COMMENT '数量',
  `cost` decimal(10, 2) NULL DEFAULT NULL COMMENT '总费用',
  `payment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '折后费用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标识符',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '姓名',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱地址',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '手机号',
  `integral` decimal(10, 2) NULL DEFAULT NULL COMMENT '积分',
  `balance` decimal(10, 2) NULL DEFAULT NULL COMMENT '余额',
  `cost` decimal(10, 2) NULL DEFAULT NULL COMMENT '共消费',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10002 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (10001, '花儿', 'srg.lch@outlook.com', '18855036835', 99999.99, 9999.99, 99999.99, '2019-03-14 09:30:08');

SET FOREIGN_KEY_CHECKS = 1;
