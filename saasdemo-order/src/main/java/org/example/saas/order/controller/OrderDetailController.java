package org.example.saas.order.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.example.saas.core.service.order.OrderDetailService;
import org.example.saas.core.domain.dto.OrderDetailDTO;
import org.example.saas.core.pojo.OrderDetail;
import org.example.saas.core.parameter.order.OrderDetailDetailGetParameter;
import org.example.saas.core.parameter.order.OrderDetailPageGetParameter;
import org.example.saas.core.parameter.order.OrderDetailDeleteParameter;
import org.example.saas.core.parameter.order.OrderDetailSaveParameter;
import org.example.saas.core.parameter.order.OrderDetailUpdateParameter;
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
 * 订单详情 服务
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@RestController
@Validated
@RequestMapping("/order-detail")
@RequiredArgsConstructor
@Api(tags = "订单详情")
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @PostMapping("/detail")
    @ApiOperation("获取订单详情详情")
    public Result<OrderDetailDTO> getDetail(@Validated @RequestBody OrderDetailDetailGetParameter parameter) {
        OrderDetailDTO detail = orderDetailService.getDetail(parameter);
        return new Result<>(detail);
    }

    @PostMapping("/page")
    @ApiOperation("获取订单详情分页列表")
    public Result<IPage<OrderDetailDTO>> getPage(@Validated @RequestBody OrderDetailPageGetParameter parameter) {
        IPage<OrderDetailDTO> page = orderDetailService.getPage(parameter);
        return new Result<>(page);
    }

    @PostMapping("/update")
    @ApiOperation("更新订单详情")
    @WebLog
    public Result<Boolean> update(@Validated @RequestBody OrderDetailUpdateParameter parameter) {
        orderDetailService.update(parameter);
        return new Result<>(true);
    }

    @PostMapping("/save")
    @ApiOperation("保存订单详情")
    @WebLog
    public Result<Boolean> save(@Validated @RequestBody OrderDetailSaveParameter parameter) {
        orderDetailService.save(parameter);
        return new Result<>(true);
    }


    @DeleteMapping("/delete")
    @ApiOperation("删除订单详情")
    @WebLog
    public Result<Boolean> delete(@Validated @RequestBody OrderDetailDeleteParameter parameter) {
        orderDetailService.delete(parameter);
        return new Result<>(true);
    }

}
