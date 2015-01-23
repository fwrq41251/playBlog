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

Date: 2015-01-24 00:34:42
*/

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
create sequence article_seq;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS "public"."article";
CREATE TABLE "public"."article" (
"id" int4 DEFAULT nextval('article_seq'::regclass) NOT NULL,
"title" varchar(300) COLLATE "default" DEFAULT NULL::character varying,
"content" text COLLATE "default",
"date" timestamp(6),
"status" varchar(10) COLLATE "default" DEFAULT NULL::character varying,
"permission" varchar(10) COLLATE "default" DEFAULT NULL::character varying,
"username" varchar(50) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO "public"."article" VALUES ('1', 'hello world', '<p>			</p><p>this is the first article</p><p>			</p>', '2014-09-19 14:07:49', null, null, 'winry');

-- ----------------------------
-- Primary Key structure for table article
-- ----------------------------
ALTER TABLE "public"."article" ADD PRIMARY KEY ("id");
