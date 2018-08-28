/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 5.7
Source Host           : localhost:3306
Source Database       : trsystem

Target Server Type    : MYSQL
Target Server Version : 5.7
File Encoding         : UTF8

Date: 1/8/2018 11:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `CSS_COURSE`
-- ----------------------------
CREATE TABLE IF NOT EXISTS CSS_COURSE
(
  COURSE_CODE VARCHAR(20) NOT NULL UNIQUE ,
  COURSE_NAME VARCHAR(255) NOT NULL,
  CONSTRAINT PRIMARY KEY (COURSE_CODE)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;