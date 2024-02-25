package org.example.saas.order.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.example.saas.core.service.order.OrderService;
import org.example.saas.core.domain.dto.OrderDTO;
import org.example.saas.core.pojo.Order;
import org.example.saas.core.parameter.order.OrderDetailGetParameter;
import org.example.saas.core.parameter.order.OrderPageGetParameter;
import org.example.saas.core.parameter.order.OrderDeleteParameter;
import org.example.saas.core.parameter.order.OrderSaveParameter;
import org.example.saas.core.parameter.order.OrderUpdateParameter;
import org.example.saas.core.parameter.order.OrderEnableParameter;
import org.example.saas.core.parameter.order.OrderDisableParameter;
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
 * 订单 服务
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@RestController
@Validated
@RequestMapping("/order")
@RequiredArgsConstructor
@Api(tags = "订单")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/detail")
    @ApiOperation("获取订单详情")
    public Result<OrderDTO> getDetail(@Validated @RequestBody OrderDetailGetParameter parameter) {
        OrderDTO detail = orderService.getDetail(parameter);
        return new Result<>(detail);
    }

    @PostMapping("/page")
    @ApiOperation("获取订单分页列表")
    public Result<IPage<OrderDTO>> getPage(@Validated @RequestBody OrderPageGetParameter parameter) {
        IPage<OrderDTO> page = orderService.getPage(parameter);
        return new Result<>(page);
    }

    @PostMapping("/update")
    @ApiOperation("更新订单")
    @WebLog
    public Result<Boolean> update(@Validated @RequestBody OrderUpdateParameter parameter) {
        orderService.update(parameter);
        return new Result<>(true);
    }

    @PostMapping("/save")
    @ApiOperation("保存订单")
    @WebLog
    public Result<Boolean> save(@Validated @RequestBody OrderSaveParameter parameter) {
        orderService.save(parameter);
        return new Result<>(true);
    }

    @PostMapping("/enable")
    @ApiOperation("启用订单")
    @WebLog
    public Result<Boolean> enable(@Validated @RequestBody OrderEnableParameter parameter) {
        orderService.enable(parameter);
        return new Result<>(true);
    }

    @PostMapping("/disable")
    @ApiOperation("禁用订单")
    @WebLog
    public Result<Boolean> save(@Validated @RequestBody OrderDisableParameter parameter) {
        orderService.disable(parameter);
        return new Result<>(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除订单")
    @WebLog
    public Result<Boolean> delete(@Validated @RequestBody OrderDeleteParameter parameter) {
        orderService.delete(parameter);
        return new Result<>(true);
    }

}
