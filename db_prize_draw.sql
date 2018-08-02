# Host: 127.0.0.1  (Version 5.6.40-log)
# Date: 2018-08-02 09:48:41
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "db_active"
#

CREATE TABLE `db_active` (
  `acid` int(11) NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `uuid` char(100) DEFAULT NULL COMMENT '发布者id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(2555) DEFAULT NULL COMMENT '内容',
  `prize_id` int(11) DEFAULT NULL COMMENT '关联的抽奖id',
  `head_pic` varchar(255) DEFAULT NULL COMMENT '头像链接',
  `nick_name` varchar(35) DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`acid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动表';

#
# Structure for table "db_ad"
#

CREATE TABLE `db_ad` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` char(100) NOT NULL DEFAULT '' COMMENT '发布者id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(3555) DEFAULT NULL COMMENT '内容',
  `prize_id` int(11) DEFAULT NULL COMMENT '关联的奖品id',
  `head_pic` varchar(255) DEFAULT '' COMMENT '头像',
  `nick_name` varchar(35) DEFAULT '' COMMENT '昵称',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告表';

#
# Structure for table "db_get_money"
#

CREATE TABLE `db_get_money` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` char(100) DEFAULT NULL COMMENT '提现者',
  `money` int(11) DEFAULT NULL COMMENT '多少钱',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提现时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='提现表';

#
# Structure for table "db_lucky"
#

CREATE TABLE `db_lucky` (
  `lid` int(11) NOT NULL AUTO_INCREMENT COMMENT '单纯的主键',
  `award_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '奖品id',
  `uuid` char(100) NOT NULL DEFAULT '' COMMENT '中奖人',
  `head_pic` varchar(255) DEFAULT NULL COMMENT '头像链接',
  `nick_name` varchar(35) DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='中奖表';

#
# Structure for table "db_partake"
#

CREATE TABLE `db_partake` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` char(100) NOT NULL DEFAULT '' COMMENT '用户ID',
  `prize_id` int(11) NOT NULL DEFAULT '0' COMMENT '抽奖的id',
  `is_lucky` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '是否中奖',
  `nick_name` varchar(35) DEFAULT NULL COMMENT '用户昵称',
  `head_pic` varchar(255) DEFAULT NULL COMMENT '头像链接',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='参与表';

#
# Structure for table "db_prize_draw"
#

CREATE TABLE `db_prize_draw` (
  `prize_id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` char(100) NOT NULL DEFAULT '' COMMENT '发起者的id',
  `title` varchar(35) NOT NULL DEFAULT '' COMMENT '标题',
  `type` int(1) NOT NULL DEFAULT '0' COMMENT '类型',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建这个抽奖的时间',
  `expire_time` timestamp NULL DEFAULT NULL COMMENT '若选择定时开奖，则传它进来，到期自动开奖。',
  `is_closed` int(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '是否已经结束，若结束则外人不得接着抽奖。',
  PRIMARY KEY (`prize_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='创建抽奖表';

#
# Structure for table "db_award"
#

CREATE TABLE `db_award` (
  `aid` int(11) NOT NULL AUTO_INCREMENT COMMENT '奖品ID，主键自增。',
  `prize_id` int(11) DEFAULT NULL COMMENT '上层的抽奖id',
  `title` varchar(35) DEFAULT NULL COMMENT '奖品的标题也就是名称',
  `lucky_num` int(11) NOT NULL DEFAULT '1' COMMENT '中奖人数',
  `type` int(1) NOT NULL DEFAULT '0' COMMENT '0是实物 1是现金',
  PRIMARY KEY (`aid`),
  KEY `db_award_ibfk_1` (`prize_id`),
  CONSTRAINT `db_award_ibfk_1` FOREIGN KEY (`prize_id`) REFERENCES `db_prize_draw` (`prize_id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='中奖表';

#
# Structure for table "db_recharge"
#

CREATE TABLE `db_recharge` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` char(100) DEFAULT NULL COMMENT '用户id',
  `money` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '金额',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '充值时间',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='充值记录表';

#
# Structure for table "db_user"
#

CREATE TABLE `db_user` (
  `uuid` char(100) NOT NULL DEFAULT '' COMMENT '用户id',
  `balance` int(11) unsigned zerofill NOT NULL DEFAULT '00000000000' COMMENT '余额',
  `user_name` varchar(25) DEFAULT NULL COMMENT '用户名',
  `tel_num` char(20) DEFAULT NULL COMMENT '电话号',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `postal_code` char(14) DEFAULT NULL COMMENT '邮政编码',
  `head_pic` varchar(255) DEFAULT NULL COMMENT '头像链接',
  `nick_name` varchar(35) DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
