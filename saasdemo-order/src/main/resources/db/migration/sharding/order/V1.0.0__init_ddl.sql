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
-- Table structure for table `saas_trade`
--
DROP TABLE IF EXISTS `saas_trade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saas_trade` (
  `trade_id` bigint(20) NOT NULL COMMENT '交易编号',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户编号',
  `customer_id` bigint NOT NULL COMMENT '客户编号',
  `total_amount` decimal(12,2) DEFAULT NULL COMMENT '总金额',
  `discount_amount` decimal(12,2) DEFAULT NULL COMMENT '优惠金额',
  `paid_amount` decimal(12,2) DEFAULT NULL COMMENT '支付金额',
  `paid` bit(1) DEFAULT NULL COMMENT '是否已支付',
  `order_count` int DEFAULT NULL COMMENT '订单数量',
  `refunded_count` int DEFAULT NULL COMMENT '已退款数量',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `version` bigint DEFAULT NULL COMMENT '乐观锁版本号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`trade_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='交易';
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `saas_order`
--
DROP TABLE IF EXISTS `saas_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saas_order` (
  `order_id` bigint(20) NOT NULL COMMENT '订单编号',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户编号',
  `trade_id` bigint NOT NULL COMMENT '交易编号',
  `customer_id` bigint NOT NULL COMMENT '客户编号',
  `total_amount` decimal(12,2) DEFAULT NULL COMMENT '总金额',
  `discount_amount` decimal(12,2) DEFAULT NULL COMMENT '优惠金额',
  `paid_amount` decimal(12,2) DEFAULT NULL COMMENT '支付金额',
  `paid` bit(1) DEFAULT NULL COMMENT '是否已支付',
  `refunded` bit(1) DEFAULT NULL COMMENT '是否已退款',
  `order_type` smallint DEFAULT NULL COMMENT '订单类型',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `version` bigint DEFAULT NULL COMMENT '乐观锁版本号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单';
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `saas_order_buy_member`
--
DROP TABLE IF EXISTS `saas_order_buy_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saas_order_buy_member` (
  `order_id` bigint(20) NOT NULL COMMENT '订单编号',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户编号',
  `customer_id` bigint NOT NULL COMMENT '客户编号',
  `member_id` bigint NOT NULL COMMENT '会员编号',
  `member_name` varchar(64) NOT NULL COMMENT '会员名称',
  `member_price` decimal(12,2) NOT NULL COMMENT '会员价格',
  `quantity` int NOT NULL COMMENT '购买数量',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `version` bigint DEFAULT NULL COMMENT '乐观锁版本号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单购买会员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `saas_order_buy_coupon`
--
DROP TABLE IF EXISTS `saas_order_buy_coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saas_order_buy_coupon` (
  `obc_id` bigint(20) NOT NULL COMMENT '优惠券购买编号',
  `order_id` bigint(20) NOT NULL COMMENT '订单编号',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户编号',
  `customer_id` bigint NOT NULL COMMENT '客户编号',
  `coupon_id` bigint NOT NULL COMMENT '优惠券编号',
  `coupon_name` varchar(64) NOT NULL COMMENT '优惠券名称',
  `coupon_price` decimal(12,2) NOT NULL COMMENT '优惠券价格',
  `quantity` int NOT NULL COMMENT '购买数量',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `version` bigint DEFAULT NULL COMMENT '乐观锁版本号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`obc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单购买优惠券';
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `saas_order_detail`
--
DROP TABLE IF EXISTS `saas_order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saas_order_detail` (
  `order_id` bigint(20) NOT NULL COMMENT '订单编号',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户编号',
  `trade_id` bigint NOT NULL COMMENT '交易编号',
  `received` bit(1) DEFAULT NULL COMMENT '是否已收货',
  `customer_nick` varchar(32) DEFAULT NULL COMMENT '客户昵称',
  `customer_phone` varchar(11) DEFAULT NULL COMMENT '客户手机号',
  `coupon_id` bigint DEFAULT NULL COMMENT '优惠券编号',
  `activity_id` bigint DEFAULT NULL COMMENT '活动编号',
  `activity_type` smallint DEFAULT NULL COMMENT '活动类型',
  `version` bigint DEFAULT NULL COMMENT '乐观锁版本号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单详情';
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `saas_order_item`
--
DROP TABLE IF EXISTS `saas_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saas_order_item` (
  `item_id` bigint NOT NULL COMMENT '订单项编号',
  `order_id` bigint DEFAULT NULL COMMENT '订单编号',
  `product_id` bigint DEFAULT NULL COMMENT '商品编号',
  `sku_id` bigint DEFAULT NULL COMMENT '商品规格编号',
  `tenant_id` bigint DEFAULT NULL COMMENT '租户编号',
  `product_name` varchar(64) DEFAULT NULL COMMENT '商品名称',
  `sku_name` varchar(64) DEFAULT NULL COMMENT '商品规格名称',
  `price` decimal(12,2) DEFAULT NULL COMMENT '商品价格',
  `quantity` int DEFAULT NULL COMMENT '购买数量',
  `total_amount` decimal(12,2) DEFAULT NULL COMMENT '总价',
  `diff_amount` decimal(12,2) DEFAULT NULL COMMENT '金额差异',
  `image` varchar(128) DEFAULT NULL COMMENT '商品主图',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单项';
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `saas_order_item_attr`
--
DROP TABLE IF EXISTS `saas_order_item_attr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saas_order_item_attr` (
  `item_id` bigint(20) NOT NULL COMMENT '订单项编号',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户编号',
  `name` varchar(32) DEFAULT NULL COMMENT '规格名称',
  `value` varchar(128) DEFAULT NULL COMMENT '规格值',
  `code_name` varchar(64) DEFAULT NULL COMMENT '规格代码名称',
  `code_value` varchar(128) DEFAULT NULL COMMENT '规格代码值',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单项属性';
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `saas_pay_log`
--
DROP TABLE IF EXISTS `saas_pay_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saas_pay_log` (
  `log_id` bigint NOT NULL COMMENT '支付日志编号',
  `customer_id` bigint NOT NULL COMMENT '客户编号',
  `tenant_id` bigint DEFAULT NULL COMMENT '租户编号',
  `trade_id` bigint DEFAULT NULL COMMENT '交易编号',
  `order_id` bigint DEFAULT NULL COMMENT '订单编号',
  `amount` decimal(12,2) DEFAULT NULL COMMENT '支付金额',
  `describe` varchar(64) DEFAULT NULL COMMENT '描述',
  `payer_remark` varchar(64) DEFAULT NULL COMMENT '付款方备注',
  `payee_remark` varchar(64) DEFAULT NULL COMMENT '收款方备注',
  `out_trade_no` varchar(32) DEFAULT NULL COMMENT '交易号码',
  `third_no` varchar(48) DEFAULT NULL COMMENT '第三方交易编号',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `version` bigint DEFAULT NULL COMMENT '乐观锁版本号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='支付日志';
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `saas_shopping_cart`
--
DROP TABLE IF EXISTS `saas_shopping_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saas_shopping_cart` (
  `cart_id` bigint(20) NOT NULL COMMENT '购物车编号',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户编号',
  `product_id` bigint NOT NULL COMMENT '商品编号',
  `sku_id` bigint NOT NULL COMMENT '商品规格编号',
  `customer_id` bigint NOT NULL COMMENT '客户编号',
  `quantity` int DEFAULT NULL COMMENT '数量',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `version` bigint DEFAULT NULL COMMENT '乐观锁版本号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='购物车';
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
