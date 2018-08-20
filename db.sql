/*
SQLyog Ultimate - MySQL GUI v8.21 
MySQL - 5.6.38-log : Database - ny_site
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ny_site` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ny_site`;

/*Table structure for table `catalog_cfg` */

DROP TABLE IF EXISTS `catalog_cfg`;

CREATE TABLE `catalog_cfg` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `site_id` int(11) NOT NULL DEFAULT '0' COMMENT '站点ID',
  `zh_name` varchar(20) NOT NULL COMMENT '分类名称',
  `code` varchar(20) NOT NULL COMMENT '分类编码',
  `py_name` varchar(50) NOT NULL COMMENT '分类拼音',
  `cid_path` varchar(50) NOT NULL COMMENT '分类路径',
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '父类ID',
  `state` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效 1有效',
  `list_no` bigint(20) NOT NULL COMMENT '列表展示顺序',
  `ext_code` varchar(20) DEFAULT NULL COMMENT '扩展编码',
  `ext_img_url` varchar(100) DEFAULT NULL COMMENT '分类图片地址http全路径',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_user` varchar(20) NOT NULL COMMENT '创建人',
  `update_user` varchar(20) NOT NULL COMMENT '更新人',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否逻辑删除0-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `catalog_cfg` */

/*Table structure for table `site_cfg` */

DROP TABLE IF EXISTS `site_cfg`;

CREATE TABLE `site_cfg` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '站点ID',
  `name` varchar(50) NOT NULL,
  `state` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态1有效',
  `py_name` varchar(50) DEFAULT NULL,
  `us_name` varchar(50) DEFAULT NULL,
  `ext_img_url` varchar(100) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `create_user` varchar(20) NOT NULL,
  `update_user` varchar(20) NOT NULL,
  `list_no` bigint(20) NOT NULL DEFAULT '1' COMMENT '顺序',
  `is_del` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `site_cfg` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
