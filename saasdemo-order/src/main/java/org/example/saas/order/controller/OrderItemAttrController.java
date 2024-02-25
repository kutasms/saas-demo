package org.example.saas.order.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.example.saas.core.service.order.OrderItemAttrService;
import org.example.saas.core.domain.dto.OrderItemAttrDTO;
import org.example.saas.core.pojo.OrderItemAttr;
import org.example.saas.core.parameter.order.OrderItemAttrDetailGetParameter;
import org.example.saas.core.parameter.order.OrderItemAttrPageGetParameter;
import org.example.saas.core.parameter.order.OrderItemAttrDeleteParameter;
import org.example.saas.core.parameter.order.OrderItemAttrSaveParameter;
import org.example.saas.core.parameter.order.OrderItemAttrUpdateParameter;
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
 * 订单项属性 服务
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@RestController
@Validated
@RequestMapping("/order-item-attr")
@RequiredArgsConstructor
@Api(tags = "订单项属性")
public class OrderItemAttrController {
    private final OrderItemAttrService orderItemAttrService;

    @PostMapping("/detail")
    @ApiOperation("获取订单项属性详情")
    public Result<OrderItemAttrDTO> getDetail(@Validated @RequestBody OrderItemAttrDetailGetParameter parameter) {
        OrderItemAttrDTO detail = orderItemAttrService.getDetail(parameter);
        return new Result<>(detail);
    }

    @PostMapping("/page")
    @ApiOperation("获取订单项属性分页列表")
    public Result<IPage<OrderItemAttrDTO>> getPage(@Validated @RequestBody OrderItemAttrPageGetParameter parameter) {
        IPage<OrderItemAttrDTO> page = orderItemAttrService.getPage(parameter);
        return new Result<>(page);
    }

    @PostMapping("/update")
    @ApiOperation("更新订单项属性")
    @WebLog
    public Result<Boolean> update(@Validated @RequestBody OrderItemAttrUpdateParameter parameter) {
        orderItemAttrService.update(parameter);
        return new Result<>(true);
    }

    @PostMapping("/save")
    @ApiOperation("保存订单项属性")
    @WebLog
    public Result<Boolean> save(@Validated @RequestBody OrderItemAttrSaveParameter parameter) {
        orderItemAttrService.save(parameter);
        return new Result<>(true);
    }


    @DeleteMapping("/delete")
    @ApiOperation("删除订单项属性")
    @WebLog
    public Result<Boolean> delete(@Validated @RequestBody OrderItemAttrDeleteParameter parameter) {
        orderItemAttrService.delete(parameter);
        return new Result<>(true);
    }

}
