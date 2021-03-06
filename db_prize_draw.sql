﻿# Host: localhost  (Version: 5.5.53)
# Date: 2018-09-10 17:07:52
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "db_active"
#

DROP TABLE IF EXISTS `db_active`;
CREATE TABLE `db_active` (
  `acid` int(11) NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `uuid` char(100) DEFAULT NULL COMMENT '发布者id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(2555) DEFAULT NULL COMMENT '内容',
  `prize_id` int(11) DEFAULT NULL COMMENT '关联的抽奖id',
  `head_pic` varchar(255) DEFAULT NULL COMMENT '头像链接',
  `nick_name` varchar(35) DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`acid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='活动表';

#
# Data for table "db_active"
#

INSERT INTO `db_active` VALUES (1,'1','1','1',1,'1','1');

#
# Structure for table "db_ad"
#

DROP TABLE IF EXISTS `db_ad`;
CREATE TABLE `db_ad` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` char(100) NOT NULL DEFAULT '' COMMENT '发布者id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(3555) DEFAULT NULL COMMENT '内容',
  `prize_id` int(11) DEFAULT NULL COMMENT '关联的奖品id',
  `head_pic` varchar(255) DEFAULT '' COMMENT '头像',
  `nick_name` varchar(35) DEFAULT '' COMMENT '昵称',
  `secret_key` varchar(255) NOT NULL DEFAULT '' COMMENT '用于控制广告抽奖的鉴权',
  PRIMARY KEY (`aid`),
  UNIQUE KEY `secret_key` (`secret_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告表';

#
# Data for table "db_ad"
#


#
# Structure for table "db_ad_auth"
#

DROP TABLE IF EXISTS `db_ad_auth`;
CREATE TABLE `db_ad_auth` (
  `authId` int(11) NOT NULL AUTO_INCREMENT,
  `prize_id` int(11) NOT NULL DEFAULT '0' COMMENT '抽奖id',
  `receive_key` varchar(255) NOT NULL DEFAULT '' COMMENT '领取用的key',
  `is_close` int(1) NOT NULL DEFAULT '0' COMMENT '是否被领取过',
  PRIMARY KEY (`authId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用于活动的鉴权';

#
# Data for table "db_ad_auth"
#


#
# Structure for table "db_get_money"
#

DROP TABLE IF EXISTS `db_get_money`;
CREATE TABLE `db_get_money` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` char(100) DEFAULT NULL COMMENT '提现者',
  `money` int(11) DEFAULT NULL COMMENT '多少钱',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提现时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='提现表';

#
# Data for table "db_get_money"
#


#
# Structure for table "db_lucky"
#

DROP TABLE IF EXISTS `db_lucky`;
CREATE TABLE `db_lucky` (
  `lid` int(11) NOT NULL AUTO_INCREMENT COMMENT '单纯的主键',
  `award_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '奖品id',
  `uuid` char(100) NOT NULL DEFAULT '' COMMENT '中奖人',
  `head_pic` varchar(255) DEFAULT NULL COMMENT '头像链接',
  `nick_name` varchar(35) DEFAULT NULL COMMENT '昵称',
  `award_num` int(11) NOT NULL DEFAULT '0' COMMENT '奖品的个数或者金钱的钱数',
  `form_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='中奖表';

#
# Data for table "db_lucky"
#


#
# Structure for table "db_partake"
#

DROP TABLE IF EXISTS `db_partake`;
CREATE TABLE `db_partake` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` char(100) NOT NULL DEFAULT '' COMMENT '用户ID',
  `prize_id` int(11) NOT NULL DEFAULT '0' COMMENT '抽奖的id',
  `is_lucky` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否中奖',
  `nick_name` varchar(35) DEFAULT NULL COMMENT '用户昵称',
  `head_pic` varchar(255) DEFAULT NULL COMMENT '头像链接',
  `form_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='参与表';

#
# Data for table "db_partake"
#


#
# Structure for table "db_prize_draw"
#

DROP TABLE IF EXISTS `db_prize_draw`;
CREATE TABLE `db_prize_draw` (
  `prize_id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` char(100) NOT NULL DEFAULT '' COMMENT '发起者的id',
  `title` varchar(35) NOT NULL DEFAULT '' COMMENT '标题',
  `type` int(1) NOT NULL DEFAULT '0' COMMENT '类型',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建这个抽奖的时间',
  `expire_time` timestamp NULL DEFAULT NULL COMMENT '若选择定时开奖，则传它进来，到期自动开奖。',
  `is_closed` int(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '是否已经结束，若结束则外人不得接着抽奖。',
  `max_people` int(11) DEFAULT NULL,
  PRIMARY KEY (`prize_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='创建抽奖表';

#
# Data for table "db_prize_draw"
#

INSERT INTO `db_prize_draw` VALUES (2,'oQX5o5ObEPjlEc-9ZA-hDRFG4hcY','1',0,'2018-09-10 17:04:19',NULL,0,NULL);

#
# Structure for table "db_award"
#

DROP TABLE IF EXISTS `db_award`;
CREATE TABLE `db_award` (
  `aid` int(11) NOT NULL AUTO_INCREMENT COMMENT '奖品ID，主键自增。',
  `prize_id` int(11) DEFAULT NULL COMMENT '上层的抽奖id',
  `title` varchar(35) DEFAULT NULL COMMENT '奖品的标题也就是名称',
  `lucky_num` int(11) NOT NULL DEFAULT '1' COMMENT '中奖人数',
  `type` int(1) NOT NULL DEFAULT '0' COMMENT '0是实物 1是现金',
  PRIMARY KEY (`aid`),
  KEY `db_award_ibfk_1` (`prize_id`),
  CONSTRAINT `db_award_ibfk_1` FOREIGN KEY (`prize_id`) REFERENCES `db_prize_draw` (`prize_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='中奖表';

#
# Data for table "db_award"
#

INSERT INTO `db_award` VALUES (1,2,'1',1,0);

#
# Structure for table "db_recharge"
#

DROP TABLE IF EXISTS `db_recharge`;
CREATE TABLE `db_recharge` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` char(100) DEFAULT NULL COMMENT '用户id',
  `money` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '金额',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '充值时间',
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='充值记录表';

#
# Data for table "db_recharge"
#


#
# Structure for table "db_user"
#

DROP TABLE IF EXISTS `db_user`;
CREATE TABLE `db_user` (
  `uuid` char(100) NOT NULL DEFAULT '' COMMENT '用户id',
  `balance` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '余额',
  `user_name` varchar(25) DEFAULT NULL COMMENT '用户名',
  `tel_num` char(20) DEFAULT NULL COMMENT '电话号',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `postal_code` char(14) DEFAULT NULL COMMENT '邮政编码',
  `head_pic` varchar(255) DEFAULT NULL COMMENT '头像链接',
  `nick_name` varchar(35) DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

#
# Data for table "db_user"
#

