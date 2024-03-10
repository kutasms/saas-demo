/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `saas_customer`
--
DROP TABLE IF EXISTS `saas_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saas_customer` (
  `customer_id` bigint NOT NULL COMMENT '客户编号',
  `tenant_id` bigint NOT NULL COMMENT '租户编号',
  `nick_name` varchar(32) NOT NULL COMMENT '昵称',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `birthday` DATETIME DEFAULT NULL COMMENT '生日',
  `phone_number` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `avatar_url` varchar(256) DEFAULT NULL COMMENT '头像地址',
  `in_black_list` bit(1) NOT NULL COMMENT '是否已被拉黑',
  `is_member` bit(1) NOT NULL COMMENT '是否会员',
  `member_source_type` tinyint(4) NOT NULL COMMENT '会员来源类型',
  `member_id` bigint DEFAULT NULL COMMENT '会员编号',
  `growth` int NOT NULL COMMENT '成长值',
  `credit` int NOT NULL COMMENT '积分',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `version` bigint NOT NULL COMMENT '乐观锁版本号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='客户';
/*!40101 SET character_set_client = @saved_cs_client */;




--
-- Table structure for table `saas_customer_wx`
--
DROP TABLE IF EXISTS `saas_customer_wx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saas_customer_wx` (
  `customer_id` bigint NOT NULL COMMENT '客户编号',
  `tenant_id` bigint NOT NULL COMMENT '租户编号',
  `wx_open_id` varchar(64) DEFAULT NULL COMMENT '微信openid',
  `wx_union_id` varchar(64) DEFAULT NULL COMMENT '微信unionid',
  `wx_nick_name` varchar(32) DEFAULT NULL COMMENT '微信昵称',
  `wx_id` varchar(48) DEFAULT NULL COMMENT '微信id',
  `access_token` varchar(128) DEFAULT NULL COMMENT '执行令牌',
  `refresh_token` varchar(128) DEFAULT NULL COMMENT '刷新令牌',
  `status` varchar(32) NOT NULL COMMENT '状态',
  `version` bigint NOT NULL COMMENT '乐观锁版本号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='客户微信';
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `saas_customer_address`
--
DROP TABLE IF EXISTS `saas_customer_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saas_customer_address` (
  `address_id` bigint NOT NULL COMMENT '客户地址编号',
  `customer_id` bigint NOT NULL COMMENT '客户编号',
  `tenant_id` bigint NOT NULL COMMENT '租户编号',
  `name` varchar(32) NOT NULL COMMENT '收货人姓名',
  `phone_number` varchar(11) NOT NULL COMMENT '收货人电话',
  `region` varchar(64) NOT NULL COMMENT '地域',
  `province` varchar(64) NOT NULL COMMENT '省份',
  `city` varchar(64) NOT NULL COMMENT '城市',
  `district` varchar(64) NOT NULL COMMENT '区县',
  `street` varchar(64) DEFAULT NULL COMMENT '街道',
  `house_number` varchar(64) NOT NULL COMMENT '门牌号',
  `status` varchar(32) NOT NULL COMMENT '状态',
  `version` bigint NOT NULL COMMENT '乐观锁版本号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='客户地址';
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `saas_customer_balance`
--
DROP TABLE IF EXISTS `saas_customer_balance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saas_customer_balance` (
  `customer_id` bigint NOT NULL COMMENT '客户编号',
  `tenant_id` bigint NOT NULL COMMENT '租户编号',
  `total` decimal(12,2) NOT NULL COMMENT '总余额',
  `usable` decimal(12,2) NOT NULL COMMENT '可用的余额',
  `frozen` decimal(12,2) NOT NULL COMMENT '冻结的余额',
  `hidden` bit(1) NOT NULL COMMENT '是否隐藏余额',
  `status` varchar(32) NOT NULL COMMENT '状态',
  `version` bigint NOT NULL COMMENT '乐观锁版本号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='客户余额';
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `saas_balance_bill`
--
DROP TABLE IF EXISTS `saas_balance_bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saas_balance_bill` (
  `bill_id` bigint NOT NULL COMMENT '余额变更记录编号',
  `customer_id` bigint NOT NULL COMMENT '客户编号',
  `tenant_id` bigint DEFAULT NULL COMMENT '租户编号',
  `amount` decimal(12,2) DEFAULT NULL COMMENT '变动金额',
  `operator` bigint DEFAULT NULL COMMENT '操作者',
  `reason` varchar(50) DEFAULT NULL COMMENT '原因',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `trigger` tinyint(4) DEFAULT NULL COMMENT '触发应用编号',
  `trade_id` bigint DEFAULT NULL COMMENT '交易编号',
  `before` decimal(12,2) DEFAULT NULL COMMENT '变动前余额',
  `after` decimal(12,2) DEFAULT NULL COMMENT '变动后余额',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`bill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='余额账单';
/*!40101 SET character_set_client = @saved_cs_client */;



/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;