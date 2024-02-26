ALTER TABLE `saas_order_item_attr`
ADD COLUMN `attr_id` BIGINT NOT NULL COMMENT '订单项属性编号' FIRST,
CHANGE COLUMN `tenant_id` `tenant_id` BIGINT NOT NULL COMMENT '租户编号' ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`attr_id`);