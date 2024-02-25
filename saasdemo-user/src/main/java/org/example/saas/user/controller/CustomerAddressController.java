package org.example.saas.user.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.example.saas.core.service.user.CustomerAddressService;
import org.example.saas.core.domain.dto.CustomerAddressDTO;
import org.example.saas.core.pojo.CustomerAddress;
import org.example.saas.core.parameter.user.CustomerAddressDetailGetParameter;
import org.example.saas.core.parameter.user.CustomerAddressPageGetParameter;
import org.example.saas.core.parameter.user.CustomerAddressDeleteParameter;
import org.example.saas.core.parameter.user.CustomerAddressSaveParameter;
import org.example.saas.core.parameter.user.CustomerAddressUpdateParameter;
import org.example.saas.core.parameter.user.CustomerAddressEnableParameter;
import org.example.saas.core.parameter.user.CustomerAddressDisableParameter;
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
 * 客户地址 服务
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */
@RestController
@Validated
@RequestMapping("/customer-address")
@RequiredArgsConstructor
@Api(tags = "客户地址")
public class CustomerAddressController {
    private final CustomerAddressService customerAddressService;

    @PostMapping("/detail")
    @ApiOperation("获取客户地址详情")
    public Result<CustomerAddressDTO> getDetail(@Validated @RequestBody CustomerAddressDetailGetParameter parameter) {
        CustomerAddressDTO detail = customerAddressService.getDetail(parameter);
        return new Result<>(detail);
    }

    @PostMapping("/page")
    @ApiOperation("获取客户地址分页列表")
    public Result<IPage<CustomerAddressDTO>> getPage(@Validated @RequestBody CustomerAddressPageGetParameter parameter) {
        IPage<CustomerAddressDTO> page = customerAddressService.getPage(parameter);
        return new Result<>(page);
    }

    @PostMapping("/update")
    @ApiOperation("更新客户地址")
    @WebLog
    public Result<Boolean> update(@Validated @RequestBody CustomerAddressUpdateParameter parameter) {
        customerAddressService.update(parameter);
        return new Result<>(true);
    }

    @PostMapping("/save")
    @ApiOperation("保存客户地址")
    @WebLog
    public Result<Boolean> save(@Validated @RequestBody CustomerAddressSaveParameter parameter) {
        customerAddressService.save(parameter);
        return new Result<>(true);
    }

    @PostMapping("/enable")
    @ApiOperation("启用客户地址")
    @WebLog
    public Result<Boolean> enable(@Validated @RequestBody CustomerAddressEnableParameter parameter) {
        customerAddressService.enable(parameter);
        return new Result<>(true);
    }

    @PostMapping("/disable")
    @ApiOperation("禁用客户地址")
    @WebLog
    public Result<Boolean> save(@Validated @RequestBody CustomerAddressDisableParameter parameter) {
        customerAddressService.disable(parameter);
        return new Result<>(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除客户地址")
    @WebLog
    public Result<Boolean> delete(@Validated @RequestBody CustomerAddressDeleteParameter parameter) {
        customerAddressService.delete(parameter);
        return new Result<>(true);
    }

}
