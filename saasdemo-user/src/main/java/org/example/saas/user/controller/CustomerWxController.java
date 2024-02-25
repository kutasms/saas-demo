package org.example.saas.user.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.example.saas.core.service.user.CustomerWxService;
import org.example.saas.core.domain.dto.CustomerWxDTO;
import org.example.saas.core.pojo.CustomerWx;
import org.example.saas.core.parameter.user.CustomerWxDetailGetParameter;
import org.example.saas.core.parameter.user.CustomerWxPageGetParameter;
import org.example.saas.core.parameter.user.CustomerWxDeleteParameter;
import org.example.saas.core.parameter.user.CustomerWxSaveParameter;
import org.example.saas.core.parameter.user.CustomerWxUpdateParameter;
import org.example.saas.core.parameter.user.CustomerWxEnableParameter;
import org.example.saas.core.parameter.user.CustomerWxDisableParameter;
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
 * 客户微信 服务
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */
@RestController
@Validated
@RequestMapping("/customer-wx")
@RequiredArgsConstructor
@Api(tags = "客户微信")
public class CustomerWxController {
    private final CustomerWxService customerWxService;

    @PostMapping("/detail")
    @ApiOperation("获取客户微信详情")
    public Result<CustomerWxDTO> getDetail(@Validated @RequestBody CustomerWxDetailGetParameter parameter) {
        CustomerWxDTO detail = customerWxService.getDetail(parameter);
        return new Result<>(detail);
    }

    @PostMapping("/page")
    @ApiOperation("获取客户微信分页列表")
    public Result<IPage<CustomerWxDTO>> getPage(@Validated @RequestBody CustomerWxPageGetParameter parameter) {
        IPage<CustomerWxDTO> page = customerWxService.getPage(parameter);
        return new Result<>(page);
    }

    @PostMapping("/update")
    @ApiOperation("更新客户微信")
    @WebLog
    public Result<Boolean> update(@Validated @RequestBody CustomerWxUpdateParameter parameter) {
        customerWxService.update(parameter);
        return new Result<>(true);
    }

    @PostMapping("/save")
    @ApiOperation("保存客户微信")
    @WebLog
    public Result<Boolean> save(@Validated @RequestBody CustomerWxSaveParameter parameter) {
        customerWxService.save(parameter);
        return new Result<>(true);
    }

    @PostMapping("/enable")
    @ApiOperation("启用客户微信")
    @WebLog
    public Result<Boolean> enable(@Validated @RequestBody CustomerWxEnableParameter parameter) {
        customerWxService.enable(parameter);
        return new Result<>(true);
    }

    @PostMapping("/disable")
    @ApiOperation("禁用客户微信")
    @WebLog
    public Result<Boolean> save(@Validated @RequestBody CustomerWxDisableParameter parameter) {
        customerWxService.disable(parameter);
        return new Result<>(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除客户微信")
    @WebLog
    public Result<Boolean> delete(@Validated @RequestBody CustomerWxDeleteParameter parameter) {
        customerWxService.delete(parameter);
        return new Result<>(true);
    }

}
