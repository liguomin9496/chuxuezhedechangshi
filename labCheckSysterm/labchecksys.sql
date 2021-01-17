/*
Navicat MySQL Data Transfer

Source Server         : lgm9496
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : labchecksys

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2021-01-16 14:24:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for day_check
-- ----------------------------
DROP TABLE IF EXISTS `day_check`;
CREATE TABLE `day_check` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `checker` bigint DEFAULT NULL COMMENT '检查者的id',
  `check_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '检查时间',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '检查单位',
  `check_object` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '检查对象',
  `danger` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '存在的隐患',
  `suggestions` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '整改意见',
  `reform_principal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '整改责任人',
  `reform_measure` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '整改措施',
  `reform_time` datetime DEFAULT NULL COMMENT '整改时间',
  `accepter` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '验收人',
  `acc_results` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '验收结果',
  `acc_time` datetime DEFAULT NULL COMMENT '验收时间',
  `school_result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学校复核结果',
  `school_time` datetime DEFAULT NULL COMMENT '学校复核时间',
  `is_danger` int NOT NULL COMMENT '是否有安全隐患  0 安全 1 不安全',
  `stage` int NOT NULL COMMENT '信息传递的阶段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of day_check
-- ----------------------------
INSERT INTO `day_check` VALUES ('29', '2', '2021-01-07 21:57:14.109', '软件学院', 'BL101', '机房电源线路老化严重', '更换线路', 'lgm', '全面更换实验室机房电源线路', '2021-01-08 15:44:03', 'hyx', '整改措施到位，验收合格', '2021-01-08 15:51:01', '整改措施到位，验收结果准确，学校复核通过', '2021-01-08 16:02:04', '1', '6');
INSERT INTO `day_check` VALUES ('30', '2', '2021-01-07 21:57:18.204', '软件学院', 'BL101', '机房电源线路老化严重', '更换线路', null, null, null, null, null, null, null, null, '1', '2');
INSERT INTO `day_check` VALUES ('31', '2', '2021-01-07 22:02:22.189', '软件学院', 'BL101', '无安全隐患', '无整改措施', null, null, null, null, null, null, null, null, '0', '6');
INSERT INTO `day_check` VALUES ('32', '2', null, '软件学院', 'BL101', '机房地板塌陷', '机房地板更换', 'lgm', null, null, null, null, '2021-01-08 19:58:03', null, null, '1', '3');

-- ----------------------------
-- Table structure for lab
-- ----------------------------
DROP TABLE IF EXISTS `lab`;
CREATE TABLE `lab` (
  `lab_id` bigint NOT NULL AUTO_INCREMENT COMMENT '实验室id',
  `lab_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '实验室名称',
  `lab_user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '实验室使用者id',
  `lab_department` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '实验室所属单位',
  `lab_safer_id` bigint DEFAULT NULL COMMENT '实验室安全负责人id',
  `lab_area` bigint NOT NULL COMMENT '实验室面积',
  PRIMARY KEY (`lab_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of lab
-- ----------------------------
INSERT INTO `lab` VALUES ('1', 'MA101', '1 2', '计算机与信息工程学院', '1', '20');
INSERT INTO `lab` VALUES ('2', 'BL101', '1 2', '软件学院', '2', '30');
INSERT INTO `lab` VALUES ('3', 'BL403', '1 2', '软件学院', '3', '30');

-- ----------------------------
-- Table structure for lab_function
-- ----------------------------
DROP TABLE IF EXISTS `lab_function`;
CREATE TABLE `lab_function` (
  `function_id` bigint NOT NULL AUTO_INCREMENT,
  `function_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`function_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of lab_function
-- ----------------------------
INSERT INTO `lab_function` VALUES ('1', 'lab_apply');
INSERT INTO `lab_function` VALUES ('2', 'day_check_m');
INSERT INTO `lab_function` VALUES ('3', 'day_check_n');
INSERT INTO `lab_function` VALUES ('4', 'look_danger');
INSERT INTO `lab_function` VALUES ('5', 'check_danger');
INSERT INTO `lab_function` VALUES ('6', 'accept_danger');
INSERT INTO `lab_function` VALUES ('7', 'notice');
INSERT INTO `lab_function` VALUES ('8', 'start_check');
INSERT INTO `lab_function` VALUES ('9', 'look_check');
INSERT INTO `lab_function` VALUES ('10', 'start_specialcheck');
INSERT INTO `lab_function` VALUES ('11', 'start_report');
INSERT INTO `lab_function` VALUES ('12', 'check_report');
INSERT INTO `lab_function` VALUES ('13', 'look_report');
INSERT INTO `lab_function` VALUES ('14', 'send_message');
INSERT INTO `lab_function` VALUES ('15', 'check_message');
INSERT INTO `lab_function` VALUES ('16', 'check_lab_apply');
INSERT INTO `lab_function` VALUES ('17', 'check_lab_safer');
INSERT INTO `lab_function` VALUES ('18', 'update_lab_infom');

-- ----------------------------
-- Table structure for lab_hidden_danger_rectification
-- ----------------------------
DROP TABLE IF EXISTS `lab_hidden_danger_rectification`;
CREATE TABLE `lab_hidden_danger_rectification` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '表格序号',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '检查人',
  `check_time` datetime DEFAULT NULL COMMENT '检查时间',
  `lab_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '检查对象',
  `department` varchar(255) DEFAULT NULL,
  `existing_danger` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '存在的隐患',
  `rectification_measures` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '整改措施',
  `rectification_person` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '整改负责人',
  `refinish_time` datetime DEFAULT NULL COMMENT '整改完成时间',
  `test_person` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '验收人',
  `test_time` datetime DEFAULT NULL COMMENT '验收时间',
  `is_finish` int DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of lab_hidden_danger_rectification
-- ----------------------------
INSERT INTO `lab_hidden_danger_rectification` VALUES ('56', 'bobo', '2020-12-30 14:56:26', 'MA101', '化学学院', '有机废液', '人工处理', 'bobo', '2020-01-02 14:56:26', '黄义雄', '2020-01-03 14:56:26', '0');
INSERT INTO `lab_hidden_danger_rectification` VALUES ('57', 'bobo', '2020-12-30 15:04:29', 'BL101', '软件学院', 'EB胶沾染物', null, null, null, null, null, '1');
INSERT INTO `lab_hidden_danger_rectification` VALUES ('58', 'hyx', '2020-12-31 15:05:44', 'MB101', '软件学院', '设备损坏', '人工处理', 'hyx', '2020-01-02 15:05:44', '黄义雄', '2020-01-03 15:05:44', '0');
INSERT INTO `lab_hidden_danger_rectification` VALUES ('59', 'hyx', '2021-01-07 21:57:14', 'BL101', '软件学院', '机房电源线路老化严重', '全面更换实验室机房电源线路', 'lgm', '2021-01-08 15:44:03', 'hyx', '2021-01-08 15:51:01', '0');
INSERT INTO `lab_hidden_danger_rectification` VALUES ('60', 'hyx', '2021-01-07 21:57:18', 'BL101', '软件学院', '机房电源线路老化严重', null, null, null, null, null, '1');

-- ----------------------------
-- Table structure for lab_month_report
-- ----------------------------
DROP TABLE IF EXISTS `lab_month_report`;
CREATE TABLE `lab_month_report` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `department` varchar(255) DEFAULT NULL,
  `lab_name` varchar(255) DEFAULT NULL,
  `check_time` datetime DEFAULT NULL,
  `existing_danger` varchar(255) DEFAULT NULL,
  `rectification_measures` varchar(255) DEFAULT NULL,
  `refinish_time` datetime DEFAULT NULL,
  `is_finish` int DEFAULT NULL,
  `is_examine` int DEFAULT NULL,
  `is_review` int DEFAULT NULL,
  `suggestion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of lab_month_report
-- ----------------------------
INSERT INTO `lab_month_report` VALUES ('12', '化学学院', 'MA101', '2020-12-30 14:56:26', '有机废液', '人工处理', '2020-01-02 14:56:26', '0', '0', '0', '请输入处理意见');
INSERT INTO `lab_month_report` VALUES ('13', '软件学院', 'BL101', '2020-12-30 15:04:29', 'EB胶沾染物', null, null, '1', '0', '0', '请输入处理意见');
INSERT INTO `lab_month_report` VALUES ('14', '软件学院', 'MB101', '2020-12-31 15:05:44', '设备损坏', '人工处理', '2020-01-02 15:05:44', '0', '0', '0', '请输入处理意见');
INSERT INTO `lab_month_report` VALUES ('15', '化学学院', 'BL101', '2021-01-07 21:57:14', '机房电源线路老化严重', '全面更换实验室机房电源线路', '2021-01-08 15:44:03', '0', '0', '0', '请输入处理意见');
INSERT INTO `lab_month_report` VALUES ('16', '软件学院', 'BL101', '2021-01-07 21:57:18', '机房电源线路老化严重', null, null, '1', '0', '0', '请输入处理意见');
INSERT INTO `lab_month_report` VALUES ('17', '软件学院', 'BL101', '2021-01-08 22:02:22', '机房地板塌陷', null, null, '1', '1', '1', '换新房顶');

-- ----------------------------
-- Table structure for lab_reform_note
-- ----------------------------
DROP TABLE IF EXISTS `lab_reform_note`;
CREATE TABLE `lab_reform_note` (
  `check_id` int NOT NULL COMMENT '天津师范大学实验室安全整改通知书',
  `check_obj` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `danger` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `reform_suggestions` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `reform_time` datetime DEFAULT NULL,
  PRIMARY KEY (`check_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of lab_reform_note
-- ----------------------------
INSERT INTO `lab_reform_note` VALUES ('0', null, null, null, null);
INSERT INTO `lab_reform_note` VALUES ('22', 'BL101', '无', '无', '2021-01-17 00:36:19');

-- ----------------------------
-- Table structure for lab_relationlist
-- ----------------------------
DROP TABLE IF EXISTS `lab_relationlist`;
CREATE TABLE `lab_relationlist` (
  `lab_id` bigint NOT NULL AUTO_INCREMENT,
  `department_manager_id` bigint NOT NULL COMMENT '单位安全管理员id',
  `department_leader_id` bigint NOT NULL COMMENT '单位分管领导',
  `system_manager_id` bigint NOT NULL COMMENT '系统管理员',
  PRIMARY KEY (`lab_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of lab_relationlist
-- ----------------------------
INSERT INTO `lab_relationlist` VALUES ('2', '2', '10', '11');

-- ----------------------------
-- Table structure for lab_role
-- ----------------------------
DROP TABLE IF EXISTS `lab_role`;
CREATE TABLE `lab_role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of lab_role
-- ----------------------------
INSERT INTO `lab_role` VALUES ('1', '学生');
INSERT INTO `lab_role` VALUES ('2', '老师');
INSERT INTO `lab_role` VALUES ('3', '实验室安全负责人');
INSERT INTO `lab_role` VALUES ('4', '单位安全管理员');
INSERT INTO `lab_role` VALUES ('5', '单位分管领导');
INSERT INTO `lab_role` VALUES ('6', '系统管理员');
INSERT INTO `lab_role` VALUES ('7', '督察员');

-- ----------------------------
-- Table structure for lab_user
-- ----------------------------
DROP TABLE IF EXISTS `lab_user`;
CREATE TABLE `lab_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of lab_user
-- ----------------------------
INSERT INTO `lab_user` VALUES ('1', 'bobo', 'bobo', '计算机与信息工程学院');
INSERT INTO `lab_user` VALUES ('2', 'hyx', 'hyx', '软件学院');
INSERT INTO `lab_user` VALUES ('3', 'h', '1', '软件学院');
INSERT INTO `lab_user` VALUES ('4', '1', 'h', '软件学院');
INSERT INTO `lab_user` VALUES ('5', 'h1', 'h1', '软件学院');
INSERT INTO `lab_user` VALUES ('8', '1', '1', '软件学院');
INSERT INTO `lab_user` VALUES ('9', 'a', 'a', '软件学院');
INSERT INTO `lab_user` VALUES ('10', 'lgm', 'lgm', '软件学院');
INSERT INTO `lab_user` VALUES ('11', 'lgm1', 'lgm1', '国资处');

-- ----------------------------
-- Table structure for role_auth
-- ----------------------------
DROP TABLE IF EXISTS `role_auth`;
CREATE TABLE `role_auth` (
  `role_id` bigint NOT NULL,
  `auth_id` bigint NOT NULL,
  KEY `FKpmfrg31fbxhvv67ph5xt8l1l3` (`auth_id`) USING BTREE,
  KEY `FKfmnlri6s4sske6fpq7vcqy2bw` (`role_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of role_auth
-- ----------------------------
INSERT INTO `role_auth` VALUES ('1', '1');
INSERT INTO `role_auth` VALUES ('1', '2');
INSERT INTO `role_auth` VALUES ('1', '3');
INSERT INTO `role_auth` VALUES ('1', '9');
INSERT INTO `role_auth` VALUES ('1', '14');
INSERT INTO `role_auth` VALUES ('1', '15');
INSERT INTO `role_auth` VALUES ('2', '1');
INSERT INTO `role_auth` VALUES ('2', '2');
INSERT INTO `role_auth` VALUES ('2', '3');
INSERT INTO `role_auth` VALUES ('2', '9');
INSERT INTO `role_auth` VALUES ('2', '14');
INSERT INTO `role_auth` VALUES ('2', '15');
INSERT INTO `role_auth` VALUES ('3', '4');
INSERT INTO `role_auth` VALUES ('3', '5');
INSERT INTO `role_auth` VALUES ('3', '6');
INSERT INTO `role_auth` VALUES ('3', '7');
INSERT INTO `role_auth` VALUES ('3', '9');
INSERT INTO `role_auth` VALUES ('3', '14');
INSERT INTO `role_auth` VALUES ('3', '15');
INSERT INTO `role_auth` VALUES ('3', '16');
INSERT INTO `role_auth` VALUES ('4', '8');
INSERT INTO `role_auth` VALUES ('4', '9');
INSERT INTO `role_auth` VALUES ('4', '11');
INSERT INTO `role_auth` VALUES ('4', '14');
INSERT INTO `role_auth` VALUES ('4', '15');
INSERT INTO `role_auth` VALUES ('5', '5');
INSERT INTO `role_auth` VALUES ('5', '6');
INSERT INTO `role_auth` VALUES ('5', '8');
INSERT INTO `role_auth` VALUES ('5', '12');
INSERT INTO `role_auth` VALUES ('5', '14');
INSERT INTO `role_auth` VALUES ('5', '15');
INSERT INTO `role_auth` VALUES ('5', '17');
INSERT INTO `role_auth` VALUES ('6', '9');
INSERT INTO `role_auth` VALUES ('6', '10');
INSERT INTO `role_auth` VALUES ('6', '4');
INSERT INTO `role_auth` VALUES ('6', '7');
INSERT INTO `role_auth` VALUES ('6', '12');
INSERT INTO `role_auth` VALUES ('6', '13');
INSERT INTO `role_auth` VALUES ('7', '4');
INSERT INTO `role_auth` VALUES ('7', '9');
INSERT INTO `role_auth` VALUES ('7', '13');
INSERT INTO `role_auth` VALUES ('7', '15');
INSERT INTO `role_auth` VALUES ('5', '18');
INSERT INTO `role_auth` VALUES ('6', '18');

-- ----------------------------
-- Table structure for spot_check
-- ----------------------------
DROP TABLE IF EXISTS `spot_check`;
CREATE TABLE `spot_check` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `checker` bigint DEFAULT NULL COMMENT '检查者的id',
  `check_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '检查时间',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '检查单位',
  `check_object` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '检查对象',
  `danger` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '存在的隐患',
  `suggestions` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '整改意见',
  `reform_principal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '整改责任人',
  `reform_measure` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '整改措施',
  `reform_time` datetime DEFAULT NULL COMMENT '整改时间',
  `accepter` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '验收人',
  `acc_results` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '验收结果',
  `acc_time` datetime DEFAULT NULL COMMENT '验收时间',
  `school_result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学校复核结果',
  `school_time` datetime DEFAULT NULL COMMENT '复核时间',
  `is_danger` int NOT NULL COMMENT '是否有安全隐患  0 安全 1 不安全',
  `type` int NOT NULL COMMENT '检查类型 0是抽查 1是专项检查 2是单位检查',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of spot_check
-- ----------------------------
INSERT INTO `spot_check` VALUES ('15', null, '2020-12-30 14:56:25.696', '软件学院', 'MA101', '无安全隐患', '无整改措施', '', null, null, null, null, null, null, null, '1', '0');
INSERT INTO `spot_check` VALUES ('16', null, '2020-12-30 15:04:28.995', '软件学院', 'BL101', '无安全隐患', '无整改措施', '', null, null, null, null, null, null, null, '1', '0');
INSERT INTO `spot_check` VALUES ('17', null, '2020-12-30 15:04:31.627', '软件学院', 'BL101', '无安全隐患', '无整改措施', '', null, null, null, null, null, null, null, '1', '0');
INSERT INTO `spot_check` VALUES ('18', null, '2020-12-30 15:05:43.984', '软件学院', 'MA101', '无安全隐患', '无整改措施', '', null, null, null, null, null, null, null, '0', '0');
INSERT INTO `spot_check` VALUES ('19', '2', '2021-01-09 23:54:27.488', '软件学院', 'BL101', '无', '无', '', 'wu', '2021-01-16 23:54:27', null, null, null, null, null, '1', '0');
INSERT INTO `spot_check` VALUES ('20', '2', '2021-01-10 00:18:22.211', '软件学院', 'BL101', null, null, '', null, '2021-01-17 00:18:22', null, null, null, null, null, '1', '0');
INSERT INTO `spot_check` VALUES ('21', '2', '2021-01-10 00:19:21.413', '软件学院', 'BL101', null, null, '', null, '2021-01-17 00:19:21', null, null, null, null, null, '1', '0');
INSERT INTO `spot_check` VALUES ('22', '2', '2021-01-10 00:36:19.256', '软件学院', 'BL101', '无', '无', '督察员', 'wu', '2021-01-17 00:36:19', null, null, null, null, null, '1', '1');
INSERT INTO `spot_check` VALUES ('23', '2', '2021-01-10 12:19:22.253', '软件学院', 'BL101', '无', '无', '督察员', 'wu', '2021-01-17 12:19:22', null, null, null, null, null, '1', '1');
INSERT INTO `spot_check` VALUES ('24', '2', '2021-01-10 12:21:33.732', '软件学院', 'BL101', '无', '无', '督察员', 'wu', null, null, null, null, null, null, '1', '2');
INSERT INTO `spot_check` VALUES ('25', '2', '2021-01-10 12:24:24.274', '软件学院', 'BL101', '无', '无', '督察员', 'wu', null, null, null, null, null, null, '1', '2');
INSERT INTO `spot_check` VALUES ('26', '2', '2021-01-10 12:24:35.985', '软件学院', 'BL101', '无', '无', '督察员', 'wu', null, null, null, null, null, null, '1', '3');

-- ----------------------------
-- Table structure for user_message
-- ----------------------------
DROP TABLE IF EXISTS `user_message`;
CREATE TABLE `user_message` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL COMMENT '发消息用户的ID',
  `user_from_id` bigint NOT NULL COMMENT '收消息用户的ID',
  `message_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息标题',
  `message_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息内容',
  `message_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息生成日期',
  `is_read` bigint DEFAULT NULL COMMENT '是否已读，0未读，1已读',
  `message_remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '消息备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_message
-- ----------------------------
INSERT INTO `user_message` VALUES ('1', '10', '2', '实验室日查安全隐患审查', '你有一个实验室安全隐患待审查！', '2021-01-07 15:26:56.304', '0', null);
INSERT INTO `user_message` VALUES ('2', '10', '2', '实验室日查安全隐患审查', '你有一个实验室安全隐患待审查！', '2021-01-07 21:32:08.314', '0', null);
INSERT INTO `user_message` VALUES ('3', '10', '2', '实验室日查安全隐患审查', '你有一个实验室安全隐患待审查！', '2021-01-07 21:33:05.893', '0', null);
INSERT INTO `user_message` VALUES ('4', '10', '2', '实验室日查安全隐患审查', '你有一个实验室安全隐患待审查！', '2021-01-07 21:55:56.464', '0', null);
INSERT INTO `user_message` VALUES ('5', '10', '2', '实验室日查安全隐患审查', '你有一个实验室安全隐患待审查！', '2021-01-07 21:57:14.113', '0', null);
INSERT INTO `user_message` VALUES ('6', '10', '2', '实验室日查安全隐患审查', '你有一个实验室安全隐患待审查！', '2021-01-07 21:57:18.207', '0', null);
INSERT INTO `user_message` VALUES ('7', '10', '10', '实验室日查安全隐患审查', '你有一个实验室安全隐患待审查！', '2021-01-08 15:12:01.433', '0', null);
INSERT INTO `user_message` VALUES ('8', '2', '10', '实验室日查安全隐患审查', '你有一个实验室安全隐患待审查！', '2021-01-08 15:32:15.995', '0', null);
INSERT INTO `user_message` VALUES ('9', '2', '10', '实验室日查安全隐患审查', '你有一个实验室安全隐患待审查！', '2021-01-08 15:35:11.938', '0', null);
INSERT INTO `user_message` VALUES ('10', '2', '10', '实验室日查安全隐患审查', '你有一个实验室安全隐患待审查！', '2021-01-08 15:42:17.315', '0', null);
INSERT INTO `user_message` VALUES ('11', '2', '10', '实验室日查安全隐患审查', '你有一个实验室安全隐患待审查！', '2021-01-08 15:42:42.817', '0', null);
INSERT INTO `user_message` VALUES ('12', '2', '10', '实验室日查安全隐患审查', '你有一个实验室安全隐患待审查！', '2021-01-08 15:44:02.836', '0', null);
INSERT INTO `user_message` VALUES ('13', '2', '11', '实验室日查安全隐患审查', '你有一个实验室安全隐患待审查！', '2021-01-08 15:49:43.683', '0', null);
INSERT INTO `user_message` VALUES ('14', '2', '11', '实验室日查安全隐患审查', '你有一个实验室安全隐患待审查！', '2021-01-08 15:51:01.095', '0', null);
INSERT INTO `user_message` VALUES ('15', '2', '11', '实验室日查安全隐患审查', '你有一个实验室安全隐患待审查！', '2021-01-08 19:46:27.975', '0', null);
INSERT INTO `user_message` VALUES ('16', '2', '11', '实验室日查安全隐患审查', '你有一个实验室安全隐患待审查！', '2021-01-08 19:52:09.964', '0', null);
INSERT INTO `user_message` VALUES ('17', '2', '11', '实验室日查安全隐患审查', '你有一个实验室安全隐患待审查！', '2021-01-08 19:54:03.243', '0', null);
INSERT INTO `user_message` VALUES ('18', '2', '11', '实验室日查安全隐患审查', '你有一个实验室安全隐患待审查！', '2021-01-08 19:54:06.821', '0', null);
INSERT INTO `user_message` VALUES ('19', '2', '11', '实验室日查安全隐患审查', '你有一个实验室安全隐患待审查！', '2021-01-08 20:00:35.012', '0', null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FK8rtpw5ybolwdkndvnyvptxfru` (`role_id`) USING BTREE,
  KEY `FKpap1hs5b5p4mpdnlnwa8uuj5g` (`user_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('2', '4');
INSERT INTO `user_role` VALUES ('10', '5');
INSERT INTO `user_role` VALUES ('11', '6');
