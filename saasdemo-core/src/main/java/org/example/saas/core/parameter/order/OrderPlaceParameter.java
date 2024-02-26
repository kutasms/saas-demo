package org.example.saas.core.parameter.order;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.example.saas.core.domain.enums.ActivityType;
import org.example.saas.core.domain.enums.OrderSubmitMode;
import org.example.saas.core.domain.enums.OrderType;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class OrderPlaceParameter implements Serializable {

    /**
     * 订单提交模式
     */
    @ApiModelProperty("订单提交模式")
    private OrderSubmitMode submitMode;

    /**
     * 订单类型
     */
    @ApiModelProperty("订单类型")
    private OrderType orderType;

    /**
     * 购物车编号列表
     */
    @ApiModelProperty("购物车编号列表")
    private List<Long> cartIds;

    /**
     * 商品规格编号列表
     */
    @ApiModelProperty("商品规格编号列表")
    private Map<Long, Integer> skuMap;


    /**
     * 使用优惠券
     */
    @ApiModelProperty("使用优惠券")
    private Long couponId;

    /**
     * 活动编号
     */
    @ApiModelProperty("活动编号")
    private Long activityId;
    /**
     * 活动类型
     */
    @ApiModelProperty("活动类型")
    private ActivityType activityType;
}
