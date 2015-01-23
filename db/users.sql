/*
Navicat PGSQL Data Transfer

Source Server         : winryblog
Source Server Version : 90303
Source Host           : ec2-107-22-190-179.compute-1.amazonaws.com:5432
Source Database       : d9rup625c1ui2t
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90303
File Encoding         : 65001

Date: 2015-01-24 00:36:28
*/


-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS "public"."users";
CREATE TABLE "public"."users" (
"username" varchar(50) COLLATE "default" NOT NULL,
"password" varchar(50) COLLATE "default" NOT NULL,
"email" varchar(100) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO "public"."users" VALUES ('winry', '580685', 'fwrq41251@gmail.com');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE "public"."users" ADD PRIMARY KEY ("username");
