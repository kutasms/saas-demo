package org.example.saas.order.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.example.saas.core.service.order.TradeService;
import org.example.saas.core.domain.dto.TradeDTO;
import org.example.saas.core.pojo.Trade;
import org.example.saas.core.parameter.order.TradeDetailGetParameter;
import org.example.saas.core.parameter.order.TradePageGetParameter;
import org.example.saas.core.parameter.order.TradeDeleteParameter;
import org.example.saas.core.parameter.order.TradeSaveParameter;
import org.example.saas.core.parameter.order.TradeUpdateParameter;
import org.example.saas.core.parameter.order.TradeEnableParameter;
import org.example.saas.core.parameter.order.TradeDisableParameter;
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
 * 交易 服务
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@RestController
@Validated
@RequestMapping("/trade")
@RequiredArgsConstructor
@Api(tags = "交易")
public class TradeController {
    private final TradeService tradeService;

    @PostMapping("/detail")
    @ApiOperation("获取交易详情")
    public Result<TradeDTO> getDetail(@Validated @RequestBody TradeDetailGetParameter parameter) {
        TradeDTO detail = tradeService.getDetail(parameter);
        return new Result<>(detail);
    }

    @PostMapping("/page")
    @ApiOperation("获取交易分页列表")
    public Result<IPage<TradeDTO>> getPage(@Validated @RequestBody TradePageGetParameter parameter) {
        IPage<TradeDTO> page = tradeService.getPage(parameter);
        return new Result<>(page);
    }

    @PostMapping("/update")
    @ApiOperation("更新交易")
    @WebLog
    public Result<Boolean> update(@Validated @RequestBody TradeUpdateParameter parameter) {
        tradeService.update(parameter);
        return new Result<>(true);
    }

    @PostMapping("/save")
    @ApiOperation("保存交易")
    @WebLog
    public Result<Boolean> save(@Validated @RequestBody TradeSaveParameter parameter) {
        tradeService.save(parameter);
        return new Result<>(true);
    }

    @PostMapping("/enable")
    @ApiOperation("启用交易")
    @WebLog
    public Result<Boolean> enable(@Validated @RequestBody TradeEnableParameter parameter) {
        tradeService.enable(parameter);
        return new Result<>(true);
    }

    @PostMapping("/disable")
    @ApiOperation("禁用交易")
    @WebLog
    public Result<Boolean> save(@Validated @RequestBody TradeDisableParameter parameter) {
        tradeService.disable(parameter);
        return new Result<>(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除交易")
    @WebLog
    public Result<Boolean> delete(@Validated @RequestBody TradeDeleteParameter parameter) {
        tradeService.delete(parameter);
        return new Result<>(true);
    }

}
