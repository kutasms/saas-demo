package org.example.saas.user.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.example.saas.core.service.user.CustomerService;
import org.example.saas.core.domain.dto.CustomerDTO;
import org.example.saas.core.pojo.Customer;
import org.example.saas.core.parameter.user.CustomerDetailGetParameter;
import org.example.saas.core.parameter.user.CustomerPageGetParameter;
import org.example.saas.core.parameter.user.CustomerDeleteParameter;
import org.example.saas.core.parameter.user.CustomerSaveParameter;
import org.example.saas.core.parameter.user.CustomerUpdateParameter;
import org.example.saas.core.parameter.user.CustomerEnableParameter;
import org.example.saas.core.parameter.user.CustomerDisableParameter;
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
 * 客户 服务
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */
@RestController
@Validated
@RequestMapping("/customer")
@RequiredArgsConstructor
@Api(tags = "客户")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/detail")
    @ApiOperation("获取客户详情")
    public Result<CustomerDTO> getDetail(@Validated @RequestBody CustomerDetailGetParameter parameter) {
        CustomerDTO detail = customerService.getDetail(parameter);
        return new Result<>(detail);
    }

    @PostMapping("/page")
    @ApiOperation("获取客户分页列表")
    public Result<IPage<CustomerDTO>> getPage(@Validated @RequestBody CustomerPageGetParameter parameter) {
        IPage<CustomerDTO> page = customerService.getPage(parameter);
        return new Result<>(page);
    }

    @PostMapping("/update")
    @ApiOperation("更新客户")
    @WebLog
    public Result<Boolean> update(@Validated @RequestBody CustomerUpdateParameter parameter) {
        customerService.update(parameter);
        return new Result<>(true);
    }

    @PostMapping("/save")
    @ApiOperation("保存客户")
    @WebLog
    public Result<Boolean> save(@Validated @RequestBody CustomerSaveParameter parameter) {
        customerService.save(parameter);
        return new Result<>(true);
    }

    @PostMapping("/enable")
    @ApiOperation("启用客户")
    @WebLog
    public Result<Boolean> enable(@Validated @RequestBody CustomerEnableParameter parameter) {
        customerService.enable(parameter);
        return new Result<>(true);
    }

    @PostMapping("/disable")
    @ApiOperation("禁用客户")
    @WebLog
    public Result<Boolean> save(@Validated @RequestBody CustomerDisableParameter parameter) {
        customerService.disable(parameter);
        return new Result<>(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除客户")
    @WebLog
    public Result<Boolean> delete(@Validated @RequestBody CustomerDeleteParameter parameter) {
        customerService.delete(parameter);
        return new Result<>(true);
    }

}
