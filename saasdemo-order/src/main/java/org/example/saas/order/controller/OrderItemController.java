package org.example.saas.order.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.example.saas.core.service.order.OrderItemService;
import org.example.saas.core.domain.dto.OrderItemDTO;
import org.example.saas.core.pojo.OrderItem;
import org.example.saas.core.parameter.order.OrderItemDetailGetParameter;
import org.example.saas.core.parameter.order.OrderItemPageGetParameter;
import org.example.saas.core.parameter.order.OrderItemDeleteParameter;
import org.example.saas.core.parameter.order.OrderItemSaveParameter;
import org.example.saas.core.parameter.order.OrderItemUpdateParameter;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.chia.multienty.core.annotation.WebLog;
import com.chia.multienty.core.domain.basic.Result;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * <p>
 * 订单项 服务
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@RestController
@Validated
@RequestMapping("/order-item")
@RequiredArgsConstructor
@Api(tags = "订单项")
public class OrderItemController {
    private final OrderItemService orderItemService;

    @PostMapping("/detail")
    @ApiOperation("获取订单项详情")
    public Result<OrderItemDTO> getDetail(@Validated @RequestBody OrderItemDetailGetParameter parameter) {
        OrderItemDTO detail = orderItemService.getDetail(parameter);
        return new Result<>(detail);
    }

    @PostMapping("/page")
    @ApiOperation("获取订单项分页列表")
    public Result<IPage<OrderItemDTO>> getPage(@Validated @RequestBody OrderItemPageGetParameter parameter) {
        IPage<OrderItemDTO> page = orderItemService.getPage(parameter);
        return new Result<>(page);
    }

    @PostMapping("/update")
    @ApiOperation("更新订单项")
    @WebLog
    public Result<Boolean> update(@Validated @RequestBody OrderItemUpdateParameter parameter) {
        orderItemService.update(parameter);
        return new Result<>(true);
    }

    @PostMapping("/save")
    @ApiOperation("保存订单项")
    @WebLog
    public Result<Boolean> save(@Validated @RequestBody OrderItemSaveParameter parameter) {
        orderItemService.save(parameter);
        return new Result<>(true);
    }


    @DeleteMapping("/delete")
    @ApiOperation("删除订单项")
    @WebLog
    public Result<Boolean> delete(@Validated @RequestBody OrderItemDeleteParameter parameter) {
        orderItemService.delete(parameter);
        return new Result<>(true);
    }

}
