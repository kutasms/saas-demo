package org.example.saas.user.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.example.saas.core.service.user.CustomerBalanceService;
import org.example.saas.core.domain.dto.CustomerBalanceDTO;
import org.example.saas.core.pojo.CustomerBalance;
import org.example.saas.core.parameter.user.CustomerBalanceDetailGetParameter;
import org.example.saas.core.parameter.user.CustomerBalancePageGetParameter;
import org.example.saas.core.parameter.user.CustomerBalanceDeleteParameter;
import org.example.saas.core.parameter.user.CustomerBalanceSaveParameter;
import org.example.saas.core.parameter.user.CustomerBalanceUpdateParameter;
import org.example.saas.core.parameter.user.CustomerBalanceEnableParameter;
import org.example.saas.core.parameter.user.CustomerBalanceDisableParameter;
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
 * 客户余额 服务
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */
@RestController
@Validated
@RequestMapping("/customer-balance")
@RequiredArgsConstructor
@Api(tags = "客户余额")
public class CustomerBalanceController {
    private final CustomerBalanceService customerBalanceService;

    @PostMapping("/detail")
    @ApiOperation("获取客户余额详情")
    public Result<CustomerBalanceDTO> getDetail(@Validated @RequestBody CustomerBalanceDetailGetParameter parameter) {
        CustomerBalanceDTO detail = customerBalanceService.getDetail(parameter);
        return new Result<>(detail);
    }

    @PostMapping("/page")
    @ApiOperation("获取客户余额分页列表")
    public Result<IPage<CustomerBalanceDTO>> getPage(@Validated @RequestBody CustomerBalancePageGetParameter parameter) {
        IPage<CustomerBalanceDTO> page = customerBalanceService.getPage(parameter);
        return new Result<>(page);
    }

    @PostMapping("/update")
    @ApiOperation("更新客户余额")
    @WebLog
    public Result<Boolean> update(@Validated @RequestBody CustomerBalanceUpdateParameter parameter) {
        customerBalanceService.update(parameter);
        return new Result<>(true);
    }

    @PostMapping("/save")
    @ApiOperation("保存客户余额")
    @WebLog
    public Result<Boolean> save(@Validated @RequestBody CustomerBalanceSaveParameter parameter) {
        customerBalanceService.save(parameter);
        return new Result<>(true);
    }

    @PostMapping("/enable")
    @ApiOperation("启用客户余额")
    @WebLog
    public Result<Boolean> enable(@Validated @RequestBody CustomerBalanceEnableParameter parameter) {
        customerBalanceService.enable(parameter);
        return new Result<>(true);
    }

    @PostMapping("/disable")
    @ApiOperation("禁用客户余额")
    @WebLog
    public Result<Boolean> save(@Validated @RequestBody CustomerBalanceDisableParameter parameter) {
        customerBalanceService.disable(parameter);
        return new Result<>(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除客户余额")
    @WebLog
    public Result<Boolean> delete(@Validated @RequestBody CustomerBalanceDeleteParameter parameter) {
        customerBalanceService.delete(parameter);
        return new Result<>(true);
    }

}
